package com.support.tickets.integration;

import static org.assertj.core.api.Assertions.assertThat;

import com.support.tickets.SupportTicketApplication;
import com.support.tickets.domain.model.TicketPriority;
import com.support.tickets.domain.model.TicketStatus;
import com.support.tickets.domain.service.CommentService;
import com.support.tickets.domain.service.TicketService;
import com.support.tickets.domain.service.TicketStatusService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@Testcontainers
class PostgreSqlRestartPersistenceIT {
    @Container
    static final PostgreSQLContainer<?> POSTGRES = new PostgreSQLContainer<>("postgres:15-alpine");

    @Test
    void preservesTicketAndCommentsAcrossFreshApplicationContext() {
        Long ticketId;
        Long commentId;

        try (ConfigurableApplicationContext firstContext = startApplicationContext()) {
            TicketService ticketService = firstContext.getBean(TicketService.class);
            CommentService commentService = firstContext.getBean(CommentService.class);
            TicketStatusService statusService = firstContext.getBean(TicketStatusService.class);

            var created = ticketService.create(
                    "Printer jam",
                    "Lobby printer is blocked",
                    TicketPriority.HIGH,
                    "support-team");
            statusService.transition(created.getId(), TicketStatus.IN_PROGRESS);
            var resolved = statusService.transition(created.getId(), TicketStatus.RESOLVED);
            var comment = commentService.addComment(created.getId(), "Cleared the paper path.");

            ticketId = resolved.getId();
            commentId = comment.getId();
        }

        try (ConfigurableApplicationContext freshContext = startApplicationContext()) {
            TicketService ticketService = freshContext.getBean(TicketService.class);

            var persisted = ticketService.getById(ticketId);

            assertThat(persisted.getId()).isEqualTo(ticketId);
            assertThat(persisted.getTitle()).isEqualTo("Printer jam");
            assertThat(persisted.getDescription()).isEqualTo("Lobby printer is blocked");
            assertThat(persisted.getPriority()).isEqualTo(TicketPriority.HIGH);
            assertThat(persisted.getAssignee()).isEqualTo("support-team");
            assertThat(persisted.getStatus()).isEqualTo(TicketStatus.RESOLVED);
            assertThat(persisted.getComments())
                    .extracting(comment -> comment.getId())
                    .containsExactly(commentId);
            assertThat(persisted.getComments().get(0).getContent())
                    .isEqualTo("Cleared the paper path.");
        }
    }

    private ConfigurableApplicationContext startApplicationContext() {
        return new SpringApplicationBuilder(SupportTicketApplication.class)
                .properties(
                        "spring.datasource.url=" + POSTGRES.getJdbcUrl(),
                        "spring.datasource.username=" + POSTGRES.getUsername(),
                        "spring.datasource.password=" + POSTGRES.getPassword(),
                        "spring.datasource.driver-class-name=org.postgresql.Driver",
                        "spring.jpa.hibernate.ddl-auto=validate",
                        "spring.flyway.enabled=true",
                        "spring.main.web-application-type=none")
                .run();
    }
}
