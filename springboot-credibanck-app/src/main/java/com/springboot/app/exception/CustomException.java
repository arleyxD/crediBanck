package com.springboot.app.exception;

public class CustomException extends RuntimeException {
	public CustomException(String message) {
        super(message);
    }
}
