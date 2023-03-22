package com.backend.platform.web.dto.request.customer;

import io.swagger.v3.oas.annotations.media.Schema;
import java.time.LocalDate;
import lombok.Getter;

@Getter
public class RegisterCustomerRequest {

  @Schema(description = "Customer's firstname", example = "Alfredo")
  String firstname;

  @Schema(description = "Customer's lastname", example = "Dominguez")
  String lastname;

  @Schema(description = "Customer's gender", example = "Woman")
  String gender;

  @Schema(description = "Customer's password", example = "Un1qu3Pa33worD!")
  String password;

  @Schema(description = "Customer's birthdate", example = "2000-01-01")
  LocalDate birthdate;
}
