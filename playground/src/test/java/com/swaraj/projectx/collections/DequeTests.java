package com.swaraj.projectx.collections;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Deque;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DequeTests {

    @Test
    void dequeue_init() {
        // First/Head , x , y , z , ... , Last/Tail
        Deque<Integer> arrayDeque = new ArrayDeque<>(); // doubly ended queue
        arrayDeque.offer(23);

        arrayDeque.offerFirst(12); //add element at first
        arrayDeque.offerLast(45);  //add element at last
        arrayDeque.offerLast(50);
        System.out.println(arrayDeque); // 12,23,45,50

        arrayDeque.offerFirst(2);
        System.out.println(arrayDeque); // 2,12,23,45,50

        System.out.println(arrayDeque.pollLast());
        System.out.println(arrayDeque); // 2,12,23,45

        arrayDeque.pollFirst();
        System.out.println(arrayDeque); // 12,23,45
    }
}
