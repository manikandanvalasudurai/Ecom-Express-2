package com.example.productservice.tableperclass;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "tbc_ta")
public class TA extends User {
    private int numberOfHelpRequests;
}
