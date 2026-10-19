package com.example.HireFlow.exception;

public class ApplicationNotFound extends RuntimeException{
    public ApplicationNotFound(String id){
        super("Application not found with id: "+id);
    }
}
