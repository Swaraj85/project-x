package com.swaraj.projectx.collections;

import com.swaraj.projectx.cars.ConcreteCar;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ArrayTests {

    @Test
    void initializeArray() {
        int[] arrayOfInt = new int[5];
        for (int i = 0; i < arrayOfInt.length; i++) {
            System.out.println("i = " + i);
        }

        int[] noSize = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        for (int i = 0; i < noSize.length; i++) {
            System.out.println("noSize[i] = " + noSize[i]);
        }

        int firstIndex = 0, lastIndex = noSize.length - 1;
        while (firstIndex <= lastIndex) {
            System.out.println("nosize[firstIndex] = " + noSize[firstIndex]);
            System.out.println("nosize[lastIndex] = " + noSize[lastIndex]);
            firstIndex++;
            lastIndex--;
        }
    }

    @Test
    void multi_dimensional_array() {
        int[][] twoDimensionalArray = new int[3][4]; // 3 rows , 4 columns
        for (int row = 0; row < twoDimensionalArray.length; row++) {
            Arrays.fill(twoDimensionalArray[row], -1);
            for (int column = 0; column < twoDimensionalArray[row].length; column++) {
                String arrayIndex = String.format("[%d ,%d]", row, column);
                System.out.println(arrayIndex + " = " + twoDimensionalArray[row][column]);
            }
            System.out.println("-----");
        }
    }

    @Test
    void dynamicArrayTest() {
        List<String> myList = new ArrayList<>(5);
        myList.add("one");
        myList.add("two");
        myList.add("three");
        assertEquals(3, myList.size());
        assertTrue(myList.get(0).equalsIgnoreCase("one"));
    }

    @Test
    void listOfList() {
        List<List<String>> listy = new ArrayList<>();
        for (int i = 0; i < listy.get(0).size(); i++) {
        }
    }
}
