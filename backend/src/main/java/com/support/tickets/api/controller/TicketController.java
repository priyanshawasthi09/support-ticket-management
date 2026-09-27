package com.support.tickets.api.controller;

import com.support.tickets.api.dto.CreateTicketRequest;
import com.support.tickets.api.dto.TicketResponse;
import com.support.tickets.api.dto.TicketSummaryResponse;
import com.support.tickets.api.dto.TransitionRequest;
import com.support.tickets.api.dto.UpdateTicketRequest;
import com.support.tickets.api.mapper.TicketMapper;
import com.support.tickets.domain.service.TicketService;
import com.support.tickets.domain.service.TicketStatusService;
import jakarta.validation.Valid;
import java.net.URI;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/tickets")
public class TicketController {
    private final TicketService ticketService;
    private final TicketStatusService ticketStatusService;
    private final TicketMapper ticketMapper;
    public TicketController(TicketService ticketService, TicketStatusService ticketStatusService, TicketMapper ticketMapper) {
        this.ticketService = ticketService;
        this.ticketStatusService = ticketStatusService;
        this.ticketMapper = ticketMapper;
    }
    @PostMapping
    public ResponseEntity<TicketResponse> create(@Valid @RequestBody CreateTicketRequest request) {
        TicketResponse response = ticketMapper.toResponse(ticketService.create(
                request.title(), request.description(), request.priority(), request.assignee()));
        return ResponseEntity.created(URI.create("/api/v1/tickets/" + response.id())).body(response);
    }
    @GetMapping
    public List<TicketSummaryResponse> list() {
        return ticketService.listSummaries().stream().map(ticketMapper::toSummary).toList();
    }
    @GetMapping("/{ticketId}")
    public TicketResponse getById(@PathVariable Long ticketId) { return ticketMapper.toResponse(ticketService.getById(ticketId)); }
    @PatchMapping("/{ticketId}")
    public TicketResponse updatePartial(@PathVariable Long ticketId, @Valid @RequestBody UpdateTicketRequest request) {
        return ticketMapper.toResponse(ticketService.updatePartial(ticketId, request));
    }
    @PostMapping("/{ticketId}/transitions")
    public TicketResponse transition(@PathVariable Long ticketId, @Valid @RequestBody TransitionRequest request) {
        return ticketMapper.toResponse(ticketStatusService.transition(ticketId, request.status()));
    }
}
