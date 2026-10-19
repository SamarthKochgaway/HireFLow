package com.example.HireFlow.exception;

import com.example.HireFlow.dto.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ApplicationNotFound.class)
    public ResponseEntity<ErrorResponse> handleNotFound(ApplicationNotFound ex) {
        ErrorResponse body = new ErrorResponse(
                HttpStatus.NOT_FOUND.value(), ex.getMessage(), LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(body);
    }
    @ExceptionHandler(InvalidStatusTransition.class)
    public ResponseEntity<ErrorResponse>handleInvalidTransition(InvalidStatusTransition ex){
        ErrorResponse body = new ErrorResponse(
              HttpStatus.BAD_REQUEST.value(), ex.getMessage(), LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);

    }
}

