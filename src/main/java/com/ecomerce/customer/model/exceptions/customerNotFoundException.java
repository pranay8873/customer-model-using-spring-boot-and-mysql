package com.ecomerce.customer.model.exceptions;

public class customerNotFoundException extends RuntimeException {
    public customerNotFoundException(String message) {
        super(message);
    }
}
