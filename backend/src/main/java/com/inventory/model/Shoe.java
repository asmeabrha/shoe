package com.inventory.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Shoe {
    @Id @GeneratedValue
    private Long id;
    private String name;
    private int size;
    private int quantity;
    private double price;
    private String color;
}
