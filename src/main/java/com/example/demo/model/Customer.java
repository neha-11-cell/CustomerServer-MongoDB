package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Data
@Document(collection = "customer")
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Customer {

    @Id
    @Min(0)
    @Max(999)
    private int id;

    @NotEmpty(message = "Name cannot be empty")
    private String customerFirstName;

    private String customerMiddleName;

    @NotEmpty(message = "Last name cannot be empty")
    private String customerLastName;

    @NotEmpty(message = "City cannot be empty")
    private String customerCity;

    @NotNull(message = "current date can't be null")
    private Date currentDate;

    @NotNull(message = "isactive can't be null")
    private boolean active;

    @NotNull(message = "Phone number  can't be null")
    @Size(min=10,max = 10)
    private String phonenumber;


    @NotNull(message = "Email can't be null")
    private String email;
    private boolean isactive;

    public Customer(String customerFirstName, String customerMiddleName, String customerLastName, String customerCity, Date currentDate, boolean active) {
        this.customerFirstName = customerFirstName;
        this.customerMiddleName = customerMiddleName;
        this.customerLastName = customerLastName;
        this.customerCity = customerCity;
        this.currentDate = currentDate;
        this.active = active;
        this.phonenumber = phonenumber;
        this.email = email;
        this.id = id;
    }

    private LocalDateTime current_date= LocalDateTime.now();


    public boolean getisactive(){
        return this.active;
    }

    public String getCustomerId() {
        return getCustomerId();
    }

    public Account getAccount() {
        return getAccount();
    }


    public void setAccount(Object account) {

    }
}
