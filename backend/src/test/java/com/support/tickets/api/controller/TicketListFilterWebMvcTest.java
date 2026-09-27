package com.support.tickets.api.controller;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.support.tickets.api.mapper.TicketMapper;
import com.support.tickets.domain.model.Ticket;
import com.support.tickets.domain.model.TicketStatus;
import com.support.tickets.domain.service.TicketService;
import com.support.tickets.domain.service.TicketStatusService;
import com.support.tickets.exception.GlobalExceptionHandler;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(TicketController.class)
@Import(GlobalExceptionHandler.class)
class TicketListFilterWebMvcTest {
    @Autowired MockMvc mockMvc;
    @MockBean TicketService ticketService;
    @MockBean TicketStatusService ticketStatusService;
    @MockBean TicketMapper ticketMapper;

    @Test
    void passesStatusAndKeywordToService() throws Exception {
        when(ticketService.listSummaries(TicketStatus.OPEN, "printer")).thenReturn(List.of());

        mockMvc.perform(get("/api/v1/tickets").param("status", "OPEN").param("q", "printer"))
                .andExpect(status().isOk());

        verify(ticketService).listSummaries(eq(TicketStatus.OPEN), eq("printer"));
    }

    @Test
    void acceptsKeywordWithoutStatus() throws Exception {
        when(ticketService.listSummaries(null, "printer")).thenReturn(List.of());

        mockMvc.perform(get("/api/v1/tickets").param("q", "printer"))
                .andExpect(status().isOk());

        verify(ticketService).listSummaries(null, "printer");
    }
}
