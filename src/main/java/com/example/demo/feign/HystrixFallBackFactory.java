package com.example.demo.feign;

import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class HystrixFallBackFactory implements FallbackFactory<Accountfeign> {
    @Override
    public Accountfeign create(Throwable cause) {
        return null;
    }
}