package com.swaraj.projectx;

import com.swaraj.projectx.inventory.InventoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.availability.AvailabilityChangeEvent;
import org.springframework.boot.availability.LivenessState;
import org.springframework.boot.availability.ReadinessState;
import org.springframework.boot.context.metrics.buffering.BufferingApplicationStartup;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@Slf4j
public class InventoryApp {

    private final InventoryService inventoryService;
    private final ApplicationEventPublisher applicationEventPublisher;

    @Autowired
    public InventoryApp(InventoryService inventoryService, ApplicationEventPublisher applicationEventPublisher) {
        this.inventoryService = inventoryService;
        this.applicationEventPublisher = applicationEventPublisher;
    }

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(InventoryApp.class);
        application.setApplicationStartup(new BufferingApplicationStartup(2048));
        application.run(args);
    }
}
