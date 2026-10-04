package com.example.HireFlow.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document(collection = "job_application")
@Data
@NoArgsConstructor
public class JobApplication {
    @Id
    private ObjectId id;
    @NonNull
    private String companyName;
    @NonNull
    private String jobTitle;
    @NonNull
    private String UserName;
    private LocalDate applicationDate = LocalDate.now();
    private Status status;


}

