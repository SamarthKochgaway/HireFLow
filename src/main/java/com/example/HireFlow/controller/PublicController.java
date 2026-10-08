package com.example.HireFlow.controller;

import com.example.HireFlow.dto.ApplicationResponse;
import com.example.HireFlow.dto.CreateApplicationRequest;
import com.example.HireFlow.entity.JobApplication;
import com.example.HireFlow.service.JobApplicationService;
import jakarta.validation.Valid;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/applications")

public class PublicController {
    @Autowired
    private JobApplicationService jobApplicationService;

@GetMapping
    public ResponseEntity<?> getAllApplications(){
    List<ApplicationResponse> all = jobApplicationService.getAll();

    if (all != null && !all.isEmpty()) {
        return new ResponseEntity<>(all, HttpStatus.OK);
    }
    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
}
@PostMapping
    public ApplicationResponse createNewApplication(@Valid @RequestBody CreateApplicationRequest request){
    return jobApplicationService.create(request);
}

@GetMapping("id/{myId}")

    public ResponseEntity<?> getById(@PathVariable ObjectId myId){

    Optional<ApplicationResponse> byId = jobApplicationService.getById(myId);

    if(byId.isPresent()){
        return new ResponseEntity<>(byId.get(),HttpStatus.OK);
    }
    else {
        return new ResponseEntity<>(byId.get(),HttpStatus.NOT_FOUND);
    }
}
@DeleteMapping("id/{myId}")
public ResponseEntity<?> deletebyId(@PathVariable ObjectId myId){
    if(jobApplicationService.deleteById(myId)){
        return ResponseEntity.noContent().build();
    }
    else {
        return ResponseEntity.notFound().build();
    }
}

}
