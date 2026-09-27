package com.support.tickets.exception;

import com.support.tickets.domain.model.TicketStatus;

public class InvalidStatusTransitionException extends RuntimeException {
    private final TicketStatus currentStatus;
    private final TicketStatus requestedStatus;

    public InvalidStatusTransitionException(TicketStatus currentStatus, TicketStatus requestedStatus) {
        super("Cannot transition ticket from %s to %s".formatted(currentStatus, requestedStatus));
        this.currentStatus = currentStatus;
        this.requestedStatus = requestedStatus;
    }

    public TicketStatus getCurrentStatus() {
        return currentStatus;
    }

    public TicketStatus getRequestedStatus() {
        return requestedStatus;
    }
}
