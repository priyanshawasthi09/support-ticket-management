package com.support.tickets.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "comments")
public class Comment {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "ticket_id", nullable = false)
    private Ticket ticket;
    @Column(columnDefinition = "TEXT", nullable = false) private String content;
    @Column(nullable = false) private LocalDateTime createdAt;
    protected Comment() { }
    public Comment(Ticket ticket, String content) {
        this.ticket = ticket;
        this.content = content;
        this.createdAt = LocalDateTime.now();
    }
    public Long getId() { return id; }
    public String getContent() { return content; }
}
