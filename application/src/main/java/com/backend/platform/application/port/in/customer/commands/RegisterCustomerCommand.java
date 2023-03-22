package com.backend.platform.application.port.in.customer.commands;

import com.backend.platform.application.validator.SecurePassword;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Past;
import java.time.LocalDate;

public record RegisterCustomerCommand(
    @NotEmpty String firstname,
    @NotEmpty String lastname,
    @NotEmpty String gender,
    @SecurePassword String clearPassword,
    @Past LocalDate birthDate
    ) {}