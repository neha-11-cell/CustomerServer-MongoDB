package com.example.demo.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "customer")
@Data
public class Customer {

    private String customerFirstName;
    private String customerMiddleName;
    private String customerLastName;
    private String customerCity;
    private Date currentDate;
    private boolean active;
    @Id
    private int id;

    public Customer(String customerFirstName, String customerMiddleName, String customerLastName, String customerCity, Date currentDate, boolean active) {
        this.customerFirstName = customerFirstName;
        this.customerMiddleName = customerMiddleName;
        this.customerLastName = customerLastName;
        this.customerCity = customerCity;
        this.currentDate = currentDate;
        this.active = active;
        this.id = id;
    }



}
