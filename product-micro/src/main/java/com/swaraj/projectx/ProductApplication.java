package com.swaraj.projectx;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class ProductApplication {

    public static void main(String[] args) {
        log.info("application {} started", ProductApplication.class);
        SpringApplication.run(ProductApplication.class, args);
        log.info("application {} initialized", ProductApplication.class);
    }
}