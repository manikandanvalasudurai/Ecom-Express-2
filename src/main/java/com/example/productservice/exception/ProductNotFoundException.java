package com.example.productservice.exception;

import lombok.Getter;

@Getter
public class ProductNotFoundException extends Exception{
    private final Long productId;
    public ProductNotFoundException(Long productId,String message){
        super(message);
        this.productId = productId;
    }
}
