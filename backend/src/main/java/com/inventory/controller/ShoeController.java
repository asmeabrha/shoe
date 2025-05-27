package com.inventory.controller;

import com.inventory.model.Shoe;
import com.inventory.repository.ShoeRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/shoes")
@CrossOrigin("*")
public class ShoeController {

    private final ShoeRepository repo;

    public ShoeController(ShoeRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<Shoe> getAll() {
        return repo.findAll();
    }

    @PostMapping
    public Shoe create(@RequestBody Shoe shoe) {
        return repo.save(shoe);
    }

    @PutMapping("/{id}")
    public Shoe update(@PathVariable Long id, @RequestBody Shoe shoe) {
        shoe.setId(id);
        return repo.save(shoe);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repo.deleteById(id);
    }
}
