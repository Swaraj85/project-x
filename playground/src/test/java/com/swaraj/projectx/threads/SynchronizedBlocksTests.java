package com.swaraj.projectx.threads;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


class SynchronizedIncrement {
    private int counter = 0;
    private static int classCounter = 0;

    public static synchronized void staticCounter() {
        classCounter++;
    }

    public static int getClassCounter() {
        return classCounter;
    }

    SynchronizedIncrement() {
        staticCounter();
    }

    public synchronized void increment() {
        counter++;
    }

    public int getCounter() {
        return counter;
    }
}

public class SynchronizedBlocksTests {

    private final Object lockObject = new Object();
    private int localCounter = 0;

    @Test
    void synchronized_method_test() {
        SynchronizedIncrement synchronizedIncrement = new SynchronizedIncrement();

        Thread thrd1 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                synchronizedIncrement.increment();
            }
        });

        Thread thrd2 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                synchronizedIncrement.increment();
            }
        });
        thrd1.start();thrd2.start();

        waitForThreads(Arrays.asList(thrd1, thrd2));
        assertEquals(20, synchronizedIncrement.getCounter());
        assertEquals(1, SynchronizedIncrement.getClassCounter());
    }

    @Test
    void synchronized_code_block_test() {
        Thread thrd1 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                synchronized (lockObject){
                    localCounter++;
                }
            }
        });
        Thread thrd2 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                synchronized (lockObject){
                    localCounter++;
                }
            }
        });
        thrd1.start();thrd2.start();
        waitForThreads(List.of(thrd1, thrd2));
        assertEquals(20, localCounter);
    }

    private void waitForThreads(List<Thread> threads) {
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
