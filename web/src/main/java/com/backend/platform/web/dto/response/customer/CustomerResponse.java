package com.backend.platform.web.dto.response.customer;

import io.swagger.v3.oas.annotations.media.Schema;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.UUID;

public class CustomerResponse {

  @Schema(description = "Customer's ID", example = "f9dc3b30-1fa5-4c23-8c28-cf00191d084e")
  private UUID id;

  @Schema(description = "Customer's firstname", example = "Victor")
  private String firstname;

  @Schema(description = "Customer's lastname", example = "Ugarte")
  private String lastname;

  @Schema(description = "Customer's gender", example = "Man")
  private String gender;

  @Schema(description = "Customer's birthdate", example = "1990-01-01")
  private LocalDate birthdate;

  @Schema(description = "Customer's age", example = "33")
  private int age;

  @Schema(description = "Date and time that customer was created", example = "2023-03-14T00:31:20.884820")
  private Timestamp createdAt;

  @Schema(description = "Date and time that customer was updated", example = "2023-03-15T00:31:20.884820")
  private Timestamp updatedAt;
}
