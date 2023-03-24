package com.backend.platform.web.controller.customer;

import com.backend.platform.application.port.in.customer.QueryAllCustomersCRUD;
import com.backend.platform.common.Adapter;
import com.backend.platform.web.dto.response.customer.CustomerResponse;
import com.backend.platform.web.mapper.customer.CustomerWebMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Adapter
@RestController
@RequiredArgsConstructor
public class CustomerCRUDController {

  private final QueryAllCustomersCRUD queryAllCustomersCRUD;
  private final CustomerWebMapper customerWebMapper;

  @Operation(summary = "Get all customers", description = "Return all customers", tags = {"Customer"})
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Successful operation",
          content = @Content(array = @ArraySchema(schema = @Schema(implementation = CustomerResponse.class))))
  })
  @GetMapping("/v3/customer/all")
  public List<CustomerResponse> getAllCustomers() {
    return customerWebMapper.toResponse(queryAllCustomersCRUD.getAll());
  }
}
