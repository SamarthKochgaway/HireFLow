package com.example.HireFlow.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NonNull;

import java.time.LocalDate;

@Data
public class CreateApplicationRequest {

    @NotBlank(message = "Company name cannot be blank")
    private String companyName;
    @NotBlank(message = "Job Title name cannot be blank")
    private String jobTitle;
    @NotBlank(message = "Username name cannot be blank")
    private String UserName;
    @NotBlank(message = "Job post URL must not be blank")
    private String jobPostUrl;
    private LocalDate applicationDate = LocalDate.now();
}
