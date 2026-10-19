package com.example.HireFlow.dto;

import java.time.LocalDateTime;

public record ErrorResponse(int status, String message , LocalDateTime timestamp) {}
