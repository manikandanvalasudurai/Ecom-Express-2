package com.example.productservice.singletable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "single_mentor") //even marking we don't get table
@DiscriminatorValue(value = "2")
public class Mentor extends User {
    private String companyName;
}
