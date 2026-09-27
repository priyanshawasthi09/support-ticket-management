package com.support.tickets.domain.service;

import com.support.tickets.domain.model.Ticket;
import com.support.tickets.domain.model.TicketStatus;
import com.support.tickets.domain.repository.TicketRepository;
import com.support.tickets.exception.TicketNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TicketStatusService {
    private final TicketRepository ticketRepository;
    private final TicketStatusTransitions transitions;

    public TicketStatusService(TicketRepository ticketRepository, TicketStatusTransitions transitions) {
        this.ticketRepository = ticketRepository;
        this.transitions = transitions;
    }

    @Transactional
    public Ticket transition(Long ticketId, TicketStatus requestedStatus) {
        Ticket ticket = ticketRepository.findById(ticketId).orElseThrow(() -> new TicketNotFoundException(ticketId));
        transitions.requireAllowed(ticket.getStatus(), requestedStatus);
        ticket.transitionTo(requestedStatus);
        return ticket;
    }
}
