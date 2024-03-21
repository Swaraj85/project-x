package com.swaraj.projectx.collections;

import org.junit.jupiter.api.Test;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class QueueTests {

    @Test
    void queue_insertion() {
        Deque<String> myQueue = new LinkedList<>();
        myQueue.addLast("one"); // same as "enqueue" operation
        myQueue.addLast("two");
        myQueue.addLast("three");

        assertEquals("one", myQueue.removeFirst()); // same as "dequeue" operation
    }

    @Test
    void queue_insertion2() {
        Queue<String> mySecondQueue = new LinkedList<>();
        mySecondQueue.offer("one"); // add element in queue
        mySecondQueue.offer("two");
        mySecondQueue.offer("three");
        System.out.println(mySecondQueue);
        assertEquals("one", mySecondQueue.peek()); // check top element without removing it

        System.out.println(mySecondQueue);

        assertEquals("one", mySecondQueue.poll()); // remove element from queue , in FIFO manner
        System.out.println(mySecondQueue);
        assertEquals("two", mySecondQueue.poll());
        System.out.println(mySecondQueue);
    }
}
