package com.example.productservice.repositories;
import com.example.productservice.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

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
    //update + insert = upsert
    Product save(Product product);

    //HQL Query -> we can use models
    @Query("select p from products p where p.id = :productId") //Since we overrided the product table name it HQL will access product table as products only
    Product findProductByGivenIdHQL(@Param("productId") Long productId);


    //SQL Query
    @Query(
            value = "select * from products where id = :productId",
            nativeQuery = true // means i am writing aql query don't do intervention on this
    )
    Product findProductByGivenIdSQL(@Param("productId") Long productId);
}
