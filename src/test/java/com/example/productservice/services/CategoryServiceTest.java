package com.example.productservice.services;

import com.example.productservice.repositories.CategoryRepository;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CategoryServiceTest {
    @Autowired
    private CategoryService categoryService;

    @Mock
    private CategoryRepository categoryRepository;
}