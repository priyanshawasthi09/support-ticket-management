package com.support.tickets.api.mapper;

import com.support.tickets.api.dto.TicketResponse;
import com.support.tickets.api.dto.TicketSummaryResponse;
import com.support.tickets.domain.model.Ticket;
import org.springframework.stereotype.Component;

@Component
public class TicketMapper {
    public TicketSummaryResponse toSummary(Ticket ticket) {
        return new TicketSummaryResponse(ticket.getId(), ticket.getTitle(), ticket.getStatus());
    }
    public TicketResponse toResponse(Ticket ticket) {
        return new TicketResponse(ticket.getId(), ticket.getTitle(), ticket.getDescription(), ticket.getPriority(),
                ticket.getAssignee(), ticket.getStatus(), java.util.List.of());
    }
}
