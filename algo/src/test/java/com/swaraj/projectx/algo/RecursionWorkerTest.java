package com.swaraj.projectx.algo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RecursionWorkerTest {

    @Test
    void startCountDown() {
        RecursionWorker.startCountDown(5);
    }

    @Test
    void testArrayTools() {
        int[] arr = new int[]{1, 2, 3, 4};

        int number_of_elements = arr.length;
        int first_index = 0;
        int last_index = number_of_elements - 1;

        assertEquals(number_of_elements, 4);
        assertEquals(last_index, 3);
        assertEquals(first_index, 0);
    }

    @Test
    void pointerMovementTest() {
        int[] arr = new int[]{1, 23, 399, 45, 89};
        int left_ptr = 0;
        int right_ptr = arr.length - 1;
        while (right_ptr >= left_ptr) {
            System.out.println("arr[left_ptr] = " + arr[left_ptr]);
            System.out.println("arr[right_ptr] = " + arr[right_ptr]);
            left_ptr++;
            right_ptr--;
        }
    }

    @Test
    void partitionTest() {
        int[] arr = new int[]{0, 5, 2, 1, 6, 3};
        int left_index = AlgoUtils.partition(arr, 0, arr.length - 1);
        printArray(arr);
    }

    private void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println("arr[i] = " + arr[i]);
        }
    }

    @Test
    void print_array_recursion() {
        print(4);
        System.out.println("-------");
        print2(4);
    }

    @Test
    void treeTest(){

    }

    private void print(int n) {
        if (n == 0) return; // base case
        print(n - 1);
        System.out.println("n = " + n);
    }

    private void print2(int n) {
        if (n == 0) return;
        System.out.println("n = " + n);
        print2(n - 1);
    }
}