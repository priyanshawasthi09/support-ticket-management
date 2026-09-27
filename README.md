# Support Ticket Management

Requires Java 21, Gradle 8.10+, Node.js 20+, and PostgreSQL 15 for local runtime. Use `docker compose up -d` to start the development database, set `SPRING_DATASOURCE_URL`, `SPRING_DATASOURCE_USERNAME`, and `SPRING_DATASOURCE_PASSWORD`, then run the backend with the `local` profile. Run backend tests with `gradle -p backend test` and start the frontend with `npm run dev` from `frontend/`.
