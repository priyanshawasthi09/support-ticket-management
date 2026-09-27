package com.support.tickets.api.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.support.tickets.api.dto.TicketResponse;
import com.support.tickets.api.dto.UpdateTicketRequest;
import com.support.tickets.api.mapper.TicketMapper;
import com.support.tickets.domain.model.TicketPriority;
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
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(TicketController.class)
@Import(GlobalExceptionHandler.class)
class TicketPatchWebMvcTest {
    @Autowired MockMvc mockMvc;
    @MockBean TicketService ticketService;
    @MockBean TicketStatusService ticketStatusService;
    @MockBean TicketMapper ticketMapper;

    @Test
    void rejectsBlankSuppliedText() throws Exception {
        mockMvc.perform(patch("/api/v1/tickets/7").contentType(MediaType.APPLICATION_JSON)
                        .content("{\"title\":\" \",\"description\":\"\"}"))
                .andExpect(status().isUnprocessableEntity())
                .andExpect(jsonPath("$.code").value("VALIDATION_ERROR"));
    }

    @Test
    void rejectsInvalidPriority() throws Exception {
        mockMvc.perform(patch("/api/v1/tickets/7").contentType(MediaType.APPLICATION_JSON)
                        .content("{\"priority\":\"URGENT\"}"))
                .andExpect(status().isUnprocessableEntity())
                .andExpect(jsonPath("$.code").value("VALIDATION_ERROR"));
    }

    @Test
    void updatesAValidPartialRequest() throws Exception {
        var updatedTicket = org.mockito.Mockito.mock(com.support.tickets.domain.model.Ticket.class);
        when(ticketService.updatePartial(eq(7L), any(UpdateTicketRequest.class))).thenReturn(updatedTicket);
        when(ticketMapper.toResponse(updatedTicket)).thenReturn(new TicketResponse(7L, "New title", "Lobby printer",
                TicketPriority.HIGH, "Asha", TicketStatus.CLOSED, List.of()));

        mockMvc.perform(patch("/api/v1/tickets/7").contentType(MediaType.APPLICATION_JSON)
                        .content("{\"title\":\"New title\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("New title"))
                .andExpect(jsonPath("$.status").value("CLOSED"));
    }
}
