package com.example.productservice.repositories;
import com.example.productservice.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
//    https://docs.spring.io/spring-data/jpa/reference/jpa/query-methods.html

    //select * from products p where p.id == productId
    @Override
    Optional<Product> findById(Long productId);

    Optional<Product> findByTitle(String title);

    List<Product> findByPriceBetween(Double minPrice,Double maxPrice);

    List<Product> findAllByCategory_Title(String categoryTitle);

    //Custom Query
    @Query("select title from products p where id = :productId")
    Optional<Product> findOnlyProductTitleById(Long productId);
}
