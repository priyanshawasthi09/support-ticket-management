package com.support.tickets.domain.service;

import com.support.tickets.domain.model.Ticket;
import com.support.tickets.domain.model.TicketPriority;
import com.support.tickets.domain.repository.TicketRepository;
import com.support.tickets.exception.TicketNotFoundException;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TicketService {
    private final TicketRepository ticketRepository;
    public TicketService(TicketRepository ticketRepository) { this.ticketRepository = ticketRepository; }
    @Transactional
    public Ticket create(String title, String description, TicketPriority priority, String assignee) {
        return ticketRepository.save(new Ticket(title, description, priority, assignee));
    }
    @Transactional(readOnly = true)
    public Ticket getById(Long ticketId) {
        return ticketRepository.findById(ticketId).orElseThrow(() -> new TicketNotFoundException(ticketId));
    }
    @Transactional(readOnly = true)
    public List<Ticket> listSummaries() { return ticketRepository.findAllByOrderByIdDesc(); }
}
