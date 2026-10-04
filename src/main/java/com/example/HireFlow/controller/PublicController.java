package com.example.HireFlow.controller;

import com.example.HireFlow.entity.JobApplication;
import com.example.HireFlow.service.JobApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/applications")

public class PublicController {
    @Autowired
    private JobApplicationService jobApplicationService;

@GetMapping
    public ResponseEntity<?> getAllApplications(){
    List<JobApplication> all = jobApplicationService.getAll();
    if (all != null && !all.isEmpty()) {
        return new ResponseEntity<>(all, HttpStatus.OK);
    }
    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
}
@PostMapping
    public JobApplication createNewApplication(@RequestBody JobApplication application){
    return jobApplicationService.create(application);
}


}
