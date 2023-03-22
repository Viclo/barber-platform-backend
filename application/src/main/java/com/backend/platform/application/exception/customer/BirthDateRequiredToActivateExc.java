package com.backend.platform.application.exception.customer;

public class BirthDateRequiredToActivateExc extends BusinessException {

  public BirthDateRequiredToActivateExc() {
    super("Customer needs to have a birthDate to be able to be activated!");
  }
}
