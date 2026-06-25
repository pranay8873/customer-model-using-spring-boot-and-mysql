package com.ecomerce.customer.model.exceptions;

public class customerExistsException extends RuntimeException {
    public customerExistsException(String message) {
        super(message);
    }
}
