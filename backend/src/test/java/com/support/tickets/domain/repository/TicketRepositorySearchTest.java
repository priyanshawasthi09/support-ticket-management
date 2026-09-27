package com.support.tickets.domain.repository;

import static org.assertj.core.api.Assertions.assertThat;

import com.support.tickets.domain.model.Ticket;
import com.support.tickets.domain.model.TicketPriority;
import com.support.tickets.domain.model.TicketStatus;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
class TicketRepositorySearchTest {
    @Autowired TicketRepository ticketRepository;

    @Test
    void searchesTitleAndDescriptionCaseInsensitively() {
        ticketRepository.save(new Ticket("Printer Jam", "Lobby equipment", TicketPriority.HIGH, null));
        ticketRepository.save(new Ticket("Account access", "PRINTER supplies are blocked", TicketPriority.LOW, null));
        ticketRepository.save(new Ticket("Printer", "Unrelated", TicketPriority.MEDIUM, null));

        assertThat(ticketRepository.search(null, "pRiNtEr")).extracting(Ticket::getTitle)
                .containsExactly("Printer", "Account access", "Printer Jam");
    }

    @Test
    void combinesStatusAndKeywordWithAndSemantics() {
        var open = new Ticket("Printer open", "Needs repair", TicketPriority.HIGH, null);
        var resolved = new Ticket("Printer resolved", "Needs repair", TicketPriority.HIGH, null);
        resolved.transitionTo(TicketStatus.RESOLVED);
        ticketRepository.save(open);
        ticketRepository.save(resolved);

        assertThat(ticketRepository.search(TicketStatus.OPEN, "repair"))
                .extracting(Ticket::getTitle).containsExactly("Printer open");
    }

    @Test
    void doesNotSearchAssigneeOrComments() {
        ticketRepository.save(new Ticket("Account access", "Login issue", TicketPriority.LOW, "printer-team"));

        assertThat(ticketRepository.search(null, "printer")).isEmpty();
    }
}
