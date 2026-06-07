package com.example.productservice.controllers;

import com.example.productservice.exception.CategoryNotFoundException;
import com.example.productservice.exception.ProductNotFoundException;
import com.example.productservice.models.Product;
import com.example.productservice.services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(@Qualifier("selfProductService") ProductService productService){
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getSingleProduct(@PathVariable("id") Long productId) throws ProductNotFoundException {
        ResponseEntity responseEntity = null;
        Product products = null;
        try{
            Optional<Product> optionalProduct = this.productService.getSingleProduct(productId);
            products = optionalProduct.orElseThrow(() -> new ProductNotFoundException(productId, productId + " doesn't exists"));
            responseEntity = new ResponseEntity<>(products, HttpStatus.OK);
        }
        catch (Exception ex){
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        return responseEntity;
    }

    @GetMapping("/")
    public List<Product> getAllProducts(){
       return this.productService.getAllProducts();
    }

    @PostMapping("/")
    public Product createProduct(@RequestBody Product product) throws CategoryNotFoundException {
        System.out.println("Controller called........");
        return productService.createProduct(product);
    }

    @DeleteMapping("/{id}")
    public boolean deleteProduct(@PathVariable("id") Long productId) throws ProductNotFoundException {
        return productService.deleteProduct(productId);
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
//    @ExceptionHandler(ProductNotFoundException.class)
//    public ResponseEntity<ProductNotFoundExceptionDto> handleProductNotFoundException(ProductNotFoundException ex){
//        ProductNotFoundExceptionDto productNotFoundExceptionDto = new ProductNotFoundExceptionDto();
//        productNotFoundExceptionDto.setProductId(ex.getProductId());
//        productNotFoundExceptionDto.setMessage(ex.getMessage() + " Came from controller");
//        return new ResponseEntity<>(productNotFoundExceptionDto , HttpStatus.NOT_FOUND);
//    }
}

