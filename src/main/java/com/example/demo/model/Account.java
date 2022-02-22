package com.example.demo.model;

import com.example.demo.enumeration.AccountType;
import lombok.Data;

import java.util.Date;


@Data
public class Account {

    private int id;
    private String customerFirstName;
    private String customerMiddleName;
    private String customerLastName;
    private String customerCity;
    private Date currentDate;
    private boolean active;

    public Account(int id, String customerFirstName, String customerMiddleName, String customerLastName, String customerCity, Date currentDate, boolean active) {
        this.id = id;
        this.customerFirstName = customerFirstName;
        this.customerMiddleName = customerMiddleName;
        this.customerLastName = customerLastName;
        this.customerCity = customerCity;
        this.currentDate = currentDate;
        this.active = active;
    }

    private AccountType accountType ;
}
