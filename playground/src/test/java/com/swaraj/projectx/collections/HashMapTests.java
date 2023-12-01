package com.swaraj.projectx.collections;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
public class HashMapTests {

    @Test
    void initializeHasMap() {
        Map<String, Integer> hashMap = new HashMap<>();
        hashMap.put("swaraj", 34);
        hashMap.put("ruhika", 32);
        
        System.out.println("hashMap = " + hashMap);
        assertEquals(34, hashMap.get("swaraj"));
    }
}
