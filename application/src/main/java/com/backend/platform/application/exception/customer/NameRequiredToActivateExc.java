package com.backend.platform.application.exception.customer;

public class NameRequiredToActivateExc extends BusinessException {

  public NameRequiredToActivateExc() {
    super("Customer needs to have firstname and lastname to be activated!");
  }
}
