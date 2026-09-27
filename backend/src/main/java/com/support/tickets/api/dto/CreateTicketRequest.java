package com.support.tickets.api.dto;

import com.support.tickets.domain.model.TicketPriority;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateTicketRequest(
        @NotBlank(message = "title must not be blank") String title,
        @NotBlank(message = "description must not be blank") String description,
        @NotNull(message = "priority is required") TicketPriority priority,
        String assignee) { }
