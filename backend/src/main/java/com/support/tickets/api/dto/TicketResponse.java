package com.support.tickets.api.dto;

import com.support.tickets.domain.model.TicketPriority;
import com.support.tickets.domain.model.TicketStatus;
import java.util.List;
public record TicketResponse(Long id, String title, String description, TicketPriority priority,
                             String assignee, TicketStatus status, List<CommentResponse> comments) { }
