package com.inventory.dto;


import lombok.Data;

@Data
public class SaleRequest
{
    public Long shoeId;
    public int quantity;
    public String soldBy;
}
