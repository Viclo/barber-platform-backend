package com.backend.platform.application.port.in.customer;

import com.backend.platform.application.domain.Customer;
import java.util.List;

public interface QueryAllCustomersCRUD {

  List<Customer> getAll();
}
