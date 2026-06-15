package com.example.productservice.singletable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "single_ta") //even marking we don't get table
@DiscriminatorValue(value = "1")
public class TA extends User {
    private int numberOfHelpRequests;
}
