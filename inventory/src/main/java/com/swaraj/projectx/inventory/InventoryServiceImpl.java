package com.swaraj.projectx.inventory;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.id.GUIDGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
@Service
public class InventoryServiceImpl implements InventoryService {

    private final InventoryRepository inventoryRepository;

//    @Value("${greeting.message}")
//    private String message;

    @Autowired
    public InventoryServiceImpl(InventoryRepository inventoryRepository){
        this.inventoryRepository = inventoryRepository;
    }

    @Override
    public InventoryDto saveInventory(InventoryDto inventoryDto){
        Inventory inventory = new Inventory();
        UUID uuid = UUID.randomUUID();
        inventory.setId(uuid);
        inventoryDto.setId(uuid.toString());
        inventory.setPrice(new BigDecimal(inventoryDto.getPrice()));
        inventory.setName(inventoryDto.getName());
        inventory.setQuantity(inventoryDto.getQuantity());
        Inventory savedInventory = inventoryRepository.save(inventory);
        inventory.setId(savedInventory.getId());
        return inventoryDto;
    }

    @Override
    public List<InventoryDto> getAllInventory() {
        Stream<InventoryDto> inventoryDtoStream = inventoryRepository.findAll().stream().map(this::convert);
        return inventoryDtoStream.collect(Collectors.toList());
    }

    @Override
    public InventoryDto getInventory(String inventory_id) {
        Optional<Inventory> byId = inventoryRepository.findById(UUID.fromString(inventory_id));
        return byId.map(this::convert).orElseGet(InventoryDto::new);
    }

    private InventoryDto convert(Inventory inventory){
        InventoryDto inventoryDto = new InventoryDto();
        inventoryDto.setId(inventory.getId().toString());
        inventoryDto.setPrice(Double.parseDouble(inventory.getPrice().toString()));
        inventoryDto.setQuantity(inventory.getQuantity());
        inventoryDto.setName(inventory.getName());
        return inventoryDto;
    }
}
