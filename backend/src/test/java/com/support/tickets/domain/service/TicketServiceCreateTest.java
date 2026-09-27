package com.support.tickets.domain.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import com.support.tickets.domain.model.Ticket;
import com.support.tickets.domain.model.TicketPriority;
import com.support.tickets.domain.model.TicketStatus;
import com.support.tickets.domain.repository.TicketRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class TicketServiceCreateTest {
    @Mock TicketRepository ticketRepository;
    @InjectMocks TicketService ticketService;
    @Test void createsOpenTicketWithOptionalAssignee() {
        when(ticketRepository.save(any(Ticket.class))).thenAnswer(invocation -> invocation.getArgument(0));
        Ticket withAssignee = ticketService.create("Printer jam", "Lobby printer", TicketPriority.HIGH, "Asha");
        Ticket withoutAssignee = ticketService.create("Printer jam", "Second report", TicketPriority.LOW, null);
        assertThat(withAssignee.getStatus()).isEqualTo(TicketStatus.OPEN);
        assertThat(withAssignee.getAssignee()).isEqualTo("Asha");
        assertThat(withoutAssignee.getAssignee()).isNull();
    }
}
