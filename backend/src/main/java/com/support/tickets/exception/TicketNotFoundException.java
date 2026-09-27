package com.support.tickets.exception;
public class TicketNotFoundException extends RuntimeException {
    public TicketNotFoundException(Long ticketId) { super("Ticket %d was not found".formatted(ticketId)); }
}
