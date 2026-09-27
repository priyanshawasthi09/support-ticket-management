package com.support.tickets.domain.repository;

import com.support.tickets.domain.model.Ticket;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
    List<Ticket> findAllByOrderByIdDesc();
    @Query("select t from Ticket t left join fetch t.comments where t.id = :ticketId")
    Optional<Ticket> findByIdWithComments(@Param("ticketId") Long ticketId);
}
