# Research: Support Ticket Management

**Feature**: `001-support-ticket-management`  
**Date**: 2026-09-27

## R1: Ticket unique identifier

**Decision**: Use a database-generated `BIGINT` primary key (`id`) as the ticket’s unique identifier, exposed in API responses and list entries as `id`.

**Rationale**: The specification requires a stable identifier that survives restarts and distinguishes duplicate titles. A surrogate key satisfies that without adding UUID infrastructure. It maps cleanly to JPA `GenerationType.IDENTITY` on PostgreSQL and H2.

**Alternatives considered**:
- UUID: Stable and opaque, but not required by the spec and adds wider columns and indexing differences between H2 and PostgreSQL.
- Composite natural keys: Rejected because titles are not unique.

## R2: Partial ticket updates (PATCH semantics)

**Decision**: Expose `PATCH /api/v1/tickets/{id}` with a JSON body where each field is optional. Fields present in the JSON are updated; fields omitted are unchanged. Send `"assignee": null` to clear the assignee explicitly.

**Rationale**: Matches FR-005 (partial updates, explicit assignee clear, omit does not clear). Jackson `JsonNullable` or a dedicated patch record with `Optional`-style presence tracking avoids accidental overwrites.

**Alternatives considered**:
- `PUT` full replacement: Rejected; conflicts with partial-update requirement.
- Separate clear-assignee flag: Works but redundant when JSON `null` is already an explicit clear signal.

## R3: Status transition API shape

**Decision**: `POST /api/v1/tickets/{id}/transitions` with body `{ "status": "IN_PROGRESS" }`. The service layer runs the state machine; the controller only validates input shape.

**Rationale**: Keeps lifecycle changes separate from field edits (FR-005 vs FR-009). A dedicated sub-resource makes illegal transitions easy to test in isolation and avoids PATCH accidentally changing status.

**Alternatives considered**:
- PATCH on ticket including `status`: Rejected; mixes field updates with lifecycle and complicates partial-update rules.

## R4: Search and filter query parameters

**Decision**: `GET /api/v1/tickets?status={STATUS}&q={keyword}`. Omit `status` to list all statuses. When both `status` and a non-empty `q` are present, apply AND logic (FR-008). **Implementation default only** (not a product requirement): when `q` is omitted or blank, apply no keyword filter. The specification leaves empty-keyword behavior undecided; this default is documented here for implementers and must not appear as a new acceptance criterion.

**Rationale**: FR-007 and FR-008 define matching and combined filter behavior when a keyword search is in effect. A default for absent/blank `q` avoids blocking implementation without claiming spec coverage.

**Alternatives considered**:
- Reject blank `q` with 400: Would invent unspecified product behavior.
- Document blank `q` in OpenAPI as a normative API guarantee: Rejected; keep contract aligned to spec, note impl default in plan/research only.

## R5: Case-insensitive search implementation

**Decision**: Use JPA Criteria API or a repository query with `LOWER(title) LIKE LOWER(CONCAT('%', :q, '%'))` (and the same for `description`), combined with OR across title and description.

**Rationale**: Portable between PostgreSQL and H2 when avoiding database-specific operators. Meets case-insensitive substring match in title or description only.

**Alternatives considered**:
- PostgreSQL `ILIKE`: Faster on PostgreSQL but diverges from H2 tests unless duplicated logic.

## R6: Error response format

**Decision**: RFC 7807 `ProblemDetail` (Spring 6 `ProblemDetail` / `@ControllerAdvice`) with extensions: `code` (stable string enum), and for invalid transitions `currentStatus` and `requestedStatus`. Map `TICKET_NOT_FOUND` → HTTP 404; validation → 422; invalid transition → 409.

**Rationale**: Constitution requires structured errors and camelCase JSON. A `code` property satisfies the specification’s stable machine-readable error code while keeping human `detail`/`title` messages.

**Alternatives considered**:
- Custom JSON only (no ProblemDetail): Rejected; constitution prefers RFC 7807/9457.

## R7: Schema migrations and profiles

**Decision**: Flyway migrations under `backend/src/main/resources/db/migration`. Profiles: `local` (PostgreSQL via env), `test` (H2 in-memory, Flyway enabled), no `ddl-auto` in committed configs.

**Rationale**: Constitution VI forbids uncontrolled schema generation in production-like paths.

## R8: List and comment ordering (implementation default)

**Decision**: List tickets by `id` descending. Return comments ordered by comment `id` ascending.

**Rationale**: The specification does not mandate sort order. Fixed defaults give deterministic UI and tests without claiming a product requirement; documented here as implementation choices only.

## R9: Text field storage (no maximum-length product validation)

**Decision**: Store `title`, `description`, `assignee`, and `content` in unbounded text columns (`TEXT` on PostgreSQL; equivalent on H2). Validate only **non-blank** content where the spec requires it (`@NotBlank` / trim checks). Do **not** add `@Size` max limits or API rules that reject otherwise valid content solely because of an invented maximum length.

**Rationale**: The specification explicitly leaves maximum lengths undecided. Rejecting long but non-blank text would be new product behavior.

**Alternatives considered**:
- Fixed `@Size(200)` / `@Size(5000)`: Rejected; would become undeclared product validation.

## R10: Persistence verification after restart (PostgreSQL)

**Decision**: H2 remains appropriate for fast `@DataJpaTest` and many `@SpringBootTest` API tests. **Mandatory**: automated verification that tickets, comments, and stable ticket `id` values survive an application restart MUST run against **PostgreSQL** (e.g. Testcontainers PostgreSQL with stop/start of the Spring context, or separate JVM lifecycle test). This is required for FR-013 / SC-002, not an optional enhancement.

**Rationale**: Restart persistence is a core spec outcome; H2 in-memory does not prove the same guarantees as the primary runtime database.

**Alternatives considered**:
- H2-only restart tests: Insufficient for PostgreSQL persistence proof.
- Manual-only quickstart restart: Insufficient for CI and constitution test gates.

## R11: Frontend stack

**Decision**: React 18 with Vite, TypeScript, React Router, and a thin `api/ticketsClient.ts` module. No global state library unless needed; list/detail state via hooks and router params.

**Rationale**: Constitution requires separated UI, hooks/client, and components. Vite is a minimal modern default for a greenfield React app.

## R12: OpenAPI documentation

**Decision**: `springdoc-openapi-starter-webmvc-ui` exposing `/swagger-ui.html` and `/v3/api-docs`, kept in sync with `contracts/openapi.yaml` as the contract source of truth for reviews.

**Rationale**: Constitution VIII recommends OpenAPI for frontend integration.

## R13: CORS for local development

**Decision**: Allow `http://localhost:5173` (Vite default) in `local` profile only via configuration property.

**Rationale**: Constitution VII; no wildcard in production profile.
