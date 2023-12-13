package com.swaraj.projectx.collections;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LinkedHashMapTests {
    @Test
    void putEntriesInLinkedMap() {
        Map<String, String> linkedHashMap = new LinkedHashMap<>(4);
        linkedHashMap.put(null, "hello");
        linkedHashMap.put(null, "hello");
    }
}
