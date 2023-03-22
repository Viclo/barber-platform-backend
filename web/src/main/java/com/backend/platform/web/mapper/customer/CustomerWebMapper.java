package com.backend.platform.web.mapper.customer;

import com.backend.platform.application.domain.Customer;
import com.backend.platform.web.dto.response.customer.CustomerResponse;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper
public interface CustomerWebMapper {

  CustomerResponse toResponse(Customer customer);
  List<CustomerResponse> toResponse(List<Customer> customerList);
}
