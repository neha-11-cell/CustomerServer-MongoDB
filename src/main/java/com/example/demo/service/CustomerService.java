package com.example.demo.service;

import com.example.demo.model.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface CustomerService {

    Customer addCustomer(Customer customer);

    Optional<Customer> getCustomerName(String name);

    Optional<Customer> getCustomerCity(String name);

    List<Customer> getAllCustomer();
}
