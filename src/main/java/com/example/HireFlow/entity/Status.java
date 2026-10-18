package com.example.HireFlow.entity;

import static com.mongodb.assertions.Assertions.assertFalse;
import static com.mongodb.assertions.Assertions.assertTrue;

public enum Status {
    APPLIED,
    INTERVIEW,
    OFFER,
    ACCEPTED,
    REJECTED,
    CLOSED;

    public boolean canMoveto(Status next){

        return switch(this){

           case APPLIED -> next==INTERVIEW||next==REJECTED||next==CLOSED;
            case INTERVIEW -> next==OFFER||next==REJECTED||next==CLOSED;
            case OFFER -> next==ACCEPTED||next==REJECTED||next==CLOSED;
            case ACCEPTED, REJECTED , CLOSED -> false;
        };


    }

}
