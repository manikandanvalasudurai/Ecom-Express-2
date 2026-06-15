package com.example.productservice.tableperclass;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "tbc_instructor")
 public class Instructor extends User {
    private String subject;
    private Double rating;
}
