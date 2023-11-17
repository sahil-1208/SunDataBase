package com.customer.globalException;

public class CustomerResponseException extends RuntimeException {

    public CustomerResponseException(String message) {
        super(message);
    }
}
