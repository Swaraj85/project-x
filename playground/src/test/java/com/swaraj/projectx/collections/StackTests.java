package com.swaraj.projectx.collections;

import org.junit.jupiter.api.Test;

import java.util.*;

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

    @Test
    void simple_stack_initialization() {
        Stack<String> animals = new Stack<>();
        animals.push("lion");
        animals.push("cat");
        animals.push("horse");

        assertEquals("horse", animals.pop());
        assertEquals("cat", animals.pop());
    }
}
