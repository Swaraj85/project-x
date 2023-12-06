package com.swaraj.projectx.cars.service;


import com.swaraj.projectx.cars.CarException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AdvancedCarService {

    private final MyCarService myCarService;
    private final String name;

    public AdvancedCarService(MyCarService myCarService, String name) {
        this.myCarService = myCarService;
        this.name = name;
    }

    public void manageAdvancedKeys() throws CarException {
        myCarService.manageKeys();
        int randomness = (int) (Math.random() * 10);
        if (randomness % 2 == 0)
            throw new CarException("something wrong with car on day "+ randomness);
        log.info("managing advanced car service {}", name);
    }
}
