package com.backend.platform.persistence.mapper;

import com.backend.platform.application.domain.Customer;
import com.backend.platform.persistence.model.CustomerEntity;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper
public interface CustomerMapper {

  List<Customer> toDomain(List<CustomerEntity> customerEntityList);

  default Customer toDomain(CustomerEntity customerEntity) {
    return Customer.createCustomer(
        customerEntity.getId(),
        customerEntity.getFirstname(),
        customerEntity.getLastname(),
        customerEntity.getGender(),
        customerEntity.getHashedPassword(),
        customerEntity.getBirthdate()
    );
  }

  default CustomerEntity toDbEntity(Customer customer) {
    return new CustomerEntity(
        customer.getId(),
        customer.getFirstName(),
        customer.getLastName(),
        customer.getGender(),
        customer.getHashedPassword(),
        customer.getBirthdate(),
        null
    );
  }
}
