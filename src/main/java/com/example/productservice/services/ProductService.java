package com.example.productservice.services;

import com.example.productservice.exception.ProductNotFoundException;
import com.example.productservice.models.Product;

import java.util.List;

public interface ProductService {
    Product getSingleProduct(Long productId) throws ProductNotFoundException;
    List<Product> getAllProducts();
    Product createProduct(Product product);
    boolean deleteProduct(Long productId);
    Product replaceProduct(Product product);
    Product updateProduct(Long productId);
    //default method for  is there any one particular class only needed when that implemented by this interface
    //no need to implement this method to all classes which implemented by this interface
    default void demoFunctionality(){}
}

