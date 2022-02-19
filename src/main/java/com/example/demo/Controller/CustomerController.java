package com.example.demo.Controller;

import com.example.demo.feign.Accountfeign;
import com.example.demo.model.Account;
import com.example.demo.model.Customer;
import com.example.demo.model.CustomerAccountResponse;
import com.example.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/service")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    Accountfeign accountfeign;

    @PostMapping("/customer")
    public ResponseEntity<Customer> createCustomer(@Valid @RequestBody Customer customer){
        try{
            Customer _customer = customerService.addCustomer(customer);
            return new ResponseEntity<>(_customer, HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/customer/{id}")
    public ResponseEntity<CustomerAccountResponse> getCustomerById(@PathVariable("id") Integer id){
        Optional<Customer> selectedCustomer = customerService.findByCustomerId(id);

        ResponseEntity<Account> account = accountfeign.getAccountById(id);
        CustomerAccountResponse car = new CustomerAccountResponse();

        if (selectedCustomer.isPresent()) {
            car.setCustomer((selectedCustomer.get()));
        }
        car.setAccount(account.getBody());
        return new ResponseEntity<>(car, HttpStatus.OK);
    }

}
