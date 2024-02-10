package com.swaraj.projectx.inventory;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@RestController
@Slf4j
@RequestMapping(value = "v1/api/inventory")
public class InventoryController {

    private final InventoryService inventoryService;

    @Autowired
    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }


    @GetMapping
    List<InventoryDto> getInventory() {
        log.info("inventory url was hit");
        return inventoryService.getAllInventory();
    }

    //@GetMapping(value = "/{inventoryId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping(value = "/{inventoryId}")
    InventoryDto getInventory(@PathVariable String inventoryId) {
        log.info("inventory id requested {}", inventoryId);
        return inventoryService.getInventory(inventoryId);
    }

    @PostMapping
    InventoryDto saveInventory(@RequestBody InventoryDto inventoryDto){
        return inventoryService.saveInventory(inventoryDto);
    }

    private List<InventoryDto> getInMemoryInventory(int objectCount) {
        Stream<InventoryDto> inventoryDtoStream = IntStream.range(0, objectCount).mapToObj(value -> {
            InventoryDto object = new InventoryDto();
            object.setName(String.format("name-%d",value));
            object.setQuantity(value);
            return object;
        });

        return inventoryDtoStream.collect(Collectors.toList());
    }
}
