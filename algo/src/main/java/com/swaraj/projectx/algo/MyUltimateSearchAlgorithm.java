package com.swaraj.projectx.algo;

public class MyUltimateSearchAlgorithm {
    public static int binarySearch(int[] sortedArray, int valueToSearch) {
        int arrayLength = sortedArray.length;
        int lower_bound = 0;
        int resultIndex = 0;
        int upper_bound = arrayLength - 1;
        int midIndex;

        while (lower_bound <= upper_bound) {
            midIndex = (lower_bound + upper_bound) / 2;
            int value_at_midpoint = sortedArray[midIndex];

            if (valueToSearch < value_at_midpoint) {
                upper_bound = midIndex - 1;
            } else if (valueToSearch > value_at_midpoint) {
                lower_bound = midIndex + 1;
            } else if (valueToSearch == value_at_midpoint) {
                resultIndex = midIndex;
                break;
            }
        }

        return resultIndex;
    }
}
