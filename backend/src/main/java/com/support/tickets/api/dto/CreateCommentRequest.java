package com.support.tickets.api.dto;
import jakarta.validation.constraints.NotBlank;
public record CreateCommentRequest(@NotBlank(message = "content must not be blank") String content) { }
