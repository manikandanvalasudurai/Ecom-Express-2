package com.example.productservice.exception;

public class InvalidTokenException extends RuntimeException {
    private String token;
    public InvalidTokenException(String message) {
        super(message);
    }
}
