package com.support.tickets.api.dto;
import com.support.tickets.domain.model.TicketPriority;
public record UpdateTicketRequest(String title, String description, TicketPriority priority, String assignee) { }
