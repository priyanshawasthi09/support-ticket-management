---
description: "Task list for Support Ticket Management implementation"
---

# Tasks: Support Ticket Management

**Input**: Design documents from `/specs/001-support-ticket-management/`

**Prerequisites**: [plan.md](./plan.md), [spec.md](./spec.md), [research.md](./research.md), [data-model.md](./data-model.md), [contracts/openapi.yaml](./contracts/openapi.yaml)

**Tests**: Included per project constitution (test pyramid) and [plan.md](./plan.md). Do not add tests that assert invented maximum string lengths. PostgreSQL restart persistence is a required gate (FR-013 / SC-002). **Blank-field and enum-format validation** belong in `@WebMvcTest` / API layer tests; **service unit tests** focus on business rules (initial OPEN, optional assignee, partial updates, status preservation, transition matrix).

**Organization**: Phases follow user story priority from [spec.md](./spec.md). Backend API is built story-by-story; frontend tasks align to the same stories.

## Format: `[ID] [P?] [Story] Description`

- **[P]**: Can run in parallel (different files, no dependencies on incomplete tasks)
- **[Story]**: US1–US5 maps to spec user stories

## Path Conventions

- Backend: `backend/src/main/java/com/support/tickets/`
- Backend tests: `backend/src/test/java/com/support/tickets/`
- Frontend: `frontend/src/`

---

## Phase 1: Setup (Shared Infrastructure)

**Purpose**: Repository layout, build tools, local PostgreSQL option

- [X] T001 Create Gradle configuration (`backend/settings.gradle`, `backend/build.gradle`) with Java 21, Spring Boot 3 (web, data-jpa, validation), Flyway, PostgreSQL driver, H2, springdoc-openapi, Testcontainers PostgreSQL, JUnit 5, Mockito, AssertJ
- [X] T002 Create `backend/src/main/java/com/support/tickets/SupportTicketApplication.java`
- [X] T003 [P] Scaffold `frontend/` with Vite, React 18, TypeScript, and React Router (`frontend/package.json`, `frontend/vite.config.ts`, `frontend/index.html`)
- [X] T004 [P] Add `docker-compose.yml` at repository root for PostgreSQL 15 (dev only; no secrets in repo)
- [X] T005 [P] Add `backend/src/main/resources/application.yml` with shared defaults (`ddl-auto=validate`, Flyway enabled)
- [X] T006 [P] Add `README.md` skeleton at repository root (placeholders for run/test instructions)

**Checkpoint**: `gradle -p backend validate` and `npm install` in `frontend/` succeed

---

## Phase 2: Foundational (Blocking Prerequisites)

**Purpose**: Schema, domain model, error contract, and API infrastructure required by every user story

**⚠️ CRITICAL**: No user story implementation until this phase completes

- [X] T007 Add Flyway migration `backend/src/main/resources/db/migration/V1__create_tickets_and_comments.sql` with `TEXT` columns (no max-length DB constraints per [research.md](./research.md) R9)
- [X] T008 Add `backend/src/main/resources/application-local.yml` (PostgreSQL via env vars, CORS for `http://localhost:5173`)
- [X] T009 Add `backend/src/main/resources/application-test.yml` (H2 in-memory, Flyway on)
- [X] T010 [P] Create enums `backend/src/main/java/com/support/tickets/domain/model/TicketStatus.java` and `TicketPriority.java`
- [X] T011 [P] Create JPA entity `backend/src/main/java/com/support/tickets/domain/model/Ticket.java` (LAZY comments, IDENTITY id)
- [X] T012 [P] Create JPA entity `backend/src/main/java/com/support/tickets/domain/model/Comment.java`
- [X] T013 [P] Create `backend/src/main/java/com/support/tickets/domain/repository/TicketRepository.java`
- [X] T014 [P] Create `backend/src/main/java/com/support/tickets/domain/repository/CommentRepository.java`
- [X] T015 [P] Create stable error codes enum `backend/src/main/java/com/support/tickets/exception/ApiErrorCode.java` (`TICKET_NOT_FOUND`, `VALIDATION_ERROR`, `INVALID_STATUS_TRANSITION`)
- [X] T016 Implement `backend/src/main/java/com/support/tickets/exception/GlobalExceptionHandler.java` returning RFC 7807 `ProblemDetail` with `code`, human message, and transition fields when applicable
- [X] T017 [P] Create API DTO records under `backend/src/main/java/com/support/tickets/api/dto/` (`TicketSummaryResponse`, `TicketResponse`, `CommentResponse`, `CreateTicketRequest`, `UpdateTicketRequest`, `CreateCommentRequest`, `TransitionRequest`)
- [X] T018 [P] Create `backend/src/main/java/com/support/tickets/api/mapper/TicketMapper.java`
- [X] T019 [P] Add `backend/src/main/java/com/support/tickets/config/WebConfig.java` for CORS (local profile)
- [X] T020 [P] Add `backend/src/main/java/com/support/tickets/config/OpenApiConfig.java` for springdoc
- [X] T021 Add `backend/src/test/java/com/support/tickets/support/AbstractIntegrationTest.java` with `@SpringBootTest` and H2 `test` profile

**Checkpoint**: Application starts on H2 test profile; migrations apply; no REST features yet

---

## Phase 3: User Story 1 — Create a ticket and find it again (Priority: P1) 🎯 MVP

**Goal**: Create ticket (OPEN), list with `id`/title/status, get detail; validation errors with stable `code`

**Independent Test**: POST create → GET list shows ticket → GET by id → duplicate title creates second distinct `id` (spec User Story 1)

### Tests for User Story 1

- [X] T022 [P] [US1] Add `backend/src/test/java/com/support/tickets/domain/service/TicketServiceCreateTest.java` (unit: new ticket starts OPEN, optional assignee on create stored or omitted — no blank-field assertion tests here)
- [X] T023 [P] [US1] Add `backend/src/test/java/com/support/tickets/api/controller/TicketControllerCreateListWebMvcTest.java` (`@WebMvcTest`: 201 create, 422 blank title/description/invalid priority with `VALIDATION_ERROR`, list summaries include `id`)
- [X] T024 [P] [US1] Add `backend/src/test/java/com/support/tickets/integration/TicketCreateListIntegrationTest.java` (H2: create two same-title tickets, distinct ids)

### Implementation for User Story 1

- [X] T025 [US1] Implement `backend/src/main/java/com/support/tickets/domain/service/TicketService.java` methods `create`, `getById`, `listSummaries` (default sort `id` DESC per research R8)
- [X] T026 [US1] Implement `backend/src/main/java/com/support/tickets/api/controller/TicketController.java` — `POST /api/v1/tickets`, `GET /api/v1/tickets`, `GET /api/v1/tickets/{id}` (comments empty array until US4)
- [X] T027 [P] [US1] Add Jakarta validation on `backend/src/main/java/com/support/tickets/api/dto/CreateTicketRequest.java` — `@NotBlank` title and description, valid `priority` enum, optional `assignee` (no `@Size` maximums); trigger via `@Valid` on `POST /api/v1/tickets` in `TicketController.java`
- [X] T028 [P] [US1] Add `frontend/src/types/ticket.ts` mirroring API types
- [X] T029 [P] [US1] Add `frontend/src/api/ticketsClient.ts` (create, list, getById, parse ProblemDetail)
- [X] T030 [US1] Add `frontend/src/pages/TicketListPage.tsx` showing `id`, title, status
- [X] T031 [US1] Add `frontend/src/pages/CreateTicketPage.tsx` with client-side required-field hints (backend authoritative)
- [X] T032 [US1] Add `frontend/src/pages/TicketDetailPage.tsx` read-only detail view
- [X] T033 [US1] Wire routes in `frontend/src/App.tsx`

**Checkpoint**: MVP API + UI for create/list/detail; run US1 independent test

---

## Phase 4: User Story 2 — Move a ticket through its lifecycle (Priority: P1)

**Goal**: Allowed transitions only; reject others including same-status; ProblemDetail with `currentStatus` / `requestedStatus`

**Independent Test**: Exercise allowed path and rejected examples from spec User Story 2 (backend tests required even if UI hides actions)

### Tests for User Story 2

- [X] T034 [P] [US2] Add `backend/src/test/java/com/support/tickets/domain/service/TicketStatusTransitionsTest.java` (unit: full transition matrix, same-status rejected)
- [X] T035 [P] [US2] Add `backend/src/test/java/com/support/tickets/api/controller/TicketTransitionWebMvcTest.java` (`@WebMvcTest`: 422 invalid `status` enum on `TransitionRequest`; 409 `INVALID_STATUS_TRANSITION` with `currentStatus`/`requestedStatus` for disallowed business transitions)

### Implementation for User Story 2

- [X] T036 [US2] Implement `backend/src/main/java/com/support/tickets/domain/service/TicketStatusService.java` and `TicketStatusTransitions` helper (FR-009/FR-010)
- [X] T037 [US2] Add `POST /api/v1/tickets/{id}/transitions` to `backend/src/main/java/com/support/tickets/api/controller/TicketController.java` with `@Valid` on `backend/src/main/java/com/support/tickets/api/dto/TransitionRequest.java` (required valid `TicketStatus` enum)
- [X] T038 [US2] Add transition actions to `frontend/src/pages/TicketDetailPage.tsx` (show only allowed targets; still call API for authority)
- [X] T039 [US2] Display transition errors using `code`, `detail`, `currentStatus`, `requestedStatus` in `frontend/src/api/ticketsClient.ts`

**Checkpoint**: Lifecycle enforced server-side; US1 + US2 both pass tests

---

## Phase 5: User Story 3 — Update ticket details (Priority: P2)

**Goal**: PATCH partial updates in any status; explicit assignee clear; status unchanged

**Independent Test**: PATCH single field; clear assignee; invalid field rejected with prior data unchanged (spec User Story 3)

### Tests for User Story 3

- [X] T040 [P] [US3] Add `backend/src/test/java/com/support/tickets/domain/service/TicketServicePatchTest.java` (unit: partial field update, omitted fields unchanged, explicit `assignee` null clears assignee, ticket `status` unchanged — no blank-field assertion tests here)
- [X] T041 [P] [US3] Add `backend/src/test/java/com/support/tickets/api/controller/TicketPatchWebMvcTest.java` (`@WebMvcTest`: 422 when supplied title/description blank or priority invalid; 200 valid partial PATCH)

### Implementation for User Story 3

- [X] T042 [US3] Add presence-aware `UpdateTicketRequest` in `backend/src/main/java/com/support/tickets/api/dto/UpdateTicketRequest.java` using `JsonNullable` or an equivalent Jackson presence-aware mechanism (omitted fields unchanged; explicit `assignee: null` clears assignee); validate any supplied title/description as `@NotBlank` and any supplied `priority` as a valid enum (no `@Size` maximums)
- [X] T043 [US3] Extend `TicketService` with `updatePartial` in `backend/src/main/java/com/support/tickets/domain/service/TicketService.java`
- [X] T044 [US3] Add `PATCH /api/v1/tickets/{id}` to `backend/src/main/java/com/support/tickets/api/controller/TicketController.java` with `@Valid` on `UpdateTicketRequest`
- [X] T045 [US3] Add edit form on `frontend/src/pages/TicketDetailPage.tsx` calling PATCH (including clear assignee)

**Checkpoint**: Edits work on CLOSED/CANCELLED tickets without status change

---

## Phase 6: User Story 4 — Add comments (Priority: P2)

**Goal**: POST non-blank comment on any status; comments on ticket detail; persist with ticket

**Independent Test**: Comment on CANCELLED ticket; blank rejected; comment not visible on other tickets (spec User Story 4)

### Tests for User Story 4

- [X] T046 [P] [US4] Add `backend/src/test/java/com/support/tickets/api/controller/CommentControllerWebMvcTest.java` (`@WebMvcTest`: 422 blank/whitespace `content` with `VALIDATION_ERROR`; 201 valid comment)
- [X] T047 [P] [US4] Add `backend/src/test/java/com/support/tickets/integration/CommentPersistenceIntegrationTest.java` (H2)

### Implementation for User Story 4

- [X] T048 [US4] Implement `backend/src/main/java/com/support/tickets/domain/service/CommentService.java`
- [X] T049 [US4] Add `POST /api/v1/tickets/{ticketId}/comments` in `backend/src/main/java/com/support/tickets/api/controller/CommentController.java` with `@Valid` on `backend/src/main/java/com/support/tickets/api/dto/CreateCommentRequest.java` (`@NotBlank` content; no `@Size` maximums)
- [X] T050 [US4] Include comments in `GET /api/v1/tickets/{id}` via `TicketMapper` (order by comment `id` ASC)
- [X] T051 [US4] Add comment list + form to `frontend/src/pages/TicketDetailPage.tsx`

**Checkpoint**: US4 complete; detail shows comments after refresh

---

## Phase 7: User Story 5 — Search and filter the list (Priority: P3)

**Goal**: `q` case-insensitive title/description OR match; single `status` filter; AND when both provided

**Independent Test**: Scenarios from spec User Story 5 (assignee/comment text must not match `q`)

**Note**: Treat omitted/blank `q` as no keyword filter — implementation default only ([research.md](./research.md) R4); do not add product acceptance tests for empty keyword.

### Tests for User Story 5

- [X] T052 [P] [US5] Add `backend/src/test/java/com/support/tickets/domain/repository/TicketRepositorySearchTest.java` (`@DataJpaTest`, H2)
- [X] T053 [P] [US5] Add `backend/src/test/java/com/support/tickets/api/controller/TicketListFilterWebMvcTest.java`

### Implementation for User Story 5

- [X] T054 [US5] Add search/filter query to `TicketRepository` in `backend/src/main/java/com/support/tickets/domain/repository/TicketRepository.java`
- [X] T055 [US5] Extend `TicketService.listSummaries` and `GET /api/v1/tickets` for `status` and `q` params
- [X] T056 [US5] Add search input and status filter to `frontend/src/pages/TicketListPage.tsx`

**Checkpoint**: Combined filter + search matches spec FR-007/FR-008

---

## Phase 8: Polish & Cross-Cutting Concerns

**Purpose**: PostgreSQL persistence gate, documentation, contract alignment

- [ ] T057 Add **required** `backend/src/test/java/com/support/tickets/integration/PostgreSqlRestartPersistenceIT.java` (mandatory CI gate, FR-013 / SC-002): keep the Testcontainers PostgreSQL database/container running; persist a ticket and comment via the API or services; terminate/close the Spring `ApplicationContext`; start a **fresh** `ApplicationContext` against the **same** database; verify the same ticket `id`, title, description, priority, assignee, `status`, and persisted comments ([plan.md](./plan.md))
- [ ] T058 Configure Maven to run PostgreSQL IT (e.g. Failsafe profile or JUnit tag); document in `README.md`
- [ ] T059 Complete `README.md` — Java 21, Node, Docker PostgreSQL, env vars, `mvn test`, run backend `local` + frontend dev server
- [ ] T060 [P] Verify springdoc output matches `specs/001-support-ticket-management/contracts/openapi.yaml` paths and schemas
- [ ] T061 Execute manual scenarios in [quickstart.md](./quickstart.md) and fix gaps
- [ ] T062 [P] Add frontend unit test `frontend/src/api/ticketsClient.test.ts` for ProblemDetail parsing (optional slice)

**Checkpoint**: Full CI green including PostgreSQL restart suite

---

## Dependencies & Execution Order

### Phase Dependencies

- **Phase 1** → **Phase 2** → **Phases 3–7** (US1 → US2 → US3 → US4 → US5 recommended) → **Phase 8**
- **US2** depends on **US1** (needs tickets). **US3–US5** depend on **US1**; **US4** benefits from detail page from **US1**.

### User Story Dependencies

| Story | Priority | Depends on |
|-------|----------|------------|
| US1 | P1 | Phase 2 only |
| US2 | P1 | US1 (ticket exists) |
| US3 | P2 | US1 |
| US4 | P2 | US1 (detail endpoint) |
| US5 | P3 | US1 (list endpoint) |

### Parallel Opportunities

- Phase 1: T003, T004, T005, T006 in parallel after T001–T002
- Phase 2: T010–T014, T017–T020 in parallel after T007–T009
- Within each story: tests marked [P] before implementation tasks for that story
- Frontend types/client (T028–T029) parallel with backend service work when DTOs stable

### Parallel Example: User Story 1

```bash
# After T025 is specced, in parallel:
# T022 TicketServiceCreateTest.java
# T023 TicketControllerCreateListWebMvcTest.java
# T028 frontend/src/types/ticket.ts
# T029 frontend/src/api/ticketsClient.ts
```

---

## Implementation Strategy

### MVP First (User Story 1 + foundation)

1. Complete Phase 1 and Phase 2
2. Complete Phase 3 (US1) including minimal frontend list/create/detail
3. **STOP and VALIDATE** using US1 independent test and H2 integration tests

### Incremental Delivery

1. Add Phase 4 (US2) — lifecycle
2. Add Phase 5 (US3) — edits
3. Add Phase 6 (US4) — comments
4. Add Phase 7 (US5) — search/filter
5. Phase 8 — PostgreSQL restart IT + README + quickstart (required before “done”)

### Suggested MVP scope

**User Story 1 only** (plus Setup and Foundational): create, list, open ticket with stable `id` on PostgreSQL when running locally; H2 tests in CI for speed.

---

## Notes

- No authentication, delete endpoints, or out-of-scope features from [spec.md](./spec.md)
- Validation DTOs: `CreateTicketRequest`, `UpdateTicketRequest` (supplied fields), `CreateCommentRequest`, `TransitionRequest` — `@NotBlank` / valid enums only; never `@Size` max or invented length rejection
- API layer (`@WebMvcTest`) owns blank/invalid-enum format tests; service unit tests own business behavior
- Empty `q`: implementation default documented in research; not a new acceptance criterion
- All tasks use checkbox format `- [ ] Tnnn` for `/speckit-implement` tracking
