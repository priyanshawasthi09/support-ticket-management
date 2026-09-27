package com.support.tickets.domain.repository;

import com.support.tickets.domain.model.Ticket;
import com.support.tickets.domain.model.TicketStatus;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
    List<Ticket> findAllByOrderByIdDesc();
    @Query("""
            select t from Ticket t
            where (:status is null or t.status = :status)
              and (:q is null
                   or lower(t.title) like lower(concat('%', :q, '%'))
                   or lower(t.description) like lower(concat('%', :q, '%')))
            order by t.id desc
            """)
    List<Ticket> search(@Param("status") TicketStatus status, @Param("q") String q);

    @Query("select t from Ticket t left join fetch t.comments where t.id = :ticketId")
    Optional<Ticket> findByIdWithComments(@Param("ticketId") Long ticketId);
}
