package com.backend.platform.application.port.out.customer;

import com.backend.platform.application.domain.Customer;

public interface SaveCustomerPort {

  void save(Customer customer);
}
