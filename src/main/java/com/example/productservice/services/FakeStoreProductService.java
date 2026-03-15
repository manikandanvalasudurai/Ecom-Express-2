package com.example.productservice.services;

import com.example.productservice.dtos.FakeStoreProductDto;
import com.example.productservice.models.Category;
import com.example.productservice.models.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
@RequiredArgsConstructor
@Primary
public class FakeStoreProductService implements ProductService {
    private final WebClient webClient;

    @Override
    public Product getSingleProduct(Long productId) {
//        return webClient.get().uri("/products/" + productId)
//                .retrieve()
//                .bodyToMono(String.class)
//                .block();
        FakeStoreProductDto dto = webClient.get().uri("/products/" + productId).retrieve().bodyToMono(FakeStoreProductDto.class).block();
        return convertDtoToProduct(dto);
    }

    @Override
    public List<Product> getAllProducts() {
        return List.of();
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
