package com.swaraj.projectx.threads;

import org.junit.jupiter.api.Test;

import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MyThreadedRunnable implements Runnable {

    private boolean keepRunningFlag = Boolean.TRUE;

    @Override
    public void run() {
        while (keepRunning()) {
            System.out.println("running inside MyThreadedRunnable..");
            try {
                Thread.sleep(1L * 1024L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public synchronized void customStop() {
        keepRunningFlag = false;
    }

    public synchronized boolean keepRunning() {
        return keepRunningFlag;
    }
}

class ThreadSafetyCheck {
    StringBuilder builder = new StringBuilder(); // "builder" is object member variable

    void addText(String textToAdd) {
        System.out.println(builder.hashCode());
        builder.append(textToAdd);
    }
}

public class BasicThreadTests {

    int counter = 0;
    volatile boolean keepRunningFlag = true;

    @Test
    void create_classic_thread_test() throws InterruptedException {
        Thread threadInstance = new Thread(() -> {
            System.out.println("completing long work...");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.printf("inside thread:%s%n", Thread.currentThread().getName());
        });

        threadInstance.start();
        System.out.println("waiting in main thread...");
        threadInstance.join();
    }

    @Test
    void start_10_threads_test() {
        System.out.printf("main thread %s%n", Thread.currentThread().getName());
        for (int outer = 0; outer < 10; outer++) {
            new Thread(() -> {
                System.out.printf("inside thread %s%n", Thread.currentThread().getName());
            }).start();
        }
    }

    @Test
    void custom_runnable_test() throws InterruptedException {
        MyThreadedRunnable myThreadedRunnable = new MyThreadedRunnable();
        Thread thrd = new Thread(myThreadedRunnable);
        thrd.start();
        System.out.println("sleeping for 10 sec before calling stop");
        Thread.sleep(10000); // 10 secs
        myThreadedRunnable.customStop();
    }

    @Test
    void race_condition_demo() {
        Thread thrd1 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                counter++;
            }
        });

        Thread thrd2 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                counter++;
            }
        });
        thrd1.start();
        thrd2.start();
        try {
            thrd1.join();
            thrd2.join();
        } catch (InterruptedException exc) {
            System.out.printf("error , message: %s", exc.getMessage());
        }

        assertEquals(20000, counter);
    }

    @Test
    void test_volatile_keyword() throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            while (keepRunningFlag){
                System.out.printf("keepRunningFlag: %s%n", keepRunningFlag);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        thread1.start();

        Thread thread2 = new Thread(() -> {
            try {
                System.out.println("thread2 going to sleep");
                Thread.sleep(10 * 1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            keepRunningFlag = false;
            System.out.println("setting to false...");
        });
        thread2.start();

        thread1.join();
        thread2.join();
    }
}
