package com.example.productservice;

import com.example.productservice.models.Product;
import com.example.productservice.repositories.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProductServiceApplicationTests {
    private final ProductRepository productRepository;
    @Autowired
    public ProductServiceApplicationTests(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Test
    void contextLoads() {
    }

    @Test
    void testQuery() {
        Product product = productRepository.findProductByGivenIdHQL(1L);
        System.out.println("DEBUG");
    }


}
