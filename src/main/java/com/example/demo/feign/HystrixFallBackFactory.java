package com.example.demo.feign;

import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

import java.text.MessageFormat;

@Component
 public class HystrixFallBackFactory implements FallbackFactory<Accountfeign> {
    @Override
    public Accountfeign create(Throwable cause) {

        return id -> {
            // dummyMethod();
            System.out.println("fallback; reason was: " + cause.getMessage());
            return null;
         };
    }
}
