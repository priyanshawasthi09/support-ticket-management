# Quickstart: Support Ticket Management

**Feature**: `001-support-ticket-management`  
**Purpose**: Runnable validation scenarios after implementation (see `tasks.md` / implement phase).

## Prerequisites

- Java 21
- Node.js 20+ (for frontend)
- Docker (optional, for PostgreSQL) or local PostgreSQL 15+
- Environment variables for database (no secrets in repo):
  - `SPRING_DATASOURCE_URL` (e.g. `jdbc:postgresql://localhost:5432/support_tickets`)
  - `SPRING_DATASOURCE_USERNAME`
  - `SPRING_DATASOURCE_PASSWORD`

## Start backend (local profile)

From repository root (after `backend/` module exists):

```bash
cd backend
./mvnw spring-boot:run -Dspring-boot.run.profiles=local
```

- API base: `http://localhost:8080`
- OpenAPI UI: `http://localhost:8080/swagger-ui.html`
- Contract reference: [contracts/openapi.yaml](./contracts/openapi.yaml)

## Start frontend

```bash
cd frontend
npm install
npm run dev
```

- UI: `http://localhost:5173` (CORS allowed from this origin in `local` profile)

## Run tests

```bash
cd backend
./mvnw test
```

- Unit tests: state machine, validation helpers
- `@WebMvcTest`: controllers and error payloads
- `@DataJpaTest`: repositories and search queries (H2)
- `@SpringBootTest`: full API flows (H2 `test` profile)
- **PostgreSQL persistence (required in CI)**: restart-persistence suite using PostgreSQL (Testcontainers or configured service) — verifies FR-013 / SC-002. H2 tests alone do not satisfy this gate.

## Manual validation scenarios

### 1. Create and list

1. `POST /api/v1/tickets` with `{ "title": "Printer jam", "description": "Lobby printer", "priority": "HIGH" }`
2. `GET /api/v1/tickets` — response includes `id`, `title`, `status` for each row.
3. Create a second ticket with the same title — two distinct `id` values in the list.

### 2. Lifecycle

1. `POST /api/v1/tickets/{id}/transitions` `{ "status": "IN_PROGRESS" }` from OPEN — success.
2. Repeat through RESOLVED → CLOSED along allowed path.
3. `POST` transition CLOSED → OPEN — `409`, `code: INVALID_STATUS_TRANSITION`, `currentStatus` and `requestedStatus` present.

### 3. Partial update and assignee

1. `PATCH /api/v1/tickets/{id}` `{ "title": "New title" }` — only title changes; status unchanged.
2. `PATCH` with `{ "assignee": null }` on a ticket that had an assignee — assignee cleared.

### 4. Comments

1. `POST /api/v1/tickets/{id}/comments` `{ "content": "Checked power cable" }` on a CLOSED ticket — `201`.
2. Empty content — `422`, `VALIDATION_ERROR`.

### 5. Search and filter

1. `GET /api/v1/tickets?q=printer` — matches title or description, case-insensitive.
2. `GET /api/v1/tickets?status=OPEN&q=printer` — only OPEN tickets matching keyword.

### 6. Persistence (PostgreSQL — required verification)

1. Create ticket and comment; note `id`.
2. Restart backend against **PostgreSQL** (not H2-only).
3. `GET /api/v1/tickets/{id}` — same `id`, fields and comments preserved.

Automated tests for this scenario MUST run against PostgreSQL in the build pipeline (see [plan.md](./plan.md) Testing strategy).

## Expected error codes

| Code | HTTP | When |
|------|------|------|
| `TICKET_NOT_FOUND` | 404 | Unknown ticket id |
| `VALIDATION_ERROR` | 422 | Bean validation / blank fields |
| `INVALID_STATUS_TRANSITION` | 409 | Disallowed status change |
