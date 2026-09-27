# Feature Specification: Support Ticket Management

**Feature Branch**: `001-support-ticket-management`

**Created**: 2026-09-27

**Status**: Draft

**Input**: User description: "A support team needs a simple way to manage the lifecycle of support tickets: create a ticket with title, description, and priority; view the list; open details; update title, description, priority, and assignee; add comments; search by keyword; and filter by current status. Status may move only along the allowed lifecycle, including cancellation from OPEN or IN_PROGRESS. Any other transition is rejected by the system, not only hidden in the screen. Input is validated with meaningful failure feedback. Tickets and comments remain available after the application restarts."

## Clarifications

### Session 2026-09-27

- Q: Must ticket titles be unique? → A: No. Titles are not required to be unique, and scenario wording must not imply a uniqueness rule.
- Q: How is an assignee stored, and must a person sign in? → A: Assignee is an optional value that can be entered and updated directly. The system has no authentication, user accounts, roles, or user directory.
- Q: Which priority values are allowed, and which fields are required to create a ticket? → A: Priority is LOW, MEDIUM, or HIGH. Title, description, and priority are required. Assignee is optional.
- Q: Can title, description, priority, and assignee be edited after RESOLVED, CLOSED, or CANCELLED? → A: Yes. Those fields remain editable in every status, and editing them never changes the status.
- Q: Can a comment be added when a ticket is RESOLVED, CLOSED, or CANCELLED? → A: Yes. Comments can be added in any status. The lifecycle rules control only status transitions.
- Q: Which fields does a keyword search, and does letter case matter? → A: Search matches the ticket title and description. Matching is case-insensitive.
- Q: Do keyword search and status filtering apply together? → A: Yes. When both are supplied, a ticket must satisfy both conditions.
- Q: How many statuses can the filter select at once? → A: One status at a time.
- Q: Is a request to keep the ticket's current status a valid transition? → A: No. It is rejected because it is not one of the explicitly allowed transitions.
- Q: What must a comment contain, and is an author required? → A: A comment must contain non-blank content. No author or account is required.
- Q: How can two tickets with the same title and status be distinguished in the list? → A: Each ticket has a unique identifier, and the list shows that identifier so the tickets can be distinguished and opened separately.
- Q: May a ticket be created with an assignee? → A: Yes. Assignee is optional on create. It may be included or omitted.
- Q: Does an update replace every field, or only the fields included in the update? → A: Updates are partial. Fields that are not included stay unchanged. Clearing an assignee is still supported.
- Q: Do lifecycle rules restrict adding comments? → A: No. Comments are allowed in every status. The state machine controls only status transitions. Comment content must still be non-blank.
- Q: What must a failure response contain? → A: Every failed operation returns a stable machine-readable error code and a human-readable message. An invalid status transition also identifies the current status and the requested status. For a missing ticket, the error code identifies the ticket as not found.
- Q: Does a ticket's unique identifier stay the same after a restart? → A: Yes. The unique identifier remains unchanged after the application restarts, along with the ticket's persisted data.

## User Scenarios & Testing *(mandatory)*

### User Story 1 - Create a ticket and find it again (Priority: P1)

A support user creates a ticket with a title, description, and priority, sees it in the list, and opens it to read the details. A ticket created this way is still there, unchanged, after the application restarts. Another ticket may use the same title.

**Why this priority**: Nothing else in the lifecycle can be managed until a ticket exists and can be found again.

**Independent Test**: Create one ticket with a non-blank title, a non-blank description, and priority HIGH. Confirm it appears in the list and opens with status OPEN. Create a second ticket with the same title. Restart the application and confirm both tickets are still present with the same unique identifiers.

**Acceptance Scenarios**:

1. **Given** the user supplies a non-blank title, a non-blank description, and priority HIGH, **When** the user creates a ticket, **Then** the ticket is saved with status OPEN, with no assignee, and appears in the list.
2. **Given** an OPEN ticket already has a title, **When** the user creates another ticket with that same title, a non-blank description, and priority LOW, **Then** both tickets are OPEN, the list shows a different unique identifier for each, and each can be opened separately.
3. **Given** a ticket exists, **When** the user opens it from the list, **Then** the user sees its title, description, priority, assignee, status, and comments.
4. **Given** a ticket was created, **When** the application is restarted, **Then** that ticket is still in the list with the same unique identifier, and its title, description, priority, and OPEN status are unchanged.
5. **Given** the user is creating a ticket, **When** the title is blank, the description is blank, or the priority is not LOW, MEDIUM, or HIGH, **Then** the ticket is not created, a stable machine-readable error code is returned, and a human-readable message explains the failure.
6. **Given** the user supplies a non-blank title, a non-blank description, priority MEDIUM, and an assignee, **When** the user creates the ticket, **Then** the ticket is saved with status OPEN and that assignee.

---

### User Story 2 - Move a ticket through its lifecycle (Priority: P1)

A support user advances a ticket only along the allowed path, or cancels it from an early status. The system refuses every other status change, including a request to keep the current status, and leaves the ticket as it was.

**Why this priority**: The purpose of the system is to manage ticket lifecycle, and illegal moves must not depend on the screen alone.

**Independent Test**: Create a ticket and attempt each allowed move, a move to the status the ticket already has, and each disallowed example. Confirm allowed moves change the status once, and every other request leaves the status unchanged and explains the failure.

**Acceptance Scenarios**:

1. **Given** a ticket is OPEN, **When** the user moves it to IN_PROGRESS, **Then** the status becomes IN_PROGRESS.
2. **Given** a ticket is IN_PROGRESS, **When** the user moves it to RESOLVED, **Then** the status becomes RESOLVED.
3. **Given** a ticket is RESOLVED, **When** the user moves it to CLOSED, **Then** the status becomes CLOSED.
4. **Given** a ticket is OPEN, **When** the user cancels it, **Then** the status becomes CANCELLED.
5. **Given** a ticket is IN_PROGRESS, **When** the user cancels it, **Then** the status becomes CANCELLED.
6. **Given** a ticket is CLOSED, **When** the user attempts to move it to OPEN, **Then** the status stays CLOSED, a stable machine-readable error code is returned, the response identifies the current status CLOSED and the requested status OPEN, and a human-readable message explains the failure.
7. **Given** a ticket is RESOLVED, **When** the user attempts to move it to OPEN, **Then** the status stays RESOLVED, a stable machine-readable error code is returned, the response identifies the current status RESOLVED and the requested status OPEN, and a human-readable message explains the failure.
8. **Given** a ticket is CANCELLED, **When** the user attempts to move it to OPEN, **Then** the status stays CANCELLED, a stable machine-readable error code is returned, the response identifies the current status CANCELLED and the requested status OPEN, and a human-readable message explains the failure.
9. **Given** a ticket is in any status, **When** the user requests that same status again, **Then** the status stays unchanged, a stable machine-readable error code is returned, the response identifies that current status and the same requested status, and a human-readable message explains the failure.
10. **Given** a ticket is in any status, **When** a status change that is not in the allowed list is submitted, including when the screen would not offer that action, **Then** the system rejects it, the status does not change, a stable machine-readable error code is returned, the response identifies the current status and the requested status, and a human-readable message explains the failure.

---

### User Story 3 - Update ticket details (Priority: P2)

A support user corrects the title, description, priority, or assignee in any status. The edit does not change the status. Assignee is an optional value the user types; it is not chosen from accounts or a directory.

**Why this priority**: The team needs to keep ticket information current, but the ticket is already usable before edits exist.

**Independent Test**: Change each editable field on an OPEN ticket and again on a CLOSED ticket. Confirm the new values are shown and the status is unchanged in both cases.

**Acceptance Scenarios**:

1. **Given** an OPEN ticket, **When** the user changes the title, description, or priority to a valid value, or sets an assignee, **Then** the ticket shows the new value and the status stays OPEN.
2. **Given** an existing ticket, **When** an update has a blank title, a blank description, or a priority other than LOW, MEDIUM, or HIGH, **Then** the previous title, description, priority, assignee, and status remain unchanged, a stable machine-readable error code is returned, and a human-readable message explains the failure.
3. **Given** a ticket is RESOLVED, CLOSED, or CANCELLED, **When** the user changes the title, description, priority, or assignee to a valid value, **Then** the ticket shows the new value and the status stays the same.
4. **Given** a ticket has an assignee, **When** the user explicitly clears the assignee, **Then** the ticket has no assignee, the title, description, and priority stay the same, and the status stays the same.
5. **Given** a ticket has a title, description, priority, and assignee, **When** the user updates only the title, **Then** the title shows the new value and the description, priority, assignee, and status remain unchanged.

---

### User Story 4 - Add comments (Priority: P2)

A support user adds a comment with non-blank content to a ticket in any status. The comment stays with that ticket and is still there after a restart. No author is stored.

**Why this priority**: Discussion supports the work, but creating and moving tickets already delivers a usable lifecycle.

**Independent Test**: Add a comment to an OPEN ticket and to a CANCELLED ticket. Confirm each comment appears only on its ticket. Submit a blank comment and confirm it is rejected. Restart the application and confirm the saved comments remain.

**Acceptance Scenarios**:

1. **Given** a ticket exists, **When** the user adds a comment with non-blank content, **Then** the comment is shown with that ticket and no author is required.
2. **Given** a comment was added, **When** the application is restarted, **Then** the comment is still shown with the same ticket.
3. **Given** two tickets exist, **When** the user adds a comment to one of them, **Then** the other ticket does not gain that comment.
4. **Given** a ticket is RESOLVED, CLOSED, or CANCELLED, **When** the user adds a comment with non-blank content, **Then** the comment is shown with that ticket and the status stays the same.
5. **Given** a ticket exists, **When** the user submits a comment that is empty or only whitespace, **Then** the comment is not added, a stable machine-readable error code is returned, and a human-readable message explains the failure.

---

### User Story 5 - Search and filter the list (Priority: P3)

A support user narrows the list by a keyword, by one current status, or by both together. A keyword matches the title or description without regard to letter case.

**Why this priority**: Finding tickets matters more as the list grows. Create, view, update, comment, and status changes are useful before search and filter exist.

**Independent Test**: Create tickets in more than one status, including titles and descriptions that differ only by letter case. Filter to one status, search for a keyword, then apply both together and confirm a ticket must satisfy both.

**Acceptance Scenarios**:

1. **Given** tickets exist in more than one status, **When** the user filters the list to one status, **Then** the list shows only tickets in that status.
2. **Given** one ticket has the title "Printer jam" and another has the description "Paper jam in the printer", **When** the user searches for "PRINTER", **Then** both tickets are shown.
3. **Given** the word "printer" appears only in a ticket's assignee or comment, **When** the user searches for "printer", **Then** that ticket is not shown because of that word.
4. **Given** an OPEN ticket and a CLOSED ticket both contain "printer" in the title, **When** the user searches for "printer" and filters to OPEN, **Then** only the OPEN ticket is shown.
5. **Given** no ticket satisfies the active keyword and selected status together, **When** the user views the list, **Then** the user sees an empty list.

---

### Edge Cases

- A ticket that does not exist cannot be opened, updated, commented on, or moved. The error code identifies the ticket as not found, a human-readable message explains the failure, and no ticket is created.
- The list is empty when no tickets exist. That is an empty list, not a failure.
- A failed create, update, comment, or status change does not save the failed change. The failure identifies the error and includes a human-readable message.
- Two tickets may share a title and a status. Each has a unique identifier shown in the list, and each can be opened separately.
- A blank or whitespace-only title or description is rejected on create and on update. A priority other than LOW, MEDIUM, or HIGH is rejected. A blank assignee is allowed.
- Skipping ahead is rejected. OPEN cannot move directly to RESOLVED or CLOSED. IN_PROGRESS cannot move directly to CLOSED.
- Moving backward is rejected. IN_PROGRESS cannot move to OPEN. RESOLVED cannot move to IN_PROGRESS or OPEN. CLOSED and CANCELLED cannot move to any status.
- RESOLVED cannot move to CANCELLED. CLOSED cannot move to CANCELLED. CANCELLED cannot move to IN_PROGRESS, RESOLVED, or CLOSED.
- Requesting the status the ticket already has is rejected. OPEN cannot be "moved" to OPEN, and the same rule applies to every other status.
- Editing title, description, priority, or assignee on a RESOLVED, CLOSED, or CANCELLED ticket succeeds when the new values are valid, and the status stays the same.
- A comment with non-blank content can be added in every status. An empty or whitespace-only comment is rejected.
- A keyword matches text in the title or description regardless of letter case. Text that appears only in the assignee or in a comment does not match.
- When a keyword and a status are both used, a ticket that meets only one of those conditions is excluded.
- The status filter applies to one status at a time.
- No maximum length is specified for title, description, assignee, or comment text.
- The order of tickets in the list, and the order of comments on a ticket, is not specified.
- Whether two people can change the same ticket at the same time is not specified.
- Whether a cancellation must include a reason is not specified.
- What happens when the keyword itself is empty is not specified.

## Requirements *(mandatory)*

### Functional Requirements

- **FR-001**: The system MUST allow a user to create a support ticket with a title, a description, and a priority. Title and description MUST contain non-blank content. Priority MUST be one of LOW, MEDIUM, or HIGH. Assignee is optional on create and MAY be included or omitted. If omitted, the new ticket has no assignee. If included, the ticket stores that assignee.
- **FR-002**: A newly created ticket MUST start in status OPEN. Creation MUST NOT let the user choose a different starting status.
- **FR-003**: The system MUST allow a user to view a list of existing tickets. Each ticket MUST have a unique identifier. Each entry in the list MUST show that identifier, the ticket title, and the current status, so two tickets with the same title and status can be distinguished and opened separately. Ticket titles are NOT required to be unique.
- **FR-004**: The system MUST allow a user to open one ticket and view its title, description, priority, assignee, current status, and comments.
- **FR-005**: The system MUST allow a user to update a ticket's title, description, priority, and assignee while the ticket is in any status, including RESOLVED, CLOSED, and CANCELLED. An update MUST change only the fields explicitly included. Every field not included MUST remain unchanged. Omitting the assignee MUST NOT clear it. An explicit request to clear the assignee MUST remove the assignee without changing fields that were not included. A valid update MUST NOT change the ticket status. Title and description MUST remain non-blank. Priority MUST remain one of LOW, MEDIUM, or HIGH.
- **FR-006**: The system MUST allow a user to add a comment to an existing ticket in any status. The comment MUST contain non-blank content, MUST remain associated with that ticket only, and MUST NOT require an author. Adding a comment MUST NOT change the ticket status. The state machine controls only status transitions and MUST NOT restrict adding a comment.
- **FR-007**: The system MUST allow a user to search tickets by a keyword. A ticket matches when the keyword appears in its title or its description. Comparison MUST ignore letter case. A keyword that appears only in the assignee or in a comment MUST NOT match that ticket.
- **FR-008**: The system MUST allow a user to filter the ticket list to one current status at a time. When a keyword and a status are both supplied, the list MUST include only tickets that match the keyword and have that status.
- **FR-009**: The system MUST allow only these status transitions:
  - OPEN → IN_PROGRESS
  - OPEN → CANCELLED
  - IN_PROGRESS → RESOLVED
  - IN_PROGRESS → CANCELLED
  - RESOLVED → CLOSED
- **FR-010**: The system MUST reject every status transition that is not listed in FR-009, including a request to set the status to the ticket's current status. The ticket status MUST stay unchanged. The failure MUST return a stable machine-readable error code and a human-readable message, and MUST identify the ticket's current status and the requested status. This includes CLOSED → OPEN, RESOLVED → OPEN, CANCELLED → OPEN, and OPEN → OPEN.
- **FR-011**: The system MUST enforce FR-009 and FR-010 itself. Hiding a disallowed action on the screen is not sufficient. A disallowed status change that is still submitted MUST be rejected.
- **FR-012**: The system MUST validate ticket and comment input. When an operation fails, the response MUST return a stable machine-readable error code and a human-readable message explaining the failure. The failed change MUST NOT be saved.
- **FR-013**: Tickets and their comments MUST still be available after the application is restarted, with the same content and status they had before the restart. Each ticket's unique identifier MUST remain unchanged.
- **FR-014**: Opening, updating, commenting on, or moving a ticket that does not exist MUST fail. The error code MUST identify the ticket as not found, and the response MUST include a human-readable message. It MUST NOT create a ticket.
- **FR-015**: Anyone using the system MUST be able to create, view, update, comment on, search, filter, and change the status of tickets. The system MUST NOT require sign-in, user accounts, roles, or a user directory. Assignee MUST be an optional value entered and updated directly, not a person chosen from an account list.

### Key Entities *(include if feature involves data)*

- **Ticket**: A single support request. It has a unique identifier, a title, description, priority, assignee, and exactly one current status. Titles are not unique. The list shows the unique identifier with the title and current status, so two tickets with the same title and status can be distinguished and opened separately. The unique identifier remains unchanged after the application restarts. Priority is one of LOW, MEDIUM, or HIGH. Assignee is an optional value and may be included or omitted on create, and may be blank. The status is one of OPEN, IN_PROGRESS, RESOLVED, CLOSED, or CANCELLED. A new ticket starts as OPEN. Title, description, priority, and assignee can be changed in every status without changing that status. An update changes only the fields included in that update. It has zero or more comments.
- **Comment**: A note added to one ticket. It has non-blank content and no author. It can be added in any ticket status. Changing or removing a comment after it is added is not specified. When a comment was written is not specified.
- **Status**: The lifecycle position of a ticket. Allowed moves are only those in FR-009. A move to the same status is not allowed. CLOSED and CANCELLED have no onward move.

## Success Criteria *(mandatory)*

### Measurable Outcomes

- **SC-001**: A user who supplies a non-blank title, a non-blank description, and a priority of LOW, MEDIUM, or HIGH can create a ticket, see it in the list, and open its details in a single session. A second ticket with the same title and status can also be created, distinguished in the list by its unique identifier, and opened separately.
- **SC-002**: After a restart, 100% of tickets and comments that were saved before the restart are still available with the same content and status, and each ticket's unique identifier is unchanged.
- **SC-003**: 100% of status changes outside the allowed list are rejected, including CLOSED → OPEN, RESOLVED → OPEN, CANCELLED → OPEN, skipped steps such as OPEN → RESOLVED, and a request to keep the current status. In each rejected case the status is unchanged, a stable machine-readable error code is returned, the response identifies the current status and the requested status, and a human-readable message explains the failure.
- **SC-004**: Every failed operation returns a stable machine-readable error code and a human-readable message explaining the failure. A blank title, a blank description, a priority outside LOW, MEDIUM, and HIGH, or a blank comment is rejected, and nothing from that failed operation is saved. For a missing ticket, the error code identifies the ticket as not found.
- **SC-005**: From a list of at least 20 tickets spanning more than one status, a user can restrict the list to one status. A keyword includes a ticket when it appears in the title or description regardless of letter case, and excludes a ticket when it appears only in the assignee or a comment. When a keyword and one status are both used, every visible ticket satisfies both.
- **SC-006**: On a RESOLVED, CLOSED, or CANCELLED ticket, a valid edit of title, description, priority, or assignee leaves the status unchanged. A comment with non-blank content can be added in each of those statuses without changing the status.

## Assumptions

### Read directly from the request

- The people served by this specification are members of a support team managing a shared set of tickets.
- Status values and the allowed moves are exactly the ones named in the request. No extra status is included.
- A status change is separate from editing title, description, priority, or assignee, because status is not one of the fields in that update.
- A new ticket starts as OPEN because creation does not accept a status, and OPEN is the start of the stated lifecycle.
- Reopening is excluded by the stated rules. CLOSED, RESOLVED, and CANCELLED cannot move to OPEN, and no other return path is listed.

### Not specified, and not decided here

These items remain undecided. No behavior is required for them until they are decided.

- Maximum lengths for title, description, assignee, and comment text.
- Sort order of the ticket list and of comments.
- Whether a comment stores the time it was written.
- Whether comments can be edited or deleted after they are added.
- Whether tickets can be deleted.
- Whether cancellation requires a reason.
- Whether the list shows every matching ticket or a page at a time.
- How simultaneous edits of the same ticket behave.
- Whether created time, updated time, or a history of status changes is visible.
- How an empty keyword is treated.

### Outside this specification

The following are outside this specification:

- Sign-in, user accounts, roles, and a user directory
- Email, alerts, or other notifications
- File attachments
- Due dates, response-time targets, or escalation
- Categories, tags, or queues beyond a single assignee field
- Dashboards, reports, or bulk changes
- A separate administration area for managing people
