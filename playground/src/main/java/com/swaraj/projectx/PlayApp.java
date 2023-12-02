package com.swaraj.projectx;

import com.swaraj.projectx.cars.service.AdvancedCarService;
import com.swaraj.projectx.cars.service.MyCarService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@Slf4j
public class PlayApp implements CommandLineRunner {

    @Autowired private MyCarService myCarService;
    @Autowired private AdvancedCarService advancedCarService;

    public static void main(String[] args) {
        SpringApplication.run(PlayApp.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("PlayApp started..");
        myCarService.manageKeys();
        advancedCarService.manageAdvancedKeys();
        log.info("PlayApp started..");
    }
}
