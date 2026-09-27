## /speckit-constitution
> Model: `agent_acp.registry.cursor`  

### **User**
/speckit-constitution

---

## /speckit-constitution 
> Model: `agent_acp.registry.cursor`  

### **User**
/speckit-constitution

### **User**
/speckit-constitution 
Create the initial constitution for the Support Ticket Management System.

The constitution must establish these five core principles:

1. Specification First
Non-trivial functionality MUST be specified before implementation.
Requirements, acceptance criteria, business rules and important constraints
must be established before implementation.

2. Domain and API Integrity
Business rules MUST be enforced by the backend and MUST NOT depend on frontend
behavior.

The ticket lifecycle is:

OPEN -> IN_PROGRESS -> RESOLVED -> CLOSED
OPEN -> CANCELLED
IN_PROGRESS -> CANCELLED

Invalid transitions MUST be rejected by the backend.

REST APIs MUST use consistent contracts, HTTP semantics, validation and
meaningful error responses.

3. Test-Driven Verification
Every functional requirement MUST have appropriate automated verification.
Business rules and invalid scenarios MUST be explicitly tested.
The state machine MUST have automated tests for valid and invalid transitions.
Integration tests MUST be used where behavior depends on multiple layers,
persistence or API contracts.

4. AI-Assisted Engineering with Human Validation
AI-generated requirements, specifications, designs, code, tests and
documentation MUST be treated as proposals rather than authoritative
decisions.

AI output MUST be validated against the approved requirements,
specification, constitution, architecture, tests and engineering standards.

Meaningful AI mistakes affecting requirements, correctness, architecture,
security, testing or maintainability MUST be recorded and resolved.

5. Simplicity and Maintainability
Prefer simple, explicit and maintainable designs.
New complexity MUST have a clear requirement or engineering justification.
Technology MUST NOT be introduced merely because an AI tool suggests it.

Additional Constraints:

Technology and Security Constraints

- Java 21
- Spring Boot
- Maven
- PostgreSQL for application persistence
- H2 may be used for automated tests where appropriate
- REST API
- React/Next.js or equivalent frontend
- Cursor + GitHub Spec Kit
- GitHub Copilot
- GitHub source control

Secrets, credentials, tokens and environment-specific sensitive
configuration MUST NOT be committed.

Development Workflow and Quality Gates:

Requirement
-> Specification
-> Clarification
-> Plan
-> Checklist
-> Tasks
-> Analysis
-> Implementation
-> Testing
-> Review
-> Fix
-> Convergence

Implementation MUST NOT begin merely because an AI agent believes the
requirements are understood.

Before accepting a feature as complete:
- implementation satisfies the specification
- automated tests pass
- invalid business scenarios are verified
- code is reviewed
- meaningful AI mistakes are documented
- remaining gaps are resolved
- implementation converges with the specification

Governance:

The constitution is the highest-level project governance document for
AI-assisted development.

Constitution changes MUST be documented and versioned using semantic versioning.

Requirements belong in feature specifications and MUST NOT be silently
introduced through implementation.

Code review and AI review MUST verify constitutional compliance.

Do not put implementation-specific class names, package names, endpoint paths
or database schemas in the constitution.

Ratification date: 2026-09-27.

*Attachment: Console Selection*
```
diff --git a/.specify/memory/constitution.md b/.specify/memory/constitution.md
index a4670ff..35f4a0f 100644
--- a/.specify/memory/constitution.md
+++ b/.specify/memory/constitution.md
@@ -1,50 +1,70 @@
-# [PROJECT_NAME] Constitution
-<!-- Example: Spec Constitution, TaskFlow Constitution, etc. -->
+<!--
+Sync Impact Report:
+- Version change: Unversioned Scaffold → 1.0.0
+- Bump Rationale: Initial adoption and formal ratification of the Support Ticket Management project constitution.
+- Principles Defined:
+  - I. Domain Integrity & Modularity (Initial definition)
+  - II. Test-First & Automated Verification (NON-NEGOTIABLE) (Initial definition)
+  - III. Strict Security, Privacy & Zero Trust Defaults (Initial definition)
+  - IV. Auditability, Observability & Structured Logging (Initial definition)
+  - V. Simplicity, Minimal Changes & Dependency Discipline (Initial definition)
+- Added Sections:
+  - Security & Compliance Standards
+  - Development Workflow & Quality Gates
+  - Governance
+- Removed Sections: None
+- Follow-up TODOs: None
+-->
+
+# Support Ticket Management Constitution
 
 ## Core Principles
```

*Attachment: Console Selection*
```
# [PROJECT_NAME] Constitution
<!-- Example: Spec Constitution, TaskFlow Constitution, etc. -->

## Core Principles

### [PRINCIPLE_1_NAME]
<!-- Example: I. Library-First -->
[PRINCIPLE_1_DESCRIPTION]
<!-- Example: Every feature starts as a standalone library; Libraries must be self-contained, independently testable, documented; Clear purpose required - no organizational-only libraries -->

### [PRINCIPLE_2_NAME]
<!-- Example: II. CLI Interface -->
[PRINCIPLE_2_DESCRIPTION]
<!-- Example: Every library exposes functionality via CLI; Text in/out protocol: stdin/args → stdout, errors → stderr; Support JSON + human-readable formats -->

### [PRINCIPLE_3_NAME]
<!-- Example: III. Test-First (NON-NEGOTIABLE) -->
[PRINCIPLE_3_DESCRIPTION]
<!-- Example: TDD mandatory: Tests written → User approved → Tests fail → Then implement; Red-Green-Refactor cycle strictly enforced -->

### [PRINCIPLE_4_NAME]
<!-- Example: IV. Integration Testing -->
[PRINCIPLE_4_DESCRIPTION]
<!-- Example: Focus areas requiring integration tests: New library contract tests, Contract changes, Inter-service communication, Shared schemas -->

### [PRINCIPLE_5_NAME]
<!-- Example: V. Observability, VI. Versioning & Breaking Changes, VII. Simplicity -->
[PRINCIPLE_5_DESCRIPTION]
<!-- Example: Text I/O ensures debuggability; Structured logging required; Or: MAJOR.MINOR.BUILD format; Or: Start simple, YAGNI principles -->

## [SECTION_2_NAME]
<!-- Example: Additional Constraints, Security Requirements, Performance Standards, etc. -->

[SECTION_2_CONTENT]
<!-- Example: Technology stack requirements, compliance standards, deployment policies, etc. -->

## [SECTION_3_NAME]
<!-- Example: Development Workflow, Review Process, Quality Gates, etc. -->

[SECTION_3_CONTENT]
<!-- Example: Code review requirements, testing gates, deployment approval process, etc. -->

## Governance
<!-- Example: Constitution supersedes all other practices; Amendments require documentation, approval, migration plan -->

[GOVERNANCE_RULES]
<!-- Example: All PRs/reviews must verify compliance; Complexity must be justified; Use [GUIDANCE_FILE] for runtime development guidance -->

**Version**: [CONSTITUTION_VERSION] | **Ratified**: [RATIFICATION_DATE] | **Last Amended**: [LAST_AMENDED_DATE]
<!-- Example: Version: 2.1.1 | Ratified: 2025-06-13 | Last Amended: 2025-07-16 -->
```

### **User**
/speckit-constitution
Create the initial constitution for the Support Ticket Management System.
The constitution must establish these five core principles:
1.
Specification First
Non-trivial functionality MUST be specified before implementation.
Requirements, acceptance criteria, business rules and important constraints
must be established before implementation.
2.
Domain and API Integrity
Business rules MUST be enforced by the backend and MUST NOT depend on frontend
behavior.
The ticket lifecycle is:
OPEN -> IN_PROGRESS -> RESOLVED -> CLOSED
OPEN -> CANCELLED
IN_PROGRESS -> CANCELLED
Invalid transitions MUST be rejected by the backend.
REST APIs MUST use consistent contracts, HTTP semantics, validation and
meaningful error responses.
3.
Test-Driven Verification
Every functional requirement MUST have appropriate automated verification.
Business rules and invalid scenarios MUST be explicitly tested.
The state machine MUST have automated tests for valid and invalid transitions.
Integration tests MUST be used where behavior depends on multiple layers,
persistence or API contracts.
4.
AI-Assisted Engineering with Human Validation
AI-generated requirements, specifications, designs, code, tests and
documentation MUST be treated as proposals rather than authoritative
decisions.
AI output MUST be validated against the approved requirements,
specification, constitution, architecture, tests and engineering standards.
Meaningful AI mistakes affecting requirements, correctness, architecture,
security, testing or maintainability MUST be recorded and resolved.
5.
Simplicity and Maintainability
Prefer simple, explicit and maintainable designs.
New complexity MUST have a clear requirement or engineering justification.
Technology MUST NOT be introduced merely because an AI tool suggests it.
Additional Constraints:
Technology and Security Constraints
•
Java 21
•
Spring Boot
•
Maven
•
PostgreSQL for application persistence
•
H2 may be used for automated tests where appropriate
•
REST API
•
React/Next.js or equivalent frontend
•
Cursor + GitHub Spec Kit
•
GitHub Copilot
•
GitHub source control
Secrets, credentials, tokens and environment-specific sensitive
configuration MUST NOT be committed.
Development Workflow and Quality Gates:
Requirement
-> Specification
-> Clarification
-> Plan
-> Checklist
-> Tasks
-> Analysis
-> Implementation
-> Testing
-> Review
-> Fix
-> Convergence
Implementation MUST NOT begin merely because an AI agent believes the
requirements are understood.
Before accepting a feature as complete:
•
implementation satisfies the specification
•
automated tests pass
•
invalid business scenarios are verified
•
code is reviewed
•
meaningful AI mistakes are documented
•
remaining gaps are resolved
•
implementation converges with the specification
Governance:
The constitution is the highest-level project governance document for
AI-assisted development.
Constitution changes MUST be documented and versioned using semantic versioning.
Requirements belong in feature specifications and MUST NOT be silently
introduced through implementation.
Code review and AI review MUST verify constitutional compliance.
Do not put implementation-specific class names, package names, endpoint paths
or database schemas in the constitution.
Ratification date: 2026-09-27.

*Attachment: Console Selection*
```
diff --git a/.specify/memory/constitution.md b/.specify/memory/constitution.md
index a4670ff..35f4a0f 100644
--- a/.specify/memory/constitution.md
+++ b/.specify/memory/constitution.md
@@ -1,50 +1,70 @@
-# [PROJECT_NAME] Constitution
-<!-- Example: Spec Constitution, TaskFlow Constitution, etc. -->
+<!--
+Sync Impact Report:
+- Version change: Unversioned Scaffold → 1.0.0
+- Bump Rationale: Initial adoption and formal ratification of the Support Ticket Management project constitution.
+- Principles Defined:
+  - I. Domain Integrity & Modularity (Initial definition)
+  - II. Test-First & Automated Verification (NON-NEGOTIABLE) (Initial definition)
+  - III. Strict Security, Privacy & Zero Trust Defaults (Initial definition)
+  - IV. Auditability, Observability & Structured Logging (Initial definition)
+  - V. Simplicity, Minimal Changes & Dependency Discipline (Initial definition)
+- Added Sections:
+  - Security & Compliance Standards
+  - Development Workflow & Quality Gates
+  - Governance
+- Removed Sections: None
+- Follow-up TODOs: None
+-->
+
+# Support Ticket Management Constitution
 
 ## Core Principles
```

*Attachment: Console Selection*
```
# [PROJECT_NAME] Constitution
<!-- Example: Spec Constitution, TaskFlow Constitution, etc. -->

## Core Principles

### [PRINCIPLE_1_NAME]
<!-- Example: I. Library-First -->
[PRINCIPLE_1_DESCRIPTION]
<!-- Example: Every feature starts as a standalone library; Libraries must be self-contained, independently testable, documented; Clear purpose required - no organizational-only libraries -->

### [PRINCIPLE_2_NAME]
<!-- Example: II. CLI Interface -->
[PRINCIPLE_2_DESCRIPTION]
<!-- Example: Every library exposes functionality via CLI; Text in/out protocol: stdin/args → stdout, errors → stderr; Support JSON + human-readable formats -->

### [PRINCIPLE_3_NAME]
<!-- Example: III. Test-First (NON-NEGOTIABLE) -->
[PRINCIPLE_3_DESCRIPTION]
<!-- Example: TDD mandatory: Tests written → User approved → Tests fail → Then implement; Red-Green-Refactor cycle strictly enforced -->

### [PRINCIPLE_4_NAME]
<!-- Example: IV. Integration Testing -->
[PRINCIPLE_4_DESCRIPTION]
<!-- Example: Focus areas requiring integration tests: New library contract tests, Contract changes, Inter-service communication, Shared schemas -->

### [PRINCIPLE_5_NAME]
<!-- Example: V. Observability, VI. Versioning & Breaking Changes, VII. Simplicity -->
[PRINCIPLE_5_DESCRIPTION]
<!-- Example: Text I/O ensures debuggability; Structured logging required; Or: MAJOR.MINOR.BUILD format; Or: Start simple, YAGNI principles -->

## [SECTION_2_NAME]
<!-- Example: Additional Constraints, Security Requirements, Performance Standards, etc. -->

[SECTION_2_CONTENT]
<!-- Example: Technology stack requirements, compliance standards, deployment policies, etc. -->

## [SECTION_3_NAME]
<!-- Example: Development Workflow, Review Process, Quality Gates, etc. -->

[SECTION_3_CONTENT]
<!-- Example: Code review requirements, testing gates, deployment approval process, etc. -->

## Governance
<!-- Example: Constitution supersedes all other practices; Amendments require documentation, approval, migration plan -->

[GOVERNANCE_RULES]
<!-- Example: All PRs/reviews must verify compliance; Complexity must be justified; Use [GUIDANCE_FILE] for runtime development guidance -->

**Version**: [CONSTITUTION_VERSION] | **Ratified**: [RATIFICATION_DATE] | **Last Amended**: [LAST_AMENDED_DATE]
<!-- Example: Version: 2.1.1 | Ratified: 2025-06-13 | Last Amended: 2025-07-16 -->
```

---

## /speckit-constitution I want to establish the engineering principles for this Support Ticket Management System before we start defining the feature.
                      
                      This…
> Model: `agent_acp.registry.cursor`  

### **User**
/speckit-constitution I want to establish the engineering principles for this Support Ticket Management System before we start defining the feature.
                      
                      This is a Java 21 + Spring Boot backend with a REST API, PostgreSQL for application persistence, H2 where appropriate for tests, and a React-based frontend.
                      
                      The project is also being evaluated on how we use AI, so the development process should be spec-driven and reviewable.
                      
                      Please create a project constitution that establishes practical principles around:
                      
                      - Clean and maintainable Java/Spring Boot code
                      - Clear separation of responsibilities
                      - API consistency
                      - Backend validation
                      - Automated testing
                      - Database and persistence practices
                      - Security and secret management
                      - Documentation
                      - Code review
                      - AI-generated code review and human verification
                      
                      Keep the principles practical for this assignment. Don't introduce unnecessary enterprise architecture or technologies that aren't required by the problem.
                      
                      We should prefer simple solutions when the requirements don't justify additional complexity.

### **User**
/speckit-constitution I want to establish the engineering principles for this Support Ticket Management System before we start defining the feature.
                      
                      This is a Java 21 + Spring Boot backend with a REST API, PostgreSQL for application persistence, H2 where appropriate for tests, and a React-based frontend.
                      
                      The project is also being evaluated on how we use AI, so the development process should be spec-driven and reviewable.
                      
                      Please create a project constitution that establishes practical principles around:
                      
                      - Clean and maintainable Java/Spring Boot code
                      - Clear separation of responsibilities
                      - API consistency
                      - Backend validation
                      - Automated testing
                      - Database and persistence practices
                      - Security and secret management
                      - Documentation
                      - Code review
                      - AI-generated code review and human verification
                      
                      Keep the principles practical for this assignment. Don't introduce unnecessary enterprise architecture or technologies that aren't required by the problem.
                      
                      We should prefer simple solutions when the requirements don't justify additional complexity.

### **User**
/speckit-specify I need to define the requirements for a Support Ticket Management System.
                 
                 The goal is to give a support team a simple way to manage the lifecycle of support tickets.
                 
                 A user should be able to:
                 
                 - Create a support ticket with a title, description and priority.
                 - View a list of existing tickets.
                 - Open a ticket and view its details.
                 - Update the ticket title, description, priority and assignee.
                 - Add comments to a ticket.
                 - Search tickets using a keyword.
                 - Filter tickets by their current status.
                 
                 A ticket has a lifecycle with these allowed transitions:
                 
                 OPEN → IN_PROGRESS
                 IN_PROGRESS → RESOLVED
                 RESOLVED → CLOSED
                 
                 A ticket can also be cancelled from:
                 
                 OPEN → CANCELLED
                 IN_PROGRESS → CANCELLED
                 
                 Any other transition must be rejected.
                 
                 For example, these must not be allowed:
                 
                 CLOSED → OPEN
                 RESOLVED → OPEN
                 CANCELLED → OPEN
                 
                 The backend must be authoritative for enforcing these lifecycle rules. The UI should not be the only place where invalid transitions are prevented.
                 
                 The system must validate ticket input and provide meaningful feedback when an operation fails.
                 
                 Tickets and comments must be persisted so that the data is still available after the application is restarted.
                 
                 The specification should focus on user-visible behaviour, business rules, acceptance criteria, edge cases and scope.
                 
                 Please do not design the technical implementation yet. Don't decide the database, Java classes, Spring controllers, React components, API endpoints or infrastructure at this stage.
                 
                 If something is ambiguous or missing from the requirements, identify it instead of silently inventing a requirement.

*Attachment: Console Selection*
```
<!--
Sync Impact Report:
- Version change: None (Initial Template) → 1.0.0
- List of modified principles:
  - [PRINCIPLE_1_NAME] → I. Clean & Maintainable Java 21 / Spring Boot Code
  - [PRINCIPLE_2_NAME] → II. Clear Separation of Responsibilities
  - [PRINCIPLE_3_NAME] → III. REST API Consistency & Standardized Error Contracts
  - [PRINCIPLE_4_NAME] → IV. Robust Backend Validation & Defensive Ingestion
  - [PRINCIPLE_5_NAME] → V. Comprehensive Automated Testing Strategy
  - Added: VI. Pragmatic Database & Persistence Practices (PostgreSQL & H2)
  - Added: VII. Security Defaults & Zero Secret Leakage
  - Added: VIII. Living, Spec-Driven Documentation
  - Added: IX. Minimal, Reviewable & Incremental Changes
  - Added: X. AI-Assisted Engineering & Mandatory Human Verification
- Added sections:
  - Technology Standards & Architectural Constraints
  - Development Workflow & Quality Gates
  - Governance
- Removed sections: None
- Follow-up TODOs: None
-->

# Support Ticket Management System Constitution

## Core Principles

### I. Clean & Maintainable Java 21 / Spring Boot Code
The backend MUST be written in clean, idiomatic Java 21 utilizing modern language features (such as records for immutable DTOs, pattern matching, and text blocks) where they improve clarity and reduce boilerplate. The application MUST leverage standard Spring Boot conventions, employing constructor-based dependency injection exclusively (field injection via `@Autowired` is forbidden). Speculative design patterns, overly complex inheritance hierarchies, and premature enterprise abstractions are prohibited. Code MUST be readable, self-explanatory, and adhere to standard Java naming and formatting conventions.
*Rationale*: A clean, idiomatic codebase minimizes cognitive load, accelerates debugging, and ensures that the system remains focused on solving core business problems rather than wrestling with accidental architectural complexity.

### II. Clear Separation of Responsibilities
The system MUST enforce strict architectural boundaries across both backend and frontend layers:
- **Presentation / Controller Layer**: `@RestController` classes MUST only handle HTTP routing, request parsing, input validation triggering, and mapping domain responses to DTOs. Controllers MUST NOT contain business logic or direct persistence calls.
- **Service / Business Layer**: `@Service` classes MUST encapsulate all domain logic, workflow orchestration, business transaction boundaries (`@Transactional`), and authorization checks. Services MUST remain independent of HTTP transport primitives (e.g., `HttpServletRequest` or raw HTTP status codes).
- **Persistence / Data Layer**: `@Repository` interfaces MUST manage data access and database operations using Spring Data JPA. Persistence exceptions MUST be handled or translated before reaching the presentation layer.
- **Data Transfer Objects (DTOs)**: Domain entities (`@Entity`) MUST NOT be directly exposed over REST endpoints. Dedicated request and response DTO records MUST mediate all client-server communications.
- **Frontend Layer**: The React frontend MUST maintain separation between presentation components, custom hooks for API communication, and state management.
*Rationale*: Strict separation of concerns simplifies unit and slice testing, prevents tight coupling, and ensures changes to data storage or UI do not cause cascading failures across business logic.

### III. REST API Consistency & Standardized Error Contracts
The backend MUST provide a predictable, RESTful API design:
- Endpoints MUST use plural nouns for resources (e.g., `/api/v1/tickets`), standard HTTP verbs (`GET`, `POST`, `PUT`, `PATCH`, `DELETE`) with their canonical semantics, and explicit version prefixes (`/api/v1`).
- Responses MUST use standard HTTP status codes (`200 OK`, `201 Created`, `204 No Content`, `400 Bad Request`, `404 Not Found`, `409 Conflict`, `422 Unprocessable Entity`, `500 Internal Server Error`).
- All error responses MUST follow a uniform, structured format (RFC 7807/9457 `ProblemDetail` or standard JSON containing `timestamp`, `status`, `error`, `message`, `path`, and validation failure details).
- All JSON field names MUST strictly adhere to `camelCase` formatting.
*Rationale*: Consistent API contracts reduce friction between frontend and backend integration, improve client usability, and provide unambiguous error diagnostics.

### IV. Robust Backend Validation & Defensive Ingestion
All input entering the backend MUST be validated defensively at the controller boundary using Jakarta Bean Validation annotations (`@Valid`, `@NotNull`, `@NotBlank`, `@Size`, etc.):
- Complex business rules, cross-field dependencies, and state-machine transitions (e.g., invalid ticket status progressions) MUST be enforced inside the service domain layer and produce explicit domain exceptions.
- Client-side validation in React MUST serve only to enhance user experience; it MUST NEVER be relied upon as a security or data integrity boundary.
- Validation failures MUST return human-readable, field-specific error messages in the standardized error payload without leaking internal stack traces or database schema details.
*Rationale*: Authoritative backend validation guarantees data consistency, prevents data corruption, and shields the application from invalid or malicious payloads.

### V. Comprehensive Automated Testing Strategy
Quality MUST be enforced through a balanced, automated test pyramid:
- **Unit Tests**: Domain logic, ticket state transitions, and business calculations MUST be tested in isolation using JUnit 5 and Mockito. Unit tests MUST run quickly with no external dependencies.
- **Web Slice Tests**: Controllers and validation rules MUST be verified using `@WebMvcTest` with mocked service beans to confirm HTTP status codes, deserialization, and error handling.
- **Data Slice Tests**: Custom queries, repository methods, and JPA mappings MUST be verified with `@DataJpaTest` using an in-memory H2 database.
- **Integration Tests**: Critical end-to-end user workflows MUST be validated via `@SpringBootTest` to ensure cross-layer coordination and correct database transactions.
- All tests MUST be deterministic, isolated, and repeatable. Any bug fix or new requirement MUST include automated tests demonstrating the fix or behavior.
*Rationale*: Automated tests build a reliable safety net that enables rapid iteration and confident refactoring while serving as executable documentation for the system.

### VI. Pragmatic Database & Persistence Practices
Data persistence MUST balance production reliability with rapid test execution:
- The persistent application runtime MUST use PostgreSQL.
- Fast automated tests SHOULD utilize in-memory H2 where appropriate, provided test configurations do not rely on H2-specific quirks that diverge from PostgreSQL behavior.
- Database schema changes MUST be structured, reproducible, and tracked via versioned migration scripts (Flyway) or clean DDL scripts; uncontrolled schema auto-generation (`hibernate.ddl-auto=update` or `create-drop`) in production environments is forbidden.
- JPA entities MUST specify appropriate identifier strategies (`GenerationType.IDENTITY` or `SEQUENCE`), use `FetchType.LAZY` by default for entity associations to avoid N+1 query performance traps, and enforce database-level constraints (foreign keys, nullability, unique indexes).
*Rationale*: Reproducible schema management and prudent persistence practices guarantee data integrity, predictable query performance, and smooth transitions from local testing to persistent environments.

### VII. Security Defaults & Zero Secret Leakage
The application MUST be built with security by default:
- **Zero Committed Secrets**: Passwords, database credentials, API keys, and private tokens MUST NEVER be committed to the repository. All secrets MUST be injected via environment variables or externalized configurations.
- **Injection Prevention**: Raw string concatenation in SQL queries is strictly prohibited; all database interactions MUST use parameterized JPA queries or prepared statements.
- **CORS & CSRF**: Cross-Origin Resource Sharing (CORS) MUST be configured to allow only legitimate frontend origins; permissive wildcard (`*`) origins in production profiles are forbidden.
- **Sanitized Outputs**: System stack traces, internal paths, and framework diagnostics MUST NEVER be exposed in API error payloads or client-visible logs.
*Rationale*: Enforcing strict secret hygiene and defensive coding defaults protects the application from common vulnerabilities and avoids data breaches.

### VIII. Living, Spec-Driven Documentation
The project MUST follow a spec-driven development methodology:
- Every feature MUST proceed through structured specification (`spec.md`), technical planning (`plan.md`), and task breakdowns (`tasks.md`) before implementation begins.
- Documentation and code MUST evolve in lockstep; documentation that diverges from implementation is considered a defect.
- The REST API contract SHOULD be documented using OpenAPI / Swagger specifications (`springdoc-openapi`) to provide interactive exploration for frontend integration.
- The project `README.md` MUST provide straightforward instructions for environment setup (Java 21, Node.js, PostgreSQL/Docker), running the application, and executing tests.
*Rationale*: Up-to-date documentation aligns team understanding, facilitates human review, and provides clear guardrails for AI-assisted workflows.

### IX. Minimal, Reviewable & Incremental Changes
Engineering changes MUST adhere to the principle of simplicity and minimal footprint:
- Implementations MUST prefer the simplest solution that meets functional and non-functional requirements. Premature microservices, distributed event brokers, reactive streams, or unnecessary dependencies MUST NOT be introduced without clear justification.
- Changes MUST be broken into small, atomic, and logically cohesive commits following Conventional Commits format (`feat:`, `fix:`, `test:`, `docs:`, `refactor:`).
- Code reviews MUST be easy to conduct, with each change having a clear purpose, zero extraneous formatting churn, and no unrelated refactorings.
*Rationale*: Smaller, well-scoped changes reduce review fatigue, simplify rollback if issues arise, and ensure that the codebase remains clean and understandable.

### X. AI-Assisted Engineering & Mandatory Human Verification
Because this project is evaluated on the disciplined use of AI, AI tools MUST operate under strict engineering governance:
- **Spec-Driven Prompts**: AI agents MUST be guided by defined specifications, plans, and the constraints of this constitution. Ad-hoc, unstructured code generation without prior planning is prohibited.
- **Mandatory Human Verification**: All AI-generated code, tests, and configuration MUST be reviewed, understood, and validated by a human engineer before merging. Blind acceptance of AI suggestions is strictly forbidden.
- **Equal Quality Standards**: AI-generated code MUST satisfy the exact same quality, test coverage, style, and security gates as human-written code.
- **Hallucination Prevention**: All third-party libraries, APIs, and Spring Boot features proposed by AI MUST be audited to verify they exist and match the target tech stack (Java 21, Spring Boot 3, React).
*Rationale*: Systematic human oversight and spec-driven AI execution demonstrate mature engineering discipline, ensuring code ownership and preventing the introduction of hallucinated or unverified dependencies.

## Technology Standards & Architectural Constraints

The Support Ticket Management System MUST adhere to the following technology choices and constraints:
- **Backend Framework**: Java 21 LTS with Spring Boot 3.x using `spring-boot-starter-web`, `spring-boot-starter-data-jpa`, and `spring-boot-starter-validation`.
- **Backend Architecture**: A modular monolith architecture organized by domain capabilities with clear controller, service, repository, and DTO layers.
- **Persistence**: PostgreSQL as the primary database for persistent development and production runtimes; H2 in-memory database reserved for fast automated integration tests where applicable.
- **Frontend Architecture**: Modern React application structured with clear separation between UI components, state management, and an API client service layer.
- **Simplicity Constraint**: Enterprise patterns such as CQRS, Event Sourcing, microservices architectures, and asynchronous messaging brokers (e.g., Kafka, RabbitMQ) MUST NOT be introduced unless explicit project requirements mandate them.

## Development Workflow & Quality Gates

All feature development and maintenance MUST progress through the following sequential quality gates:
1. **Specify Gate**: Define the problem statement, user stories, acceptance criteria, and operational boundaries in `spec.md` (`/speckit-specify`).
2. **Plan Gate**: Formulate technical design, data models, API endpoints, error handling strategies, and test coverage plans in `plan.md` (`/speckit-plan`).
3. **Tasks Gate**: Decompose the implementation plan into ordered, testable, and independently verifiable task items in `tasks.md` (`/speckit-tasks`).
4. **Implementation & Test Gate**: Implement the functionality following the defined tasks. Code MUST be accompanied by unit and slice tests verifying both positive scenarios and boundary conditions.
5. **Review & Human Verification Gate**: Perform automated test execution (must pass 100%), verify absence of hardcoded secrets or unneeded dependencies, inspect AI-generated artifacts, and validate adherence to this constitution.

## Governance

This constitution serves as the foundational authority for all architectural, implementation, and code evaluation decisions in this repository:
- **Supremacy**: The principles and constraints outlined in this document supersede all conflicting ad-hoc practices, individual preferences, or unchecked AI generation outputs.
- **Amendment Procedure**: Any amendment to this constitution MUST be proposed with explicit justification, reviewed against project goals, and documented with an updated Sync Impact Report.
- **Versioning Policy**: The constitution version MUST follow semantic versioning rules:
  - **MAJOR** version bumps signify backward-incompatible governance removals, foundational architecture changes, or major principle redefinitions.
  - **MINOR** version bumps signify the addition of new principles, structural sections, or material expansion of development constraints.
  - **PATCH** version bumps signify clarifications, typographical corrections, or non-semantic wording refinements.
- **Compliance Auditing**: Every specification, plan, task list, and pull request MUST be verified against this constitution before implementation or merging.

**Version**: 1.0.0 | **Ratified**: 2026-09-27 | **Last Amended**: 2026-09-27
```

### **User**
/speckit-clarify I've reviewed the generated specification and there are a few points that need an explicit decision before we move to technical planning.
                  
                  Please focus the clarification on the existing ambiguities rather than introducing new features.
                  
                  For this project, I'd like to clarify the following:
                  
                  1. Ticket titles do not need to be unique unless the original requirement explicitly requires uniqueness. The wording in one acceptance scenario should not imply a uniqueness constraint.
                  
                  2. Keep assignee simple for this assignment. Treat it as an optional value that can be entered/updated directly. We are not introducing authentication, user accounts, roles, or a user directory.
                  
                  3. Use three priority values:
                     - LOW
                     - MEDIUM
                     - HIGH
                  
                     Title, description, and priority are required when creating a ticket. Assignee is optional.
                  
                  4. Ticket title, description, priority, and assignee can still be edited after a ticket reaches RESOLVED, CLOSED, or CANCELLED. Editing these fields must never change the ticket status.
                  
                  5. Comments can be added to an existing ticket regardless of its current status. The state machine only controls status transitions.
                  
                  6. Search should match against the ticket title and description, and matching should be case-insensitive.
                  
                  7. Search and status filtering should work together. If both are supplied, the result must satisfy both conditions.
                  
                  8. The status filter should support selecting one status at a time.
                  
                  9. If a requested status is the same as the current status, treat it as an invalid transition because it is not one of the explicitly allowed transitions.
                  
                  10. A comment must contain non-blank content. No author/account model is required.
                  
                  Please use these decisions to resolve the relevant clarification points in the specification.
                  
                  Do not start technical planning or implementation yet.

*Attachment: Console Selection*
```
# Feature Specification: Support Ticket Management

**Feature Branch**: `001-support-ticket-management`

**Created**: 2026-09-27

**Status**: Draft

**Input**: User description: "A support team needs a simple way to manage the lifecycle of support tickets: create a ticket with title, description, and priority; view the list; open details; update title, description, priority, and assignee; add comments; search by keyword; and filter by current status. Status may move only along the allowed lifecycle, including cancellation from OPEN or IN_PROGRESS. Any other transition is rejected by the system, not only hidden in the screen. Input is validated with meaningful failure feedback. Tickets and comments remain available after the application restarts."

## User Scenarios & Testing *(mandatory)*

### User Story 1 - Create a ticket and find it again (Priority: P1)

A support user creates a ticket with a title, description, and priority, sees it in the list, and opens it to read the details. A ticket created this way is still there, unchanged, after the application restarts.

**Why this priority**: Nothing else in the lifecycle can be managed until a ticket exists and can be found again.

**Independent Test**: Create one ticket with a title, description, and priority, confirm it appears in the list, open it, restart the application, and confirm the same ticket is still present with the same details.

**Acceptance Scenarios**:

1. **Given** no ticket with a chosen title exists, **When** the user creates a ticket with that title, a description, and a priority, **Then** the ticket is saved with status OPEN and appears in the list.
2. **Given** a ticket exists, **When** the user opens it from the list, **Then** the user sees its title, description, priority, assignee, status, and comments.
3. **Given** a ticket was created, **When** the application is restarted, **Then** that ticket is still in the list and its title, description, priority, and OPEN status are unchanged.
4. **Given** the user is creating a ticket, **When** the supplied input is invalid, **Then** the ticket is not created and the user is told why the operation failed.

---

### User Story 2 - Move a ticket through its lifecycle (Priority: P1)

A support user advances a ticket only along the allowed path, or cancels it from an early status. The system refuses every other status change and leaves the ticket as it was.

**Why this priority**: The purpose of the system is to manage ticket lifecycle, and illegal moves must not depend on the screen alone.

**Independent Test**: Create a ticket and attempt each allowed move and each disallowed example. Confirm allowed moves change the status once, and disallowed moves leave the status unchanged and explain the failure.

**Acceptance Scenarios**:

1. **Given** a ticket is OPEN, **When** the user moves it to IN_PROGRESS, **Then** the status becomes IN_PROGRESS.
2. **Given** a ticket is IN_PROGRESS, **When** the user moves it to RESOLVED, **Then** the status becomes RESOLVED.
3. **Given** a ticket is RESOLVED, **When** the user moves it to CLOSED, **Then** the status becomes CLOSED.
4. **Given** a ticket is OPEN, **When** the user cancels it, **Then** the status becomes CANCELLED.
5. **Given** a ticket is IN_PROGRESS, **When** the user cancels it, **Then** the status becomes CANCELLED.
6. **Given** a ticket is CLOSED, **When** the user attempts to move it to OPEN, **Then** the status stays CLOSED and the user is told the change is not allowed.
7. **Given** a ticket is RESOLVED, **When** the user attempts to move it to OPEN, **Then** the status stays RESOLVED and the user is told the change is not allowed.
8. **Given** a ticket is CANCELLED, **When** the user attempts to move it to OPEN, **Then** the status stays CANCELLED and the user is told the change is not allowed.
9. **Given** a ticket is in any status, **When** a status change that is not in the allowed list is submitted, including when the screen would not offer that action, **Then** the system rejects it, the status does not change, and the user is told the change is not allowed.

---

### User Story 3 - Update ticket details (Priority: P2)

A support user corrects the title, description, priority, or assignee without that edit itself changing the status.

**Why this priority**: The team needs to keep ticket information current, but the ticket is already usable before edits exist.

**Independent Test**: Open an OPEN ticket, change each editable field to a new valid value, and confirm the new values are shown while the status stays OPEN.

**Acceptance Scenarios**:

1. **Given** an OPEN ticket, **When** the user changes the title, description, priority, or assignee to a valid value, **Then** the ticket shows the new value and the status stays OPEN.
2. **Given** an existing ticket, **When** an update is invalid, **Then** the previous title, description, priority, assignee, and status remain unchanged and the user is told why the update failed.
3. **Given** a ticket is RESOLVED, CLOSED, or CANCELLED, **When** the user attempts to change title, description, priority, or assignee, **Then** the outcome follows the unresolved rule in FR-016.

---

### User Story 4 - Add comments (Priority: P2)

A support user adds a comment to a ticket so the conversation stays with that ticket. Comments are still there after a restart.

**Why this priority**: Discussion supports the work, but creating and moving tickets already delivers a usable lifecycle.

**Independent Test**: Open a ticket, add a comment, confirm it appears on that ticket only, restart the application, and confirm the comment is still present.

**Acceptance Scenarios**:

1. **Given** a ticket exists, **When** the user adds a comment, **Then** the comment is shown with that ticket.
2. **Given** a comment was added, **When** the application is restarted, **Then** the comment is still shown with the same ticket.
3. **Given** two tickets exist, **When** the user adds a comment to one of them, **Then** the other ticket does not gain that comment.
4. **Given** a ticket is RESOLVED, CLOSED, or CANCELLED, **When** the user attempts to add a comment, **Then** the outcome follows the unresolved rule in FR-016.

---

### User Story 5 - Search and filter the list (Priority: P3)

A support user narrows the list by a keyword and by the ticket's current status.

**Why this priority**: Finding tickets matters more as the list grows. Create, view, update, comment, and status changes are useful before search and filter exist.

**Independent Test**: Create tickets in more than one status, filter the list to one status, and search with a keyword that matches only some tickets.

**Acceptance Scenarios**:

1. **Given** tickets exist in more than one status, **When** the user filters the list to one status, **Then** the list shows tickets in that status.
2. **Given** tickets exist, **When** the user searches with a keyword, **Then** the list is limited using that keyword.
3. **Given** no ticket satisfies the active filter or keyword, **When** the user views the list, **Then** the user sees an empty list and is not shown an unrelated ticket.

---

### Edge Cases

- A ticket that does not exist cannot be opened, updated, commented on, or moved. The user is told it was not found, and no ticket is created.
- The list is empty when no tickets exist. That is an empty list, not a failure.
- A failed create, update, comment, or status change does not save the failed change.
- Skipping ahead is rejected. OPEN cannot move directly to RESOLVED or CLOSED. IN_PROGRESS cannot move directly to CLOSED.
- Moving backward is rejected. IN_PROGRESS cannot move to OPEN. RESOLVED cannot move to IN_PROGRESS or OPEN. CLOSED and CANCELLED cannot move to any status.
- RESOLVED cannot move to CANCELLED. CLOSED cannot move to CANCELLED. CANCELLED cannot move to IN_PROGRESS, RESOLVED, or CLOSED.
- Repeating the current status is not specified. It is unknown whether that attempt succeeds as no change or is rejected.
- Which ticket fields a keyword searches, whether matching ignores letter case, and whether a keyword and a status filter apply together are not specified.
- Whether a blank title, blank description, blank comment, or blank assignee is rejected is not fully specified. Mandatory content and allowed priority values are unresolved (FR-017).
- No maximum length is specified for title, description, priority, assignee, or comment text.
- The order of tickets in the list, and the order of comments on a ticket, is not specified.
- Whether two people can change the same ticket at the same time is not specified.
- Whether a cancellation must include a reason is not specified.

## Requirements *(mandatory)*

### Functional Requirements

- **FR-001**: The system MUST allow a user to create a support ticket by supplying a title, a description, and a priority.
- **FR-002**: A newly created ticket MUST start in status OPEN. Creation MUST NOT let the user choose a different starting status.
- **FR-003**: The system MUST allow a user to view a list of existing tickets. Each entry in the list MUST show the ticket title and current status.
- **FR-004**: The system MUST allow a user to open one ticket and view its title, description, priority, assignee, current status, and comments.
- **FR-005**: The system MUST allow a user to update a ticket's title, description, priority, and assignee. That update MUST NOT by itself change the ticket status.
- **FR-006**: The system MUST allow a user to add a comment to a ticket. The comment MUST remain associated with that ticket and only that ticket.
- **FR-007**: The system MUST allow a user to search tickets using a keyword. Which fields are searched, how a match is decided, and whether search combines with a status filter are not specified.
- **FR-008**: The system MUST allow a user to filter the ticket list by current status. Whether more than one status can be selected at the same time is not specified.
- **FR-009**: The system MUST allow only these status transitions:
  - OPEN → IN_PROGRESS
  - OPEN → CANCELLED
  - IN_PROGRESS → RESOLVED
  - IN_PROGRESS → CANCELLED
  - RESOLVED → CLOSED
- **FR-010**: The system MUST reject every status transition that is not listed in FR-009. The ticket status MUST stay unchanged. The user MUST be told that the change is not allowed. This includes CLOSED → OPEN, RESOLVED → OPEN, and CANCELLED → OPEN.
- **FR-011**: The system MUST enforce FR-009 and FR-010 itself. Hiding a disallowed action on the screen is not sufficient. A disallowed status change that is still submitted MUST be rejected.
- **FR-012**: The system MUST validate ticket and comment input. When an operation fails, the user MUST receive an explanation of why it failed, and the failed change MUST NOT be saved.
- **FR-013**: Tickets and their comments MUST still be available after the application is restarted, with the same content and status they had before the restart.
- **FR-014**: Opening, updating, commenting on, or moving a ticket that does not exist MUST fail with an explanation and MUST NOT create a ticket.
- **FR-015**: Who may perform each action, whether a person must sign in, and what an assignee is are [NEEDS CLARIFICATION: no roles, sign-in, or directory of people is described. Assignee is named as an editable field, but not as a person chosen from a known set, and creation does not mention an assignee.]
- **FR-016**: Whether title, description, priority, assignee, and new comments can still be changed when a ticket is RESOLVED, CLOSED, or CANCELLED is [NEEDS CLARIFICATION: updates and comments are required, but no rule says whether later statuses are editable or view-only.]
- **FR-017**: The allowed priority values, and which of title, description, and priority are mandatory, are [NEEDS CLARIFICATION: priority is required as an input to create a ticket, but no allowed values or blank-input rule is given.]

### Key Entities *(include if feature involves data)*

- **Ticket**: A single support request. It has a title, description, priority, assignee, and exactly one current status. The status is one of OPEN, IN_PROGRESS, RESOLVED, CLOSED, or CANCELLED. A new ticket starts as OPEN. It can be told apart from other tickets so a user can open it from the list. It has zero or more comments.
- **Comment**: A note added to one ticket. It has content supplied by the user. Who wrote it, and when, is not specified. Changing or removing a comment after it is added is not specified.
- **Status**: The lifecycle position of a ticket. Allowed moves are only those in FR-009. CLOSED and CANCELLED have no onward move in the stated rules.

## Success Criteria *(mandatory)*

### Measurable Outcomes

- **SC-001**: A user who supplies a valid title, description, and priority can create a ticket, see it in the list, and open its details in a single session.
- **SC-002**: After a restart, 100% of tickets and comments that were saved before the restart are still available with the same content and status.
- **SC-003**: 100% of status changes outside the allowed list are rejected, including the examples CLOSED → OPEN, RESOLVED → OPEN, and CANCELLED → OPEN, and including skipped steps such as OPEN → RESOLVED. In each rejected case the status is unchanged and the user receives an explanation.
- **SC-004**: When required ticket or comment input is invalid, the operation is rejected, nothing from that failed operation is saved, and the user can tell from the message why it failed.
- **SC-005**: From a list of at least 20 tickets spanning more than one status, a user can restrict the visible list to one current status, and can restrict the visible list using a keyword, without being shown a ticket that falls outside the active restriction.

## Assumptions

### Read directly from the request

- The people served by this specification are members of a support team managing a shared set of tickets.
- Status values and the allowed moves are exactly the ones named in the request. No extra status is included.
- A status change is separate from editing title, description, priority, or assignee, because status is not one of the fields in that update.
- A new ticket starts as OPEN because creation does not accept a status, and OPEN is the start of the stated lifecycle.
- Reopening is excluded by the stated rules. CLOSED, RESOLVED, and CANCELLED cannot move to OPEN, and no other return path is listed.

### Not specified, and not decided here

These items were missing or ambiguous. No behavior is required for them until they are decided. They are listed so they are not treated as agreed requirements.

- Who may create, view, update, assign, comment, or change status, and whether anyone must sign in (FR-015).
- Whether an assignee is a typed name, a person chosen from a known set, or something else, and whether a ticket may have no assignee (FR-015).
- Whether details and new comments can change in RESOLVED, CLOSED, and CANCELLED (FR-016).
- Which priority values exist, and whether title, description, and priority may be blank (FR-017).
- Which fields a keyword searches, whether search ignores letter case, and whether a keyword and a status filter apply at the same time (FR-007).
- Whether the status filter accepts one status or several at once (FR-008).
- Whether setting the status to the status the ticket already has is a harmless no-change or a rejected transition.
- Maximum lengths for title, description, priority, assignee, and comment text.
- Sort order of the ticket list and of comments.
- Whether a comment stores an author or a time.
- Whether comments can be edited or deleted.
- Whether tickets can be deleted.
- Whether cancellation requires a reason.
- Whether the list shows every matching ticket or a page at a time.
- How simultaneous edits of the same ticket behave.
- Whether created time, updated time, or a history of status changes is visible.

### Outside this specification

The following were not requested and are outside this specification:

- Email, alerts, or other notifications
- File attachments
- Due dates, response-time targets, or escalation
- Categories, tags, or queues beyond a single assignee field
- Dashboards, reports, or bulk changes
- A separate administration area for managing people
```

### **User**
/speckit-checklist The clarification pass is complete.
                   
                   Now I want to validate the specification before we move into technical planning.
                   
                   Review the current specification against the original assignment and check for:
                   
                   - Missing functional requirements
                   - Contradictory requirements
                   - Requirements that are too vague to implement or test
                   - Acceptance scenarios that don't cover important behaviour
                   - State-machine transitions that are missing or incorrectly defined
                   - Validation rules that are missing
                   - Error cases that aren't testable
                   - Requirements that accidentally introduce functionality outside the assignment
                   - Success criteria that cannot be objectively verified
                   
                   Also check that every original acceptance criterion from the assignment is represented somewhere in the specification.
                   
                   Do not design the architecture or implementation yet.
                   
                   If you find problems, report them clearly rather than silently changing the requirements.

*Attachment: Console Selection*
```
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

## User Scenarios & Testing *(mandatory)*

### User Story 1 - Create a ticket and find it again (Priority: P1)

A support user creates a ticket with a title, description, and priority, sees it in the list, and opens it to read the details. A ticket created this way is still there, unchanged, after the application restarts. Another ticket may use the same title.

**Why this priority**: Nothing else in the lifecycle can be managed until a ticket exists and can be found again.

**Independent Test**: Create one ticket with a non-blank title, a non-blank description, and priority HIGH. Confirm it appears in the list and opens with status OPEN. Create a second ticket with the same title. Restart the application and confirm both tickets are still present.

**Acceptance Scenarios**:

1. **Given** the user supplies a non-blank title, a non-blank description, and priority HIGH, **When** the user creates a ticket, **Then** the ticket is saved with status OPEN, with no assignee, and appears in the list.
2. **Given** a ticket already has a title, **When** the user creates another ticket with that same title, a non-blank description, and priority LOW, **Then** both tickets exist and each can be opened.
3. **Given** a ticket exists, **When** the user opens it from the list, **Then** the user sees its title, description, priority, assignee, status, and comments.
4. **Given** a ticket was created, **When** the application is restarted, **Then** that ticket is still in the list and its title, description, priority, and OPEN status are unchanged.
5. **Given** the user is creating a ticket, **When** the title is blank, the description is blank, or the priority is not LOW, MEDIUM, or HIGH, **Then** the ticket is not created and the user is told why the operation failed.

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
6. **Given** a ticket is CLOSED, **When** the user attempts to move it to OPEN, **Then** the status stays CLOSED and the user is told the change is not allowed.
7. **Given** a ticket is RESOLVED, **When** the user attempts to move it to OPEN, **Then** the status stays RESOLVED and the user is told the change is not allowed.
8. **Given** a ticket is CANCELLED, **When** the user attempts to move it to OPEN, **Then** the status stays CANCELLED and the user is told the change is not allowed.
9. **Given** a ticket is in any status, **When** the user requests that same status again, **Then** the status stays unchanged and the user is told the change is not allowed.
10. **Given** a ticket is in any status, **When** a status change that is not in the allowed list is submitted, including when the screen would not offer that action, **Then** the system rejects it, the status does not change, and the user is told the change is not allowed.

---

### User Story 3 - Update ticket details (Priority: P2)

A support user corrects the title, description, priority, or assignee in any status. The edit does not change the status. Assignee is an optional value the user types; it is not chosen from accounts or a directory.

**Why this priority**: The team needs to keep ticket information current, but the ticket is already usable before edits exist.

**Independent Test**: Change each editable field on an OPEN ticket and again on a CLOSED ticket. Confirm the new values are shown and the status is unchanged in both cases.

**Acceptance Scenarios**:

1. **Given** an OPEN ticket, **When** the user changes the title, description, or priority to a valid value, or sets an assignee, **Then** the ticket shows the new value and the status stays OPEN.
2. **Given** an existing ticket, **When** an update has a blank title, a blank description, or a priority other than LOW, MEDIUM, or HIGH, **Then** the previous title, description, priority, assignee, and status remain unchanged and the user is told why the update failed.
3. **Given** a ticket is RESOLVED, CLOSED, or CANCELLED, **When** the user changes the title, description, priority, or assignee to a valid value, **Then** the ticket shows the new value and the status stays the same.
4. **Given** a ticket has an assignee, **When** the user clears the assignee, **Then** the ticket has no assignee and the status stays the same.

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
5. **Given** a ticket exists, **When** the user submits a comment that is empty or only whitespace, **Then** the comment is not added and the user is told why.

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

- A ticket that does not exist cannot be opened, updated, commented on, or moved. The user is told it was not found, and no ticket is created.
- The list is empty when no tickets exist. That is an empty list, not a failure.
- A failed create, update, comment, or status change does not save the failed change.
- Two tickets may share a title. Each remains a separate ticket and can be opened on its own.
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

- **FR-001**: The system MUST allow a user to create a support ticket with a title, a description, and a priority. Title and description MUST contain non-blank content. Priority MUST be one of LOW, MEDIUM, or HIGH. Assignee is optional and MAY be blank. A new ticket has no assignee until one is entered.
- **FR-002**: A newly created ticket MUST start in status OPEN. Creation MUST NOT let the user choose a different starting status.
- **FR-003**: The system MUST allow a user to view a list of existing tickets. Each entry in the list MUST show the ticket title and current status. Ticket titles are NOT required to be unique.
- **FR-004**: The system MUST allow a user to open one ticket and view its title, description, priority, assignee, current status, and comments.
- **FR-005**: The system MUST allow a user to update a ticket's title, description, priority, and assignee while the ticket is in any status, including RESOLVED, CLOSED, and CANCELLED. A valid update MUST NOT change the ticket status. Title and description MUST remain non-blank. Priority MUST remain one of LOW, MEDIUM, or HIGH. The user MAY set or clear the assignee.
- **FR-006**: The system MUST allow a user to add a comment to an existing ticket in any status. The comment MUST contain non-blank content, MUST remain associated with that ticket only, and MUST NOT require an author. Adding a comment MUST NOT change the ticket status. The lifecycle rules do not accept or reject comments.
- **FR-007**: The system MUST allow a user to search tickets by a keyword. A ticket matches when the keyword appears in its title or its description. Comparison MUST ignore letter case. A keyword that appears only in the assignee or in a comment MUST NOT match that ticket.
- **FR-008**: The system MUST allow a user to filter the ticket list to one current status at a time. When a keyword and a status are both supplied, the list MUST include only tickets that match the keyword and have that status.
- **FR-009**: The system MUST allow only these status transitions:
  - OPEN → IN_PROGRESS
  - OPEN → CANCELLED
  - IN_PROGRESS → RESOLVED
  - IN_PROGRESS → CANCELLED
  - RESOLVED → CLOSED
- **FR-010**: The system MUST reject every status transition that is not listed in FR-009, including a request to set the status to the ticket's current status. The ticket status MUST stay unchanged. The user MUST be told that the change is not allowed. This includes CLOSED → OPEN, RESOLVED → OPEN, CANCELLED → OPEN, and OPEN → OPEN.
- **FR-011**: The system MUST enforce FR-009 and FR-010 itself. Hiding a disallowed action on the screen is not sufficient. A disallowed status change that is still submitted MUST be rejected.
- **FR-012**: The system MUST validate ticket and comment input. When an operation fails, the user MUST receive an explanation of why it failed, and the failed change MUST NOT be saved.
- **FR-013**: Tickets and their comments MUST still be available after the application is restarted, with the same content and status they had before the restart.
- **FR-014**: Opening, updating, commenting on, or moving a ticket that does not exist MUST fail with an explanation and MUST NOT create a ticket.
- **FR-015**: Anyone using the system MUST be able to create, view, update, comment on, search, filter, and change the status of tickets. The system MUST NOT require sign-in, user accounts, roles, or a user directory. Assignee MUST be an optional value entered and updated directly, not a person chosen from an account list.

### Key Entities *(include if feature involves data)*

- **Ticket**: A single support request. It has a title, description, priority, assignee, and exactly one current status. Titles are not unique. Priority is one of LOW, MEDIUM, or HIGH. Assignee is an optional value and may be blank. The status is one of OPEN, IN_PROGRESS, RESOLVED, CLOSED, or CANCELLED. A new ticket starts as OPEN with no assignee. It can be told apart from other tickets so a user can open it from the list even when titles match. Title, description, priority, and assignee can be changed in every status without changing that status. It has zero or more comments.
- **Comment**: A note added to one ticket. It has non-blank content and no author. It can be added in any ticket status. Changing or removing a comment after it is added is not specified. When a comment was written is not specified.
- **Status**: The lifecycle position of a ticket. Allowed moves are only those in FR-009. A move to the same status is not allowed. CLOSED and CANCELLED have no onward move.

## Success Criteria *(mandatory)*

### Measurable Outcomes

- **SC-001**: A user who supplies a non-blank title, a non-blank description, and a priority of LOW, MEDIUM, or HIGH can create a ticket, see it in the list, and open its details in a single session. A second ticket with the same title can also be created and opened.
- **SC-002**: After a restart, 100% of tickets and comments that were saved before the restart are still available with the same content and status.
- **SC-003**: 100% of status changes outside the allowed list are rejected, including CLOSED → OPEN, RESOLVED → OPEN, CANCELLED → OPEN, skipped steps such as OPEN → RESOLVED, and a request to keep the current status. In each rejected case the status is unchanged and the user receives an explanation.
- **SC-004**: A blank title, a blank description, a priority outside LOW, MEDIUM, and HIGH, or a blank comment is rejected. Nothing from that failed operation is saved, and the user can tell from the message why it failed.
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
```

### **User**
/speckit-clarify The checklist review found a few remaining ambiguities. Resolve only these points; don't add new functionality.
                 
                 1. Ticket titles are not unique. The ticket list must still provide enough information for two tickets with the same title and status to be distinguished and opened separately. Use the ticket's unique identifier for this purpose.
                 
                 2. Assignee is optional during ticket creation. The create operation may include an assignee, and it may also be omitted.
                 
                 3. Updates are partial. When a ticket field is updated, all other existing fields must remain unchanged unless they are explicitly included in the update. Clearing an assignee should still be supported.
                 
                 4. Comments are allowed in every ticket status. The state machine only controls status transitions; it does not restrict whether comments can be added. Comment content must still be non-blank.
                 
                 5. Error responses must provide a clear, machine-readable indication of what went wrong. At minimum, the response should identify the error and provide a human-readable message explaining the failure. Invalid transitions should identify the current and requested status, and a missing ticket should indicate that the ticket was not found.
                 
                 Do not change anything else in the requirements, and do not start technical planning yet.

*Attachment: Console Selection*
```
# Assignment Coverage Checklist: Support Ticket Management

**Purpose**: Check whether the specification is complete, consistent, testable, and limited to the assignment before technical planning
**Created**: 2026-09-27
**Feature**: [spec.md](../spec.md)

**Note**: This custom checklist is generated by the `/speckit-checklist` command based on feature context and requirements.
**Review Ownership**: This checklist is a reviewer-owned requirements-quality review artifact. Mark an item `[x]` only when the reviewer determines the requirements-quality criterion is satisfied.
**Marker Semantics**: `[x]` means the criterion has been reviewed and satisfied for requirements quality. It does not mean implementation work is complete.

## Assignment Traceability

- [ ] CHK001 - Is every original user capability represented as a requirement: create with title, description, and priority; view the list; open details; update title, description, priority, and assignee; add comments; search by keyword; and filter by current status? [Completeness, Spec §FR-001–FR-008]
- [ ] CHK002 - Are all five allowed transitions from the assignment listed, with no extra allowed transition: OPEN → IN_PROGRESS, OPEN → CANCELLED, IN_PROGRESS → RESOLVED, IN_PROGRESS → CANCELLED, and RESOLVED → CLOSED? [Completeness, Spec §FR-009]
- [ ] CHK003 - Are the assignment's rejected examples, CLOSED → OPEN, RESOLVED → OPEN, and CANCELLED → OPEN, covered together with the rule that every other transition is rejected? [Completeness, Spec §FR-010, User Story 2]
- [ ] CHK004 - Is system enforcement of invalid transitions specified separately from hiding an action on the screen? [Completeness, Spec §FR-011]
- [ ] CHK005 - Are input validation with failure feedback, and availability of tickets and comments after a restart, both specified? [Completeness, Spec §FR-012, Spec §FR-013]

## Requirement Completeness

- [ ] CHK006 - Does the list requirement state what a user sees to distinguish two tickets that share both a title and a status? [Gap, Spec §FR-003, Spec §Key Entities]
- [ ] CHK007 - Is it explicit whether assignee can be supplied during creation, or only by a later update? [Ambiguity, Spec §FR-001, User Story 1]
- [ ] CHK008 - Is it specified whether changing one of title, description, priority, or assignee leaves the other fields unchanged? [Ambiguity, Spec §FR-005, User Story 3]
- [ ] CHK009 - Is behavior for an empty keyword specified, or explicitly recorded as having no required behavior? [Gap, Spec §Assumptions]
- [ ] CHK010 - Are maximum length, list order, comment order, comment time, comment edit or removal, ticket deletion, a cancellation reason, showing one page at a time, simultaneous edits, and visible timestamps or status history documented as undecided rather than implied? [Assumption, Spec §Assumptions]

## Requirement Clarity

- [ ] CHK011 - Is keyword matching specific enough to judge the "PRINTER" / "Printer jam" case, including what "appears in" means and whether letter case is ignored? [Clarity, Spec §FR-007, User Story 5]
- [ ] CHK012 - Is a non-blank title, description, and comment defined to include rejection of whitespace-only values, with the same meaning on create and update? [Clarity, Spec §FR-001, Spec §FR-006, Spec §Edge Cases]
- [ ] CHK013 - Can the sentence that lifecycle rules do not accept or reject comments be read as waiving validation of comment content? [Ambiguity, Spec §FR-006]
- [ ] CHK014 - Is the minimum content of a failure explanation defined so a reviewer can agree the message is sufficient? [Clarity, Spec §FR-012, Spec §SC-004]

## Requirement Consistency

- [ ] CHK015 - Do the create scenario, update scenario, and edge cases agree that a blank or whitespace-only title or description is rejected and that the previous values remain? [Consistency, User Story 1, User Story 3, Spec §Edge Cases]
- [ ] CHK016 - Do the edit requirements, later-status scenarios, and success criteria agree that a valid edit never changes status? [Consistency, Spec §FR-005, User Story 3, Spec §SC-006]
- [ ] CHK017 - Do the comment requirements and scenarios agree that a non-blank comment is allowed in every status and does not change status? [Consistency, Spec §FR-006, User Story 4]
- [ ] CHK018 - Do search, filter, and scenario text agree that a keyword and one selected status must both be satisfied? [Consistency, Spec §FR-007, Spec §FR-008, User Story 5]
- [ ] CHK019 - Does the list requirement agree with the entity statement that two tickets with the same title can still be told apart and opened separately? [Conflict, Spec §FR-003, Spec §Key Entities]

## State Transitions

- [ ] CHK020 - Is the allowed set closed, so a transition is accepted only when it is one of the five listed moves? [Completeness, Spec §FR-009, Spec §FR-010]
- [ ] CHK021 - Is a request to keep the current status specified as rejected for every status, not only for OPEN → OPEN? [Clarity, Spec §FR-010, User Story 2]
- [ ] CHK022 - Are skipped moves and backward moves covered by the rejection rule, including OPEN → RESOLVED, OPEN → CLOSED, IN_PROGRESS → CLOSED, IN_PROGRESS → OPEN, RESOLVED → IN_PROGRESS, and RESOLVED → CANCELLED? [Coverage, Spec §FR-010, Spec §Edge Cases]
- [ ] CHK023 - Are moves out of CLOSED and CANCELLED specified as rejected, including moves other than the three examples named in the assignment? [Coverage, Spec §Edge Cases, Spec §FR-010]

## Scenario Coverage

- [ ] CHK024 - Does each allowed transition have its own acceptance scenario? [Coverage, User Story 2]
- [ ] CHK025 - Does each rejected example named in the assignment have an acceptance scenario, plus a scenario for a same-status request and a scenario for any other disallowed request? [Coverage, User Story 2]
- [ ] CHK026 - Do create scenarios allow two tickets to share a title without wording that assumes titles are unique? [Coverage, User Story 1, Spec §Clarifications]
- [ ] CHK027 - Are acceptance scenarios present for a title match, a description match, a case-insensitive match, a keyword found only in the assignee or a comment, and a keyword combined with one status? [Coverage, User Story 5]
- [ ] CHK028 - Is survival of assignee after a restart specified in an acceptance scenario, or only by the general persistence requirement? [Coverage, Spec §FR-013, User Story 1]
- [ ] CHK029 - Is an empty result specified for search alone and for a status filter alone, or only when both are used together? [Coverage, User Story 5]

## Validation and Error Cases

- [ ] CHK030 - Are missing or blank title, missing or blank description, and a priority outside LOW, MEDIUM, and HIGH specified as failures for both create and update? [Completeness, Spec §FR-001, Spec §FR-005, User Story 1, User Story 3]
- [ ] CHK031 - Is an empty or whitespace-only comment specified as a failure that does not add the comment? [Completeness, Spec §FR-006, User Story 4]
- [ ] CHK032 - Are open, update, comment, and status change on a missing ticket specified as failures that do not create a ticket? [Completeness, Spec §FR-014, Spec §Edge Cases]
- [ ] CHK033 - Are the expected explanations for an illegal transition and for a missing ticket specific enough to test, and is invalid-field feedback specified to that same degree? [Consistency, Spec §FR-010, Spec §FR-012, Spec §FR-014, Spec §SC-004]
- [ ] CHK034 - Is it specified that a failed create, update, comment, or status change leaves already saved ticket data unchanged? [Completeness, Spec §Edge Cases, Spec §FR-012]
- [ ] CHK035 - Is a blank assignee allowed, and is clearing a previously entered assignee specified without changing status? [Completeness, Spec §FR-005, User Story 3]

## Scope Boundaries

- [ ] CHK036 - Are sign-in, accounts, roles, a user directory, notifications, attachments, due dates, categories, dashboards, and people administration placed outside the specification? [Coverage, Spec §FR-015, Spec §Assumptions]
- [ ] CHK037 - Do the requirements avoid turning undecided items into required behavior, including ticket deletion, comment editing, a cancellation reason, and status history? [Scope, Spec §Assumptions]
- [ ] CHK038 - Is the behavior added beyond the original wording traceable to a recorded clarification, rather than to an unrelated feature? [Scope, Spec §Clarifications]

## Success Criteria Quality

- [ ] CHK039 - Can SC-001, SC-002, SC-003, SC-005, and SC-006 be judged from observable outcomes without choosing an unstated rule? [Measurability, Spec §SC-001–SC-006]
- [ ] CHK040 - Can "the user can tell from the message why it failed" in SC-004 be judged without a subjective reading? [Measurability, Spec §SC-004]
- [ ] CHK041 - Does SC-003 use the same rejected-transition set as FR-009 and FR-010, including skipped steps and a request to keep the current status? [Consistency, Spec §SC-003, Spec §FR-009, Spec §FR-010]

## Notes

- Mark items `[x]` only after review confirms the requirement-quality criterion is satisfied.
- Leave items unchecked when they still require clarification, correction, or reviewer evaluation.
- `/speckit-implement` reads checklist checkbox state as a gate and must not modify markers.
- `checklists/requirements.md` has a separate built-in lifecycle maintained by `/speckit-specify` and `/speckit-clarify`.
- Items are numbered CHK001–CHK041.
- This review did not change `spec.md`. Findings below are the pre-planning review; checkbox state is still for the reviewer.

### Findings that need a decision or a spec correction

- CHK006 and CHK019: The entity text says two tickets with the same title can be told apart and opened from the list. FR-003 only requires each list entry to show title and current status. Two OPEN tickets with the same title have no specified visible distinction.
- CHK007: FR-001 says assignee is optional on create and that a new ticket has no assignee until one is entered. User Story 1 expects creation with no assignee. The spec does not say whether creation may also accept an assignee.
- CHK008: FR-005 and User Story 3 allow each field to be changed, and they allow the assignee to be cleared. They do not say whether an update of one field preserves the others.
- CHK013: FR-006 requires non-blank comment content and also says the lifecycle rules do not accept or reject comments. The second sentence can be misread as skipping comment validation. The intended reading is that only status moves are governed by the lifecycle.
- CHK014, CHK033, and CHK040: An illegal transition must be described as not allowed, and a missing ticket must be described as not found. Other failures only require "an explanation of why" and that the user can tell why. That explanation has no required content, so SC-004 is not objectively testable.

### Already represented from the assignment

- Create, list, open, update, comment, keyword search, and status filter are specified.
- The five allowed transitions are the only allowed transitions.
- CLOSED → OPEN, RESOLVED → OPEN, and CANCELLED → OPEN are rejected, as is every transition outside the allowed set, including a request to keep the current status.
- Invalid transitions are rejected even when the screen still submits them.
- Tickets and comments remain after a restart.
- Sign-in, notifications, attachments, due dates, categories, dashboards, and people administration are outside the specification.

### Recorded as undecided, and not required behavior

- Empty keyword; maximum text length; list and comment order; comment time; editing or removing comments; deleting tickets; a cancellation reason; paging the list; simultaneous edits; created time, updated time, and status history.
```

### **User**
/speckit-checklist

*Attachment: Console Selection*
```
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
- Q: What must a failure response contain? → A: It must identify the error in a machine-readable way and include a human-readable message. An invalid transition identifies the current and requested status. A missing ticket indicates that the ticket was not found.

## User Scenarios & Testing *(mandatory)*

### User Story 1 - Create a ticket and find it again (Priority: P1)

A support user creates a ticket with a title, description, and priority, sees it in the list, and opens it to read the details. A ticket created this way is still there, unchanged, after the application restarts. Another ticket may use the same title.

**Why this priority**: Nothing else in the lifecycle can be managed until a ticket exists and can be found again.

**Independent Test**: Create one ticket with a non-blank title, a non-blank description, and priority HIGH. Confirm it appears in the list and opens with status OPEN. Create a second ticket with the same title. Restart the application and confirm both tickets are still present.

**Acceptance Scenarios**:

1. **Given** the user supplies a non-blank title, a non-blank description, and priority HIGH, **When** the user creates a ticket, **Then** the ticket is saved with status OPEN, with no assignee, and appears in the list.
2. **Given** an OPEN ticket already has a title, **When** the user creates another ticket with that same title, a non-blank description, and priority LOW, **Then** both tickets are OPEN, the list shows a different unique identifier for each, and each can be opened separately.
3. **Given** a ticket exists, **When** the user opens it from the list, **Then** the user sees its title, description, priority, assignee, status, and comments.
4. **Given** a ticket was created, **When** the application is restarted, **Then** that ticket is still in the list and its title, description, priority, and OPEN status are unchanged.
5. **Given** the user is creating a ticket, **When** the title is blank, the description is blank, or the priority is not LOW, MEDIUM, or HIGH, **Then** the ticket is not created, the error is identified, and a human-readable message explains the failure.
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
6. **Given** a ticket is CLOSED, **When** the user attempts to move it to OPEN, **Then** the status stays CLOSED, the error identifies the current status CLOSED and the requested status OPEN, and a human-readable message explains the failure.
7. **Given** a ticket is RESOLVED, **When** the user attempts to move it to OPEN, **Then** the status stays RESOLVED, the error identifies the current status RESOLVED and the requested status OPEN, and a human-readable message explains the failure.
8. **Given** a ticket is CANCELLED, **When** the user attempts to move it to OPEN, **Then** the status stays CANCELLED, the error identifies the current status CANCELLED and the requested status OPEN, and a human-readable message explains the failure.
9. **Given** a ticket is in any status, **When** the user requests that same status again, **Then** the status stays unchanged, the error identifies that current status and the same requested status, and a human-readable message explains the failure.
10. **Given** a ticket is in any status, **When** a status change that is not in the allowed list is submitted, including when the screen would not offer that action, **Then** the system rejects it, the status does not change, the error identifies the current status and the requested status, and a human-readable message explains the failure.

---

### User Story 3 - Update ticket details (Priority: P2)

A support user corrects the title, description, priority, or assignee in any status. The edit does not change the status. Assignee is an optional value the user types; it is not chosen from accounts or a directory.

**Why this priority**: The team needs to keep ticket information current, but the ticket is already usable before edits exist.

**Independent Test**: Change each editable field on an OPEN ticket and again on a CLOSED ticket. Confirm the new values are shown and the status is unchanged in both cases.

**Acceptance Scenarios**:

1. **Given** an OPEN ticket, **When** the user changes the title, description, or priority to a valid value, or sets an assignee, **Then** the ticket shows the new value and the status stays OPEN.
2. **Given** an existing ticket, **When** an update has a blank title, a blank description, or a priority other than LOW, MEDIUM, or HIGH, **Then** the previous title, description, priority, assignee, and status remain unchanged, the error is identified, and a human-readable message explains the failure.
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
5. **Given** a ticket exists, **When** the user submits a comment that is empty or only whitespace, **Then** the comment is not added, the error is identified, and a human-readable message explains the failure.

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

- A ticket that does not exist cannot be opened, updated, commented on, or moved. The error indicates that the ticket was not found, the error is identified, a human-readable message explains the failure, and no ticket is created.
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
- **FR-010**: The system MUST reject every status transition that is not listed in FR-009, including a request to set the status to the ticket's current status. The ticket status MUST stay unchanged. The failure MUST identify the error, include a human-readable message, and identify the ticket's current status and the requested status. This includes CLOSED → OPEN, RESOLVED → OPEN, CANCELLED → OPEN, and OPEN → OPEN.
- **FR-011**: The system MUST enforce FR-009 and FR-010 itself. Hiding a disallowed action on the screen is not sufficient. A disallowed status change that is still submitted MUST be rejected.
- **FR-012**: The system MUST validate ticket and comment input. When an operation fails, the response MUST identify the error in a machine-readable form and MUST include a human-readable message explaining the failure. The failed change MUST NOT be saved.
- **FR-013**: Tickets and their comments MUST still be available after the application is restarted, with the same content and status they had before the restart.
- **FR-014**: Opening, updating, commenting on, or moving a ticket that does not exist MUST fail. The failure MUST indicate that the ticket was not found, identify the error, and include a human-readable message. It MUST NOT create a ticket.
- **FR-015**: Anyone using the system MUST be able to create, view, update, comment on, search, filter, and change the status of tickets. The system MUST NOT require sign-in, user accounts, roles, or a user directory. Assignee MUST be an optional value entered and updated directly, not a person chosen from an account list.

### Key Entities *(include if feature involves data)*

- **Ticket**: A single support request. It has a unique identifier, a title, description, priority, assignee, and exactly one current status. Titles are not unique. The list shows the unique identifier with the title and current status, so two tickets with the same title and status can be distinguished and opened separately. Priority is one of LOW, MEDIUM, or HIGH. Assignee is an optional value and may be included or omitted on create, and may be blank. The status is one of OPEN, IN_PROGRESS, RESOLVED, CLOSED, or CANCELLED. A new ticket starts as OPEN. Title, description, priority, and assignee can be changed in every status without changing that status. An update changes only the fields included in that update. It has zero or more comments.
- **Comment**: A note added to one ticket. It has non-blank content and no author. It can be added in any ticket status. Changing or removing a comment after it is added is not specified. When a comment was written is not specified.
- **Status**: The lifecycle position of a ticket. Allowed moves are only those in FR-009. A move to the same status is not allowed. CLOSED and CANCELLED have no onward move.

## Success Criteria *(mandatory)*

### Measurable Outcomes

- **SC-001**: A user who supplies a non-blank title, a non-blank description, and a priority of LOW, MEDIUM, or HIGH can create a ticket, see it in the list, and open its details in a single session. A second ticket with the same title and status can also be created, distinguished in the list by its unique identifier, and opened separately.
- **SC-002**: After a restart, 100% of tickets and comments that were saved before the restart are still available with the same content and status.
- **SC-003**: 100% of status changes outside the allowed list are rejected, including CLOSED → OPEN, RESOLVED → OPEN, CANCELLED → OPEN, skipped steps such as OPEN → RESOLVED, and a request to keep the current status. In each rejected case the status is unchanged, the error identifies the current status and the requested status, and a human-readable message explains the failure.
- **SC-004**: Every failed operation identifies the error and includes a human-readable message explaining the failure. A blank title, a blank description, a priority outside LOW, MEDIUM, and HIGH, or a blank comment is rejected, and nothing from that failed operation is saved. A missing ticket is identified as not found.
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
```

### **User**
Q1: A
Q2: B
Q3: B

*Attachment: Console Selection*
```
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
- Q: What must a failure response contain? → A: It must identify the error in a machine-readable way and include a human-readable message. An invalid transition identifies the current and requested status. A missing ticket indicates that the ticket was not found.

## User Scenarios & Testing *(mandatory)*

### User Story 1 - Create a ticket and find it again (Priority: P1)

A support user creates a ticket with a title, description, and priority, sees it in the list, and opens it to read the details. A ticket created this way is still there, unchanged, after the application restarts. Another ticket may use the same title.

**Why this priority**: Nothing else in the lifecycle can be managed until a ticket exists and can be found again.

**Independent Test**: Create one ticket with a non-blank title, a non-blank description, and priority HIGH. Confirm it appears in the list and opens with status OPEN. Create a second ticket with the same title. Restart the application and confirm both tickets are still present.

**Acceptance Scenarios**:

1. **Given** the user supplies a non-blank title, a non-blank description, and priority HIGH, **When** the user creates a ticket, **Then** the ticket is saved with status OPEN, with no assignee, and appears in the list.
2. **Given** an OPEN ticket already has a title, **When** the user creates another ticket with that same title, a non-blank description, and priority LOW, **Then** both tickets are OPEN, the list shows a different unique identifier for each, and each can be opened separately.
3. **Given** a ticket exists, **When** the user opens it from the list, **Then** the user sees its title, description, priority, assignee, status, and comments.
4. **Given** a ticket was created, **When** the application is restarted, **Then** that ticket is still in the list and its title, description, priority, and OPEN status are unchanged.
5. **Given** the user is creating a ticket, **When** the title is blank, the description is blank, or the priority is not LOW, MEDIUM, or HIGH, **Then** the ticket is not created, the error is identified, and a human-readable message explains the failure.
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
6. **Given** a ticket is CLOSED, **When** the user attempts to move it to OPEN, **Then** the status stays CLOSED, the error identifies the current status CLOSED and the requested status OPEN, and a human-readable message explains the failure.
7. **Given** a ticket is RESOLVED, **When** the user attempts to move it to OPEN, **Then** the status stays RESOLVED, the error identifies the current status RESOLVED and the requested status OPEN, and a human-readable message explains the failure.
8. **Given** a ticket is CANCELLED, **When** the user attempts to move it to OPEN, **Then** the status stays CANCELLED, the error identifies the current status CANCELLED and the requested status OPEN, and a human-readable message explains the failure.
9. **Given** a ticket is in any status, **When** the user requests that same status again, **Then** the status stays unchanged, the error identifies that current status and the same requested status, and a human-readable message explains the failure.
10. **Given** a ticket is in any status, **When** a status change that is not in the allowed list is submitted, including when the screen would not offer that action, **Then** the system rejects it, the status does not change, the error identifies the current status and the requested status, and a human-readable message explains the failure.

---

### User Story 3 - Update ticket details (Priority: P2)

A support user corrects the title, description, priority, or assignee in any status. The edit does not change the status. Assignee is an optional value the user types; it is not chosen from accounts or a directory.

**Why this priority**: The team needs to keep ticket information current, but the ticket is already usable before edits exist.

**Independent Test**: Change each editable field on an OPEN ticket and again on a CLOSED ticket. Confirm the new values are shown and the status is unchanged in both cases.

**Acceptance Scenarios**:

1. **Given** an OPEN ticket, **When** the user changes the title, description, or priority to a valid value, or sets an assignee, **Then** the ticket shows the new value and the status stays OPEN.
2. **Given** an existing ticket, **When** an update has a blank title, a blank description, or a priority other than LOW, MEDIUM, or HIGH, **Then** the previous title, description, priority, assignee, and status remain unchanged, the error is identified, and a human-readable message explains the failure.
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
5. **Given** a ticket exists, **When** the user submits a comment that is empty or only whitespace, **Then** the comment is not added, the error is identified, and a human-readable message explains the failure.

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

- A ticket that does not exist cannot be opened, updated, commented on, or moved. The error indicates that the ticket was not found, the error is identified, a human-readable message explains the failure, and no ticket is created.
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
- **FR-010**: The system MUST reject every status transition that is not listed in FR-009, including a request to set the status to the ticket's current status. The ticket status MUST stay unchanged. The failure MUST identify the error, include a human-readable message, and identify the ticket's current status and the requested status. This includes CLOSED → OPEN, RESOLVED → OPEN, CANCELLED → OPEN, and OPEN → OPEN.
- **FR-011**: The system MUST enforce FR-009 and FR-010 itself. Hiding a disallowed action on the screen is not sufficient. A disallowed status change that is still submitted MUST be rejected.
- **FR-012**: The system MUST validate ticket and comment input. When an operation fails, the response MUST identify the error in a machine-readable form and MUST include a human-readable message explaining the failure. The failed change MUST NOT be saved.
- **FR-013**: Tickets and their comments MUST still be available after the application is restarted, with the same content and status they had before the restart.
- **FR-014**: Opening, updating, commenting on, or moving a ticket that does not exist MUST fail. The failure MUST indicate that the ticket was not found, identify the error, and include a human-readable message. It MUST NOT create a ticket.
- **FR-015**: Anyone using the system MUST be able to create, view, update, comment on, search, filter, and change the status of tickets. The system MUST NOT require sign-in, user accounts, roles, or a user directory. Assignee MUST be an optional value entered and updated directly, not a person chosen from an account list.

### Key Entities *(include if feature involves data)*

- **Ticket**: A single support request. It has a unique identifier, a title, description, priority, assignee, and exactly one current status. Titles are not unique. The list shows the unique identifier with the title and current status, so two tickets with the same title and status can be distinguished and opened separately. Priority is one of LOW, MEDIUM, or HIGH. Assignee is an optional value and may be included or omitted on create, and may be blank. The status is one of OPEN, IN_PROGRESS, RESOLVED, CLOSED, or CANCELLED. A new ticket starts as OPEN. Title, description, priority, and assignee can be changed in every status without changing that status. An update changes only the fields included in that update. It has zero or more comments.
- **Comment**: A note added to one ticket. It has non-blank content and no author. It can be added in any ticket status. Changing or removing a comment after it is added is not specified. When a comment was written is not specified.
- **Status**: The lifecycle position of a ticket. Allowed moves are only those in FR-009. A move to the same status is not allowed. CLOSED and CANCELLED have no onward move.

## Success Criteria *(mandatory)*

### Measurable Outcomes

- **SC-001**: A user who supplies a non-blank title, a non-blank description, and a priority of LOW, MEDIUM, or HIGH can create a ticket, see it in the list, and open its details in a single session. A second ticket with the same title and status can also be created, distinguished in the list by its unique identifier, and opened separately.
- **SC-002**: After a restart, 100% of tickets and comments that were saved before the restart are still available with the same content and status.
- **SC-003**: 100% of status changes outside the allowed list are rejected, including CLOSED → OPEN, RESOLVED → OPEN, CANCELLED → OPEN, skipped steps such as OPEN → RESOLVED, and a request to keep the current status. In each rejected case the status is unchanged, the error identifies the current status and the requested status, and a human-readable message explains the failure.
- **SC-004**: Every failed operation identifies the error and includes a human-readable message explaining the failure. A blank title, a blank description, a priority outside LOW, MEDIUM, and HIGH, or a blank comment is rejected, and nothing from that failed operation is saved. A missing ticket is identified as not found.
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
```

### **User**
/speckit-clarify The focused checklist is complete. I found only two remaining requirements-quality ambiguities that should be resolved before planning.
                 
                 1. Ticket identifier persistence:
                 A ticket's unique identifier must remain unchanged after the application restarts, along with the ticket's persisted data.
                 
                 2. Machine-readable error responses:
                 Every failed API operation must return a stable machine-readable error code and a human-readable message.
                 For an invalid status transition, the error response must additionally identify the current status and the requested status.
                 For a missing ticket, the error code must identify the ticket as not found.
                 
                 Do not change any other requirements.
                 Do not add behavior for the items explicitly marked as undecided.
                 Do not start technical planning yet.

*Attachment: Console Selection*
```
# Clarifications Checklist: Support Ticket Management

**Purpose**: Formally review the five latest specification decisions, and confirm that undecided items stay explicit non-requirements before planning
**Created**: 2026-09-27
**Feature**: [spec.md](../spec.md)

**Note**: This custom checklist is generated by the `/speckit-checklist` command based on feature context and requirements.
**Review Ownership**: This checklist is a reviewer-owned requirements-quality review artifact. Mark an item `[x]` only when the reviewer determines the requirements-quality criterion is satisfied.
**Marker Semantics**: `[x]` means the criterion has been reviewed and satisfied for requirements quality. It does not mean implementation work is complete.

## Unique Identifier

- [ ] CHK001 - Is a unique identifier required for every ticket, including two tickets that share a title and a status? [Completeness, Spec §FR-003, Spec §Key Entities]
- [ ] CHK002 - Is the list required to show the unique identifier together with the title and current status? [Completeness, Spec §FR-003]
- [ ] CHK003 - Is the unique identifier required on the opened ticket, or only in the list? [Clarity, Spec §FR-003, Spec §FR-004]
- [ ] CHK004 - Is the form or stability of the unique identifier specified, or is any distinct value sufficient? [Clarity, Spec §FR-003]
- [ ] CHK005 - Do the list requirement, the ticket entity, and SC-001 agree that the identifier is how same-title, same-status tickets are distinguished and opened separately? [Consistency, Spec §FR-003, Spec §SC-001, User Story 1]
- [ ] CHK006 - Is survival of the same unique identifier after a restart specified, or only survival of ticket content and status? [Coverage, Spec §FR-013, Spec §SC-002]
- [ ] CHK007 - Is an acceptance scenario defined for two OPEN tickets with the same title showing different identifiers? [Coverage, User Story 1]

## Assignee on Create

- [ ] CHK008 - Is it explicit that creation may include an assignee and may omit one? [Clarity, Spec §FR-001, Spec §Clarifications]
- [ ] CHK009 - Are the stored results specified for both the included-assignee case and the omitted-assignee case? [Completeness, Spec §FR-001]
- [ ] CHK010 - Are acceptance scenarios present for creating a ticket with an assignee and for creating a ticket without one? [Coverage, User Story 1]
- [ ] CHK011 - Is omitting an assignee during creation kept distinct from explicitly clearing an assignee during an update? [Consistency, Spec §FR-001, Spec §FR-005]

## Partial Updates

- [ ] CHK012 - Is an update defined as changing only the fields explicitly included? [Clarity, Spec §FR-005, Spec §Clarifications]
- [ ] CHK013 - Is it specified that every field not included remains unchanged, including status? [Completeness, Spec §FR-005, Spec §SC-006]
- [ ] CHK014 - Is omitting the assignee specified as leaving it unchanged, while an explicit clear removes it and leaves other included-or-not rules intact? [Clarity, Spec §FR-005, User Story 3]
- [ ] CHK015 - Is an acceptance scenario defined for changing only the title while description, priority, assignee, and status stay unchanged? [Coverage, User Story 3]
- [ ] CHK016 - When an update includes an invalid value, do the requirements say previously saved fields remain unchanged? [Consistency, User Story 3, Spec §Edge Cases]
- [ ] CHK017 - Do partial-update requirements apply in RESOLVED, CLOSED, and CANCELLED as well as in earlier statuses? [Coverage, Spec §FR-005, Spec §SC-006]

## Comments and the State Machine

- [ ] CHK018 - Are comments specified as allowed in every status, including RESOLVED, CLOSED, and CANCELLED? [Completeness, Spec §FR-006, User Story 4]
- [ ] CHK019 - Is the state machine limited to status transitions, so it does not restrict adding a comment? [Clarity, Spec §FR-006, Spec §Clarifications]
- [ ] CHK020 - Does that limit still leave non-blank comment content required, including rejection of a whitespace-only comment? [Consistency, Spec §FR-006, Spec §Edge Cases]
- [ ] CHK021 - Do the comment requirements agree that adding a comment does not change status? [Consistency, Spec §FR-006, Spec §SC-006]
- [ ] CHK022 - Is an acceptance scenario present for a non-blank comment on a RESOLVED, CLOSED, or CANCELLED ticket? [Coverage, User Story 4]

## Failure Responses

- [ ] CHK023 - Is every failed operation required to identify the error and include a human-readable message? [Completeness, Spec §FR-012, Spec §SC-004]
- [ ] CHK024 - Is "machine-readable" defined with criteria a reviewer can apply without choosing an unstated format? [Clarity, Spec §FR-012]
- [ ] CHK025 - Are invalid status changes required to identify both the current status and the requested status? [Completeness, Spec §FR-010, Spec §SC-003]
- [ ] CHK026 - Is a missing ticket required to be identified as not found for open, update, comment, and status change? [Completeness, Spec §FR-014, Spec §Edge Cases]
- [ ] CHK027 - Are failure requirements consistent across invalid create, invalid update, a blank comment, an illegal transition, and a missing ticket? [Consistency, Spec §FR-010, Spec §FR-012, Spec §FR-014, User Stories 1–4]
- [ ] CHK028 - Is it specified that a failed create, update, comment, or status change does not save the failed change? [Completeness, Spec §FR-012, Spec §Edge Cases]
- [ ] CHK029 - Can SC-003 and SC-004 be judged from the written failure content without a subjective reading? [Measurability, Spec §SC-003, Spec §SC-004]

## Deferred Items

- [ ] CHK030 - Is maximum text length explicitly recorded as having no required behavior? [Assumption, Spec §Assumptions]
- [ ] CHK031 - Are list order and comment order explicitly recorded as having no required behavior? [Assumption, Spec §Assumptions]
- [ ] CHK032 - Is the time a comment was written explicitly recorded as having no required behavior? [Assumption, Spec §Assumptions, Spec §Key Entities]
- [ ] CHK033 - Are editing and removing a comment explicitly recorded as having no required behavior? [Assumption, Spec §Assumptions, Spec §Key Entities]
- [ ] CHK034 - Is deleting a ticket explicitly recorded as having no required behavior? [Assumption, Spec §Assumptions]
- [ ] CHK035 - Is a cancellation reason explicitly recorded as having no required behavior? [Assumption, Spec §Assumptions]
- [ ] CHK036 - Is paging the list, versus showing every matching ticket, explicitly recorded as having no required behavior? [Assumption, Spec §Assumptions]
- [ ] CHK037 - Are simultaneous edits of the same ticket explicitly recorded as having no required behavior? [Assumption, Spec §Assumptions]
- [ ] CHK038 - Are created time, updated time, and status history explicitly recorded as having no required behavior? [Assumption, Spec §Assumptions]
- [ ] CHK039 - Is an empty keyword explicitly recorded as having no required behavior, without the search requirement implying a required result? [Assumption, Spec §FR-007, Spec §Assumptions]
- [ ] CHK040 - Does the undecided section state that no behavior is required for those items until a later decision? [Clarity, Spec §Assumptions]

## Notes

- Mark items `[x]` only after review confirms the requirement-quality criterion is satisfied.
- Leave items unchecked when they still require clarification, correction, or reviewer evaluation.
- `/speckit-implement` reads checklist checkbox state as a gate and must not modify markers.
- `checklists/requirements.md` has a separate built-in lifecycle maintained by `/speckit-specify` and `/speckit-clarify`.
- Items are numbered CHK001–CHK040.
- Scope is the five decisions from the 2026-09-27 clarification session: unique identifier, optional assignee on create, partial updates, comments versus the state machine, and failure responses. Undecided items are included so they stay explicit non-requirements.
- This checklist does not replace `checklists/assignment.md`.
- `spec.md` was not changed.
```

### **User**
/speckit-plan The specification has completed its clarification and requirements review.
              
              Now create the technical implementation plan for this feature.
              
              Base the plan strictly on the finalized specification and the project constitution.
              
              The plan should cover:
              
              - Java 21 and Spring Boot backend structure
              - PostgreSQL as the primary database and H2 for tests
              - REST API design under /api/v1
              - entities, DTOs, repositories, services, and controllers
              - validation and standardized error responses
              - enforcement of the ticket status state machine in the service/domain layer
              - persistence and migrations
              - backend unit, integration, repository, and API tests
              - React frontend structure and API integration
              - frontend validation and meaningful error handling
              - search and status filtering
              - application configuration for local development and testing
              - documentation required by the constitution
              
              Keep the implementation as a modular monolith.
              
              Do not introduce authentication, microservices, Kafka, Redis, CQRS, event sourcing, or other functionality outside the specification.
              
              For anything intentionally left undecided in the specification, don't turn it into a new product requirement. Make only the technical decisions necessary to implement the defined behavior.
              
              Keep the plan incremental and explain important technical decisions and trade-offs.

*Attachment: Console Selection*
```
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
```

### **User**
/speckit-plan The specification has completed its clarification and requirements review.
              
              Now create the technical implementation plan for this feature.
              
              Base the plan strictly on the finalized specification and the project constitution.
              
              The plan should cover:
              
              - Java 21 and Spring Boot backend structure
              - PostgreSQL as the primary database and H2 for tests
              - REST API design under /api/v1
              - entities, DTOs, repositories, services, and controllers
              - validation and standardized error responses
              - enforcement of the ticket status state machine in the service/domain layer
              - persistence and migrations
              - backend unit, integration, repository, and API tests
              - React frontend structure and API integration
              - frontend validation and meaningful error handling
              - search and status filtering
              - application configuration for local development and testing
              - documentation required by the constitution
              
              Keep the implementation as a modular monolith.
              
              Do not introduce authentication, microservices, Kafka, Redis, CQRS, event sourcing, or other functionality outside the specification.
              
              For anything intentionally left undecided in the specification, don't turn it into a new product requirement. Make only the technical decisions necessary to implement the defined behavior.
              
              Keep the plan incremental and explain important technical decisions and trade-offs.

*Attachment: Console Selection*
```
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
```

### **User**
/speckit-plan I reviewed the generated implementation plan against the finalized specification.
              
              Before we move to task generation, make these corrections:
              
              1. Do not introduce maximum text lengths as product validation requirements. The specification explicitly leaves maximum lengths undecided. Remove fixed @Size limits and any requirement that would reject otherwise valid title, description, assignee, or comment content solely because of an invented maximum length.
              
              2. Keep the blank/omitted search keyword behavior as an implementation default only. Do not turn it into a new product requirement or acceptance criterion, since the specification explicitly leaves empty-keyword behavior undecided.
              
              3. Make persistence verification explicit. H2 may be used for fast repository/API integration tests, but verification that tickets, comments, and stable ticket IDs survive an actual application restart must be covered against PostgreSQL rather than treated as an optional enhancement.
              
              Do not introduce any other new product behavior.
              
              Keep the existing architecture, API separation, state-machine design, DTO separation, and incremental implementation strategy.

*Attachment: Console Selection*
```
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

### 6. Persistence

1. Create ticket and comment; note `id`.
2. Restart backend against PostgreSQL.
3. `GET /api/v1/tickets/{id}` — same `id`, fields and comments preserved.

## Expected error codes

| Code | HTTP | When |
|------|------|------|
| `TICKET_NOT_FOUND` | 404 | Unknown ticket id |
| `VALIDATION_ERROR` | 422 | Bean validation / blank fields |
| `INVALID_STATUS_TRANSITION` | 409 | Disallowed status change |
```

### **User**
/speckit-plan I reviewed the generated implementation plan against the finalized specification.
              
              Before we move to task generation, make these corrections:
              
              1. Do not introduce maximum text lengths as product validation requirements. The specification explicitly leaves maximum lengths undecided. Remove fixed @Size limits and any requirement that would reject otherwise valid title, description, assignee, or comment content solely because of an invented maximum length.
              
              2. Keep the blank/omitted search keyword behavior as an implementation default only. Do not turn it into a new product requirement or acceptance criterion, since the specification explicitly leaves empty-keyword behavior undecided.
              
              3. Make persistence verification explicit. H2 may be used for fast repository/API integration tests, but verification that tickets, comments, and stable ticket IDs survive an actual application restart must be covered against PostgreSQL rather than treated as an optional enhancement.
              
              Do not introduce any other new product behavior.
              
              Keep the existing architecture, API separation, state-machine design, DTO separation, and incremental implementation strategy.

*Attachment: Console Selection*
```
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

### 6. Persistence

1. Create ticket and comment; note `id`.
2. Restart backend against PostgreSQL.
3. `GET /api/v1/tickets/{id}` — same `id`, fields and comments preserved.

## Expected error codes

| Code | HTTP | When |
|------|------|------|
| `TICKET_NOT_FOUND` | 404 | Unknown ticket id |
| `VALIDATION_ERROR` | 422 | Bean validation / blank fields |
| `INVALID_STATUS_TRANSITION` | 409 | Disallowed status change |
```

### **User**
/speckit-tasks

*Attachment: Console Selection*
```
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
```

### **User**
/speckit-tasks Review the generated tasks.md against the approved spec, research.md, data-model.md, openapi.yaml, and plan.md.
               
               Make only these corrections:
               
               1. Expand validation coverage beyond CreateTicketRequest:
                  - CreateTicketRequest: title, description, priority, optional assignee.
                  - UpdateTicketRequest: validate any supplied title/description as non-blank and priority as a valid enum.
                  - CreateCommentRequest: content must be non-blank.
                  - TransitionRequest: status must be a valid enum.
                  Keep the existing rule that there are no invented maximum-length validations.
               
               2. Move blank-field validation testing to the API/web layer where appropriate. Service unit tests should focus on business behavior such as OPEN as the initial state, optional assignee handling, partial update semantics, and status preservation.
               
               3. Make the PostgreSQL restart-persistence task explicit that the test must:
                  - keep the PostgreSQL database/container alive,
                  - persist a ticket and comment,
                  - terminate/close the Spring application context,
                  - create a fresh application context against the same database,
                  - verify the same ticket ID, fields, status, and comments.
                  This remains a mandatory CI gate.
               
               4. For PATCH presence tracking, do not require a specific dependency such as JsonNullable unless needed. The task may use JsonNullable or an equivalent Jackson presence-aware mechanism, but omitted fields must remain unchanged and explicit assignee:null must clear the assignee.
               
               5. Keep all existing task scope, ordering, user-story mapping, API design, state-machine design, PostgreSQL requirement, and no-max-length rules unchanged.
               
               Do not introduce any new product requirements or behavior.

*Attachment: Console Selection*
```
---
description: "Task list for Support Ticket Management implementation"
---

# Tasks: Support Ticket Management

**Input**: Design documents from `/specs/001-support-ticket-management/`

**Prerequisites**: [plan.md](./plan.md), [spec.md](./spec.md), [research.md](./research.md), [data-model.md](./data-model.md), [contracts/openapi.yaml](./contracts/openapi.yaml)

**Tests**: Included per project constitution (test pyramid) and [plan.md](./plan.md). Do not add tests that assert invented maximum string lengths. PostgreSQL restart persistence is a required gate (FR-013 / SC-002).

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

- [ ] T001 Create `backend/pom.xml` with Java 21, Spring Boot 3 (web, data-jpa, validation), Flyway, PostgreSQL driver, H2, springdoc-openapi, Testcontainers PostgreSQL, JUnit 5, Mockito, AssertJ
- [ ] T002 Create `backend/src/main/java/com/support/tickets/SupportTicketApplication.java`
- [ ] T003 [P] Scaffold `frontend/` with Vite, React 18, TypeScript, and React Router (`frontend/package.json`, `frontend/vite.config.ts`, `frontend/index.html`)
- [ ] T004 [P] Add `docker-compose.yml` at repository root for PostgreSQL 15 (dev only; no secrets in repo)
- [ ] T005 [P] Add `backend/src/main/resources/application.yml` with shared defaults (`ddl-auto=validate`, Flyway enabled)
- [ ] T006 [P] Add `README.md` skeleton at repository root (placeholders for run/test instructions)

**Checkpoint**: `./mvnw -f backend/pom.xml -q validate` and `npm install` in `frontend/` succeed

---

## Phase 2: Foundational (Blocking Prerequisites)

**Purpose**: Schema, domain model, error contract, and API infrastructure required by every user story

**⚠️ CRITICAL**: No user story implementation until this phase completes

- [ ] T007 Add Flyway migration `backend/src/main/resources/db/migration/V1__create_tickets_and_comments.sql` with `TEXT` columns (no max-length DB constraints per [research.md](./research.md) R9)
- [ ] T008 Add `backend/src/main/resources/application-local.yml` (PostgreSQL via env vars, CORS for `http://localhost:5173`)
- [ ] T009 Add `backend/src/main/resources/application-test.yml` (H2 in-memory, Flyway on)
- [ ] T010 [P] Create enums `backend/src/main/java/com/support/tickets/domain/model/TicketStatus.java` and `TicketPriority.java`
- [ ] T011 [P] Create JPA entity `backend/src/main/java/com/support/tickets/domain/model/Ticket.java` (LAZY comments, IDENTITY id)
- [ ] T012 [P] Create JPA entity `backend/src/main/java/com/support/tickets/domain/model/Comment.java`
- [ ] T013 [P] Create `backend/src/main/java/com/support/tickets/domain/repository/TicketRepository.java`
- [ ] T014 [P] Create `backend/src/main/java/com/support/tickets/domain/repository/CommentRepository.java`
- [ ] T015 [P] Create stable error codes enum `backend/src/main/java/com/support/tickets/exception/ApiErrorCode.java` (`TICKET_NOT_FOUND`, `VALIDATION_ERROR`, `INVALID_STATUS_TRANSITION`)
- [ ] T016 Implement `backend/src/main/java/com/support/tickets/exception/GlobalExceptionHandler.java` returning RFC 7807 `ProblemDetail` with `code`, human message, and transition fields when applicable
- [ ] T017 [P] Create API DTO records under `backend/src/main/java/com/support/tickets/api/dto/` (`TicketSummaryResponse`, `TicketResponse`, `CommentResponse`, `CreateTicketRequest`, `CreateCommentRequest`, `TransitionRequest`)
- [ ] T018 [P] Create `backend/src/main/java/com/support/tickets/api/mapper/TicketMapper.java`
- [ ] T019 [P] Add `backend/src/main/java/com/support/tickets/config/WebConfig.java` for CORS (local profile)
- [ ] T020 [P] Add `backend/src/main/java/com/support/tickets/config/OpenApiConfig.java` for springdoc
- [ ] T021 Add `backend/src/test/java/com/support/tickets/support/AbstractIntegrationTest.java` with `@SpringBootTest` and H2 `test` profile

**Checkpoint**: Application starts on H2 test profile; migrations apply; no REST features yet

---

## Phase 3: User Story 1 — Create a ticket and find it again (Priority: P1)  MVP

**Goal**: Create ticket (OPEN), list with `id`/title/status, get detail; validation errors with stable `code`

**Independent Test**: POST create → GET list shows ticket → GET by id → duplicate title creates second distinct `id` (spec User Story 1)

### Tests for User Story 1

- [ ] T022 [P] [US1] Add `backend/src/test/java/com/support/tickets/domain/service/TicketServiceCreateTest.java` (unit: OPEN default, optional assignee, NotBlank failures)
- [ ] T023 [P] [US1] Add `backend/src/test/java/com/support/tickets/api/controller/TicketControllerCreateListWebMvcTest.java` (`@WebMvcTest`: 201 create, 422 blank title, list summaries include `id`)
- [ ] T024 [P] [US1] Add `backend/src/test/java/com/support/tickets/integration/TicketCreateListIntegrationTest.java` (H2: create two same-title tickets, distinct ids)

### Implementation for User Story 1

- [ ] T025 [US1] Implement `backend/src/main/java/com/support/tickets/domain/service/TicketService.java` methods `create`, `getById`, `listSummaries` (default sort `id` DESC per research R8)
- [ ] T026 [US1] Implement `backend/src/main/java/com/support/tickets/api/controller/TicketController.java` — `POST /api/v1/tickets`, `GET /api/v1/tickets`, `GET /api/v1/tickets/{id}` (comments empty array until US4)
- [ ] T027 [P] [US1] Apply Jakarta `@NotBlank` on `CreateTicketRequest` only (no `@Size` maximums)
- [ ] T028 [P] [US1] Add `frontend/src/types/ticket.ts` mirroring API types
- [ ] T029 [P] [US1] Add `frontend/src/api/ticketsClient.ts` (create, list, getById, parse ProblemDetail)
- [ ] T030 [US1] Add `frontend/src/pages/TicketListPage.tsx` showing `id`, title, status
- [ ] T031 [US1] Add `frontend/src/pages/CreateTicketPage.tsx` with client-side required-field hints (backend authoritative)
- [ ] T032 [US1] Add `frontend/src/pages/TicketDetailPage.tsx` read-only detail view
- [ ] T033 [US1] Wire routes in `frontend/src/App.tsx`

**Checkpoint**: MVP API + UI for create/list/detail; run US1 independent test

---

## Phase 4: User Story 2 — Move a ticket through its lifecycle (Priority: P1)

**Goal**: Allowed transitions only; reject others including same-status; ProblemDetail with `currentStatus` / `requestedStatus`

**Independent Test**: Exercise allowed path and rejected examples from spec User Story 2 (backend tests required even if UI hides actions)

### Tests for User Story 2

- [ ] T034 [P] [US2] Add `backend/src/test/java/com/support/tickets/domain/service/TicketStatusTransitionsTest.java` (unit: full transition matrix, same-status rejected)
- [ ] T035 [P] [US2] Add `backend/src/test/java/com/support/tickets/api/controller/TicketTransitionWebMvcTest.java` (409 `INVALID_STATUS_TRANSITION` with status fields)

### Implementation for User Story 2

- [ ] T036 [US2] Implement `backend/src/main/java/com/support/tickets/domain/service/TicketStatusService.java` and `TicketStatusTransitions` helper (FR-009/FR-010)
- [ ] T037 [US2] Add `POST /api/v1/tickets/{id}/transitions` to `backend/src/main/java/com/support/tickets/api/controller/TicketController.java`
- [ ] T038 [US2] Add transition actions to `frontend/src/pages/TicketDetailPage.tsx` (show only allowed targets; still call API for authority)
- [ ] T039 [US2] Display transition errors using `code`, `detail`, `currentStatus`, `requestedStatus` in `frontend/src/api/ticketsClient.ts`

**Checkpoint**: Lifecycle enforced server-side; US1 + US2 both pass tests

---

## Phase 5: User Story 3 — Update ticket details (Priority: P2)

**Goal**: PATCH partial updates in any status; explicit assignee clear; status unchanged

**Independent Test**: PATCH single field; clear assignee; invalid field rejected with prior data unchanged (spec User Story 3)

### Tests for User Story 3

- [ ] T040 [P] [US3] Add `backend/src/test/java/com/support/tickets/domain/service/TicketServicePatchTest.java` (partial field update, omit assignee unchanged, null clears assignee)
- [ ] T041 [P] [US3] Add `backend/src/test/java/com/support/tickets/api/controller/TicketPatchWebMvcTest.java`

### Implementation for User Story 3

- [ ] T042 [US3] Add presence-aware `UpdateTicketRequest` in `backend/src/main/java/com/support/tickets/api/dto/UpdateTicketRequest.java` (Jackson/`JsonNullable`; no `@Size` max)
- [ ] T043 [US3] Extend `TicketService` with `updatePartial` in `backend/src/main/java/com/support/tickets/domain/service/TicketService.java`
- [ ] T044 [US3] Add `PATCH /api/v1/tickets/{id}` to `backend/src/main/java/com/support/tickets/api/controller/TicketController.java`
- [ ] T045 [US3] Add edit form on `frontend/src/pages/TicketDetailPage.tsx` calling PATCH (including clear assignee)

**Checkpoint**: Edits work on CLOSED/CANCELLED tickets without status change

---

## Phase 6: User Story 4 — Add comments (Priority: P2)

**Goal**: POST non-blank comment on any status; comments on ticket detail; persist with ticket

**Independent Test**: Comment on CANCELLED ticket; blank rejected; comment not visible on other tickets (spec User Story 4)

### Tests for User Story 4

- [ ] T046 [P] [US4] Add `backend/src/test/java/com/support/tickets/api/controller/CommentControllerWebMvcTest.java`
- [ ] T047 [P] [US4] Add `backend/src/test/java/com/support/tickets/integration/CommentPersistenceIntegrationTest.java` (H2)

### Implementation for User Story 4

- [ ] T048 [US4] Implement `backend/src/main/java/com/support/tickets/domain/service/CommentService.java`
- [ ] T049 [US4] Add `POST /api/v1/tickets/{ticketId}/comments` in `backend/src/main/java/com/support/tickets/api/controller/CommentController.java`
- [ ] T050 [US4] Include comments in `GET /api/v1/tickets/{id}` via `TicketMapper` (order by comment `id` ASC)
- [ ] T051 [US4] Add comment list + form to `frontend/src/pages/TicketDetailPage.tsx`

**Checkpoint**: US4 complete; detail shows comments after refresh

---

## Phase 7: User Story 5 — Search and filter the list (Priority: P3)

**Goal**: `q` case-insensitive title/description OR match; single `status` filter; AND when both provided

**Independent Test**: Scenarios from spec User Story 5 (assignee/comment text must not match `q`)

**Note**: Treat omitted/blank `q` as no keyword filter — implementation default only ([research.md](./research.md) R4); do not add product acceptance tests for empty keyword.

### Tests for User Story 5

- [ ] T052 [P] [US5] Add `backend/src/test/java/com/support/tickets/domain/repository/TicketRepositorySearchTest.java` (`@DataJpaTest`, H2)
- [ ] T053 [P] [US5] Add `backend/src/test/java/com/support/tickets/api/controller/TicketListFilterWebMvcTest.java`

### Implementation for User Story 5

- [ ] T054 [US5] Add search/filter query to `TicketRepository` in `backend/src/main/java/com/support/tickets/domain/repository/TicketRepository.java`
- [ ] T055 [US5] Extend `TicketService.listSummaries` and `GET /api/v1/tickets` for `status` and `q` params
- [ ] T056 [US5] Add search input and status filter to `frontend/src/pages/TicketListPage.tsx`

**Checkpoint**: Combined filter + search matches spec FR-007/FR-008

---

## Phase 8: Polish & Cross-Cutting Concerns

**Purpose**: PostgreSQL persistence gate, documentation, contract alignment

- [ ] T057 Add **required** `backend/src/test/java/com/support/tickets/integration/PostgreSqlRestartPersistenceIT.java` using Testcontainers PostgreSQL — create ticket + comment, restart Spring context, assert same `id`, fields, status, comments ([plan.md](./plan.md))
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
- Validation: `@NotBlank` / enums only — never reject valid content for invented max length
- Empty `q`: implementation default documented in research; not a new acceptance criterion
- All tasks use checkbox format `- [ ] Tnnn` for `/speckit-implement` tracking
```

---

## We are implementing a Spec-Driven Support Ticket Management System.

Before changing anything, read and follow these artifacts:

- .specify/memory/constitution.md
- specs/001-support-ticket-managemen…
> Model: `agent_acp.registry.codex-acp`  

### **User**
We are implementing a Spec-Driven Support Ticket Management System.

Before changing anything, read and follow these artifacts:

- .specify/memory/constitution.md
- specs/001-support-ticket-management/spec.md
- specs/001-support-ticket-management/plan.md
- specs/001-support-ticket-management/research.md
- specs/001-support-ticket-management/data-model.md
- specs/001-support-ticket-management/contracts/openapi.yaml
- specs/001-support-ticket-management/quickstart.md
- specs/001-support-ticket-management/tasks.md

Use the Spec Kit workflow and treat the specification and constitution as the source of truth.

IMPLEMENT ONLY:
- Phase 1: Project Setup
- Phase 2: Foundational Backend
- User Story 1: Create and View Tickets

Do NOT implement:
- US2 state transitions
- US3 partial updates
- US4 comments
- US5 search/filter
- Phase 8 PostgreSQL restart verification
- Any other future functionality

Follow the tasks.md task order and mark completed tasks as you finish them.

Important constraints:
- Java 21
- Spring Boot 3
- Maven
- PostgreSQL for runtime
- H2 for tests
- Flyway migrations
- constructor injection only
- controller/service/repository/DTO separation
- Jakarta Bean Validation
- ProblemDetail with stable machine-readable error codes
- no authentication, roles, users, or user directory
- no title uniqueness
- no artificial max-length validation
- no ddl-auto update/create in runtime configuration
- do not invent behavior not specified in the artifacts
- preserve the documented architecture
- use the package structure defined by the plan
- create tests required by the current tasks

For User Story 1, implement only:
- create ticket
- list tickets
- view ticket details
- required field validation
- duplicate titles must be supported
- stable ticket IDs
- persistence model and repository
- corresponding frontend pieces required by the plan

Before implementing, inspect the existing repository and determine what already exists. Do not overwrite or restructure existing Spec Kit artifacts.

After implementation:
1. Run the relevant backend tests.
2. Run the build/checks.
3. Fix only issues caused by this implementation.
4. Update tasks.md checkboxes for completed tasks.
5. Report:
   - files created/changed
   - tests run and results
   - tasks completed
   - any deviations or ambiguities encountered
   - anything that still needs human verification

Do not implement beyond the requested scope. Stop after Phase 1 + Phase 2 + US1.

*Attachment: Console Selection*
```
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

- [ ] T001 Create `backend/pom.xml` with Java 21, Spring Boot 3 (web, data-jpa, validation), Flyway, PostgreSQL driver, H2, springdoc-openapi, Testcontainers PostgreSQL, JUnit 5, Mockito, AssertJ
- [ ] T002 Create `backend/src/main/java/com/support/tickets/SupportTicketApplication.java`
- [ ] T003 [P] Scaffold `frontend/` with Vite, React 18, TypeScript, and React Router (`frontend/package.json`, `frontend/vite.config.ts`, `frontend/index.html`)
- [ ] T004 [P] Add `docker-compose.yml` at repository root for PostgreSQL 15 (dev only; no secrets in repo)
- [ ] T005 [P] Add `backend/src/main/resources/application.yml` with shared defaults (`ddl-auto=validate`, Flyway enabled)
- [ ] T006 [P] Add `README.md` skeleton at repository root (placeholders for run/test instructions)

**Checkpoint**: `./mvnw -f backend/pom.xml -q validate` and `npm install` in `frontend/` succeed

---

## Phase 2: Foundational (Blocking Prerequisites)

**Purpose**: Schema, domain model, error contract, and API infrastructure required by every user story

**⚠️ CRITICAL**: No user story implementation until this phase completes

- [ ] T007 Add Flyway migration `backend/src/main/resources/db/migration/V1__create_tickets_and_comments.sql` with `TEXT` columns (no max-length DB constraints per [research.md](./research.md) R9)
- [ ] T008 Add `backend/src/main/resources/application-local.yml` (PostgreSQL via env vars, CORS for `http://localhost:5173`)
- [ ] T009 Add `backend/src/main/resources/application-test.yml` (H2 in-memory, Flyway on)
- [ ] T010 [P] Create enums `backend/src/main/java/com/support/tickets/domain/model/TicketStatus.java` and `TicketPriority.java`
- [ ] T011 [P] Create JPA entity `backend/src/main/java/com/support/tickets/domain/model/Ticket.java` (LAZY comments, IDENTITY id)
- [ ] T012 [P] Create JPA entity `backend/src/main/java/com/support/tickets/domain/model/Comment.java`
- [ ] T013 [P] Create `backend/src/main/java/com/support/tickets/domain/repository/TicketRepository.java`
- [ ] T014 [P] Create `backend/src/main/java/com/support/tickets/domain/repository/CommentRepository.java`
- [ ] T015 [P] Create stable error codes enum `backend/src/main/java/com/support/tickets/exception/ApiErrorCode.java` (`TICKET_NOT_FOUND`, `VALIDATION_ERROR`, `INVALID_STATUS_TRANSITION`)
- [ ] T016 Implement `backend/src/main/java/com/support/tickets/exception/GlobalExceptionHandler.java` returning RFC 7807 `ProblemDetail` with `code`, human message, and transition fields when applicable
- [ ] T017 [P] Create API DTO records under `backend/src/main/java/com/support/tickets/api/dto/` (`TicketSummaryResponse`, `TicketResponse`, `CommentResponse`, `CreateTicketRequest`, `UpdateTicketRequest`, `CreateCommentRequest`, `TransitionRequest`)
- [ ] T018 [P] Create `backend/src/main/java/com/support/tickets/api/mapper/TicketMapper.java`
- [ ] T019 [P] Add `backend/src/main/java/com/support/tickets/config/WebConfig.java` for CORS (local profile)
- [ ] T020 [P] Add `backend/src/main/java/com/support/tickets/config/OpenApiConfig.java` for springdoc
- [ ] T021 Add `backend/src/test/java/com/support/tickets/support/AbstractIntegrationTest.java` with `@SpringBootTest` and H2 `test` profile

**Checkpoint**: Application starts on H2 test profile; migrations apply; no REST features yet

---

## Phase 3: User Story 1 — Create a ticket and find it again (Priority: P1)  MVP

**Goal**: Create ticket (OPEN), list with `id`/title/status, get detail; validation errors with stable `code`

**Independent Test**: POST create → GET list shows ticket → GET by id → duplicate title creates second distinct `id` (spec User Story 1)

### Tests for User Story 1

- [ ] T022 [P] [US1] Add `backend/src/test/java/com/support/tickets/domain/service/TicketServiceCreateTest.java` (unit: new ticket starts OPEN, optional assignee on create stored or omitted — no blank-field assertion tests here)
- [ ] T023 [P] [US1] Add `backend/src/test/java/com/support/tickets/api/controller/TicketControllerCreateListWebMvcTest.java` (`@WebMvcTest`: 201 create, 422 blank title/description/invalid priority with `VALIDATION_ERROR`, list summaries include `id`)
- [ ] T024 [P] [US1] Add `backend/src/test/java/com/support/tickets/integration/TicketCreateListIntegrationTest.java` (H2: create two same-title tickets, distinct ids)

### Implementation for User Story 1

- [ ] T025 [US1] Implement `backend/src/main/java/com/support/tickets/domain/service/TicketService.java` methods `create`, `getById`, `listSummaries` (default sort `id` DESC per research R8)
- [ ] T026 [US1] Implement `backend/src/main/java/com/support/tickets/api/controller/TicketController.java` — `POST /api/v1/tickets`, `GET /api/v1/tickets`, `GET /api/v1/tickets/{id}` (comments empty array until US4)
- [ ] T027 [P] [US1] Add Jakarta validation on `backend/src/main/java/com/support/tickets/api/dto/CreateTicketRequest.java` — `@NotBlank` title and description, valid `priority` enum, optional `assignee` (no `@Size` maximums); trigger via `@Valid` on `POST /api/v1/tickets` in `TicketController.java`
- [ ] T028 [P] [US1] Add `frontend/src/types/ticket.ts` mirroring API types
- [ ] T029 [P] [US1] Add `frontend/src/api/ticketsClient.ts` (create, list, getById, parse ProblemDetail)
- [ ] T030 [US1] Add `frontend/src/pages/TicketListPage.tsx` showing `id`, title, status
- [ ] T031 [US1] Add `frontend/src/pages/CreateTicketPage.tsx` with client-side required-field hints (backend authoritative)
- [ ] T032 [US1] Add `frontend/src/pages/TicketDetailPage.tsx` read-only detail view
- [ ] T033 [US1] Wire routes in `frontend/src/App.tsx`

**Checkpoint**: MVP API + UI for create/list/detail; run US1 independent test

---

## Phase 4: User Story 2 — Move a ticket through its lifecycle (Priority: P1)

**Goal**: Allowed transitions only; reject others including same-status; ProblemDetail with `currentStatus` / `requestedStatus`

**Independent Test**: Exercise allowed path and rejected examples from spec User Story 2 (backend tests required even if UI hides actions)

### Tests for User Story 2

- [ ] T034 [P] [US2] Add `backend/src/test/java/com/support/tickets/domain/service/TicketStatusTransitionsTest.java` (unit: full transition matrix, same-status rejected)
- [ ] T035 [P] [US2] Add `backend/src/test/java/com/support/tickets/api/controller/TicketTransitionWebMvcTest.java` (`@WebMvcTest`: 422 invalid `status` enum on `TransitionRequest`; 409 `INVALID_STATUS_TRANSITION` with `currentStatus`/`requestedStatus` for disallowed business transitions)

### Implementation for User Story 2

- [ ] T036 [US2] Implement `backend/src/main/java/com/support/tickets/domain/service/TicketStatusService.java` and `TicketStatusTransitions` helper (FR-009/FR-010)
- [ ] T037 [US2] Add `POST /api/v1/tickets/{id}/transitions` to `backend/src/main/java/com/support/tickets/api/controller/TicketController.java` with `@Valid` on `backend/src/main/java/com/support/tickets/api/dto/TransitionRequest.java` (required valid `TicketStatus` enum)
- [ ] T038 [US2] Add transition actions to `frontend/src/pages/TicketDetailPage.tsx` (show only allowed targets; still call API for authority)
- [ ] T039 [US2] Display transition errors using `code`, `detail`, `currentStatus`, `requestedStatus` in `frontend/src/api/ticketsClient.ts`

**Checkpoint**: Lifecycle enforced server-side; US1 + US2 both pass tests

---

## Phase 5: User Story 3 — Update ticket details (Priority: P2)

**Goal**: PATCH partial updates in any status; explicit assignee clear; status unchanged

**Independent Test**: PATCH single field; clear assignee; invalid field rejected with prior data unchanged (spec User Story 3)

### Tests for User Story 3

- [ ] T040 [P] [US3] Add `backend/src/test/java/com/support/tickets/domain/service/TicketServicePatchTest.java` (unit: partial field update, omitted fields unchanged, explicit `assignee` null clears assignee, ticket `status` unchanged — no blank-field assertion tests here)
- [ ] T041 [P] [US3] Add `backend/src/test/java/com/support/tickets/api/controller/TicketPatchWebMvcTest.java` (`@WebMvcTest`: 422 when supplied title/description blank or priority invalid; 200 valid partial PATCH)

### Implementation for User Story 3

- [ ] T042 [US3] Add presence-aware `UpdateTicketRequest` in `backend/src/main/java/com/support/tickets/api/dto/UpdateTicketRequest.java` using `JsonNullable` or an equivalent Jackson presence-aware mechanism (omitted fields unchanged; explicit `assignee: null` clears assignee); validate any supplied title/description as `@NotBlank` and any supplied `priority` as a valid enum (no `@Size` maximums)
- [ ] T043 [US3] Extend `TicketService` with `updatePartial` in `backend/src/main/java/com/support/tickets/domain/service/TicketService.java`
- [ ] T044 [US3] Add `PATCH /api/v1/tickets/{id}` to `backend/src/main/java/com/support/tickets/api/controller/TicketController.java` with `@Valid` on `UpdateTicketRequest`
- [ ] T045 [US3] Add edit form on `frontend/src/pages/TicketDetailPage.tsx` calling PATCH (including clear assignee)

**Checkpoint**: Edits work on CLOSED/CANCELLED tickets without status change

---

## Phase 6: User Story 4 — Add comments (Priority: P2)

**Goal**: POST non-blank comment on any status; comments on ticket detail; persist with ticket

**Independent Test**: Comment on CANCELLED ticket; blank rejected; comment not visible on other tickets (spec User Story 4)

### Tests for User Story 4

- [ ] T046 [P] [US4] Add `backend/src/test/java/com/support/tickets/api/controller/CommentControllerWebMvcTest.java` (`@WebMvcTest`: 422 blank/whitespace `content` with `VALIDATION_ERROR`; 201 valid comment)
- [ ] T047 [P] [US4] Add `backend/src/test/java/com/support/tickets/integration/CommentPersistenceIntegrationTest.java` (H2)

### Implementation for User Story 4

- [ ] T048 [US4] Implement `backend/src/main/java/com/support/tickets/domain/service/CommentService.java`
- [ ] T049 [US4] Add `POST /api/v1/tickets/{ticketId}/comments` in `backend/src/main/java/com/support/tickets/api/controller/CommentController.java` with `@Valid` on `backend/src/main/java/com/support/tickets/api/dto/CreateCommentRequest.java` (`@NotBlank` content; no `@Size` maximums)
- [ ] T050 [US4] Include comments in `GET /api/v1/tickets/{id}` via `TicketMapper` (order by comment `id` ASC)
- [ ] T051 [US4] Add comment list + form to `frontend/src/pages/TicketDetailPage.tsx`

**Checkpoint**: US4 complete; detail shows comments after refresh

---

## Phase 7: User Story 5 — Search and filter the list (Priority: P3)

**Goal**: `q` case-insensitive title/description OR match; single `status` filter; AND when both provided

**Independent Test**: Scenarios from spec User Story 5 (assignee/comment text must not match `q`)

**Note**: Treat omitted/blank `q` as no keyword filter — implementation default only ([research.md](./research.md) R4); do not add product acceptance tests for empty keyword.

### Tests for User Story 5

- [ ] T052 [P] [US5] Add `backend/src/test/java/com/support/tickets/domain/repository/TicketRepositorySearchTest.java` (`@DataJpaTest`, H2)
- [ ] T053 [P] [US5] Add `backend/src/test/java/com/support/tickets/api/controller/TicketListFilterWebMvcTest.java`

### Implementation for User Story 5

- [ ] T054 [US5] Add search/filter query to `TicketRepository` in `backend/src/main/java/com/support/tickets/domain/repository/TicketRepository.java`
- [ ] T055 [US5] Extend `TicketService.listSummaries` and `GET /api/v1/tickets` for `status` and `q` params
- [ ] T056 [US5] Add search input and status filter to `frontend/src/pages/TicketListPage.tsx`

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
```

### **User**
$speckit-implement Implement the current feature using the existing Spec Kit artifacts.
                   
                   Before making any changes, read and follow these files:
                   
                   - `.specify/memory/constitution.md`
                   - `specs/001-support-ticket-management/spec.md`
                   - `specs/001-support-ticket-management/plan.md`
                   - `specs/001-support-ticket-management/research.md`
                   - `specs/001-support-ticket-management/data-model.md`
                   - `specs/001-support-ticket-management/contracts/openapi.yaml`
                   - `specs/001-support-ticket-management/quickstart.md`
                   - `specs/001-support-ticket-management/tasks.md`
                   
                   Use the constitution, specification, plan, and tasks as the source of truth. Do not invent requirements or behavior that is not documented.
                   
                   ### Implementation scope
                   
                   Implement ONLY:
                   
                   1. Phase 1 — Project Setup
                   2. Phase 2 — Foundational Backend
                   3. User Story 1 — Create and View Tickets
                   
                   Do NOT implement:
                   
                   - User Story 2 — State transitions
                   - User Story 3 — Partial ticket updates
                   - User Story 4 — Comments
                   - User Story 5 — Search and filtering
                   - Phase 8 PostgreSQL restart verification
                   - Any functionality belonging to later phases
                   
                   Follow the task order in `tasks.md` and update the task checkboxes as tasks are completed.
                   
                   ### Technical constraints
                   
                   Follow the constitution and plan exactly:
                   
                   - Java 21
                   - Spring Boot 3
                   - Maven
                   - PostgreSQL for runtime
                   - H2 for tests
                   - Flyway migrations
                   - Constructor injection
                   - Controller / Service / Repository / DTO separation
                   - Jakarta Bean Validation
                   - ProblemDetail with stable machine-readable error codes
                   - No authentication, roles, users, or user directory
                   - Ticket titles are NOT unique
                   - Do NOT introduce artificial max-length validation
                   - Do NOT use `ddl-auto=update` or `ddl-auto=create`
                   - Do not introduce microservices, CQRS, event sourcing, Kafka, or other architecture not required by the specification
                   - Preserve the package structure and architecture defined in the plan
                   
                   ### User Story 1
                   
                   Implement only the functionality required for:
                   
                   - Creating a ticket
                   - Listing tickets
                   - Viewing ticket details
                   - Required-field validation
                   - Supporting duplicate ticket titles
                   - Stable ticket IDs
                   - Persistence model and repository
                   - Required frontend pieces defined by the plan
                   
                   Ensure the implementation matches the OpenAPI contract and documented data model.
                   
                   ### Testing
                   
                   Create and run the tests required by the current tasks.
                   
                   At minimum, verify the behavior relevant to the implemented scope, including:
                   
                   - Ticket creation
                   - Required-field validation
                   - Duplicate titles
                   - Listing tickets
                   - Viewing a ticket by ID
                   - Not-found behavior where required
                   - Persistence/repository behavior appropriate to the current phase
                   
                   Do not implement the PostgreSQL restart persistence test yet because that belongs to Phase 8.
                   
                   ### Important implementation rules
                   
                   - Inspect the existing repository before changing files.
                   - Do not modify or remove Spec Kit artifacts unless the implementation workflow specifically requires updating `tasks.md`.
                   - Do not implement future user stories "because they are related".
                   - Do not add speculative features.
                   - Keep changes incremental and aligned with the plan.
                   - If an ambiguity is discovered, use the existing artifacts to resolve it. If they genuinely do not define the behavior, report the ambiguity instead of inventing a requirement.
                   
                   ### Completion
                   
                   After implementation:
                   
                   1. Run the relevant tests.
                   2. Run the backend build/checks.
                   3. Fix implementation issues found by those checks.
                   4. Update `tasks.md` for completed tasks.
                   5. Do not proceed beyond Phase 1 + Phase 2 + User Story 1.
                   
                   Finally, report:
                   
                   - Files created/modified
                   - Tasks completed
                   - Tests executed and their results
                   - Build/check results
                   - Any deviations from the specification/plan
                   - Any assumptions or unresolved ambiguities
                   - Anything that requires human verification
                   
                   Stop after this scope. Do not continue to the next user story.

*Attachment: Console Selection*
```
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

- [ ] T001 Create `backend/pom.xml` with Java 21, Spring Boot 3 (web, data-jpa, validation), Flyway, PostgreSQL driver, H2, springdoc-openapi, Testcontainers PostgreSQL, JUnit 5, Mockito, AssertJ
- [ ] T002 Create `backend/src/main/java/com/support/tickets/SupportTicketApplication.java`
- [ ] T003 [P] Scaffold `frontend/` with Vite, React 18, TypeScript, and React Router (`frontend/package.json`, `frontend/vite.config.ts`, `frontend/index.html`)
- [ ] T004 [P] Add `docker-compose.yml` at repository root for PostgreSQL 15 (dev only; no secrets in repo)
- [ ] T005 [P] Add `backend/src/main/resources/application.yml` with shared defaults (`ddl-auto=validate`, Flyway enabled)
- [ ] T006 [P] Add `README.md` skeleton at repository root (placeholders for run/test instructions)

**Checkpoint**: `./mvnw -f backend/pom.xml -q validate` and `npm install` in `frontend/` succeed

---

## Phase 2: Foundational (Blocking Prerequisites)

**Purpose**: Schema, domain model, error contract, and API infrastructure required by every user story

**⚠️ CRITICAL**: No user story implementation until this phase completes

- [ ] T007 Add Flyway migration `backend/src/main/resources/db/migration/V1__create_tickets_and_comments.sql` with `TEXT` columns (no max-length DB constraints per [research.md](./research.md) R9)
- [ ] T008 Add `backend/src/main/resources/application-local.yml` (PostgreSQL via env vars, CORS for `http://localhost:5173`)
- [ ] T009 Add `backend/src/main/resources/application-test.yml` (H2 in-memory, Flyway on)
- [ ] T010 [P] Create enums `backend/src/main/java/com/support/tickets/domain/model/TicketStatus.java` and `TicketPriority.java`
- [ ] T011 [P] Create JPA entity `backend/src/main/java/com/support/tickets/domain/model/Ticket.java` (LAZY comments, IDENTITY id)
- [ ] T012 [P] Create JPA entity `backend/src/main/java/com/support/tickets/domain/model/Comment.java`
- [ ] T013 [P] Create `backend/src/main/java/com/support/tickets/domain/repository/TicketRepository.java`
- [ ] T014 [P] Create `backend/src/main/java/com/support/tickets/domain/repository/CommentRepository.java`
- [ ] T015 [P] Create stable error codes enum `backend/src/main/java/com/support/tickets/exception/ApiErrorCode.java` (`TICKET_NOT_FOUND`, `VALIDATION_ERROR`, `INVALID_STATUS_TRANSITION`)
- [ ] T016 Implement `backend/src/main/java/com/support/tickets/exception/GlobalExceptionHandler.java` returning RFC 7807 `ProblemDetail` with `code`, human message, and transition fields when applicable
- [ ] T017 [P] Create API DTO records under `backend/src/main/java/com/support/tickets/api/dto/` (`TicketSummaryResponse`, `TicketResponse`, `CommentResponse`, `CreateTicketRequest`, `UpdateTicketRequest`, `CreateCommentRequest`, `TransitionRequest`)
- [ ] T018 [P] Create `backend/src/main/java/com/support/tickets/api/mapper/TicketMapper.java`
- [ ] T019 [P] Add `backend/src/main/java/com/support/tickets/config/WebConfig.java` for CORS (local profile)
- [ ] T020 [P] Add `backend/src/main/java/com/support/tickets/config/OpenApiConfig.java` for springdoc
- [ ] T021 Add `backend/src/test/java/com/support/tickets/support/AbstractIntegrationTest.java` with `@SpringBootTest` and H2 `test` profile

**Checkpoint**: Application starts on H2 test profile; migrations apply; no REST features yet

---

## Phase 3: User Story 1 — Create a ticket and find it again (Priority: P1)  MVP

**Goal**: Create ticket (OPEN), list with `id`/title/status, get detail; validation errors with stable `code`

**Independent Test**: POST create → GET list shows ticket → GET by id → duplicate title creates second distinct `id` (spec User Story 1)

### Tests for User Story 1

- [ ] T022 [P] [US1] Add `backend/src/test/java/com/support/tickets/domain/service/TicketServiceCreateTest.java` (unit: new ticket starts OPEN, optional assignee on create stored or omitted — no blank-field assertion tests here)
- [ ] T023 [P] [US1] Add `backend/src/test/java/com/support/tickets/api/controller/TicketControllerCreateListWebMvcTest.java` (`@WebMvcTest`: 201 create, 422 blank title/description/invalid priority with `VALIDATION_ERROR`, list summaries include `id`)
- [ ] T024 [P] [US1] Add `backend/src/test/java/com/support/tickets/integration/TicketCreateListIntegrationTest.java` (H2: create two same-title tickets, distinct ids)

### Implementation for User Story 1

- [ ] T025 [US1] Implement `backend/src/main/java/com/support/tickets/domain/service/TicketService.java` methods `create`, `getById`, `listSummaries` (default sort `id` DESC per research R8)
- [ ] T026 [US1] Implement `backend/src/main/java/com/support/tickets/api/controller/TicketController.java` — `POST /api/v1/tickets`, `GET /api/v1/tickets`, `GET /api/v1/tickets/{id}` (comments empty array until US4)
- [ ] T027 [P] [US1] Add Jakarta validation on `backend/src/main/java/com/support/tickets/api/dto/CreateTicketRequest.java` — `@NotBlank` title and description, valid `priority` enum, optional `assignee` (no `@Size` maximums); trigger via `@Valid` on `POST /api/v1/tickets` in `TicketController.java`
- [ ] T028 [P] [US1] Add `frontend/src/types/ticket.ts` mirroring API types
- [ ] T029 [P] [US1] Add `frontend/src/api/ticketsClient.ts` (create, list, getById, parse ProblemDetail)
- [ ] T030 [US1] Add `frontend/src/pages/TicketListPage.tsx` showing `id`, title, status
- [ ] T031 [US1] Add `frontend/src/pages/CreateTicketPage.tsx` with client-side required-field hints (backend authoritative)
- [ ] T032 [US1] Add `frontend/src/pages/TicketDetailPage.tsx` read-only detail view
- [ ] T033 [US1] Wire routes in `frontend/src/App.tsx`

**Checkpoint**: MVP API + UI for create/list/detail; run US1 independent test

---

## Phase 4: User Story 2 — Move a ticket through its lifecycle (Priority: P1)

**Goal**: Allowed transitions only; reject others including same-status; ProblemDetail with `currentStatus` / `requestedStatus`

**Independent Test**: Exercise allowed path and rejected examples from spec User Story 2 (backend tests required even if UI hides actions)

### Tests for User Story 2

- [ ] T034 [P] [US2] Add `backend/src/test/java/com/support/tickets/domain/service/TicketStatusTransitionsTest.java` (unit: full transition matrix, same-status rejected)
- [ ] T035 [P] [US2] Add `backend/src/test/java/com/support/tickets/api/controller/TicketTransitionWebMvcTest.java` (`@WebMvcTest`: 422 invalid `status` enum on `TransitionRequest`; 409 `INVALID_STATUS_TRANSITION` with `currentStatus`/`requestedStatus` for disallowed business transitions)

### Implementation for User Story 2

- [ ] T036 [US2] Implement `backend/src/main/java/com/support/tickets/domain/service/TicketStatusService.java` and `TicketStatusTransitions` helper (FR-009/FR-010)
- [ ] T037 [US2] Add `POST /api/v1/tickets/{id}/transitions` to `backend/src/main/java/com/support/tickets/api/controller/TicketController.java` with `@Valid` on `backend/src/main/java/com/support/tickets/api/dto/TransitionRequest.java` (required valid `TicketStatus` enum)
- [ ] T038 [US2] Add transition actions to `frontend/src/pages/TicketDetailPage.tsx` (show only allowed targets; still call API for authority)
- [ ] T039 [US2] Display transition errors using `code`, `detail`, `currentStatus`, `requestedStatus` in `frontend/src/api/ticketsClient.ts`

**Checkpoint**: Lifecycle enforced server-side; US1 + US2 both pass tests

---

## Phase 5: User Story 3 — Update ticket details (Priority: P2)

**Goal**: PATCH partial updates in any status; explicit assignee clear; status unchanged

**Independent Test**: PATCH single field; clear assignee; invalid field rejected with prior data unchanged (spec User Story 3)

### Tests for User Story 3

- [ ] T040 [P] [US3] Add `backend/src/test/java/com/support/tickets/domain/service/TicketServicePatchTest.java` (unit: partial field update, omitted fields unchanged, explicit `assignee` null clears assignee, ticket `status` unchanged — no blank-field assertion tests here)
- [ ] T041 [P] [US3] Add `backend/src/test/java/com/support/tickets/api/controller/TicketPatchWebMvcTest.java` (`@WebMvcTest`: 422 when supplied title/description blank or priority invalid; 200 valid partial PATCH)

### Implementation for User Story 3

- [ ] T042 [US3] Add presence-aware `UpdateTicketRequest` in `backend/src/main/java/com/support/tickets/api/dto/UpdateTicketRequest.java` using `JsonNullable` or an equivalent Jackson presence-aware mechanism (omitted fields unchanged; explicit `assignee: null` clears assignee); validate any supplied title/description as `@NotBlank` and any supplied `priority` as a valid enum (no `@Size` maximums)
- [ ] T043 [US3] Extend `TicketService` with `updatePartial` in `backend/src/main/java/com/support/tickets/domain/service/TicketService.java`
- [ ] T044 [US3] Add `PATCH /api/v1/tickets/{id}` to `backend/src/main/java/com/support/tickets/api/controller/TicketController.java` with `@Valid` on `UpdateTicketRequest`
- [ ] T045 [US3] Add edit form on `frontend/src/pages/TicketDetailPage.tsx` calling PATCH (including clear assignee)

**Checkpoint**: Edits work on CLOSED/CANCELLED tickets without status change

---

## Phase 6: User Story 4 — Add comments (Priority: P2)

**Goal**: POST non-blank comment on any status; comments on ticket detail; persist with ticket

**Independent Test**: Comment on CANCELLED ticket; blank rejected; comment not visible on other tickets (spec User Story 4)

### Tests for User Story 4

- [ ] T046 [P] [US4] Add `backend/src/test/java/com/support/tickets/api/controller/CommentControllerWebMvcTest.java` (`@WebMvcTest`: 422 blank/whitespace `content` with `VALIDATION_ERROR`; 201 valid comment)
- [ ] T047 [P] [US4] Add `backend/src/test/java/com/support/tickets/integration/CommentPersistenceIntegrationTest.java` (H2)

### Implementation for User Story 4

- [ ] T048 [US4] Implement `backend/src/main/java/com/support/tickets/domain/service/CommentService.java`
- [ ] T049 [US4] Add `POST /api/v1/tickets/{ticketId}/comments` in `backend/src/main/java/com/support/tickets/api/controller/CommentController.java` with `@Valid` on `backend/src/main/java/com/support/tickets/api/dto/CreateCommentRequest.java` (`@NotBlank` content; no `@Size` maximums)
- [ ] T050 [US4] Include comments in `GET /api/v1/tickets/{id}` via `TicketMapper` (order by comment `id` ASC)
- [ ] T051 [US4] Add comment list + form to `frontend/src/pages/TicketDetailPage.tsx`

**Checkpoint**: US4 complete; detail shows comments after refresh

---

## Phase 7: User Story 5 — Search and filter the list (Priority: P3)

**Goal**: `q` case-insensitive title/description OR match; single `status` filter; AND when both provided

**Independent Test**: Scenarios from spec User Story 5 (assignee/comment text must not match `q`)

**Note**: Treat omitted/blank `q` as no keyword filter — implementation default only ([research.md](./research.md) R4); do not add product acceptance tests for empty keyword.

### Tests for User Story 5

- [ ] T052 [P] [US5] Add `backend/src/test/java/com/support/tickets/domain/repository/TicketRepositorySearchTest.java` (`@DataJpaTest`, H2)
- [ ] T053 [P] [US5] Add `backend/src/test/java/com/support/tickets/api/controller/TicketListFilterWebMvcTest.java`

### Implementation for User Story 5

- [ ] T054 [US5] Add search/filter query to `TicketRepository` in `backend/src/main/java/com/support/tickets/domain/repository/TicketRepository.java`
- [ ] T055 [US5] Extend `TicketService.listSummaries` and `GET /api/v1/tickets` for `status` and `q` params
- [ ] T056 [US5] Add search input and status filter to `frontend/src/pages/TicketListPage.tsx`

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
```

### **User**
$speckit-implement Implement the current feature using the existing Spec Kit artifacts.
                   
                   Before making any changes, read and follow these files:
                   
                   - `.specify/memory/constitution.md`
                   - `specs/001-support-ticket-management/spec.md`
                   - `specs/001-support-ticket-management/plan.md`
                   - `specs/001-support-ticket-management/research.md`
                   - `specs/001-support-ticket-management/data-model.md`
                   - `specs/001-support-ticket-management/contracts/openapi.yaml`
                   - `specs/001-support-ticket-management/quickstart.md`
                   - `specs/001-support-ticket-management/tasks.md`
                   
                   Use the constitution, specification, plan, and tasks as the source of truth. Do not invent requirements or behavior that is not documented.
                   
                   ### Implementation scope
                   
                   Implement ONLY:
                   
                   1. Phase 1 — Project Setup
                   2. Phase 2 — Foundational Backend
                   3. User Story 1 — Create and View Tickets
                   
                   Do NOT implement:
                   
                   - User Story 2 — State transitions
                   - User Story 3 — Partial ticket updates
                   - User Story 4 — Comments
                   - User Story 5 — Search and filtering
                   - Phase 8 PostgreSQL restart verification
                   - Any functionality belonging to later phases
                   
                   Follow the task order in `tasks.md` and update the task checkboxes as tasks are completed.
                   
                   ### Technical constraints
                   
                   Follow the constitution and plan exactly:
                   
                   - Java 21
                   - Spring Boot 3
                   - Maven
                   - PostgreSQL for runtime
                   - H2 for tests
                   - Flyway migrations
                   - Constructor injection
                   - Controller / Service / Repository / DTO separation
                   - Jakarta Bean Validation
                   - ProblemDetail with stable machine-readable error codes
                   - No authentication, roles, users, or user directory
                   - Ticket titles are NOT unique
                   - Do NOT introduce artificial max-length validation
                   - Do NOT use `ddl-auto=update` or `ddl-auto=create`
                   - Do not introduce microservices, CQRS, event sourcing, Kafka, or other architecture not required by the specification
                   - Preserve the package structure and architecture defined in the plan
                   
                   ### User Story 1
                   
                   Implement only the functionality required for:
                   
                   - Creating a ticket
                   - Listing tickets
                   - Viewing ticket details
                   - Required-field validation
                   - Supporting duplicate ticket titles
                   - Stable ticket IDs
                   - Persistence model and repository
                   - Required frontend pieces defined by the plan
                   
                   Ensure the implementation matches the OpenAPI contract and documented data model.
                   
                   ### Testing
                   
                   Create and run the tests required by the current tasks.
                   
                   At minimum, verify the behavior relevant to the implemented scope, including:
                   
                   - Ticket creation
                   - Required-field validation
                   - Duplicate titles
                   - Listing tickets
                   - Viewing a ticket by ID
                   - Not-found behavior where required
                   - Persistence/repository behavior appropriate to the current phase
                   
                   Do not implement the PostgreSQL restart persistence test yet because that belongs to Phase 8.
                   
                   ### Important implementation rules
                   
                   - Inspect the existing repository before changing files.
                   - Do not modify or remove Spec Kit artifacts unless the implementation workflow specifically requires updating `tasks.md`.
                   - Do not implement future user stories "because they are related".
                   - Do not add speculative features.
                   - Keep changes incremental and aligned with the plan.
                   - If an ambiguity is discovered, use the existing artifacts to resolve it. If they genuinely do not define the behavior, report the ambiguity instead of inventing a requirement.
                   
                   ### Completion
                   
                   After implementation:
                   
                   1. Run the relevant tests.
                   2. Run the backend build/checks.
                   3. Fix implementation issues found by those checks.
                   4. Update `tasks.md` for completed tasks.
                   5. Do not proceed beyond Phase 1 + Phase 2 + User Story 1.
                   
                   Finally, report:
                   
                   - Files created/modified
                   - Tasks completed
                   - Tests executed and their results
                   - Build/check results
                   - Any deviations from the specification/plan
                   - Any assumptions or unresolved ambiguities
                   - Anything that requires human verification
                   
                   Stop after this scope. Do not continue to the next user story.

*Attachment: Console Selection*
```
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

- [ ] T001 Create `backend/pom.xml` with Java 21, Spring Boot 3 (web, data-jpa, validation), Flyway, PostgreSQL driver, H2, springdoc-openapi, Testcontainers PostgreSQL, JUnit 5, Mockito, AssertJ
- [ ] T002 Create `backend/src/main/java/com/support/tickets/SupportTicketApplication.java`
- [ ] T003 [P] Scaffold `frontend/` with Vite, React 18, TypeScript, and React Router (`frontend/package.json`, `frontend/vite.config.ts`, `frontend/index.html`)
- [ ] T004 [P] Add `docker-compose.yml` at repository root for PostgreSQL 15 (dev only; no secrets in repo)
- [ ] T005 [P] Add `backend/src/main/resources/application.yml` with shared defaults (`ddl-auto=validate`, Flyway enabled)
- [ ] T006 [P] Add `README.md` skeleton at repository root (placeholders for run/test instructions)

**Checkpoint**: `./mvnw -f backend/pom.xml -q validate` and `npm install` in `frontend/` succeed

---

## Phase 2: Foundational (Blocking Prerequisites)

**Purpose**: Schema, domain model, error contract, and API infrastructure required by every user story

**⚠️ CRITICAL**: No user story implementation until this phase completes

- [ ] T007 Add Flyway migration `backend/src/main/resources/db/migration/V1__create_tickets_and_comments.sql` with `TEXT` columns (no max-length DB constraints per [research.md](./research.md) R9)
- [ ] T008 Add `backend/src/main/resources/application-local.yml` (PostgreSQL via env vars, CORS for `http://localhost:5173`)
- [ ] T009 Add `backend/src/main/resources/application-test.yml` (H2 in-memory, Flyway on)
- [ ] T010 [P] Create enums `backend/src/main/java/com/support/tickets/domain/model/TicketStatus.java` and `TicketPriority.java`
- [ ] T011 [P] Create JPA entity `backend/src/main/java/com/support/tickets/domain/model/Ticket.java` (LAZY comments, IDENTITY id)
- [ ] T012 [P] Create JPA entity `backend/src/main/java/com/support/tickets/domain/model/Comment.java`
- [ ] T013 [P] Create `backend/src/main/java/com/support/tickets/domain/repository/TicketRepository.java`
- [ ] T014 [P] Create `backend/src/main/java/com/support/tickets/domain/repository/CommentRepository.java`
- [ ] T015 [P] Create stable error codes enum `backend/src/main/java/com/support/tickets/exception/ApiErrorCode.java` (`TICKET_NOT_FOUND`, `VALIDATION_ERROR`, `INVALID_STATUS_TRANSITION`)
- [ ] T016 Implement `backend/src/main/java/com/support/tickets/exception/GlobalExceptionHandler.java` returning RFC 7807 `ProblemDetail` with `code`, human message, and transition fields when applicable
- [ ] T017 [P] Create API DTO records under `backend/src/main/java/com/support/tickets/api/dto/` (`TicketSummaryResponse`, `TicketResponse`, `CommentResponse`, `CreateTicketRequest`, `UpdateTicketRequest`, `CreateCommentRequest`, `TransitionRequest`)
- [ ] T018 [P] Create `backend/src/main/java/com/support/tickets/api/mapper/TicketMapper.java`
- [ ] T019 [P] Add `backend/src/main/java/com/support/tickets/config/WebConfig.java` for CORS (local profile)
- [ ] T020 [P] Add `backend/src/main/java/com/support/tickets/config/OpenApiConfig.java` for springdoc
- [ ] T021 Add `backend/src/test/java/com/support/tickets/support/AbstractIntegrationTest.java` with `@SpringBootTest` and H2 `test` profile

**Checkpoint**: Application starts on H2 test profile; migrations apply; no REST features yet

---

## Phase 3: User Story 1 — Create a ticket and find it again (Priority: P1)  MVP

**Goal**: Create ticket (OPEN), list with `id`/title/status, get detail; validation errors with stable `code`

**Independent Test**: POST create → GET list shows ticket → GET by id → duplicate title creates second distinct `id` (spec User Story 1)

### Tests for User Story 1

- [ ] T022 [P] [US1] Add `backend/src/test/java/com/support/tickets/domain/service/TicketServiceCreateTest.java` (unit: new ticket starts OPEN, optional assignee on create stored or omitted — no blank-field assertion tests here)
- [ ] T023 [P] [US1] Add `backend/src/test/java/com/support/tickets/api/controller/TicketControllerCreateListWebMvcTest.java` (`@WebMvcTest`: 201 create, 422 blank title/description/invalid priority with `VALIDATION_ERROR`, list summaries include `id`)
- [ ] T024 [P] [US1] Add `backend/src/test/java/com/support/tickets/integration/TicketCreateListIntegrationTest.java` (H2: create two same-title tickets, distinct ids)

### Implementation for User Story 1

- [ ] T025 [US1] Implement `backend/src/main/java/com/support/tickets/domain/service/TicketService.java` methods `create`, `getById`, `listSummaries` (default sort `id` DESC per research R8)
- [ ] T026 [US1] Implement `backend/src/main/java/com/support/tickets/api/controller/TicketController.java` — `POST /api/v1/tickets`, `GET /api/v1/tickets`, `GET /api/v1/tickets/{id}` (comments empty array until US4)
- [ ] T027 [P] [US1] Add Jakarta validation on `backend/src/main/java/com/support/tickets/api/dto/CreateTicketRequest.java` — `@NotBlank` title and description, valid `priority` enum, optional `assignee` (no `@Size` maximums); trigger via `@Valid` on `POST /api/v1/tickets` in `TicketController.java`
- [ ] T028 [P] [US1] Add `frontend/src/types/ticket.ts` mirroring API types
- [ ] T029 [P] [US1] Add `frontend/src/api/ticketsClient.ts` (create, list, getById, parse ProblemDetail)
- [ ] T030 [US1] Add `frontend/src/pages/TicketListPage.tsx` showing `id`, title, status
- [ ] T031 [US1] Add `frontend/src/pages/CreateTicketPage.tsx` with client-side required-field hints (backend authoritative)
- [ ] T032 [US1] Add `frontend/src/pages/TicketDetailPage.tsx` read-only detail view
- [ ] T033 [US1] Wire routes in `frontend/src/App.tsx`

**Checkpoint**: MVP API + UI for create/list/detail; run US1 independent test

---

## Phase 4: User Story 2 — Move a ticket through its lifecycle (Priority: P1)

**Goal**: Allowed transitions only; reject others including same-status; ProblemDetail with `currentStatus` / `requestedStatus`

**Independent Test**: Exercise allowed path and rejected examples from spec User Story 2 (backend tests required even if UI hides actions)

### Tests for User Story 2

- [ ] T034 [P] [US2] Add `backend/src/test/java/com/support/tickets/domain/service/TicketStatusTransitionsTest.java` (unit: full transition matrix, same-status rejected)
- [ ] T035 [P] [US2] Add `backend/src/test/java/com/support/tickets/api/controller/TicketTransitionWebMvcTest.java` (`@WebMvcTest`: 422 invalid `status` enum on `TransitionRequest`; 409 `INVALID_STATUS_TRANSITION` with `currentStatus`/`requestedStatus` for disallowed business transitions)

### Implementation for User Story 2

- [ ] T036 [US2] Implement `backend/src/main/java/com/support/tickets/domain/service/TicketStatusService.java` and `TicketStatusTransitions` helper (FR-009/FR-010)
- [ ] T037 [US2] Add `POST /api/v1/tickets/{id}/transitions` to `backend/src/main/java/com/support/tickets/api/controller/TicketController.java` with `@Valid` on `backend/src/main/java/com/support/tickets/api/dto/TransitionRequest.java` (required valid `TicketStatus` enum)
- [ ] T038 [US2] Add transition actions to `frontend/src/pages/TicketDetailPage.tsx` (show only allowed targets; still call API for authority)
- [ ] T039 [US2] Display transition errors using `code`, `detail`, `currentStatus`, `requestedStatus` in `frontend/src/api/ticketsClient.ts`

**Checkpoint**: Lifecycle enforced server-side; US1 + US2 both pass tests

---

## Phase 5: User Story 3 — Update ticket details (Priority: P2)

**Goal**: PATCH partial updates in any status; explicit assignee clear; status unchanged

**Independent Test**: PATCH single field; clear assignee; invalid field rejected with prior data unchanged (spec User Story 3)

### Tests for User Story 3

- [ ] T040 [P] [US3] Add `backend/src/test/java/com/support/tickets/domain/service/TicketServicePatchTest.java` (unit: partial field update, omitted fields unchanged, explicit `assignee` null clears assignee, ticket `status` unchanged — no blank-field assertion tests here)
- [ ] T041 [P] [US3] Add `backend/src/test/java/com/support/tickets/api/controller/TicketPatchWebMvcTest.java` (`@WebMvcTest`: 422 when supplied title/description blank or priority invalid; 200 valid partial PATCH)

### Implementation for User Story 3

- [ ] T042 [US3] Add presence-aware `UpdateTicketRequest` in `backend/src/main/java/com/support/tickets/api/dto/UpdateTicketRequest.java` using `JsonNullable` or an equivalent Jackson presence-aware mechanism (omitted fields unchanged; explicit `assignee: null` clears assignee); validate any supplied title/description as `@NotBlank` and any supplied `priority` as a valid enum (no `@Size` maximums)
- [ ] T043 [US3] Extend `TicketService` with `updatePartial` in `backend/src/main/java/com/support/tickets/domain/service/TicketService.java`
- [ ] T044 [US3] Add `PATCH /api/v1/tickets/{id}` to `backend/src/main/java/com/support/tickets/api/controller/TicketController.java` with `@Valid` on `UpdateTicketRequest`
- [ ] T045 [US3] Add edit form on `frontend/src/pages/TicketDetailPage.tsx` calling PATCH (including clear assignee)

**Checkpoint**: Edits work on CLOSED/CANCELLED tickets without status change

---

## Phase 6: User Story 4 — Add comments (Priority: P2)

**Goal**: POST non-blank comment on any status; comments on ticket detail; persist with ticket

**Independent Test**: Comment on CANCELLED ticket; blank rejected; comment not visible on other tickets (spec User Story 4)

### Tests for User Story 4

- [ ] T046 [P] [US4] Add `backend/src/test/java/com/support/tickets/api/controller/CommentControllerWebMvcTest.java` (`@WebMvcTest`: 422 blank/whitespace `content` with `VALIDATION_ERROR`; 201 valid comment)
- [ ] T047 [P] [US4] Add `backend/src/test/java/com/support/tickets/integration/CommentPersistenceIntegrationTest.java` (H2)

### Implementation for User Story 4

- [ ] T048 [US4] Implement `backend/src/main/java/com/support/tickets/domain/service/CommentService.java`
- [ ] T049 [US4] Add `POST /api/v1/tickets/{ticketId}/comments` in `backend/src/main/java/com/support/tickets/api/controller/CommentController.java` with `@Valid` on `backend/src/main/java/com/support/tickets/api/dto/CreateCommentRequest.java` (`@NotBlank` content; no `@Size` maximums)
- [ ] T050 [US4] Include comments in `GET /api/v1/tickets/{id}` via `TicketMapper` (order by comment `id` ASC)
- [ ] T051 [US4] Add comment list + form to `frontend/src/pages/TicketDetailPage.tsx`

**Checkpoint**: US4 complete; detail shows comments after refresh

---

## Phase 7: User Story 5 — Search and filter the list (Priority: P3)

**Goal**: `q` case-insensitive title/description OR match; single `status` filter; AND when both provided

**Independent Test**: Scenarios from spec User Story 5 (assignee/comment text must not match `q`)

**Note**: Treat omitted/blank `q` as no keyword filter — implementation default only ([research.md](./research.md) R4); do not add product acceptance tests for empty keyword.

### Tests for User Story 5

- [ ] T052 [P] [US5] Add `backend/src/test/java/com/support/tickets/domain/repository/TicketRepositorySearchTest.java` (`@DataJpaTest`, H2)
- [ ] T053 [P] [US5] Add `backend/src/test/java/com/support/tickets/api/controller/TicketListFilterWebMvcTest.java`

### Implementation for User Story 5

- [ ] T054 [US5] Add search/filter query to `TicketRepository` in `backend/src/main/java/com/support/tickets/domain/repository/TicketRepository.java`
- [ ] T055 [US5] Extend `TicketService.listSummaries` and `GET /api/v1/tickets` for `status` and `q` params
- [ ] T056 [US5] Add search input and status filter to `frontend/src/pages/TicketListPage.tsx`

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
```

### **User**
$speckit-implement Implement the current feature using the existing Spec Kit artifacts.
                   
                   Before making any changes, read and follow these files:
                   
                   - `.specify/memory/constitution.md`
                   - `specs/001-support-ticket-management/spec.md`
                   - `specs/001-support-ticket-management/plan.md`
                   - `specs/001-support-ticket-management/research.md`
                   - `specs/001-support-ticket-management/data-model.md`
                   - `specs/001-support-ticket-management/contracts/openapi.yaml`
                   - `specs/001-support-ticket-management/quickstart.md`
                   - `specs/001-support-ticket-management/tasks.md`
                   
                   Use the constitution, specification, plan, and tasks as the source of truth. Do not invent requirements or behavior that is not documented.
                   
                   ### Implementation scope
                   
                   Implement ONLY:
                   
                   1. Phase 1 — Project Setup
                   2. Phase 2 — Foundational Backend
                   3. User Story 1 — Create and View Tickets
                   
                   Do NOT implement:
                   
                   - User Story 2 — State transitions
                   - User Story 3 — Partial ticket updates
                   - User Story 4 — Comments
                   - User Story 5 — Search and filtering
                   - Phase 8 PostgreSQL restart verification
                   - Any functionality belonging to later phases
                   
                   Follow the task order in `tasks.md` and update the task checkboxes as tasks are completed.
                   
                   ### Technical constraints
                   
                   Follow the constitution and plan exactly:
                   
                   - Java 21
                   - Spring Boot 3
                   - Maven
                   - PostgreSQL for runtime
                   - H2 for tests
                   - Flyway migrations
                   - Constructor injection
                   - Controller / Service / Repository / DTO separation
                   - Jakarta Bean Validation
                   - ProblemDetail with stable machine-readable error codes
                   - No authentication, roles, users, or user directory
                   - Ticket titles are NOT unique
                   - Do NOT introduce artificial max-length validation
                   - Do NOT use `ddl-auto=update` or `ddl-auto=create`
                   - Do not introduce microservices, CQRS, event sourcing, Kafka, or other architecture not required by the specification
                   - Preserve the package structure and architecture defined in the plan
                   
                   ### User Story 1
                   
                   Implement only the functionality required for:
                   
                   - Creating a ticket
                   - Listing tickets
                   - Viewing ticket details
                   - Required-field validation
                   - Supporting duplicate ticket titles
                   - Stable ticket IDs
                   - Persistence model and repository
                   - Required frontend pieces defined by the plan
                   
                   Ensure the implementation matches the OpenAPI contract and documented data model.
                   
                   ### Testing
                   
                   Create and run the tests required by the current tasks.
                   
                   At minimum, verify the behavior relevant to the implemented scope, including:
                   
                   - Ticket creation
                   - Required-field validation
                   - Duplicate titles
                   - Listing tickets
                   - Viewing a ticket by ID
                   - Not-found behavior where required
                   - Persistence/repository behavior appropriate to the current phase
                   
                   Do not implement the PostgreSQL restart persistence test yet because that belongs to Phase 8.
                   
                   ### Important implementation rules
                   
                   - Inspect the existing repository before changing files.
                   - Do not modify or remove Spec Kit artifacts unless the implementation workflow specifically requires updating `tasks.md`.
                   - Do not implement future user stories "because they are related".
                   - Do not add speculative features.
                   - Keep changes incremental and aligned with the plan.
                   - If an ambiguity is discovered, use the existing artifacts to resolve it. If they genuinely do not define the behavior, report the ambiguity instead of inventing a requirement.
                   
                   ### Completion
                   
                   After implementation:
                   
                   1. Run the relevant tests.
                   2. Run the backend build/checks.
                   3. Fix implementation issues found by those checks.
                   4. Update `tasks.md` for completed tasks.
                   5. Do not proceed beyond Phase 1 + Phase 2 + User Story 1.
                   
                   Finally, report:
                   
                   - Files created/modified
                   - Tasks completed
                   - Tests executed and their results
                   - Build/check results
                   - Any deviations from the specification/plan
                   - Any assumptions or unresolved ambiguities
                   - Anything that requires human verification
                   
                   Stop after this scope. Do not continue to the next user story.

*Attachment: Console Selection*
```
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

- [ ] T001 Create `backend/pom.xml` with Java 21, Spring Boot 3 (web, data-jpa, validation), Flyway, PostgreSQL driver, H2, springdoc-openapi, Testcontainers PostgreSQL, JUnit 5, Mockito, AssertJ
- [ ] T002 Create `backend/src/main/java/com/support/tickets/SupportTicketApplication.java`
- [ ] T003 [P] Scaffold `frontend/` with Vite, React 18, TypeScript, and React Router (`frontend/package.json`, `frontend/vite.config.ts`, `frontend/index.html`)
- [ ] T004 [P] Add `docker-compose.yml` at repository root for PostgreSQL 15 (dev only; no secrets in repo)
- [ ] T005 [P] Add `backend/src/main/resources/application.yml` with shared defaults (`ddl-auto=validate`, Flyway enabled)
- [ ] T006 [P] Add `README.md` skeleton at repository root (placeholders for run/test instructions)

**Checkpoint**: `./mvnw -f backend/pom.xml -q validate` and `npm install` in `frontend/` succeed

---

## Phase 2: Foundational (Blocking Prerequisites)

**Purpose**: Schema, domain model, error contract, and API infrastructure required by every user story

**⚠️ CRITICAL**: No user story implementation until this phase completes

- [ ] T007 Add Flyway migration `backend/src/main/resources/db/migration/V1__create_tickets_and_comments.sql` with `TEXT` columns (no max-length DB constraints per [research.md](./research.md) R9)
- [ ] T008 Add `backend/src/main/resources/application-local.yml` (PostgreSQL via env vars, CORS for `http://localhost:5173`)
- [ ] T009 Add `backend/src/main/resources/application-test.yml` (H2 in-memory, Flyway on)
- [ ] T010 [P] Create enums `backend/src/main/java/com/support/tickets/domain/model/TicketStatus.java` and `TicketPriority.java`
- [ ] T011 [P] Create JPA entity `backend/src/main/java/com/support/tickets/domain/model/Ticket.java` (LAZY comments, IDENTITY id)
- [ ] T012 [P] Create JPA entity `backend/src/main/java/com/support/tickets/domain/model/Comment.java`
- [ ] T013 [P] Create `backend/src/main/java/com/support/tickets/domain/repository/TicketRepository.java`
- [ ] T014 [P] Create `backend/src/main/java/com/support/tickets/domain/repository/CommentRepository.java`
- [ ] T015 [P] Create stable error codes enum `backend/src/main/java/com/support/tickets/exception/ApiErrorCode.java` (`TICKET_NOT_FOUND`, `VALIDATION_ERROR`, `INVALID_STATUS_TRANSITION`)
- [ ] T016 Implement `backend/src/main/java/com/support/tickets/exception/GlobalExceptionHandler.java` returning RFC 7807 `ProblemDetail` with `code`, human message, and transition fields when applicable
- [ ] T017 [P] Create API DTO records under `backend/src/main/java/com/support/tickets/api/dto/` (`TicketSummaryResponse`, `TicketResponse`, `CommentResponse`, `CreateTicketRequest`, `UpdateTicketRequest`, `CreateCommentRequest`, `TransitionRequest`)
- [ ] T018 [P] Create `backend/src/main/java/com/support/tickets/api/mapper/TicketMapper.java`
- [ ] T019 [P] Add `backend/src/main/java/com/support/tickets/config/WebConfig.java` for CORS (local profile)
- [ ] T020 [P] Add `backend/src/main/java/com/support/tickets/config/OpenApiConfig.java` for springdoc
- [ ] T021 Add `backend/src/test/java/com/support/tickets/support/AbstractIntegrationTest.java` with `@SpringBootTest` and H2 `test` profile

**Checkpoint**: Application starts on H2 test profile; migrations apply; no REST features yet

---

## Phase 3: User Story 1 — Create a ticket and find it again (Priority: P1)  MVP

**Goal**: Create ticket (OPEN), list with `id`/title/status, get detail; validation errors with stable `code`

**Independent Test**: POST create → GET list shows ticket → GET by id → duplicate title creates second distinct `id` (spec User Story 1)

### Tests for User Story 1

- [ ] T022 [P] [US1] Add `backend/src/test/java/com/support/tickets/domain/service/TicketServiceCreateTest.java` (unit: new ticket starts OPEN, optional assignee on create stored or omitted — no blank-field assertion tests here)
- [ ] T023 [P] [US1] Add `backend/src/test/java/com/support/tickets/api/controller/TicketControllerCreateListWebMvcTest.java` (`@WebMvcTest`: 201 create, 422 blank title/description/invalid priority with `VALIDATION_ERROR`, list summaries include `id`)
- [ ] T024 [P] [US1] Add `backend/src/test/java/com/support/tickets/integration/TicketCreateListIntegrationTest.java` (H2: create two same-title tickets, distinct ids)

### Implementation for User Story 1

- [ ] T025 [US1] Implement `backend/src/main/java/com/support/tickets/domain/service/TicketService.java` methods `create`, `getById`, `listSummaries` (default sort `id` DESC per research R8)
- [ ] T026 [US1] Implement `backend/src/main/java/com/support/tickets/api/controller/TicketController.java` — `POST /api/v1/tickets`, `GET /api/v1/tickets`, `GET /api/v1/tickets/{id}` (comments empty array until US4)
- [ ] T027 [P] [US1] Add Jakarta validation on `backend/src/main/java/com/support/tickets/api/dto/CreateTicketRequest.java` — `@NotBlank` title and description, valid `priority` enum, optional `assignee` (no `@Size` maximums); trigger via `@Valid` on `POST /api/v1/tickets` in `TicketController.java`
- [ ] T028 [P] [US1] Add `frontend/src/types/ticket.ts` mirroring API types
- [ ] T029 [P] [US1] Add `frontend/src/api/ticketsClient.ts` (create, list, getById, parse ProblemDetail)
- [ ] T030 [US1] Add `frontend/src/pages/TicketListPage.tsx` showing `id`, title, status
- [ ] T031 [US1] Add `frontend/src/pages/CreateTicketPage.tsx` with client-side required-field hints (backend authoritative)
- [ ] T032 [US1] Add `frontend/src/pages/TicketDetailPage.tsx` read-only detail view
- [ ] T033 [US1] Wire routes in `frontend/src/App.tsx`

**Checkpoint**: MVP API + UI for create/list/detail; run US1 independent test

---

## Phase 4: User Story 2 — Move a ticket through its lifecycle (Priority: P1)

**Goal**: Allowed transitions only; reject others including same-status; ProblemDetail with `currentStatus` / `requestedStatus`

**Independent Test**: Exercise allowed path and rejected examples from spec User Story 2 (backend tests required even if UI hides actions)

### Tests for User Story 2

- [ ] T034 [P] [US2] Add `backend/src/test/java/com/support/tickets/domain/service/TicketStatusTransitionsTest.java` (unit: full transition matrix, same-status rejected)
- [ ] T035 [P] [US2] Add `backend/src/test/java/com/support/tickets/api/controller/TicketTransitionWebMvcTest.java` (`@WebMvcTest`: 422 invalid `status` enum on `TransitionRequest`; 409 `INVALID_STATUS_TRANSITION` with `currentStatus`/`requestedStatus` for disallowed business transitions)

### Implementation for User Story 2

- [ ] T036 [US2] Implement `backend/src/main/java/com/support/tickets/domain/service/TicketStatusService.java` and `TicketStatusTransitions` helper (FR-009/FR-010)
- [ ] T037 [US2] Add `POST /api/v1/tickets/{id}/transitions` to `backend/src/main/java/com/support/tickets/api/controller/TicketController.java` with `@Valid` on `backend/src/main/java/com/support/tickets/api/dto/TransitionRequest.java` (required valid `TicketStatus` enum)
- [ ] T038 [US2] Add transition actions to `frontend/src/pages/TicketDetailPage.tsx` (show only allowed targets; still call API for authority)
- [ ] T039 [US2] Display transition errors using `code`, `detail`, `currentStatus`, `requestedStatus` in `frontend/src/api/ticketsClient.ts`

**Checkpoint**: Lifecycle enforced server-side; US1 + US2 both pass tests

---

## Phase 5: User Story 3 — Update ticket details (Priority: P2)

**Goal**: PATCH partial updates in any status; explicit assignee clear; status unchanged

**Independent Test**: PATCH single field; clear assignee; invalid field rejected with prior data unchanged (spec User Story 3)

### Tests for User Story 3

- [ ] T040 [P] [US3] Add `backend/src/test/java/com/support/tickets/domain/service/TicketServicePatchTest.java` (unit: partial field update, omitted fields unchanged, explicit `assignee` null clears assignee, ticket `status` unchanged — no blank-field assertion tests here)
- [ ] T041 [P] [US3] Add `backend/src/test/java/com/support/tickets/api/controller/TicketPatchWebMvcTest.java` (`@WebMvcTest`: 422 when supplied title/description blank or priority invalid; 200 valid partial PATCH)

### Implementation for User Story 3

- [ ] T042 [US3] Add presence-aware `UpdateTicketRequest` in `backend/src/main/java/com/support/tickets/api/dto/UpdateTicketRequest.java` using `JsonNullable` or an equivalent Jackson presence-aware mechanism (omitted fields unchanged; explicit `assignee: null` clears assignee); validate any supplied title/description as `@NotBlank` and any supplied `priority` as a valid enum (no `@Size` maximums)
- [ ] T043 [US3] Extend `TicketService` with `updatePartial` in `backend/src/main/java/com/support/tickets/domain/service/TicketService.java`
- [ ] T044 [US3] Add `PATCH /api/v1/tickets/{id}` to `backend/src/main/java/com/support/tickets/api/controller/TicketController.java` with `@Valid` on `UpdateTicketRequest`
- [ ] T045 [US3] Add edit form on `frontend/src/pages/TicketDetailPage.tsx` calling PATCH (including clear assignee)

**Checkpoint**: Edits work on CLOSED/CANCELLED tickets without status change

---

## Phase 6: User Story 4 — Add comments (Priority: P2)

**Goal**: POST non-blank comment on any status; comments on ticket detail; persist with ticket

**Independent Test**: Comment on CANCELLED ticket; blank rejected; comment not visible on other tickets (spec User Story 4)

### Tests for User Story 4

- [ ] T046 [P] [US4] Add `backend/src/test/java/com/support/tickets/api/controller/CommentControllerWebMvcTest.java` (`@WebMvcTest`: 422 blank/whitespace `content` with `VALIDATION_ERROR`; 201 valid comment)
- [ ] T047 [P] [US4] Add `backend/src/test/java/com/support/tickets/integration/CommentPersistenceIntegrationTest.java` (H2)

### Implementation for User Story 4

- [ ] T048 [US4] Implement `backend/src/main/java/com/support/tickets/domain/service/CommentService.java`
- [ ] T049 [US4] Add `POST /api/v1/tickets/{ticketId}/comments` in `backend/src/main/java/com/support/tickets/api/controller/CommentController.java` with `@Valid` on `backend/src/main/java/com/support/tickets/api/dto/CreateCommentRequest.java` (`@NotBlank` content; no `@Size` maximums)
- [ ] T050 [US4] Include comments in `GET /api/v1/tickets/{id}` via `TicketMapper` (order by comment `id` ASC)
- [ ] T051 [US4] Add comment list + form to `frontend/src/pages/TicketDetailPage.tsx`

**Checkpoint**: US4 complete; detail shows comments after refresh

---

## Phase 7: User Story 5 — Search and filter the list (Priority: P3)

**Goal**: `q` case-insensitive title/description OR match; single `status` filter; AND when both provided

**Independent Test**: Scenarios from spec User Story 5 (assignee/comment text must not match `q`)

**Note**: Treat omitted/blank `q` as no keyword filter — implementation default only ([research.md](./research.md) R4); do not add product acceptance tests for empty keyword.

### Tests for User Story 5

- [ ] T052 [P] [US5] Add `backend/src/test/java/com/support/tickets/domain/repository/TicketRepositorySearchTest.java` (`@DataJpaTest`, H2)
- [ ] T053 [P] [US5] Add `backend/src/test/java/com/support/tickets/api/controller/TicketListFilterWebMvcTest.java`

### Implementation for User Story 5

- [ ] T054 [US5] Add search/filter query to `TicketRepository` in `backend/src/main/java/com/support/tickets/domain/repository/TicketRepository.java`
- [ ] T055 [US5] Extend `TicketService.listSummaries` and `GET /api/v1/tickets` for `status` and `q` params
- [ ] T056 [US5] Add search input and status filter to `frontend/src/pages/TicketListPage.tsx`

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
```

---

## $speckit-implement Implement the current feature using the existing Spec Kit artifacts.
                   
                   Before making any changes, read and follow these files:…
> Model: `agent_acp.registry.codex-acp`  

### **User**
$speckit-implement Implement the current feature using the existing Spec Kit artifacts.
                   
                   Before making any changes, read and follow these files:
                   
                   - `.specify/memory/constitution.md`
                   - `specs/001-support-ticket-management/spec.md`
                   - `specs/001-support-ticket-management/plan.md`
                   - `specs/001-support-ticket-management/research.md`
                   - `specs/001-support-ticket-management/data-model.md`
                   - `specs/001-support-ticket-management/contracts/openapi.yaml`
                   - `specs/001-support-ticket-management/quickstart.md`
                   - `specs/001-support-ticket-management/tasks.md`
                   
                   Use the constitution, specification, plan, and tasks as the source of truth. Do not invent requirements or behavior that is not documented.
                   
                   ### Implementation scope
                   
                   Implement ONLY:
                   
                   1. Phase 1 — Project Setup
                   2. Phase 2 — Foundational Backend
                   3. User Story 1 — Create and View Tickets
                   
                   Do NOT implement:
                   
                   - User Story 2 — State transitions
                   - User Story 3 — Partial ticket updates
                   - User Story 4 — Comments
                   - User Story 5 — Search and filtering
                   - Phase 8 PostgreSQL restart verification
                   - Any functionality belonging to later phases
                   
                   Follow the task order in `tasks.md` and update the task checkboxes as tasks are completed.
                   
                   ### Technical constraints
                   
                   Follow the constitution and plan exactly:
                   
                   - Java 21
                   - Spring Boot 3
                   - Maven
                   - PostgreSQL for runtime
                   - H2 for tests
                   - Flyway migrations
                   - Constructor injection
                   - Controller / Service / Repository / DTO separation
                   - Jakarta Bean Validation
                   - ProblemDetail with stable machine-readable error codes
                   - No authentication, roles, users, or user directory
                   - Ticket titles are NOT unique
                   - Do NOT introduce artificial max-length validation
                   - Do NOT use `ddl-auto=update` or `ddl-auto=create`
                   - Do not introduce microservices, CQRS, event sourcing, Kafka, or other architecture not required by the specification
                   - Preserve the package structure and architecture defined in the plan
                   
                   ### User Story 1
                   
                   Implement only the functionality required for:
                   
                   - Creating a ticket
                   - Listing tickets
                   - Viewing ticket details
                   - Required-field validation
                   - Supporting duplicate ticket titles
                   - Stable ticket IDs
                   - Persistence model and repository
                   - Required frontend pieces defined by the plan
                   
                   Ensure the implementation matches the OpenAPI contract and documented data model.
                   
                   ### Testing
                   
                   Create and run the tests required by the current tasks.
                   
                   At minimum, verify the behavior relevant to the implemented scope, including:
                   
                   - Ticket creation
                   - Required-field validation
                   - Duplicate titles
                   - Listing tickets
                   - Viewing a ticket by ID
                   - Not-found behavior where required
                   - Persistence/repository behavior appropriate to the current phase
                   
                   Do not implement the PostgreSQL restart persistence test yet because that belongs to Phase 8.
                   
                   ### Important implementation rules
                   
                   - Inspect the existing repository before changing files.
                   - Do not modify or remove Spec Kit artifacts unless the implementation workflow specifically requires updating `tasks.md`.
                   - Do not implement future user stories "because they are related".
                   - Do not add speculative features.
                   - Keep changes incremental and aligned with the plan.
                   - If an ambiguity is discovered, use the existing artifacts to resolve it. If they genuinely do not define the behavior, report the ambiguity instead of inventing a requirement.
                   
                   ### Completion
                   
                   After implementation:
                   
                   1. Run the relevant tests.
                   2. Run the backend build/checks.
                   3. Fix implementation issues found by those checks.
                   4. Update `tasks.md` for completed tasks.
                   5. Do not proceed beyond Phase 1 + Phase 2 + User Story 1.
                   
                   Finally, report:
                   
                   - Files created/modified
                   - Tasks completed
                   - Tests executed and their results
                   - Build/check results
                   - Any deviations from the specification/plan
                   - Any assumptions or unresolved ambiguities
                   - Anything that requires human verification
                   
                   Stop after this scope. Do not continue to the next user story.

### **User**
yes

### **User**
The project must have gradle as it configuration

---

## $speckit-implement Continue from the current validated checkpoint. Implement only US2 — Update Ticket from specs/001-support-ticket-management/tasks.md. Read the constitution, specification, clarific…
> Model: `agent_acp.registry.codex-acp`  

### **User**
$speckit-implement Continue from the current validated checkpoint. Implement only US2 — Update Ticket from specs/001-support-ticket-management/tasks.md. Read the constitution, specification, clarifications, plan, research, data model, API contract, and existing implementation before changing anything. Do not implement US3 or any later user story. Run the relevant automated tests, update only the US2 task checkboxes that are actually completed, and stop after US2 implementation and tests. Do not modify requirements or reviewer-owned checklists to mark them complete.

### **User**
yes

---

## yoo
> Model: `agent_acp.registry.cursor`  

### **User**
yoo

---
