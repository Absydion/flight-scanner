package com.app.exception;

public class validPaymentException extends RuntimeException {
    public InvalidPaymentException(String message) {
        super(message);
    }
}
