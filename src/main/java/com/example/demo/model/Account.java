package com.example.demo.model;

import lombok.Data;


@Data
public class Account {

    private int id;
    private String AccountName;
    private String BankName;


    public Account(String accountName, String bankName){
        AccountName= accountName;
        BankName = bankName;
    }



}
