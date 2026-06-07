package com.example.productservice.services;
import com.example.productservice.exception.CategoryNotFoundException;
import com.example.productservice.exception.ProductNotFoundException;
import com.example.productservice.models.Category;
import com.example.productservice.models.Product;
import com.example.productservice.repositories.CategoryRepository;
import com.example.productservice.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SelfProductService implements ProductService{
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    @Override
    public Optional<Product> getSingleProduct(Long productId) throws ProductNotFoundException {
        Optional<Product> optionalProduct = productRepository.findById(productId);
        if(optionalProduct.isEmpty()){
            throw new ProductNotFoundException(productId ,"doesn't exists");
        }
        optionalProduct.get();
        return optionalProduct;
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product createProduct(Product product) throws CategoryNotFoundException {
        System.out.println("Service called........");
        Category category = product.getCategory();
        if(category == null){
            throw new CategoryNotFoundException("Product can't be created with out category.Please try again with Category");
        }
        Optional<Category> optionalCategory = categoryRepository.findByTitle(category.getTitle());
        if(optionalCategory.isEmpty()){
            //There is no category in the DB with the given title
            //create a category obj and save DB
            category = categoryRepository.save(category);
        } else {
            category = optionalCategory.get();
        }
        product.setCategory(category);
        return productRepository.save(product);
    }

    @Override
    public boolean deleteProduct(Long productId) throws ProductNotFoundException {
        Optional<Product> optionalProduct = productRepository.findById(productId);
        if(optionalProduct.isEmpty()){
            throw new  ProductNotFoundException(productId, "Product not found with id: ");
        }
        productRepository.deleteById(productId);
        return true;
    }

    @Override
    public Product replaceProduct(Product product) {
        return null;
    }

    @Override
    public Product updateProduct(Long productId) {
        return null;
    }

    @Override
    public void demoFunctionality() {
        ProductService.super.demoFunctionality();
    }
}
