package com.swaraj.projectx;

import com.swaraj.projectx.cars.service.AdvancedCarService;
import com.swaraj.projectx.cars.service.MyCarService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PlayConfig {

    @Value("${play.name}") String playName;

    @Bean
    public MyCarService myCarService() {
        return new MyCarService();
    }

    @Bean
    public AdvancedCarService advancedCarService() {
        return new AdvancedCarService(myCarService(), playName);
    }

}
