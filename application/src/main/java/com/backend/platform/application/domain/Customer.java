package com.backend.platform.application.domain;

import java.time.LocalDate;
import java.time.Period;
import java.util.UUID;
import lombok.Getter;

@Getter
public class Customer {

  private final UUID id;
  private final String firstName;
  private final String lastName;
  private final String gender;
  private final String hashedPassword;
  private final int age;
  private final LocalDate birthdate;

  private Customer(UUID id, String firstName, String lastName, String gender, String hashedPassword, LocalDate birthdate) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.gender = gender;
    this.hashedPassword = hashedPassword;
    this.age = Period.between(birthdate, LocalDate.now()).getYears();
    this.birthdate = birthdate;
  }

  public static Customer newCustomer(String firstName, String lastName, String gender, String hashedPassword, LocalDate birthDate) {
    return new Customer(null, firstName, lastName, gender, hashedPassword, birthDate);
  }

  public static Customer createCustomer(UUID id, String firstName, String lastName, String gender, String hashedPassword, LocalDate birthDate) {
    return new Customer(id, firstName, lastName, gender, hashedPassword, birthDate);
  }
}
