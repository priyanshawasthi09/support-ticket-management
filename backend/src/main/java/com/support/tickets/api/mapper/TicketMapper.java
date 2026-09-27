package com.support.tickets.api.mapper;

import com.support.tickets.api.dto.TicketResponse;
import com.support.tickets.api.dto.TicketSummaryResponse;
import com.support.tickets.api.dto.CommentResponse;
import com.support.tickets.domain.model.Comment;
import com.support.tickets.domain.model.Ticket;
import org.springframework.stereotype.Component;

@Component
public class TicketMapper {
    public TicketSummaryResponse toSummary(Ticket ticket) {
        return new TicketSummaryResponse(ticket.getId(), ticket.getTitle(), ticket.getStatus());
    }
    public TicketResponse toResponse(Ticket ticket) {
        return new TicketResponse(ticket.getId(), ticket.getTitle(), ticket.getDescription(), ticket.getPriority(),
                ticket.getAssignee(), ticket.getStatus(), ticket.getComments().stream().map(this::toCommentResponse).toList());
    }
    public CommentResponse toCommentResponse(Comment comment) { return new CommentResponse(comment.getId(), comment.getContent()); }
}
