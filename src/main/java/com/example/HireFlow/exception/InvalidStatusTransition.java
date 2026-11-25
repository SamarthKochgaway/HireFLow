package com.example.HireFlow.exception;

import com.example.HireFlow.entity.Status;

public class InvalidStatusTransition extends RuntimeException {
    public InvalidStatusTransition(Status from, Status to){
        super("Cannot move from "+from+" to "+to);
    }
}
