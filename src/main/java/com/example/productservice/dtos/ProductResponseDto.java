package com.example.productservice.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductResponseDto {
    private String title;
    private Double price;
    private String description;
    private String image;
    private CategoryDto category;
}
