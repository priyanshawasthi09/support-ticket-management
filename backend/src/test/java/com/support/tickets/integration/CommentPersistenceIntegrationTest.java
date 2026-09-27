package com.support.tickets.integration;

import static org.assertj.core.api.Assertions.assertThat;

import com.support.tickets.domain.model.TicketPriority;
import com.support.tickets.domain.model.TicketStatus;
import com.support.tickets.domain.service.CommentService;
import com.support.tickets.domain.service.TicketService;
import com.support.tickets.domain.service.TicketStatusService;
import com.support.tickets.support.AbstractIntegrationTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

class CommentPersistenceIntegrationTest extends AbstractIntegrationTest {
    @Autowired TicketService ticketService;
    @Autowired TicketStatusService ticketStatusService;
    @Autowired CommentService commentService;

    @Test
    @Transactional
    void persistsACommentOnlyOnItsCancelledTicket() {
        var cancelledTicket = ticketService.create("Printer jam", "Lobby printer", TicketPriority.HIGH, null);
        var otherTicket = ticketService.create("Email problem", "Cannot send mail", TicketPriority.LOW, null);
        ticketStatusService.transition(cancelledTicket.getId(), TicketStatus.CANCELLED);

        commentService.addComment(cancelledTicket.getId(), "Checked power cable");

        assertThat(ticketService.getById(cancelledTicket.getId()).getComments())
                .extracting("content").containsExactly("Checked power cable");
        assertThat(ticketService.getById(otherTicket.getId()).getComments()).isEmpty();
        assertThat(ticketService.getById(cancelledTicket.getId()).getStatus()).isEqualTo(TicketStatus.CANCELLED);
    }
}
