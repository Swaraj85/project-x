package com.swaraj.projectx.cars.service;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

@Slf4j
public class AdvancedCarService {

    @Autowired MyCarService myCarService;
    @Value("${play.name}") String name;

    public void manageAdvancedKeys() {
        log.info("managing advanced car service {}", name);
    }
}
