package com.example.demo.service;

import com.example.demo.model.Customer;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface CustomerService {

    Customer addCustomer(Customer customer);

    Optional<Customer> getCustomerCity(String name);

    Optional<Customer> getCustomerFirstName(String name);

    Optional<Customer> getCustomerMiddleName(String name);

    Optional<Customer> getCustomerLastName(String name);

    Optional<Customer> getCurrentDate(String name);

    List<Customer> getAllCustomer();

    Optional<Customer> findByCustomerId(Integer id);
}
