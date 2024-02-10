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
    void queue_insertion2(){
        Queue<String> mySecondQueue = new LinkedList<>();
        mySecondQueue.add("one");
        mySecondQueue.add("two");
        assertEquals("one",mySecondQueue.remove());
    }
}
