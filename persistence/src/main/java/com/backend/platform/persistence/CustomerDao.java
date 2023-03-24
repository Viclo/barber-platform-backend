package com.backend.platform.persistence;

import com.backend.platform.application.domain.Customer;
import com.backend.platform.application.port.in.customer.QueryAllCustomersCRUD;
import com.backend.platform.application.port.out.customer.LoadCustomerPort;
import com.backend.platform.application.port.out.customer.SaveCustomerPort;
import com.backend.platform.common.Adapter;
import com.backend.platform.persistence.errors.CustomerDoesNotExistExc;
import com.backend.platform.persistence.mapper.CustomerMapper;
import com.backend.platform.persistence.model.CustomerEntity;
import com.backend.platform.persistence.repository.CustomerRepository;
import java.util.List;
import java.util.UUID;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
public class CustomerDao implements SaveCustomerPort, LoadCustomerPort, QueryAllCustomersCRUD {

  private final CustomerRepository customerRepository;
  private final CustomerMapper customerMapper;

  public CustomerDao (CustomerRepository customerRepository, CustomerMapper customerMapper) {
    this.customerRepository = customerRepository;
    this.customerMapper = customerMapper;
  }

  @Override
  public Customer findById(UUID id) {
    final CustomerEntity customerEntity = customerRepository.findById(id).orElseThrow(() -> new CustomerDoesNotExistExc(id));

    return customerMapper.toDomain(customerEntity);
  }

  @Override
  public List<Customer> getAll() {
    return customerMapper.toDomain(customerRepository.findAll());
  }

  @Override
  public void save(Customer customer) {
    customerRepository.save(customerMapper.toDbEntity(customer));
  }
}
