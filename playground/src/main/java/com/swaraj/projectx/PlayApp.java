package com.swaraj.projectx;

import com.swaraj.projectx.cars.CarException;
import com.swaraj.projectx.cars.service.AdvancedCarService;
import com.swaraj.projectx.cars.service.MyCarService;
import com.swaraj.projectx.comp.MyComponent;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.kafka.core.KafkaTemplate;

import java.util.Objects;


@SpringBootApplication
@Slf4j
public class PlayApp implements CommandLineRunner {
    private final MyCarService myCarService;
    private final AdvancedCarService advancedCarService;
    private final KafkaTemplate<String, String> kafkaTemplate;
    private final MyComponent myComponent;
    private final ApplicationContext applicationContext;

    //@Autowired
    PlayApp(MyCarService myCarService,
            AdvancedCarService advancedCarService,
            KafkaTemplate<String, String> kafkaTemplate,
            MyComponent myComponent,
            ApplicationContext applicationContext) {

        this.myCarService = myCarService;
        this.advancedCarService = advancedCarService;
        this.kafkaTemplate = kafkaTemplate;
        this.myComponent = myComponent;
        this.applicationContext = applicationContext;
    }

    public static void main(String[] args) {
        SpringApplication.run(PlayApp.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("PlayApp started..");
        //backup1();
        myComponent.method1();
        MyComponent myComponentRef1 = myComponent;
        MyComponent myComponentRef2 = applicationContext.getBean(MyComponent.class);
        log.info("PlayApp finished..");
    }

    private void backup1() {
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
    }
}
