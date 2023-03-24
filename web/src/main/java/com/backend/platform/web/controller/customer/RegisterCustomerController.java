package com.backend.platform.web.controller.customer;

import com.backend.platform.application.port.in.customer.RegisterCustomerUseCase;
import com.backend.platform.common.Adapter;
import com.backend.platform.web.dto.request.customer.RegisterCustomerRequest;
import com.backend.platform.web.mapper.customer.RegisterCustomerWebMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Adapter
@RestController
@RequiredArgsConstructor
public class RegisterCustomerController {

  private final RegisterCustomerUseCase registerCustomerUseCase;
  private final RegisterCustomerWebMapper registerCustomerWebMapper;

  @Operation(summary = "Register Customer", description = "Register a new customer", tags = {"Customer"})
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Successful operation"),
      @ApiResponse(responseCode = "400", description = "Invalid parameter")
  })
  @PostMapping("/v3/register")
  public void registerCustomer(@RequestBody RegisterCustomerRequest registerCustomerRequest) {
    registerCustomerUseCase.register(registerCustomerWebMapper.toCommand(registerCustomerRequest));
  }
}
