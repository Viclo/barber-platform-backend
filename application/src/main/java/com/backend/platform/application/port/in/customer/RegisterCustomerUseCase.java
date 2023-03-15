package com.backend.platform.application.port.in.customer;

import com.backend.platform.application.port.in.customer.commands.RegisterCustomerCommand;
import org.springframework.validation.annotation.Validated;

public interface RegisterCustomerUseCase {

  void register(@Validated RegisterCustomerCommand registerCustomerCommand);
}
