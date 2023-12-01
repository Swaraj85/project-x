package com.swaraj.projectx.cars;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class AbstractCar {

    public enum EngineState {STARTED, STOPPED};

    private EngineState engineState;

    public abstract void honk();

    public abstract void honk(String message);

    public void startEngine(){
        log.info("Engine starting from AbstractCar");
    }

    protected void changeEngineStatus(EngineState expectedEngineState) {
        this.engineState = expectedEngineState;
        log.info("changing engine status to {}", expectedEngineState);
    }
}
