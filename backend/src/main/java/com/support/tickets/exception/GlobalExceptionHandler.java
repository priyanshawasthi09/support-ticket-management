package com.support.tickets.exception;

import java.util.List;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(TicketNotFoundException.class)
    ProblemDetail handleNotFound(TicketNotFoundException exception) {
        return problem(HttpStatus.NOT_FOUND, "Not Found", exception.getMessage(), ApiErrorCode.TICKET_NOT_FOUND);
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    ProblemDetail handleValidation(MethodArgumentNotValidException exception) {
        ProblemDetail problem = problem(HttpStatus.UNPROCESSABLE_ENTITY, "Validation Failed",
                "One or more fields are invalid", ApiErrorCode.VALIDATION_ERROR);
        List<Map<String, String>> errors = exception.getBindingResult().getFieldErrors().stream()
                .map(error -> Map.of("field", error.getField(), "message", message(error))).toList();
        problem.setProperty("errors", errors);
        return problem;
    }
    @ExceptionHandler(HttpMessageNotReadableException.class)
    ProblemDetail handleUnreadable(HttpMessageNotReadableException exception) {
        return problem(HttpStatus.UNPROCESSABLE_ENTITY, "Validation Failed", "Request body is invalid", ApiErrorCode.VALIDATION_ERROR);
    }
    private ProblemDetail problem(HttpStatus status, String title, String detail, ApiErrorCode code) {
        ProblemDetail problem = ProblemDetail.forStatusAndDetail(status, detail);
        problem.setTitle(title);
        problem.setProperty("code", code.name());
        return problem;
    }
    private String message(FieldError error) { return error.getDefaultMessage() == null ? "invalid value" : error.getDefaultMessage(); }
}
