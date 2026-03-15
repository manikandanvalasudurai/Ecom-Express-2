package com.example.productservice.models;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonPropertyOrder({"title","price","description","image","category"})
public class Product extends BaseModel {
//    @Setter If we want to use specifically to one field at class level we can provide getter at field which required only we can provide setter
    private String title;
    private  Double price;
    private String description;
    private String image;
    private Category category;
}
