package com.swaraj.projectx.collections;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HashSetTests {
    @Test
    void putEntriesInSet() {

        Set<String> uniqueStrings = new HashSet<>();
        uniqueStrings.add("alpha");
        uniqueStrings.add("beta");
        uniqueStrings.add("gamma");
        uniqueStrings.add("alpha");

        assertTrue(uniqueStrings.contains("alpha"));
    }

    @Test
    void init(){
        List<String> stringer = Arrays.asList("one", "two");
        Set<String> uniqueElements = new HashSet<>(stringer);
    }
}
