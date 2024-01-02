package com.swaraj.projectx.inventory;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.availability.AvailabilityChangeEvent;
import org.springframework.boot.availability.ReadinessState;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class HealthCheckReceiver {

    @EventListener
    public void onStateChange(AvailabilityChangeEvent<ReadinessState> event) {
        switch (event.getState()) {
            case ACCEPTING_TRAFFIC:
                log.info("traffic acceptance started");
                break;
            case REFUSING_TRAFFIC:
                log.info("traffic refusing started");
                break;
        }
    }
}
