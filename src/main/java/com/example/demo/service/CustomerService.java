package com.example.demo.service;

import com.example.demo.exception.CustomerAlreadyExistsException;
import com.example.demo.exception.CustomerNotFoundException;
import com.example.demo.feign.Accountfeign;
import com.example.demo.model.Account;
import com.example.demo.model.Customer;
import com.example.demo.model.Putrequest;
import com.example.demo.repo.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    CustomerRepo customerRepo;

    @Autowired
    private Accountfeign accountfeign;


    public Customer add(Customer cus){
        if( !customerRepo.findById(cus.getCustomerId()).isPresent()){
//        Customer customer = customerRepo.findById(cus.getCustomerId()).get();


            Account account = accountfeign.createAccount(cus.getAccount());


            return customerRepo.save(cus);


        }
        else{
            Customer customer = customerRepo.findById(cus.getCustomerId()).get();
            if(customer.getisactive()){
                Account accountModel= accountfeign.createAccount(cus.getAccount());
                return customerRepo.save(cus);
            }
            else{
                throw new CustomerNotFoundException("Customer is already inactive,cannnot create account") ;
            }


        }
    }

    public Customer findById(Integer cust_id){
        if(!customerRepo.findById(cust_id).isPresent()) {
            throw new CustomerNotFoundException("id doesnt exist");
        }
        Customer c= customerRepo.findById(cust_id).get();
        c.setAccount(null);

        return c;
    }


    public List<Customer> findAll() throws CustomerAlreadyExistsException {
        if(customerRepo.findAll().isEmpty()) {
            throw new CustomerAlreadyExistsException("No customer found for this id");
        }
        List<Customer> c= customerRepo.findAll();
        for(Customer c1 : c)
           c1.setAccount(null);

        return c;
    }

//
//    public Customer deleteCust(Integer id){
//        Customer cus = customerRepo.findById(id).get();
//
//        if(cus.getisactive()==false)
//            throw new CustomerAlreadyExistsException("Customer is already inactive");
//        else {
//            cus.setIsactive(false);
//            customerRepo.save(cus);
//            List<Account> accountLists = (List<Account>) feign.updateActive(id);
//            cus = findById(id);
//            return cus;
//        }
//    }

    public Customer deleteCust(Integer id) throws CustomerAlreadyExistsException {
        Customer cus = findById(id);
        if(cus.getisactive()==false) {
            throw new CustomerAlreadyExistsException("Customer is already inactive");
        }
        cus.setIsactive(false);
        customerRepo.save(cus);
        List<Account> accountLists = (List<Account>) accountfeign.updateActive(id);
        cus = findById(id);
        return cus;
    }
    public Customer updateLastName(Putrequest p){
        Customer cus = findById(p.getId());
        cus.setCustomerLastName(p.getLastname());
        customerRepo.save(cus);
        return cus = findById(p.getId());

    }

    public Customer updateMiddleName(Putrequest p){
        Customer cus = findById(p.getId());
        cus.setCustomerMiddleName(p.getMiddlename());
        customerRepo.save(cus);
        return cus = findById(p.getId());

    }

    public Customer updateAddress(Putrequest p){
        Customer cus = findById(p.getId());
        cus.setCustomerCity(p.getAddress());
        customerRepo.save(cus);
        return cus = findById(p.getId());

    }

    public Customer updatePhone(Putrequest p){
        Customer cus = findById(p.getId());
        cus.setPhonenumber(p.getPhone());
        customerRepo.save(cus);
        return cus = findById(p.getId());

    }

    public Customer updateEmail(Putrequest p){
        Customer cus = findById(p.getId());
        cus.setEmail(p.getEmail());
        customerRepo.save(cus);
        return cus = findById(p.getId());

    }
}
