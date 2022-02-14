package com.example.demo.service;

import com.example.demo.model.Customer;
import com.example.demo.repo.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    CustomerRepo customerRepo;

    @Override
    public Customer addCustomer(Customer customer) {
        return customerRepo.save(new Customer(customer.getCustomerName(), customer.getCustomerCity()));

    }
    @Override
    public Optional<Customer> getCustomerName(String name) {
        return customerRepo.findByName(name);
    }

    @Override
    public Optional<Customer> getCustomerCity(String name) {
        return customerRepo.findByAuthor(name);
    }


    @Override
    public List<Customer> getAllCustomer() {
        return customerRepo.findAll();
    }


}
