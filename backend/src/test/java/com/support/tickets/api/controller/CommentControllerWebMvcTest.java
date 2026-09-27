package com.support.tickets.api.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.support.tickets.api.dto.CommentResponse;
import com.support.tickets.api.mapper.TicketMapper;
import com.support.tickets.domain.service.CommentService;
import com.support.tickets.exception.GlobalExceptionHandler;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(CommentController.class)
@Import(GlobalExceptionHandler.class)
class CommentControllerWebMvcTest {
    @Autowired MockMvc mockMvc;
    @MockBean CommentService commentService;
    @MockBean TicketMapper ticketMapper;

    @Test
    void rejectsBlankAndWhitespaceOnlyContent() throws Exception {
        mockMvc.perform(post("/api/v1/tickets/7/comments").contentType(MediaType.APPLICATION_JSON)
                        .content("{\"content\":\" \"}"))
                .andExpect(status().isUnprocessableEntity())
                .andExpect(jsonPath("$.code").value("VALIDATION_ERROR"));
    }

    @Test
    void createsAComment() throws Exception {
        var comment = org.mockito.Mockito.mock(com.support.tickets.domain.model.Comment.class);
        when(commentService.addComment(eq(7L), eq("Checked power cable"))).thenReturn(comment);
        when(ticketMapper.toCommentResponse(comment)).thenReturn(new CommentResponse(11L, "Checked power cable"));

        mockMvc.perform(post("/api/v1/tickets/7/comments").contentType(MediaType.APPLICATION_JSON)
                        .content("{\"content\":\"Checked power cable\"}"))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(11))
                .andExpect(jsonPath("$.content").value("Checked power cable"));
    }
}
