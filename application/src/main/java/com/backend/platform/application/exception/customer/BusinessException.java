package com.backend.platform.application.exception.customer;

public abstract class BusinessException extends IllegalStateException {

  public BusinessException(String error) {
    super(error);
  }
}
