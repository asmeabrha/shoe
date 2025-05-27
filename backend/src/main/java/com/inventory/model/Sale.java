package com.inventory.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class Sale {
    @Id @GeneratedValue
    private Long id;
    private Long shoeId;
    private int quantitySold;
    private String soldBy;
    private LocalDateTime soldAt = LocalDateTime.now();
}
