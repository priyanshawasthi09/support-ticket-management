package com.support.tickets.api.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.support.tickets.api.dto.TicketResponse;
import com.support.tickets.api.dto.TicketSummaryResponse;
import com.support.tickets.api.mapper.TicketMapper;
import com.support.tickets.domain.model.TicketPriority;
import com.support.tickets.domain.model.TicketStatus;
import com.support.tickets.domain.service.TicketService;
import com.support.tickets.domain.service.TicketStatusService;
import com.support.tickets.exception.GlobalExceptionHandler;
import com.support.tickets.exception.TicketNotFoundException;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(TicketController.class)
@Import(GlobalExceptionHandler.class)
class TicketControllerCreateListWebMvcTest {
    @Autowired MockMvc mockMvc;
    @MockBean TicketService ticketService;
    @MockBean TicketStatusService ticketStatusService;
    @MockBean TicketMapper ticketMapper;
    @Test void createsTicket() throws Exception {
        when(ticketService.create(any(), any(), any(), any())).thenReturn(null);
        when(ticketMapper.toResponse(null)).thenReturn(new TicketResponse(7L, "Printer jam", "Lobby printer", TicketPriority.HIGH, null, TicketStatus.OPEN, List.of()));
        mockMvc.perform(post("/api/v1/tickets").contentType(MediaType.APPLICATION_JSON)
                        .content("{\"title\":\"Printer jam\",\"description\":\"Lobby printer\",\"priority\":\"HIGH\"}"))
                .andExpect(status().isCreated()).andExpect(jsonPath("$.id").value(7));
    }
    @Test void rejectsBlankAndInvalidPriority() throws Exception {
        mockMvc.perform(post("/api/v1/tickets").contentType(MediaType.APPLICATION_JSON)
                        .content("{\"title\":\" \",\"description\":\"\",\"priority\":\"URGENT\"}"))
                .andExpect(status().isUnprocessableEntity()).andExpect(jsonPath("$.code").value("VALIDATION_ERROR"));
    }
    @Test void listsSummaryIds() throws Exception {
        var ticket = org.mockito.Mockito.mock(com.support.tickets.domain.model.Ticket.class);
        when(ticketService.listSummaries()).thenReturn(List.of(ticket));
        when(ticketMapper.toSummary(ticket)).thenReturn(new TicketSummaryResponse(8L, "Printer jam", TicketStatus.OPEN));
        mockMvc.perform(get("/api/v1/tickets")).andExpect(status().isOk()).andExpect(jsonPath("$[0].id").value(8));
    }
    @Test void returnsStableNotFoundProblem() throws Exception {
        when(ticketService.getById(99L)).thenThrow(new TicketNotFoundException(99L));
        mockMvc.perform(get("/api/v1/tickets/99")).andExpect(status().isNotFound())
                .andExpect(jsonPath("$.code").value("TICKET_NOT_FOUND"));
    }
}
