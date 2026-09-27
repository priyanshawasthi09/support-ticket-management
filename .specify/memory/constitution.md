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
