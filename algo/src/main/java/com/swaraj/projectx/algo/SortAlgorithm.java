package com.swaraj.projectx.algo;

public class SortAlgorithm {
    public static void bubbleSort(int[] unsortedArray) {
        int unsorted_until_index = unsortedArray.length - 1;
        boolean sorted = false;

        while (!sorted) {
            sorted = true;
            for (int i = 0; i < unsorted_until_index; i++) {
                if (unsortedArray[i] > unsortedArray[i + 1]) {
                    sorted = false;
                    // swap the numbers
                    swapValueAtIndex(unsortedArray, i, i + 1);
                }
            }

            unsorted_until_index = unsorted_until_index - 1;
        }
    }

    public static void selectionSort(int[] unsortedArray) {
        int total_elements = unsortedArray.length;

        for (int i = 0; i < total_elements; i++) {
            int lowest_number_index = i;

            for (int j = i + 1; j < total_elements; j++) {
                if (unsortedArray[j] < unsortedArray[lowest_number_index]) {
                    lowest_number_index = j;
                }
            }
            swapValueAtIndex(unsortedArray, i, lowest_number_index);
        }
    }

    private static void swapValueAtIndex(int[] arr, int firstIndex, int secondIndex) {
        int temp = arr[secondIndex];
        arr[secondIndex] = arr[firstIndex];
        arr[firstIndex] = temp;
    }

    public static void insertionSort(int[] numbers) {
        for (int i = 1; i < numbers.length; i++) {
            int selected_key_position = i;
            int selected_key = numbers[i];

            while (selected_key_position > 0 && numbers[selected_key_position - 1] > selected_key) {
                numbers[selected_key_position] = numbers[selected_key_position - 1];
                selected_key_position--;
            }

            numbers[selected_key_position] = selected_key;
        }
    }

    public static void quickSort(int[] num, int start_index, int end_index) {
        if (end_index - start_index <= 0) return;
        int pivot_position = AlgoUtils.partition(num, start_index, end_index);
        quickSort(num, start_index, pivot_position - 1);
        quickSort(num, pivot_position + 1, end_index);
    }
}
