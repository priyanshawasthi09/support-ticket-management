package com.support.tickets.api.controller;

import com.support.tickets.api.dto.CommentResponse;
import com.support.tickets.api.dto.CreateCommentRequest;
import com.support.tickets.api.mapper.TicketMapper;
import com.support.tickets.domain.service.CommentService;
import jakarta.validation.Valid;
import java.net.URI;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/tickets/{ticketId}/comments")
public class CommentController {
    private final CommentService commentService;
    private final TicketMapper ticketMapper;

    public CommentController(CommentService commentService, TicketMapper ticketMapper) {
        this.commentService = commentService;
        this.ticketMapper = ticketMapper;
    }

    @PostMapping
    public ResponseEntity<CommentResponse> create(@PathVariable Long ticketId,
                                                  @Valid @RequestBody CreateCommentRequest request) {
        CommentResponse response = ticketMapper.toCommentResponse(commentService.addComment(ticketId, request.content()));
        return ResponseEntity.created(URI.create("/api/v1/tickets/" + ticketId + "/comments/" + response.id())).body(response);
    }
}
