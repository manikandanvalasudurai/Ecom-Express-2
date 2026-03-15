package com.example.productservice.models;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
//@Data
@JsonPropertyOrder({"id","createdAt","lastModifiedAt"})
public abstract class BaseModel {
    private Long id;
    private Date createdAt;
    private Date lastModifiedAt;
}
