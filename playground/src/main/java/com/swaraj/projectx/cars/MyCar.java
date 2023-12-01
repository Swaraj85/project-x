package com.swaraj.projectx.cars;

public interface MyCar {
    void honkAgain();

    default String mustShowLight() {
        return "Default Light!!!";
    }
}
