package com.swaraj.projectx;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@Slf4j
@RequestMapping(value = "v1/api/order")
public class OrderController {

    private final InventoryClient inventoryClient;

    @Autowired
    public OrderController(InventoryClient inventoryClient) {
        this.inventoryClient = inventoryClient;
    }

    @GetMapping("/{inventoryId}")
    public String home(@PathVariable String inventoryId) {
        String orderId = UUID.randomUUID().toString();
        log.info("order controller was hit with inventory id: {}", inventoryId);
        Inventory inventory = inventoryClient.getInventory(inventoryId);
        return String.format("order id %s generated for inventory %s", orderId, inventory.getId());
    }
}
