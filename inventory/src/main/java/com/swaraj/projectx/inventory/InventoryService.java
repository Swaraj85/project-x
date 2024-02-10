package com.swaraj.projectx.inventory;

import java.util.List;

public interface InventoryService {
    InventoryDto saveInventory(InventoryDto inventoryDto);

    List<InventoryDto> getAllInventory();

    InventoryDto getInventory(String inventory_id);

}
