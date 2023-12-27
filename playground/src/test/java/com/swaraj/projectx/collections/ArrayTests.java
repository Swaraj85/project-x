package com.swaraj.projectx.collections;

import com.swaraj.projectx.cars.ConcreteCar;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.*;

public class ArrayTests {

    @Test
    void initializeArray() {
        int[] arrayOfInt = new int[50];
        for (int i = 0; i < arrayOfInt.length; i++) {
            System.out.println("i = " + i);
        }
    }
}
