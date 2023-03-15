package com.backend.platform.application.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.Getter;

@Getter
public class Customer {

  private final UUID id;
  private final String firstName;
  private final String lastName;
  private final String gender;
  private final String hashedPassword;
  private final LocalDate birthDate;
  private final LocalDateTime createdAt;
  private final LocalDateTime updatedAt;

  private Customer(UUID id, String firstName, String lastName, String gender, String hashedPassword, LocalDate birthDate) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.gender = gender;
    this.hashedPassword = hashedPassword;
    this.birthDate = birthDate;
    createdAt = LocalDateTime.now();
    updatedAt = LocalDateTime.now();
  }

  public static Customer newCustomer(String firstName, String lastName, String gender, String hashedPassword, LocalDate birthDate) {
    return new Customer(null, firstName, lastName, gender, hashedPassword, birthDate);
  }

  public static Customer createCustomer(UUID id, String firstName, String lastName, String gender, String hashedPassword, LocalDate birthDate) {
    return new Customer(id, firstName, lastName, gender, hashedPassword, birthDate);
  }
}
