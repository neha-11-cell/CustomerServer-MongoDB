package com.example.demo.feign;

import com.example.demo.config.CustomerRetryClientConfig;
import com.example.demo.model.Account;
import com.example.demo.model.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@FeignClient(name = "ACCOUNT-SERVICE", configuration = CustomerRetryClientConfig.class,fallbackFactory = HystrixFallBackFactory.class)
//@FeignClient(name = "Customer-Server", fallbackFactory = HystrixFallBackFactory.class)
public interface Accountfeign {

    @GetMapping("/account/uds/{id}")
    List<Account> findIDS(@PathVariable Integer id);

    @PatchMapping("/account/disableisActive/{id}")
    List<Account> updateActive(@PathVariable Integer id);

    @PostMapping("/account")
    Account createAccount(@RequestBody Account account);
}
