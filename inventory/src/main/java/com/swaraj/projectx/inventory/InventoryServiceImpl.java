package com.swaraj.projectx.inventory;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class InventoryServiceImpl implements InventoryService {

//    @Value("${secret.name}")
//    private String injectedName;

//    @Value("${env}")
//    private String environment;

    @Override
    public void operation1() {
        //log.info("environment: {} secret word is {}", environment);
        log.info("executing -> operation1");
    }

    @Override
    public void operation2() {
        log.info("executing -> operation2");
    }

    @Override
    public void operation3() {
        log.info("executing -> operation3");
    }
}
