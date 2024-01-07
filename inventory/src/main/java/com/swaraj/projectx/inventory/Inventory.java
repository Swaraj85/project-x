package com.swaraj.projectx.inventory;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Data
public class Inventory {
    @Id
    @Column(name = "inventory_id", nullable = false)
    private UUID id;

    private String name;
    private int quantity;
    private BigDecimal price;
}
