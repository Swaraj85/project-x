package com.swaraj.projectx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class OrderApp {

    @GetMapping("/")
    public String home() {
        return "order-service";
    }

    public static void main(String[] args) {
        SpringApplication.run(OrderApp.class, args);
    }
}