package com.support.tickets.domain.repository;

import com.support.tickets.domain.model.Ticket;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
    List<Ticket> findAllByOrderByIdDesc();
}
