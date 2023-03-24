package com.backend.platform.application.domain;

import com.backend.platform.application.exception.customer.GenderRequiredToActivateExc;
import com.backend.platform.application.exception.customer.NameRequiredToActivateExc;
import java.time.LocalDate;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class CustomerTest {

  @Test
  public void should_CreateNewCustomer() {
    final Customer customer = Customer.newCustomer("Elvis", "Martinez", "Male", "MyPa$$word1234", LocalDate.of(1990, 12, 12));

    assertNotNull(customer);
    assertNull(customer.getId());
  }

  @Test
  public void should_ThrowGenderRequired() {
    assertThrows(
        GenderRequiredToActivateExc.class, () -> Customer.newCustomer("Elvis", "Martinez", null, "MyPa$$word1234", LocalDate.of(1990, 12, 12))
    );
  }

  @Test
  public void should_ThrowFirstnameRequired() {
    assertThrows(
        NameRequiredToActivateExc.class, () -> Customer.newCustomer(null, "Martinez", "Male", "MyPa$$word1234", LocalDate.of(1990, 12, 12))
    );
  }

  @Test
  public void should_ThrowLastnameRequired() {
    assertThrows(
        NameRequiredToActivateExc.class, () -> Customer.newCustomer("Elvis", null, "Male", "MyPa$$word1234", LocalDate.of(1990, 12, 12))
    );
  }
}
