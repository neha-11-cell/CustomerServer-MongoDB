package com.example.demo.service;

import com.example.demo.exception.CustomerNotFoundException;
import com.example.demo.model.Customer;
import com.example.demo.repo.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public abstract class CustomerServiceImpl implements CustomerService{

    @Autowired
    CustomerRepo customerRepo;

    @Override
    public Customer addCustomer(Customer customer) {
        return customerRepo.save(new Customer(customer.getCustomerFirstName(), customer.getCustomerMiddleName(),
                customer.getCustomerLastName(), customer.getCustomerCity(), customer.getCurrentDate(),
                customer.isActive()));

    }
    @Override
    public Optional<Customer> getCustomerFirstName(String name) {
        return customerRepo.findByName(name);
    }

    @Override
    public Optional<Customer> getCustomerMiddleName(String name) {
        return customerRepo.findByAuthor(name);
    }

    @Override
    public Optional<Customer> getCustomerLastName(String name) {
        return customerRepo.findByAuthor(name);
    }

    @Override
    public Optional<Customer> getCustomerCity(String name) {
        return customerRepo.findByAuthor(name);
    }

    @Override
    public Optional<Customer> getCurrentDate(String name) {
        return customerRepo.findByAuthor(name);
    }

    @Override
    public List<Customer> getAllCustomer() {
        return customerRepo.findAll();
    }

    @Override
   public  Optional<Customer> findByCustomerId(Integer id){
        Optional<Customer> customer= customerRepo.findById(id);
        if(!customer.isPresent())
            throw new CustomerNotFoundException("Please check customer id");
        return customer;
    }

}
