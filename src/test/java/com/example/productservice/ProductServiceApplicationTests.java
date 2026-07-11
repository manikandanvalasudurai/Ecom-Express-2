package com.example.productservice;

import com.example.productservice.models.Category;
import com.example.productservice.models.Product;
import com.example.productservice.repositories.CategoryRepository;
import com.example.productservice.repositories.ProductRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class ProductServiceApplicationTests {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    @Autowired
    public ProductServiceApplicationTests(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Test
//    @Transactional
    void contextLoads() {
    }

    @Test
    void testQuery() {

        //EAGER FETCH
        /*
               SELECT p1_0.id,
               c1_0.id,
               c1_0.created_at,
               c1_0.last_modified_at,
               c1_0.title,
               p1_0.created_at,
               p1_0.description,
               p1_0.image,
               p1_0.last_modified_at,
               p1_0.price,
               p1_0.title
        FROM   products p1_0
               LEFT JOIN categories c1_0
                      ON c1_0.id = p1_0.category_id
        WHERE  p1_0.id = ?
        8?
         */
        Optional<Product> productOptional = productRepository.findById(1L);


        //LAZY Fetch
        /*
               SELECT c1_0.id,
               c1_0.created_at,
               c1_0.last_modified_at,
               c1_0.title
        FROM   categories c1_0
        WHERE  c1_0.id = ?
        */
        Optional<Category> categoryOptional = categoryRepository.findById(2L);

        //Still wants Multiple products associated with this categories a few DB Queries is better than JOIN Operations from ORM

        /*
        HIBERNATE:

                SELECT c1_0.id,
                       c1_0.created_at,
                       c1_0.last_modified_at,
                       c1_0.title,
                       p1_0.category_id,
                       p1_0.id,
                       p1_0.created_at,
                       p1_0.description,
                       p1_0.image,
                       p1_0.last_modified_at,
                       p1_0.price,
                       p1_0.title
                FROM   categories c1_0
                       LEFT JOIN products p1_0
                              ON c1_0.id = p1_0.category_id
                WHERE  c1_0.id = ?
                */

        List<Product> products = categoryOptional.get().getProducts();
        System.out.println(products.get(0).getTitle());
        System.out.println("DEBUG");
    }
}
