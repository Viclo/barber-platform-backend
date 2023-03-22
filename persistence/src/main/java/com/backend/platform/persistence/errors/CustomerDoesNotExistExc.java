package com.backend.platform.persistence.errors;

import com.backend.platform.application.exception.customer.BusinessException;
import java.util.UUID;

public class CustomerDoesNotExistExc extends BusinessException {

  public CustomerDoesNotExistExc(UUID id) {
    super("Customer with id " + id.toString() + "does not exist!");
  }
}
