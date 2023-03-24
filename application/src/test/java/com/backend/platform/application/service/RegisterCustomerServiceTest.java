package com.backend.platform.application.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.willDoNothing;

import com.backend.platform.application.port.in.customer.commands.RegisterCustomerCommand;
import com.backend.platform.application.port.out.customer.LoadCustomerPort;
import com.backend.platform.application.port.out.customer.SaveCustomerPort;
import com.backend.platform.application.service.customer.RegisterCustomerService;
import java.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
class RegisterCustomerServiceTest {

  @Autowired private RegisterCustomerService sut;
  @MockBean private SaveCustomerPort saveCustomerPort;
  @MockBean private LoadCustomerPort loadCustomerPort;
  @BeforeEach void setUp() { willDoNothing().given(saveCustomerPort).save(any()); }

  @Test
  public void should_SaveUser() {
    LocalDate birthdate = LocalDate.of(1990, 12, 12);
    RegisterCustomerCommand registerCustomerCommand = new RegisterCustomerCommand("Elvis", "Martinez", "Male", "MyPa$$word1234", birthdate);
    sut.register(registerCustomerCommand);
  }
}
