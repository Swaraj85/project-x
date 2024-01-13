package com.swaraj.projectx.algo;

public class AlgoUtils {
    public static void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    public static int partition(int[] arr, int left_ptr, int right_ptr) {
        int pivot_index = right_ptr;
        int pivot_value = arr[right_ptr];

        right_ptr = right_ptr - 1;

        while (true) {
            while (arr[left_ptr] < pivot_value)
                left_ptr = left_ptr + 1;
            while (arr[right_ptr] > pivot_value)
                right_ptr = right_ptr - 1;

            if (left_ptr >= right_ptr) break;
            else swap(arr, left_ptr, right_ptr);
        }

        swap(arr, left_ptr, pivot_index);
        return left_ptr;
    }
}
