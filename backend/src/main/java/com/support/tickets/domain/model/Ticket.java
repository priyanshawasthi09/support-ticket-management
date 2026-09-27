package com.support.tickets.domain.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OrderBy;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tickets")
public class Ticket {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(columnDefinition = "TEXT", nullable = false) private String title;
    @Column(columnDefinition = "TEXT", nullable = false) private String description;
    @Enumerated(EnumType.STRING) @Column(length = 20, nullable = false) private TicketPriority priority;
    @Column(columnDefinition = "TEXT") private String assignee;
    @Enumerated(EnumType.STRING) @Column(length = 20, nullable = false) private TicketStatus status;
    @Column(nullable = false) private LocalDateTime createdAt;
    @Column(nullable = false) private LocalDateTime updatedAt;
    @OneToMany(mappedBy = "ticket", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @OrderBy("id ASC")
    private List<Comment> comments = new ArrayList<>();

    protected Ticket() { }

    public Ticket(String title, String description, TicketPriority priority, String assignee) {
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.assignee = assignee;
        this.status = TicketStatus.OPEN;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = this.createdAt;
    }
    public Long getId() { return id; }
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public TicketPriority getPriority() { return priority; }
    public String getAssignee() { return assignee; }
    public TicketStatus getStatus() { return status; }
    public List<Comment> getComments() { return comments; }

    public void transitionTo(TicketStatus requestedStatus) {
        status = requestedStatus;
        updatedAt = LocalDateTime.now();
    }

    public void updateTitle(String title) { this.title = title; updatedAt = LocalDateTime.now(); }
    public void updateDescription(String description) { this.description = description; updatedAt = LocalDateTime.now(); }
    public void updatePriority(TicketPriority priority) { this.priority = priority; updatedAt = LocalDateTime.now(); }
    public void updateAssignee(String assignee) { this.assignee = assignee; updatedAt = LocalDateTime.now(); }
    public void addComment(Comment comment) { comments.add(comment); }
}
