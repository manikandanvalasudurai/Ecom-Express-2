package com.example.productservice.models;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonPropertyOrder({"title","price","description","image","category"})
@Entity(name = "products")
public class Product extends BaseModel {
//    @Setter If we want to use specifically to one field at class level we can provide getter at field which required only we can provide setter
    private String title;
    private  Double price;
    private String description;
    private String image;
    @ManyToOne
    private Category category;
}
