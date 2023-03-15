package com.backend.platform.application.service.customer;

import com.backend.platform.application.domain.Customer;
import com.backend.platform.application.port.in.customer.RegisterCustomerUseCase;
import com.backend.platform.application.port.in.customer.commands.RegisterCustomerCommand;
import com.backend.platform.application.port.out.customer.SaveCustomerPort;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;

@Validated
@Transactional
@RequiredArgsConstructor
public class RegisterCustomerService implements RegisterCustomerUseCase {

  private final SaveCustomerPort saveCustomerPort;

  @Override
  public void register(@Valid RegisterCustomerCommand registerCustomerCommand) {
    String encryptedPw = this.superSecureHashingAlgorithm(registerCustomerCommand.clearPassword());
    Customer newCustomer = Customer.newCustomer(registerCustomerCommand.firstname(), registerCustomerCommand.lastname(), registerCustomerCommand.gender(), encryptedPw, registerCustomerCommand.birthDate());

    saveCustomerPort.save(newCustomer);
  }

  private String superSecureHashingAlgorithm(String clearPassword) {
    return new StringBuilder(clearPassword).reverse().toString();
  }
}
