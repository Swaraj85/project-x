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
        Queue<Integer> minHeap = new PriorityQueue<>(); // min heap
        Queue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder()); // max heap
        minHeap.addAll(List.of(1, 6, 2, 3, 4, 99));
        maxHeap.addAll(List.of(1, 6, 2, 3, 4, 99));

        minHeap.offer(24);
        minHeap.offer(12);

        while (!minHeap.isEmpty()) {
            System.out.println(minHeap);
            System.out.println("removed: " + minHeap.poll());
        }

        System.out.println("maxheap: " + maxHeap);
        assertEquals(99, maxHeap.poll()); // since its max heap
    }
}
