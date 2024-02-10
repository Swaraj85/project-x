package com.swaraj.projectx;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("inventory-service")
public interface InventoryClient {

    @GetMapping(value = "v1/api/inventory/{inventoryId}",
            consumes = "application/json")
    Inventory getInventory(@PathVariable("inventoryId") String inventoryId);
}
