package com.swaraj.projectx.collections;

import com.swaraj.projectx.cars.ConcreteCar;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarTests {
    @Test
    void startCar() {

        ConcreteCar concreteCar = new ConcreteCar("tata", 12);
        concreteCar.startEngine();
        concreteCar.honk();
    }
}
