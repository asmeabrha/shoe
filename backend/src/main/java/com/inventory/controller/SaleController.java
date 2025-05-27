package com.inventory.controller;

import com.inventory.dto.SaleRequest;
import com.inventory.model.Sale;
import com.inventory.model.Shoe;
import com.inventory.repository.SaleRepository;
import com.inventory.repository.ShoeRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sales")
@CrossOrigin("*")
public class SaleController {

    private final SaleRepository saleRepo;
    private final ShoeRepository shoeRepo;

    public SaleController(SaleRepository saleRepo, ShoeRepository shoeRepo) {
        this.saleRepo = saleRepo;
        this.shoeRepo = shoeRepo;
    }

    @PostMapping
    public String registerSale(@RequestBody SaleRequest req) {
        Shoe shoe = shoeRepo.findById(req.getShoeId())
                .orElseThrow(() -> new RuntimeException("Shoe not found"));

        if (shoe.getQuantity() < req.getQuantity()) {
            return "Not enough stock";
        }

        shoe.setQuantity(shoe.getQuantity() - req.getQuantity());
        shoeRepo.save(shoe);

        Sale sale = new Sale();
        sale.setShoeId(req.getShoeId());
        sale.setQuantitySold(req.getQuantity());
        sale.setSoldBy(req.getSoldBy());
        saleRepo.save(sale);

        return "Sale registered";
    }

    @GetMapping
    public List<Sale> getAllSales() {
        return saleRepo.findAll();
    }
}
