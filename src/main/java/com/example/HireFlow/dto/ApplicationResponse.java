package com.example.HireFlow.dto;

import com.example.HireFlow.entity.Status;
import lombok.Data;
import lombok.NonNull;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class ApplicationResponse {
    private ObjectId id;
    private String companyName;
    private String jobTitle;
    private String UserName;
    private String jobPostUrl;
    private LocalDate applicationDate = LocalDate.now();
    private Status status;
    private LocalDateTime updatedAt;
}
