package com.swaraj.projectx;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Collections;
import java.util.List;
import java.util.function.Supplier;

@SpringBootApplication
public class PlayApp implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(PlayApp.class, args);
    }
    @Override
    public void run(String... args) throws Exception {

    }
}
