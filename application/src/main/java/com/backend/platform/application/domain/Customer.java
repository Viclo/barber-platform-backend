package com.backend.platform.application.domain;

import com.backend.platform.application.exception.customer.GenderRequiredToActivateExc;
import com.backend.platform.application.exception.customer.NameRequiredToActivateExc;
import java.time.LocalDate;
import java.time.Period;
import java.util.UUID;
import lombok.Getter;

@Getter
public class Customer {

  private final UUID id;
  private final String firstname;
  private final String lastname;
  private final String gender;
  private final String hashedPassword;
  private final int age;
  private final LocalDate birthdate;

  private Customer(UUID id, String firstname, String lastname, String gender, String hashedPassword, LocalDate birthdate) {
    this.id = id;
    if (firstname != null) {
      this.firstname = firstname;
    }else{
      this.firstname = null;
      throw new NameRequiredToActivateExc();
    }
    if (lastname != null) {
      this.lastname = lastname;
    }else{
      this.lastname = null;
      throw new NameRequiredToActivateExc();
    }
    if (gender != null) {
      this.gender = gender;
    }else{
      this.gender = null;
      throw new GenderRequiredToActivateExc();
    }
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
