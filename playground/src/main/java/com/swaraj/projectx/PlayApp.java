package com.swaraj.projectx;

import com.swaraj.projectx.cars.service.AdvancedCarService;
import com.swaraj.projectx.cars.service.MyCarService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.core.KafkaTemplate;


@SpringBootApplication
@Slf4j
public class PlayApp implements CommandLineRunner {
    private final MyCarService myCarService;
    private final AdvancedCarService advancedCarService;
    private final KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    PlayApp(MyCarService myCarService, AdvancedCarService advancedCarService,
            KafkaTemplate<String, String> kafkaTemplate) {

        this.myCarService = myCarService;
        this.advancedCarService = advancedCarService;
        this.kafkaTemplate = kafkaTemplate;
    }

    public static void main(String[] args) {
        SpringApplication.run(PlayApp.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("PlayApp started..");
        myCarService.manageKeys();
        advancedCarService.manageAdvancedKeys();
        kafkaTemplate.send("mytopic","hello from spring boot kafka");
        log.info("PlayApp started..");
    }
}
