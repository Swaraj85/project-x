package com.swaraj.projectx.collections;

import org.assertj.core.internal.Comparables;
import org.junit.jupiter.api.Test;

import java.util.*;

public class TreeMapTests {

    @Test
    void putEntriesInTreeMap() {
        TreeMap<Integer, String> mainMap = new TreeMap<>();
        mainMap.put(99, "ninety nine");
        mainMap.put(5, "five");
        mainMap.put(67, "sixty seven");
        mainMap.put(56, "fifty six");
        mainMap.put(83, "eighty three");

        System.out.println("mainMap = " + mainMap); // all entries are sorted by key
        System.out.println("mainMap.firstKey() = " + mainMap.firstKey());
        System.out.println("mainMap.lastKey() = " + mainMap.lastKey());

        SortedMap<Integer, String> headMap = new TreeMap<>(mainMap.headMap(67)); //get entries < 67
        System.out.println("headMap = " + headMap);

        SortedMap<Integer, String> tailMap = new TreeMap<>(mainMap.tailMap(67)); //get entries >= 67
        System.out.println("tailMap = " + tailMap);
    }

    @Test
    void binaryPlay() {
        // keys are sorted, in this case key is string , hence sorted alphabetically
        TreeMap<String, Integer> numbers = new TreeMap<>();
        //NavigableMap<String, Integer> numbers = new TreeMap<>();
        numbers.put("one", 1);
        numbers.put("two", 2);
        numbers.put("three", 3);
        numbers.put("nine", 9);
        numbers.put("eight", 8);
        System.out.println(numbers);
    }
}
