package com.example.demo.controller;

import com.example.demo.exception.CustomerAlreadyExistsException;
import com.example.demo.feign.Accountfeign;
import com.example.demo.model.Account;
import com.example.demo.model.Customer;
import com.example.demo.model.CustomerAccountResponse;
import com.example.demo.model.Putrequest;
import com.example.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/service")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    //@Autowired
   // private RestTemplate restTemplate;

    @Autowired
    Accountfeign accountfeign;

    @PostMapping
    public ResponseEntity<Customer> save(@Valid @RequestBody Customer cus){
        return new ResponseEntity<Customer>(customerService.add(cus), HttpStatus.ACCEPTED);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity <Customer> findById(@PathVariable("id") Integer cust_id){
        return new ResponseEntity<Customer>(customerService.findById(cust_id),HttpStatus.ACCEPTED);
    }



    @GetMapping()
    public ResponseEntity <List<Customer>> findAll() throws CustomerAlreadyExistsException {
        return new ResponseEntity<List<Customer>>(customerService.findAll(),HttpStatus.ACCEPTED);
    }




    @GetMapping("/feign/id/{id}")
    public ResponseEntity<CustomerAccountResponse> getAllDataBasedOnCentreId(@PathVariable("id") Integer id){
        CustomerAccountResponse customerAccountResponse=new CustomerAccountResponse();


        Customer customer=  customerService.findById(id);
        customerAccountResponse.setCustomer(customer);


        //Account_Model accountLists=  restTemplate.getForObject("http://ACCOUNT-SERVICE/account/id/"+id,Account_Model.class);
        List<Account> accountLists = accountfeign.findIDS(id);

        customerAccountResponse.setAccount((Account) accountLists);
        return new ResponseEntity<CustomerAccountResponse>(customerAccountResponse,HttpStatus.OK);
    }

    //
    @PatchMapping("/updateActive/{id}")
    public ResponseEntity<Customer> delete(@PathVariable("id") Integer id) throws CustomerAlreadyExistsException {

        return new ResponseEntity<Customer>(customerService.deleteCust(id),HttpStatus.ACCEPTED);
    }

    @PatchMapping("/updateLastName")
    public ResponseEntity<Customer> updateLastName(@RequestBody Putrequest p){
        return new ResponseEntity<Customer>(customerService.updateLastName(p),HttpStatus.ACCEPTED);
    }

    @PatchMapping("/updateMiddleName")
    public ResponseEntity<Customer> updateMiddleName(@RequestBody Putrequest p){
        return new ResponseEntity<Customer>(customerService.updateMiddleName(p),HttpStatus.ACCEPTED);
    }

    @PatchMapping("/updateAddress")
    public ResponseEntity<Customer> updateAddress(@RequestBody Putrequest p){
        return new ResponseEntity<Customer>(customerService.updateAddress(p),HttpStatus.ACCEPTED);
    }

    @PatchMapping("/updatePhone")
    public ResponseEntity<Customer> updatePhone(@RequestBody Putrequest p){
        return new ResponseEntity<Customer>(customerService.updatePhone(p),HttpStatus.ACCEPTED);
    }

    @PatchMapping("/updateEmail")
    public ResponseEntity<Customer> updateEmail(@RequestBody Putrequest p){
        return new ResponseEntity<Customer>(customerService.updateEmail(p),HttpStatus.ACCEPTED);
    }

}
