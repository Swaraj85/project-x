package com.swaraj.projectx.algo;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class MyUltimateAlgorithmTest {

    @Test
    void testBinarySearch() {
        int[] sortedArray = IntStream.range(0, 100).toArray();
        int i = MyUltimateSearchAlgorithm.binarySerach(sortedArray, 45);
        assertEquals(45, i);
    }

    @Test
    void testLoops() {
        int number_of_steps = 0;
        for (int i = 0; i < 50; i++) {
            for (int j = 0; j < 50; j++) {
                number_of_steps++;
            }
        }
        System.out.println("number_of_steps = " + number_of_steps);
    }
}