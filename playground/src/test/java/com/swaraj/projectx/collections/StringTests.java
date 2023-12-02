package com.swaraj.projectx.collections;

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StringTests {

    @Test
    void stringComparison() {
        Comparable<String> comparable = "iello";
        int i = comparable.compareTo("hello");
        assertTrue(i > 0); // because "i" comes after "h" in natural order of char, ghij
    }
}
