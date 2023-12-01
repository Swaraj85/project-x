package com.swaraj.projectx.collections;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PriorityQueueTests {
    @Test
    void queueAdditionAndRemoval() {
        Queue<Integer> workLoad = new PriorityQueue<>();
        workLoad.addAll(List.of(1, 6, 2, 3, 4, 99));

        while (!workLoad.isEmpty()) {
            System.out.println("workLoad.remove() = " + workLoad.remove());
        }
    }
}
