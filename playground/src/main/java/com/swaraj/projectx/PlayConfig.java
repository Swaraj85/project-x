package com.swaraj.projectx;

import com.swaraj.projectx.cars.service.AdvancedCarService;
import com.swaraj.projectx.cars.service.MyCarService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
public class PlayConfig {

    @Bean
    public MyCarService myCarService() {
        return new MyCarService();
    }

    @Bean
    public AdvancedCarService advancedCarService() {
        return new AdvancedCarService();
    }
}
