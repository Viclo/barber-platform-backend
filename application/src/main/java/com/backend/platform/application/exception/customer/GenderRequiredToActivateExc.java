package com.backend.platform.application.exception.customer;

public class GenderRequiredToActivateExc extends BusinessException{

  public GenderRequiredToActivateExc() {
    super("Customer needs a gender to be able to be activated!");
  }
}
