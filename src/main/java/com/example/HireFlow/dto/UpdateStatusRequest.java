package com.example.HireFlow.dto;

import com.example.HireFlow.entity.Status;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
@Data
public class UpdateStatusRequest {
   @NotNull //@NotBlank for strings only
  private Status status;
}
