package com.example.productservice.singletable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "instructor_mentor") //even marking we don't get table
@DiscriminatorValue(value = "3")
 public class Instructor extends User {
    private String subject;
    private Double rating;
}
