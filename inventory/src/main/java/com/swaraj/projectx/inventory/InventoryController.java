package com.swaraj.projectx.inventory;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@RestController
@Slf4j
@RequestMapping(value = "v1/api")
public class InventoryController {

    private final InventoryService inventoryService;

    @Autowired
    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @GetMapping
    String home() {
        log.info("home url was hit");
        inventoryService.operation1();
        return "hello inventory service";
    }

    @GetMapping("/inventory")
    List<InventoryDto> getInventory() {
        log.info("inventory url was hit");
        return getInMemoryInventory(10);
    }

    @GetMapping("/inventory/{inventoryId}")
    InventoryDto getInventory(@PathVariable Long inventoryId) {
        log.info("inventory id requested {}", inventoryId);
        return getInMemoryInventory(1).stream().findFirst().get();
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
