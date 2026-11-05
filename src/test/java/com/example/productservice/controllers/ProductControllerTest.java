//package com.example.productservice.controllers;
//
//import com.example.productservice.commons.AuthCommons;
//import com.example.productservice.dtos.UserDto;
//import com.example.productservice.exception.ProductNotFoundException;
//import com.example.productservice.models.Product;
//import com.example.productservice.services.ProductService;
//import net.bytebuddy.utility.RandomString;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.bean.override.mockito.MockitoBean;
//
//import java.util.Optional;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//
//@SpringBootTest
//class ProductControllerTest {
//
//    @MockitoBean
//    private ProductService productService;
//
//    @MockitoBean
//    private AuthCommons authCommons;
//
//    @Autowired
//    private ProductController productController;
//
//    @Test
//    @DisplayName("Should return product when valid product ID is provided")
//    void testGetSingleProductPositiveCase() throws ProductNotFoundException {
//
//        // Arrange
//        Long productId = 1L;
//
//        Product serviceProduct = new Product();
//        serviceProduct.setId(productId);
//        serviceProduct.setTitle("Iphone 12");
//        serviceProduct.setPrice(60000.1);
//
//        UserDto userDto = new UserDto();
//        userDto.setId(1L);
//
//        String token = RandomString.make();
//
//        when(authCommons.validateToken(token))
//                .thenReturn(userDto);
//
//        when(productService.getSingleProduct(productId))
//                .thenReturn(Optional.of(serviceProduct));
//
//        // Act
//        Product actualProduct =
//                productController.getSingleProduct(productId , token).getBody();
//
//        // Assert
//        assertNotNull(actualProduct);
//        assertEquals(1L, actualProduct.getId());
//        assertEquals("Iphone 12", actualProduct.getTitle());
//        assertEquals(60000.1, actualProduct.getPrice(), 0.001);
//
//        verify(productService).getSingleProduct(1L);
//    }
//
//    @Test
//    @DisplayName("Should throw ProductNotFoundException when product is not found")
//    void testGetSingleProductNegativeCase() {
//
//        // Arrange
//        // TODO
//
//        // Act
//        // TODO
//
//        // Assert
//        // TODO
//    }
//
//    // TODO: Write test cases for getAllProducts()
//}
