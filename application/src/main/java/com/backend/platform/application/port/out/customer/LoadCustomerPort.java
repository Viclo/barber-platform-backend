package com.backend.platform.application.port.out.customer;

import com.backend.platform.application.domain.Customer;
import java.util.UUID;

public interface LoadCustomerPort {

  Customer findById(UUID id);
}
