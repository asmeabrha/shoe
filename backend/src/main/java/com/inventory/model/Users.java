package com.inventory.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Users {
    @Id @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String username;

    private String password;
    private String role; // "ADMIN" or "USER"
    private String color;  // add this field


    public Users() {}
    public Users(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    // Getters and Setters
}
