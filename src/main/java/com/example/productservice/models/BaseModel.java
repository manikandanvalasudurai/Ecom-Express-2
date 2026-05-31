package com.example.productservice.models;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
//@Data
@JsonPropertyOrder({"id","createdAt","lastModifiedAt"})
@MappedSuperclass
public abstract class BaseModel {
    @Id
    private Long id;
    private Date createdAt;
    private Date lastModifiedAt;
}
