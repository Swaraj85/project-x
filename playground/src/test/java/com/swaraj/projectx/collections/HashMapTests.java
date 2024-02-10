package com.swaraj.projectx.collections;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
public class HashMapTests {

    private static final Map<String, Integer> myHashMap;

    static {
        myHashMap = new HashMap<>();
        myHashMap.put("swaraj", 34);
        myHashMap.put("ruhika", 32);
    }

    @Test
    void initializeHashMap() {
        assertEquals(34, myHashMap.get("swaraj"));
    }

    @Test
    void iterateOverMap() {
        myHashMap.forEach((key, value) -> {
            System.out.println("Key = " + key + " Value =" + value);
        });

        for (Map.Entry<String, Integer> entry : myHashMap.entrySet()) {
            System.out.println("Key = " + entry.getKey() + " Value =" + entry.getValue());
        }
    }

    @Test
    void putEntriesInMap() {
        IntStream.rangeClosed(1, 100).forEach(value -> {
            myHashMap.put(Integer.toString(value), value);
        });
        assertEquals(102, myHashMap.entrySet().size());
    }

    @Test
    void mergeInMap() {
        Map<String, Integer> mySecondHashMap = new HashMap<>();
        mySecondHashMap.put("one", null);
        mySecondHashMap.put("two", null);
        mySecondHashMap.put(null, null);
        mySecondHashMap.put(null, null);

        Map<String, Integer> myThirsHashMap = new LinkedHashMap<>();
        mySecondHashMap.put("one", null);
        mySecondHashMap.put("one", null);
    }

    @Test
    void imp_function_calls() {
        Map<String, Integer> mapper = new HashMap<>();
    }
}
