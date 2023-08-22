package com.springboot.app.exception;

public class CardIdValidationException extends RuntimeException {
    public CardIdValidationException(String message) {
        super(message);
    }
}
