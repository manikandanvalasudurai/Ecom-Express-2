package com.example.productservice.services;

import com.example.productservice.dtos.FakeStoreProductDto;
import com.example.productservice.exception.ProductNotFoundException;
import com.example.productservice.models.Category;
import com.example.productservice.models.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FakeStoreProductService implements ProductService {
    private final WebClient webClient;

        @Override
        public Product getSingleProduct(Long productId) throws ProductNotFoundException {
            FakeStoreProductDto response = webClient.get().uri("/products/" + productId).retrieve().bodyToMono(FakeStoreProductDto.class).block();
            if(response == null){
                throw new ProductNotFoundException(productId, productId  + " Does not Exists");
            }
            return convertDtoToProduct(response);
        }

    @Override
    public List<Product> getAllProducts() {
    /*    Basic Implementation
        Mono<ResponseEntity<FakeStoreProductDto[]>> products = webClient.get().uri("/products/").retrieve().toEntity(FakeStoreProductDto[].class);
        FakeStoreProductDto[] fakeStoreProductDtos = products.block().getBody();
        List<Product> allProducts = new ArrayList<>();
        for(FakeStoreProductDto fakeStoreProductDto : fakeStoreProductDtos ){
            allProducts.add(convertDtoToProduct((fakeStoreProductDto)));
        }
        return  allProducts; */
       // 1. Fetch the data
        FakeStoreProductDto[] dtos = webClient.get()
                .uri("/products/")
                .retrieve()
                .bodyToMono(FakeStoreProductDto[].class) // We skip toEntity() if we only need the body
                .onErrorReturn(new FakeStoreProductDto[0])
                .block(); // Blocking to return a List

        // 2. Defensive check: If API returns nothing, return empty list instead of NullPointerException
        if (dtos == null) {
            return Collections.emptyList();
        }

        // 3. Use Java Streams for a cleaner transformation
        return Arrays.stream(dtos)
                .map(this::convertDtoToProduct)
                .toList();
    }

    @Override
    public Product createProduct(Product product) {
        return null;
    }

    @Override
    public boolean deleteProduct(Long productId) {
        return false;
    }

    @Override
    public Product replaceProduct(Product product) {
        return null;
    }

    @Override
    public Product updateProduct(Long productId) {
        return null;
    }

    private Product convertDtoToProduct(FakeStoreProductDto dto){
        Product product = new Product();
        product.setId(dto.getId());
        product.setTitle(dto.getTitle());
        product.setPrice(dto.getPrice());
        product.setDescription(dto.getDescription());
        product.setImage(dto.getImage());
        Category category = new Category();
        category.setTitle(dto.getCategory());
        product.setCategory((category));
        return product;
    }
}
