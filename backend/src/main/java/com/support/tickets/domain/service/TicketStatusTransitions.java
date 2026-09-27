package com.support.tickets.domain.service;

import com.support.tickets.domain.model.TicketStatus;
import com.support.tickets.exception.InvalidStatusTransitionException;
import java.util.EnumMap;
import java.util.Map;
import java.util.Set;
import org.springframework.stereotype.Component;

@Component
public class TicketStatusTransitions {
    private final Map<TicketStatus, Set<TicketStatus>> allowedTransitions = new EnumMap<>(TicketStatus.class);

    public TicketStatusTransitions() {
        allowedTransitions.put(TicketStatus.OPEN, Set.of(TicketStatus.IN_PROGRESS, TicketStatus.CANCELLED));
        allowedTransitions.put(TicketStatus.IN_PROGRESS, Set.of(TicketStatus.RESOLVED, TicketStatus.CANCELLED));
        allowedTransitions.put(TicketStatus.RESOLVED, Set.of(TicketStatus.CLOSED));
        allowedTransitions.put(TicketStatus.CLOSED, Set.of());
        allowedTransitions.put(TicketStatus.CANCELLED, Set.of());
    }

    public boolean isAllowed(TicketStatus currentStatus, TicketStatus requestedStatus) {
        return allowedTransitions.get(currentStatus).contains(requestedStatus);
    }

    public void requireAllowed(TicketStatus currentStatus, TicketStatus requestedStatus) {
        if (!isAllowed(currentStatus, requestedStatus)) {
            throw new InvalidStatusTransitionException(currentStatus, requestedStatus);
        }
    }
}
