package com.swaraj.projectx;

import com.swaraj.projectx.cars.CarException;
import com.swaraj.projectx.cars.service.AdvancedCarService;
import com.swaraj.projectx.cars.service.MyCarService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
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

    //@Autowired
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

        try {
            myCarService.manageKeys();
            //kafkaTemplate.send("mytopic", "hello from spring boot kafka");
            advancedCarService.manageAdvancedKeys();
        } catch (CarException carException) {

            String rootCauseMessage = ExceptionUtils.getRootCauseMessage(carException);
            String stackTrace = ExceptionUtils.getStackTrace(carException);
            log.error("Global error: {} {}", rootCauseMessage, stackTrace);
            System.exit(1);
        }


        log.info("PlayApp finished..");
    }
}
