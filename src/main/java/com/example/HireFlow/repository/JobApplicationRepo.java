package com.example.HireFlow.repository;

import com.example.HireFlow.entity.JobApplication;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

 public interface JobApplicationRepo extends MongoRepository<JobApplication,ObjectId>{}//ObjectId isliye because we have mapped @Id to objectId