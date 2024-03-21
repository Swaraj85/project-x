package com.swaraj.projectx.collections;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

public class HashSetTests {
    @Test
    void putEntriesInSet() {

        Set<String> uniqueStrings = new HashSet<>();
        uniqueStrings.add("alpha");
        uniqueStrings.add("beta");
        uniqueStrings.add("gamma");
        uniqueStrings.add("alpha");
        System.out.println(uniqueStrings);
        assertTrue(uniqueStrings.contains("alpha"));

        uniqueStrings.remove("alpha");
        assertFalse(uniqueStrings.contains("alpha"));
    }

    public static void main(String[] args) {
        System.out.println("hello test");
    }

    @Test
    void init_hash_set() {
        Set<Integer> integerSet = new HashSet<>();
        integerSet.add(1);
        integerSet.add(45);
        integerSet.add(9);
        integerSet.add(34);
        integerSet.add(56);
        System.out.println(integerSet);

        integerSet.add(34);
        integerSet.add(34);

        assertTrue(integerSet.contains(34));
    }

    @Test
    void set_intersections() {
        Set<Integer> setA = Set.of(1, 2, 3);
        Set<Integer> setB = Set.of(3, 4, 5);
    }
}
