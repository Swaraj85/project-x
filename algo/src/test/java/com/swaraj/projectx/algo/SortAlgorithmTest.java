package com.swaraj.projectx.algo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SortAlgorithmTest {

    @Test
    void bubbleSort() {
        int[] numbers = new int[]{3, 9, 1, 2, 7, 45, 99, 345};
        SortAlgorithm.bubbleSort(numbers);

        //is array sorted?
        isArraySorted(numbers);
    }

    @Test
    void selectionSort() {
        int[] numbers = new int[]{3, 9, 1, 2, 7, 45, 99, 345};
        SortAlgorithm.selectionSort(numbers);

        //is array sorted?
        isArraySorted(numbers);
    }

    @Test
    void insertionSort(){
        int[] numbers = new int[]{3, 9, 1, 2, 7, 45, 99, 345};
        SortAlgorithm.insertionSort(numbers);
        //is array sorted?
        isArraySorted(numbers);
    }

    private static void isArraySorted(int[] numbers) {
        for (int i = 0; i < numbers.length - 1; i++) {
            assertTrue(numbers[i + 1] > numbers[i]);
        }
    }
}