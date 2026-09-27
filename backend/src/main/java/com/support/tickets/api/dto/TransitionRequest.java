package com.support.tickets.api.dto;
import com.support.tickets.domain.model.TicketStatus;
import jakarta.validation.constraints.NotNull;
public record TransitionRequest(@NotNull(message = "status is required") TicketStatus status) { }
