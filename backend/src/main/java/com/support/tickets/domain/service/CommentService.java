package com.support.tickets.domain.service;

import com.support.tickets.domain.model.Comment;
import com.support.tickets.domain.model.Ticket;
import com.support.tickets.domain.repository.CommentRepository;
import com.support.tickets.domain.repository.TicketRepository;
import com.support.tickets.exception.TicketNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CommentService {
    private final TicketRepository ticketRepository;
    private final CommentRepository commentRepository;

    public CommentService(TicketRepository ticketRepository, CommentRepository commentRepository) {
        this.ticketRepository = ticketRepository;
        this.commentRepository = commentRepository;
    }

    @Transactional
    public Comment addComment(Long ticketId, String content) {
        Ticket ticket = ticketRepository.findById(ticketId).orElseThrow(() -> new TicketNotFoundException(ticketId));
        Comment comment = new Comment(ticket, content);
        ticket.addComment(comment);
        return commentRepository.save(comment);
    }
}
