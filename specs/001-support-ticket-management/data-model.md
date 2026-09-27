# Data Model: Support Ticket Management

**Feature**: `001-support-ticket-management`  
**Date**: 2026-09-27

## Overview

Two persisted aggregates: **Ticket** (root) and **Comment** (child). Status lifecycle is enforced in the service layer, not by database triggers.

## Entity: Ticket

| Field | Type | Constraints | Notes |
|-------|------|-------------|--------|
| `id` | BIGINT | PK, generated, immutable | Exposed as unique identifier (FR-003, FR-013) |
| `title` | TEXT | NOT NULL, non-blank (app validation) | Not unique; no max-length product rule |
| `description` | TEXT | NOT NULL, non-blank (app validation) | No max-length product rule |
| `priority` | ENUM | NOT NULL | `LOW`, `MEDIUM`, `HIGH` |
| `assignee` | TEXT | NULL allowed | Optional free text; no max-length product rule |
| `status` | ENUM | NOT NULL | `OPEN`, `IN_PROGRESS`, `RESOLVED`, `CLOSED`, `CANCELLED` |
| `createdAt` | TIMESTAMP | NOT NULL | Implementation metadata; not shown in spec UI |
| `updatedAt` | TIMESTAMP | NOT NULL | Implementation metadata |

**Initial state**: `status = OPEN`, `assignee` null unless provided on create.

**Relationships**: One-to-many to `Comment` (`comments`), `FetchType.LAZY`, cascade persist only for new comments.

## Entity: Comment

| Field | Type | Constraints | Notes |
|-------|------|-------------|--------|
| `id` | BIGINT | PK, generated | |
| `ticket` | FK → Ticket | NOT NULL | Many-to-one |
| `content` | TEXT | NOT NULL, non-blank (app validation) | No author field; no max-length product rule |
| `createdAt` | TIMESTAMP | NOT NULL | Stored for ordering only; not required by spec UI |

## Enumerations

### TicketPriority

`LOW`, `MEDIUM`, `HIGH`

### TicketStatus

`OPEN`, `IN_PROGRESS`, `RESOLVED`, `CLOSED`, `CANCELLED`

## State machine (service layer)

Allowed transitions (FR-009):

```text
OPEN          → IN_PROGRESS | CANCELLED
IN_PROGRESS   → RESOLVED | CANCELLED
RESOLVED      → CLOSED
CLOSED        → (none)
CANCELLED     → (none)
```

All other transitions, including same-status requests, throw `InvalidStatusTransitionException` (FR-010).

## Validation rules (application layer)

| Rule | Layer | Error code (stable) |
|------|--------|---------------------|
| Blank title/description on create/update | Bean Validation (`@NotBlank` only; no `@Size` max) + service | `VALIDATION_ERROR` |
| Invalid priority | Bean Validation | `VALIDATION_ERROR` |
| Blank comment | Bean Validation | `VALIDATION_ERROR` |
| Ticket not found | Service | `TICKET_NOT_FOUND` |
| Illegal status transition | Domain / service | `INVALID_STATUS_TRANSITION` |

## Database schema (Flyway)

**Table `tickets`**

- Columns as above; check constraints or enum mapping via VARCHAR + application enum (portable H2/PostgreSQL).

**Table `comments`**

- `ticket_id` FK → `tickets(id)` ON DELETE RESTRICT (tickets are not deletable in spec; restrict is safe).

**Indexes**

- `idx_tickets_status` on `status` (filter).
- Optional functional/index strategy for search deferred to implementation; LIKE on LOWER(title/description) acceptable at assignment scale.

## DTO mapping (API)

Entities are never exposed directly (Constitution II).

| DTO | Purpose |
|-----|---------|
| `CreateTicketRequest` | title, description, priority, optional assignee |
| `UpdateTicketRequest` | optional fields for PATCH (presence-aware) |
| `TransitionRequest` | target status |
| `CreateCommentRequest` | content |
| `TicketResponse` | id, title, description, priority, assignee, status, comments |
| `TicketSummaryResponse` | id, title, status (list) |
| `CommentResponse` | id, content |

## Undecided spec items — implementation stance

| Spec gap | Implementation choice | Not a product requirement |
|----------|----------------------|---------------------------|
| Sort order | `id DESC` tickets, comment `id ASC` | Documented in research.md R8 |
| Max lengths | Undecided in spec; use TEXT, no max validation | Documented in research.md R9 |
| Empty keyword | Undecided in spec; impl default for absent/blank `q` only | Documented in research.md R4 |
| Timestamps in UI | Not displayed in v1 UI | Columns exist for ordering/debug |
| Ticket/comment delete | No API | No migration for soft delete |
