package com.example.productservice.controllers;

import com.example.productservice.commons.AuthCommons;
import com.example.productservice.models.Product;
import com.example.productservice.services.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ProductController.class)
class ProductControllerMockMvcTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private ProductService productService;

    @MockitoBean
    private AuthCommons authCommons;

    @Test
    void testGetAllProducts() throws Exception {

        // Arrange
        Product product1 = new Product();
        product1.setId(1L);
        product1.setTitle("Iphone 12");
        product1.setPrice(60000.1);

        Product product2 = new Product();
        product2.setId(2L);
        product2.setTitle("Samsung S24");
        product2.setPrice(70000.1);

        when(productService.getAllProducts())
                .thenReturn(List.of(product1, product2));

        // Act + Assert
        mockMvc.perform(get("/products/"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].title").value("Iphone 12"))
                .andExpect(jsonPath("$[0].price").value(60000.1))
                .andExpect(jsonPath("$[1].id").value(2))
                .andExpect(jsonPath("$[1].title").value("Samsung S24"))
                .andExpect(jsonPath("$[1].price").value(70000.1));
    }
}
