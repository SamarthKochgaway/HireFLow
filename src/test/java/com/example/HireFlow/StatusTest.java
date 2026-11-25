package com.example.HireFlow;

import com.example.HireFlow.entity.Status;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class StatusTest {

    @ParameterizedTest
    @CsvSource({
            "APPLIED, INTERVIEW",
            "APPLIED, REJECTED",
            "INTERVIEW, OFFER",
            "OFFER, ACCEPTED"
    })
    void allowedTransitions(Status from, Status to) {
        assertTrue(from.canMoveto(to));
    }

    @ParameterizedTest
    @CsvSource({
            "APPLIED, ACCEPTED",
            "REJECTED, INTERVIEW",
            "ACCEPTED, APPLIED"
    })
    void forbiddenTransitions(Status from, Status to) {
        assertFalse(from.canMoveto(to));
    }
}