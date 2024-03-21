package com.swaraj.projectx.collections;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

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
        Map<String, Integer> numbers = new HashMap<>();
        numbers.put("one", 1);
        numbers.put("two", 2);
        numbers.put("three", 3);
        numbers.put("nine", 9);
        numbers.put("eight", 8);
        System.out.println(numbers);
//        for (Map.Entry<String, Integer> entry : numbers.entrySet()) {
//            System.out.println(entry);
//        }
        int incrementer = 1;

        // increment existing value of key by 1
        numbers.computeIfPresent("one", (key, existingValue) -> {
            return existingValue + incrementer;
        });

        // returns 0 bec key "seven" doesnt exist
        assertEquals(0, numbers.getOrDefault("seven", 0));

        System.out.println(numbers);
    }

    @Test
    void array_of_hash_map() {
        Map<String, String>[] paritions = new HashMap[30];
        paritions[0] = new HashMap<>();
    }

    @Test
    void hash_of_objects() {
        Map<Object, Object> hasher = new HashMap<>();
        hasher.put("aa", 1);
        hasher.put(123, 456);
        System.out.println(hasher.get("aa"));
        System.out.println(hasher.get(123));

        String s = new String("abc");
        s.toUpperCase();
        System.out.println(s);
    }
}
