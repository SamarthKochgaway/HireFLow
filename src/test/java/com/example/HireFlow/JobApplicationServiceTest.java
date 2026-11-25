package com.example.HireFlow;

import com.example.HireFlow.entity.JobApplication;
import com.example.HireFlow.entity.Status;
import com.example.HireFlow.exception.ApplicationNotFound;
import com.example.HireFlow.exception.InvalidStatusTransition;
import com.example.HireFlow.repository.JobApplicationRepo;
import com.example.HireFlow.service.JobApplicationService;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class JobApplicationServiceTest {

    @Mock
    private JobApplicationRepo repository;

    @InjectMocks
    private JobApplicationService service;
    @Test
    void updateStatus_validTransition_savesNewStatus() {
        ObjectId id = new ObjectId();
        JobApplication app = new JobApplication();
        app.setStatus(Status.APPLIED);

        when(repository.findById(id)).thenReturn(Optional.of(app));
        when(repository.save(any(JobApplication.class)))
                .thenAnswer(inv -> inv.getArgument(0));

        service.updatedStatus(id, Status.INTERVIEW);

        assertEquals(Status.INTERVIEW, app.getStatus());
        verify(repository).save(app);
    }

    @Test
    void updateStatus_invalidTransition_throwsAndDoesNotSave() {
        ObjectId id = new ObjectId();
        JobApplication app = new JobApplication();
        app.setStatus(Status.APPLIED);

        when(repository.findById(id)).thenReturn(Optional.of(app));

        assertThrows(InvalidStatusTransition.class,
                () -> service.updatedStatus(id, Status.ACCEPTED));

        verify(repository, never()).save(any());
    }

    @Test
    void updateStatus_notFound_throws() {
        ObjectId id = new ObjectId();
        when(repository.findById(id)).thenReturn(Optional.empty());

        assertThrows(ApplicationNotFound.class,
                () -> service.updatedStatus(id, Status.INTERVIEW));
    }
}