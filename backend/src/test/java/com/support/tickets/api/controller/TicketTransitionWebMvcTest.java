package com.support.tickets.api.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.support.tickets.api.dto.TicketResponse;
import com.support.tickets.api.mapper.TicketMapper;
import com.support.tickets.domain.model.TicketStatus;
import com.support.tickets.domain.service.TicketService;
import com.support.tickets.domain.service.TicketStatusService;
import com.support.tickets.exception.GlobalExceptionHandler;
import com.support.tickets.exception.InvalidStatusTransitionException;
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
class TicketTransitionWebMvcTest {
    @Autowired MockMvc mockMvc;
    @MockBean TicketService ticketService;
    @MockBean TicketStatusService ticketStatusService;
    @MockBean TicketMapper ticketMapper;

    @Test
    void rejectsAnUnknownStatusAsValidationError() throws Exception {
        mockMvc.perform(post("/api/v1/tickets/7/transitions")
                        .contentType(MediaType.APPLICATION_JSON).content("{\"status\":\"PAUSED\"}"))
                .andExpect(status().isUnprocessableEntity())
                .andExpect(jsonPath("$.code").value("VALIDATION_ERROR"));
    }

    @Test
    void returnsTransitionDetailsForARejectedMove() throws Exception {
        when(ticketStatusService.transition(eq(7L), eq(TicketStatus.OPEN)))
                .thenThrow(new InvalidStatusTransitionException(TicketStatus.CLOSED, TicketStatus.OPEN));

        mockMvc.perform(post("/api/v1/tickets/7/transitions")
                        .contentType(MediaType.APPLICATION_JSON).content("{\"status\":\"OPEN\"}"))
                .andExpect(status().isConflict())
                .andExpect(jsonPath("$.code").value("INVALID_STATUS_TRANSITION"))
                .andExpect(jsonPath("$.currentStatus").value("CLOSED"))
                .andExpect(jsonPath("$.requestedStatus").value("OPEN"));
    }
}
