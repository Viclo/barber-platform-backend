package com.backend.platform.application.port.in.customer;

import com.backend.platform.application.port.in.customer.commands.RegisterCustomerCommand;
import jakarta.validation.Valid;

public interface RegisterCustomerUseCase {

  void register(@Valid RegisterCustomerCommand registerCustomerCommand);
}
