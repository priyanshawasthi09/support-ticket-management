package com.support.tickets.integration;

import static org.assertj.core.api.Assertions.assertThat;

import com.support.tickets.domain.model.TicketPriority;
import com.support.tickets.domain.repository.TicketRepository;
import com.support.tickets.domain.service.TicketService;
import com.support.tickets.exception.TicketNotFoundException;
import com.support.tickets.support.AbstractIntegrationTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

class TicketCreateListIntegrationTest extends AbstractIntegrationTest {
    @Autowired TicketService ticketService;
    @Autowired TicketRepository ticketRepository;
    @Test @Transactional void persistsDuplicateTitlesWithDistinctIdsAndReadsById() {
        var first = ticketService.create("Printer jam", "Lobby printer", TicketPriority.HIGH, null);
        var second = ticketService.create("Printer jam", "Office printer", TicketPriority.LOW, null);
        assertThat(first.getId()).isNotEqualTo(second.getId());
        assertThat(ticketService.listSummaries()).extracting("id").contains(first.getId(), second.getId());
        assertThat(ticketService.getById(first.getId()).getTitle()).isEqualTo("Printer jam");
    }
    @Test void reportsMissingTicket() {
        org.assertj.core.api.Assertions.assertThatThrownBy(() -> ticketService.getById(999L))
                .isInstanceOf(TicketNotFoundException.class);
    }
}
