package com.example.productservice.controllers;

import com.example.productservice.dtos.ExceptionDto;
import com.example.productservice.dtos.ProductNotFoundExceptionDto;
import com.example.productservice.exception.ProductNotFoundException;
import com.example.productservice.models.Product;
import com.example.productservice.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/{id}")
    public ResponseEntity<Product> getSingleProduct(@PathVariable("id") Long productId) throws ProductNotFoundException {
        ResponseEntity responseEntity = null;
        Product products = null;
        try{
            products = this.productService.getSingleProduct(productId);
            responseEntity = new ResponseEntity<>(products, HttpStatus.OK);
        }
        catch (Exception ex){
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        return responseEntity;
    }

    @GetMapping("")
    public List<Product> getAllProducts(){
       return this.productService.getAllProducts();
    }

    @PostMapping("/")
    public Product createProduct(@RequestBody Product product){
        return new Product();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable("id") Long productId){
        return null;
    }

    @PutMapping("/{id}")
    public Product replaceProduct(@PathVariable("id") Long productId, @RequestBody Product product){
        return new Product();
    }

    @PatchMapping("/{id}")
    public Product updateProduct(@PathVariable("id") Long productId,@RequestBody Product product){
        return new Product();
    }

//    Check for priority vs @controlleradvice
    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ProductNotFoundExceptionDto> handleProductNotFoundException(ProductNotFoundException ex){
        ProductNotFoundExceptionDto productNotFoundExceptionDto = new ProductNotFoundExceptionDto();
        productNotFoundExceptionDto.setProductId(ex.getProductId());
        productNotFoundExceptionDto.setMessage(ex.getMessage() + " Came from controller");
        return new ResponseEntity<>(productNotFoundExceptionDto , HttpStatus.NOT_FOUND);
    }
}

