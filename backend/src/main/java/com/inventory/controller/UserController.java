package com.inventory.controller;

import com.inventory.model.Users;
import com.inventory.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping("/api/users")
@CrossOrigin("*")
public class UserController {

    private final UserRepository repo;

    public UserController(UserRepository repo) {
        this.repo = repo;
    }

    @PostConstruct
    public void initAdmin() {
        if (repo.findByUsername("admin").isEmpty()) {
            repo.save(new Users("admin", "tikuranbessa@123", "ADMIN"));
            System.out.println("✅ Default admin user created.");
        }
    }

    @PostMapping("/login")
    public Users login(@RequestBody Users req) {
        Optional<Users> user = repo.findByUsername(req.getUsername());
        if (user.isPresent() && user.get().getPassword().equals(req.getPassword())) {
            return user.get();
        } else {
            throw new RuntimeException("Invalid username or password");
        }
    }

    @PostMapping("/create")
    public Users createUser(@RequestBody Users newUsers) {
        return repo.save(newUsers);
    }
}
