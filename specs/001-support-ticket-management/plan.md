# Implementation Plan: Support Ticket Management

**Branch**: `001-support-ticket-management` | **Date**: 2026-09-27 | **Spec**: [spec.md](./spec.md)

**Input**: Feature specification from `/specs/001-support-ticket-management/spec.md`

## Summary

Deliver a **modular monolith** support ticket system: Java 21 / Spring Boot 3 REST API backed by PostgreSQL, React UI, and automated tests (H2 for fast slices). Users create and list tickets (showing stable numeric `id`, title, status), open details, partially update fields, add comments in any status, search (`q`) and filter (`status`) together, and move tickets only along the defined lifecycle. The **service layer** owns the status state machine and partial-update rules; the API returns **RFC 7807 ProblemDetail** responses with stable `code` values. No authentication, microservices, or out-of-scope features.

**Design artifacts**: [research.md](./research.md), [data-model.md](./data-model.md), [contracts/openapi.yaml](./contracts/openapi.yaml), [quickstart.md](./quickstart.md).

## Technical Context

**Language/Version**: Java 21 (backend), TypeScript + React 18 (frontend)

**Primary Dependencies**: Spring Boot 3.x (`web`, `data-jpa`, `validation`), Flyway, springdoc-openapi, PostgreSQL driver, H2 (test), JUnit 5, Mockito, AssertJ; Vite, React Router (frontend)

**Storage**: PostgreSQL (runtime `local`/prod); H2 in-memory (`test` profile) for `@DataJpaTest` and `@SpringBootTest`

**Testing**: JUnit 5 pyramid per constitution — unit (state machine), `@WebMvcTest`, `@DataJpaTest` (H2), `@SpringBootTest` (H2 for fast API flows), **plus mandatory PostgreSQL restart-persistence tests** (FR-013 / SC-002)

**Target Platform**: Linux/macOS dev; JVM server + static/Vite dev server for UI

**Project Type**: Web application (backend + frontend)

**Performance Goals**: Assignment scale (tens of concurrent users, hundreds of tickets); no formal SLA in spec

**Constraints**: Modular monolith only; secrets via env; CORS limited to dev frontend origin; no `ddl-auto` in committed configs

**Scale/Scope**: Single support team; five statuses; CRUD-ish ticket operations without delete/history/attachments

## Constitution Check

*GATE: Must pass before Phase 0 research. Re-check after Phase 1 design.*

| Principle | Plan compliance |
|-----------|----------------|
| I Clean Java / Spring Boot | Constructor injection; records for DTOs; idiomatic layering |
| II Separation of concerns | Controllers → services → repositories; entities not exposed |
| III REST `/api/v1`, ProblemDetail errors, camelCase JSON | See [contracts/openapi.yaml](./contracts/openapi.yaml) |
| IV Validation at boundary + domain rules in service | Jakarta validation on requests; transitions in `TicketStatusService` |
| V Test pyramid | Mapped in Testing Strategy below |
| VI PostgreSQL + Flyway; H2 tests | [research.md](./research.md) R7 |
| VII No secrets in repo; parameterized JPA; CORS | `application-local.yml` uses env; CORS property |
| VIII spec/plan/tasks; OpenAPI; README | OpenAPI + planned root README in implement phase |
| IX Simplicity | No Kafka, Redis, CQRS, microservices |
| X Spec-driven implementation | This plan traces to FR-* in spec |

**Post-design re-check**: Passed — data model and contracts align with gates; no violations requiring Complexity Tracking.

## Project Structure

### Documentation (this feature)

```text
specs/001-support-ticket-management/
├── plan.md
├── research.md
├── data-model.md
├── quickstart.md
├── contracts/
│   └── openapi.yaml
└── tasks.md             # /speckit-tasks (not created by /speckit-plan)
```

### Source Code (repository root)

```text
backend/
├── pom.xml
├── src/main/java/com/support/tickets/
│   ├── SupportTicketApplication.java
│   ├── config/              # Web, CORS, OpenAPI
│   ├── domain/
│   │   ├── model/           # JPA entities, enums
│   │   ├── repository/      # Spring Data JPA
│   │   └── service/         # TicketService, CommentService, TicketStatusService
│   ├── api/
│   │   ├── controller/      # TicketController, CommentController
│   │   ├── dto/             # Request/response records
│   │   └── mapper/          # Entity ↔ DTO
│   └── exception/           # @ControllerAdvice, ProblemDetail + codes
├── src/main/resources/
│   ├── application.yml
│   ├── application-local.yml
│   ├── application-test.yml
│   └── db/migration/        # Flyway V1__init.sql
└── src/test/java/...        # unit, web, jpa, integration packages

frontend/
├── package.json
├── vite.config.ts
├── src/
│   ├── api/                 # ticketsClient, error parsing
│   ├── hooks/               # useTickets, useTicketDetail
│   ├── components/          # TicketList, TicketForm, TicketDetail, CommentList
│   ├── pages/               # ListPage, DetailPage, CreatePage
│   ├── types/               # mirrors API types
│   └── App.tsx
└── src/**/*.test.tsx        # component/hook tests (optional slice)

README.md                    # setup, run, test (constitution VIII)
docker-compose.yml           # optional PostgreSQL for local dev
```

**Structure Decision**: Two top-level modules (`backend/`, `frontend/`) under one repo — modular monolith API with separate UI client. Package-by-layer inside `com.support.tickets` keeps boundaries clear without microservice split.

## Incremental delivery strategy

Implement in thin vertical slices so each step is demonstrable and testable:

1. **Bootstrap** — Maven/Gradle backend, Flyway schema, health, profiles (`local`, `test`).
2. **Ticket CRUD core** — Create (OPEN), get by id, list summaries with `id`/title/status; persistence tests.
3. **Validation & errors** — Global exception handler, `VALIDATION_ERROR`, `TICKET_NOT_FOUND`; `@WebMvcTest`.
4. **State machine** — `TicketStatusService` + transition endpoint; unit tests for all allowed/forbidden edges.
5. **Partial PATCH** — Presence-aware update DTO; assignee null clear; tests for FR-005.
6. **Comments** — POST comment; load with ticket detail; any status.
7. **Search/filter** — Repository query + list endpoint params; `@DataJpaTest` for case-insensitive OR title/description.
8. **Frontend** — List (id, title, status), create, detail, edit, transitions, comments, search/filter; display API errors from `code`/`detail`.
9. **PostgreSQL persistence verification** — Automated test against PostgreSQL proving tickets, comments, and stable `id` survive application restart (required gate, not optional).
10. **Docs & polish** — README, springdoc, quickstart walkthrough.

## Backend design

### Layer responsibilities

- **Controllers**: Map HTTP to DTOs, `@Valid` on bodies (`@NotBlank` / enum checks only — **no `@Size` maximums**), return `ResponseEntity` with correct status codes. No transition logic in controller.
- **Services**: `@Transactional` orchestration; `TicketStatusService` encapsulates FR-009/FR-010; `TicketService` for create/update/list/get/search; `CommentService` for add comment.
- **Repositories**: `TicketRepository` with custom `@Query` for search+filter; `CommentRepository` if needed.
- **Domain model**: `Ticket`, `Comment`, enums `TicketStatus`, `TicketPriority`.

### State machine

Centralize allowed transitions in one class (e.g. `TicketStatusTransitions` map or enum method). `transition(ticket, targetStatus)`:

- If `current == target` → `INVALID_STATUS_TRANSITION`
- If transition not in allowed set → same
- Else update entity status and save

Unit-test the matrix exhaustively (constitution V).

### Partial updates

Use a patch DTO with optional fields (Jackson `@JsonInclude` + custom deserializer or `JsonNullable<String>` for assignee). Service applies only present fields. Document in API that omitted `assignee` leaves unchanged; JSON `null` clears.

### Error handling

`@RestControllerAdvice` builds `ProblemDetail` with:

- `code`: `TICKET_NOT_FOUND` | `VALIDATION_ERROR` | `INVALID_STATUS_TRANSITION`
- `detail`: human-readable message
- Extensions: `currentStatus`, `requestedStatus` for invalid transitions; `errors[]` for field validation

Never expose stack traces (constitution VII).

### Persistence

- Flyway `V1__create_tickets_and_comments.sql` per [data-model.md](./data-model.md). Text fields use `TEXT` (no invented max-length constraints).
- `spring.jpa.hibernate.ddl-auto=validate` (or `none`) with Flyway managing schema.
- **Test profiles**:
  - `test` (H2): fast repository and API integration tests.
  - `postgresql-test` (or Testcontainers in a dedicated test class): **required** restart-persistence verification on PostgreSQL — create ticket + comment, restart Spring context (or stop/start app), assert same `id`, fields, comments (FR-013, SC-002).
- Migrations must remain portable between H2 and PostgreSQL where both are used; use `TEXT` and standard SQL.

### Configuration

| Profile | Database | Notes |
|---------|----------|--------|
| `local` | PostgreSQL | Env-based datasource; CORS `http://localhost:5173` |
| `test` | H2 | Fast unit/slice/integration tests |
| `postgresql-test` | PostgreSQL (Testcontainers or CI service) | **Mandatory** restart persistence suite |

`application.yml` shared defaults; secrets only via env placeholders.

## REST API summary

Full contract: [contracts/openapi.yaml](./contracts/openapi.yaml).

| Method | Path | Purpose |
|--------|------|---------|
| GET | `/api/v1/tickets` | List; `?status=&q=` |
| POST | `/api/v1/tickets` | Create |
| GET | `/api/v1/tickets/{id}` | Detail + comments |
| PATCH | `/api/v1/tickets/{id}` | Partial field update |
| POST | `/api/v1/tickets/{id}/transitions` | Status change |
| POST | `/api/v1/tickets/{id}/comments` | Add comment |

No DELETE endpoints (ticket/comment delete out of spec).

## Testing strategy

| Layer | Focus | Examples |
|-------|--------|----------|
| Unit | `TicketStatusTransitions`, validation helpers | CLOSED→OPEN rejected; OPEN→IN_PROGRESS allowed |
| `@WebMvcTest` | Controllers, ProblemDetail shape | 404 `TICKET_NOT_FOUND`; 409 with statuses |
| `@DataJpaTest` (H2) | `TicketRepository` search/filter | Case-insensitive title/description match; status AND keyword |
| `@SpringBootTest` (H2) | Fast full-stack API flows | Create, transition, comment, list filter |
| **PostgreSQL persistence** (required) | FR-013 / SC-002 | Testcontainers PostgreSQL: persist ticket + comment, restart application context, assert unchanged `id`, content, status, comments |

Validation tests must cover **non-blank** and enum rules only. Do not add tests that assert rejection based on invented maximum string lengths.

**Search `q` parameter**: Implementation may treat omitted/blank `q` as no keyword filter ([research.md](./research.md) R4). Do not add product acceptance criteria for empty-keyword behavior.

Frontend: test API client error parsing; manual quickstart scenarios for UI; PostgreSQL persistence remains a backend automated gate.

## Frontend design

- **Routing**: `/` list, `/tickets/new`, `/tickets/:id`.
- **List**: Show `id`, title, status; controls for status filter (single select) and search input; call `GET /api/v1/tickets`.
- **Create**: Form validation (required title/description/priority) for UX only; submit `POST /api/v1/tickets`.
- **Detail**: Show all fields; PATCH for edits; buttons only for **allowed** transitions (UX) but backend remains authoritative; comment form.
- **Errors**: Map `problem+json` `code` and `detail` to user-visible messages; show transition errors with current/requested status when present.

No auth UI, no user directory picker for assignee (free text).

## Documentation (constitution VIII)

- Root **README.md**: Java 21, Node, PostgreSQL/Docker, env vars, `mvn test`, run backend + frontend.
- **springdoc** for interactive API docs.
- Keep **openapi.yaml** aligned with controllers during implementation.

## Complexity Tracking

> No constitution violations requiring justification.

| Violation | Why Needed | Simpler Alternative Rejected Because |
|-----------|------------|-------------------------------------|
| — | — | — |

## Phase 0 & Phase 1 outputs

- **Phase 0**: [research.md](./research.md) — all technical choices resolved; no NEEDS CLARIFICATION remaining.
- **Phase 1**: [data-model.md](./data-model.md), [contracts/openapi.yaml](./contracts/openapi.yaml), [quickstart.md](./quickstart.md).

**Next step**: Run `/speckit-tasks` to produce `tasks.md`, then `/speckit-implement`.
