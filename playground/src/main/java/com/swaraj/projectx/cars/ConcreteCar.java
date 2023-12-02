package com.swaraj.projectx.cars;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class ConcreteCar extends AbstractCar {

    private static final List<String> carNameHolder;

    static {
        carNameHolder = new ArrayList<>();
        carNameHolder.add("tata");
    }

    private String name;
    private int age;

    public ConcreteCar(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public void honk() {
        log.info("honking from ConcreteCar");
    }

    @Override
    public void honk(String message) {
    }

    @Override
    public void startEngine() {
        super.startEngine();
        log.info("starting concrete car engine");
        super.changeEngineStatus(EngineState.STARTED);
    }

    @Override
    public String toString() {
        return "ConcreteCar{" +
                "name='" + name + '\'' +
                ", age=" + age +
                "} " + super.toString();
    }
}
