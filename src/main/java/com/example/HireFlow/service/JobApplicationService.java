package com.example.HireFlow.service;

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

    public JobApplication create(JobApplication application){
        if(application.getApplicationDate()==null)
            application.setApplicationDate(LocalDate.now());
        // using getter and setter for application date as its not a variable here its part of the object "application". if it was inside entity then directly use karlete without getters and setters
          application.setStatus(Status.APPLIED);
          return jobApplicationRepo.save(application);
    }
    public List<JobApplication> getAll(){
        return jobApplicationRepo.findAll();
    }

    public Optional<JobApplication> getById(ObjectId id){ // "Optional" to prevent NullPointerException and throw exceptions
        return jobApplicationRepo.findById(id);
    }
    public boolean deleteById(ObjectId id){
        if(!jobApplicationRepo.existsById(id)) {return false ;}
        jobApplicationRepo.deleteById(id);
         return true;
    }

}
