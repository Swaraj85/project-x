package com.swaraj.projectx.collections;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HashSetTests {
    @Test
    void putEntriesInSet() {

        Set<String> uniqueStrings = new HashSet<>();
        uniqueStrings.add("alpha");
        uniqueStrings.add("beta");
        uniqueStrings.add("gamma");
    }
}
