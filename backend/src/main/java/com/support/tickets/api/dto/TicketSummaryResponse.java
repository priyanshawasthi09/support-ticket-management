package com.support.tickets.api.dto;

import com.support.tickets.domain.model.TicketStatus;
public record TicketSummaryResponse(Long id, String title, TicketStatus status) { }
