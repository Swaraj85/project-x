package com.swaraj.projectx;

import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
public class Inventory {
    private String id;

    private String name;
    private int quantity;
    private double price;
}
