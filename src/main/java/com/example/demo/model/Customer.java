package com.example.demo.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "customer")
@Data
public class Customer {

    String customerName;
    String customerCity;
    @Id
    String id;

    public Customer(String customerName, String customerCity){
        this.customerName = customerName;
        this.customerCity = customerCity;

    }

}
