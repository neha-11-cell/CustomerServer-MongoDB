package com.example.demo.config;

import feign.Retryer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomerRetryClientConfig {

    @Bean
    public Retryer clientServiceRetryer(){
        return new FeignClientRetryer();
    }

}
