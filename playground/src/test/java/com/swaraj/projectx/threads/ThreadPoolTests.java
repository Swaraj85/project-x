package com.swaraj.projectx.threads;

import com.swaraj.projectx.cars.CarException;
import org.junit.jupiter.api.Test;

import java.util.concurrent.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ThreadPoolTests {

    @Test
    void simple_ExecutorService_test() throws ExecutionException, InterruptedException {
        //fixed thread pool
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Future<String> futureResult = executorService.submit(() -> {
            System.out.println("executing long running jobs");
            Thread.sleep(5000L);
            return "result";
        });
        assertEquals("result", futureResult.get());
    }

    @Test
    void simple_ExecutorService_handle_exception_test() throws ExecutionException, InterruptedException {
        //fixed thread pool with exception
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Future<String> futureResult = executorService.submit(() -> {
            int number = 0;
            System.out.println("executing long running jobs");
            Thread.sleep(5000L);
            if (number == 0) throw new CarException("server unavailable");
            return "result";
        });

        assertThrows(ExecutionException.class, () -> {
            String result = futureResult.get();
        });
    }
}
