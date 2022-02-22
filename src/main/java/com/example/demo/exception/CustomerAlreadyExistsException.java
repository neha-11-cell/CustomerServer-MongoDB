package com.example.demo.exception;

public class CustomerAlreadyExistsException extends Throwable {
    public CustomerAlreadyExistsException(String message) {
        super(message);
    }
}
