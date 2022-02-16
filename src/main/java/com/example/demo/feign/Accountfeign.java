package com.example.demo.feign;

import com.example.demo.model.Account;
import com.example.demo.model.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@FeignClient(name = "Customer-Server", fallbackFactory = HystrixFallBackFactory.class)
public interface Accountfeign {

    @GetMapping("/customer/{id}")
    ResponseEntity<Account> getAccountById(@PathVariable("id") Integer id);
}
