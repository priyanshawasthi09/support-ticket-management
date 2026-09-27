package com.support.tickets.domain.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import com.support.tickets.api.dto.UpdateTicketRequest;
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
class TicketServicePatchTest {
    @Mock TicketRepository ticketRepository;
    @InjectMocks TicketService ticketService;

    @Test
    void updatesOnlySuppliedFieldsAndLeavesStatusUnchanged() {
        Ticket ticket = new Ticket("Printer jam", "Lobby printer", TicketPriority.HIGH, "Asha");
        ticket.transitionTo(TicketStatus.CLOSED);
        when(ticketRepository.findById(7L)).thenReturn(java.util.Optional.of(ticket));

        UpdateTicketRequest request = new UpdateTicketRequest();
        request.setTitle("Printer repaired");

        Ticket updated = ticketService.updatePartial(7L, request);

        assertThat(updated.getTitle()).isEqualTo("Printer repaired");
        assertThat(updated.getDescription()).isEqualTo("Lobby printer");
        assertThat(updated.getPriority()).isEqualTo(TicketPriority.HIGH);
        assertThat(updated.getAssignee()).isEqualTo("Asha");
        assertThat(updated.getStatus()).isEqualTo(TicketStatus.CLOSED);
    }

    @Test
    void explicitNullAssigneeClearsOnlyTheAssignee() {
        Ticket ticket = new Ticket("Printer jam", "Lobby printer", TicketPriority.HIGH, "Asha");
        when(ticketRepository.findById(7L)).thenReturn(java.util.Optional.of(ticket));

        UpdateTicketRequest request = new UpdateTicketRequest();
        request.setAssignee(null);

        Ticket updated = ticketService.updatePartial(7L, request);

        assertThat(updated.getAssignee()).isNull();
        assertThat(updated.getTitle()).isEqualTo("Printer jam");
        assertThat(updated.getDescription()).isEqualTo("Lobby printer");
        assertThat(updated.getPriority()).isEqualTo(TicketPriority.HIGH);
        assertThat(updated.getStatus()).isEqualTo(TicketStatus.OPEN);
    }
}
