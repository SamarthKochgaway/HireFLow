package com.example.HireFlow.service;

import com.example.HireFlow.dto.ApplicationResponse;
import com.example.HireFlow.dto.CreateApplicationRequest;
import com.example.HireFlow.repository.JobApplicationRepo;
import com.example.HireFlow.entity.JobApplication;
import com.example.HireFlow.entity.Status;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class JobApplicationService {

    @Autowired
    private JobApplicationRepo jobApplicationRepo;

    public ApplicationResponse create(CreateApplicationRequest request){
        JobApplication application = new JobApplication();
        application.setJobTitle(request.getJobTitle());
        application.setCompanyName(request.getCompanyName());
        application.setJobPostUrl(request.getJobPostUrl());
        application.setUserName(request.getUserName());
        application.setApplicationDate(
                request.getApplicationDate() != null ? request.getApplicationDate() : LocalDate.now());
        application.setStatus(Status.APPLIED);
        return toResponse(jobApplicationRepo.save(application));

    }
    public List<ApplicationResponse> getAll() {
        return jobApplicationRepo.findAll().stream()
                .map(this::toResponse)
                .toList();
    }

    public Optional<ApplicationResponse> getById(ObjectId id) {
        return jobApplicationRepo.findById(id).map(this::toResponse);
    }

    private ApplicationResponse toResponse(JobApplication application) {
        ApplicationResponse response = new ApplicationResponse();
        response.setId(application.getId());
        response.setCompanyName(application.getCompanyName());
        response.setJobTitle(application.getJobTitle());
        response.setJobPostUrl(application.getJobPostUrl());
        response.setApplicationDate(application.getApplicationDate());
        response.setStatus(application.getStatus());
        return response;
    }
    public boolean deleteById(ObjectId id){
        if(!jobApplicationRepo.existsById(id)) {return false ;}
        jobApplicationRepo.deleteById(id);
         return true;
    }



}
