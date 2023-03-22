package com.backend.platform.persistence.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

@Entity
@NoArgsConstructor
public class CustomerEntity {

  @Id
  private UUID id;
  private String firstname;
  private String lastname;
  private String gender;
  private String hashedPassword;
  private LocalDate birthdate;
  @CreatedDate
  private LocalDateTime createdAt;

  public CustomerEntity(UUID id, String firstname, String lastname, String gender,
      String hashedPassword, LocalDate birthdate,LocalDateTime createdAt) {
    this.id = id;
    this.firstname = firstname;
    this.lastname = lastname;
    this.gender = gender;
    this.hashedPassword = hashedPassword;
    this.birthdate = birthdate;
    this.createdAt = createdAt;
  }

  public UUID getId() {
    return id;
  }

  public String getFirstname() {
    return firstname;
  }

  public String getLastname() {
    return lastname;
  }

  public String getGender() {
    return gender;
  }

  public String getHashedPassword() {
    return hashedPassword;
  }

  public LocalDate getBirthdate() {
    return birthdate;
  }

  public LocalDateTime getCreatedAt() {
    return createdAt;
  }
}
