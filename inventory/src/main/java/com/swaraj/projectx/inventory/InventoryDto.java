package com.swaraj.projectx.inventory;

import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
public class InventoryDto {
    private String id;

    private String name;
    private int quantity;
    private double price;
}
