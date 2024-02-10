package com.swaraj.projectx.collections;

import org.junit.jupiter.api.Test;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StackTests {

    @Test
    void stack_usage() {
        //Stack<String> myStack = new Stack<>(); stack class is marked obsolete
        Deque<String> myStack = new LinkedList<>();
        myStack.push("one");
        myStack.push("two");// added last
        assertEquals(2, myStack.size());

        assertEquals("two", myStack.pop()); // last item is removed
        assertEquals("one", myStack.pop());
        assertEquals(0, myStack.size());
    }

    @Test
    void iterateViaWhileLoop() {
        Deque<String> myStack = new LinkedList<>();
        myStack.push("hola");
        myStack.push("man");
        while (!myStack.isEmpty()) {
            System.out.println("myStack.pop() = " + myStack.pop());
        }
    }
}
