package com.example.productservice.exception;

public class CategoryNotFoundException extends Exception{
    public CategoryNotFoundException(String message){
        super(message);
    }
}
