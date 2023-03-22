package com.backend.platform.web.mapper.customer;

import com.backend.platform.application.port.in.customer.commands.RegisterCustomerCommand;
import com.backend.platform.web.dto.request.customer.RegisterCustomerRequest;
import org.mapstruct.Mapper;

@Mapper
public interface RegisterCustomerWebMapper {

  default RegisterCustomerCommand toCommand(RegisterCustomerRequest registerCustomerRequest) {
    return new RegisterCustomerCommand(
        registerCustomerRequest.getFirstname(),
        registerCustomerRequest.getLastname(),
        registerCustomerRequest.getGender(),
        registerCustomerRequest.getPassword(),
        registerCustomerRequest.getBirthdate()
    );
  }
}
