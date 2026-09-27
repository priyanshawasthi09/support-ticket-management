package com.support.tickets.domain.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import com.support.tickets.domain.model.TicketStatus;
import com.support.tickets.exception.InvalidStatusTransitionException;
import java.util.Map;
import java.util.Set;
import org.junit.jupiter.api.Test;

class TicketStatusTransitionsTest {
    private final TicketStatusTransitions transitions = new TicketStatusTransitions();

    @Test
    void permitsExactlyTheDefinedLifecycleTransitions() {
        Map<TicketStatus, Set<TicketStatus>> allowed = Map.of(
                TicketStatus.OPEN, Set.of(TicketStatus.IN_PROGRESS, TicketStatus.CANCELLED),
                TicketStatus.IN_PROGRESS, Set.of(TicketStatus.RESOLVED, TicketStatus.CANCELLED),
                TicketStatus.RESOLVED, Set.of(TicketStatus.CLOSED),
                TicketStatus.CLOSED, Set.of(),
                TicketStatus.CANCELLED, Set.of());

        for (TicketStatus current : TicketStatus.values()) {
            for (TicketStatus requested : TicketStatus.values()) {
                if (allowed.get(current).contains(requested)) {
                    assertThat(transitions.isAllowed(current, requested)).isTrue();
                } else {
                    assertThatThrownBy(() -> transitions.requireAllowed(current, requested))
                            .isInstanceOf(InvalidStatusTransitionException.class)
                            .satisfies(exception -> {
                                var transitionException = (InvalidStatusTransitionException) exception;
                                assertThat(transitionException.getCurrentStatus()).isEqualTo(current);
                                assertThat(transitionException.getRequestedStatus()).isEqualTo(requested);
                            });
                }
            }
        }
    }

    @Test
    void rejectsARequestForTheCurrentStatus() {
        assertThatThrownBy(() -> transitions.requireAllowed(TicketStatus.OPEN, TicketStatus.OPEN))
                .isInstanceOf(InvalidStatusTransitionException.class)
                .hasMessageContaining("OPEN");
    }
}
