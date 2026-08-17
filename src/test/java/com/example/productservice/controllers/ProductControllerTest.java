package com.example.productservice.controllers;

import com.example.productservice.services.ProductService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductControllerTest {
    @Mock
    public ProductService productService;
    @Autowired
    public ProductController productController;

    @Test
    public void testGetSingleProductPositiveCase(){
    }

    @Test
    public void testGetSingleProductNegativeCase(){}
}