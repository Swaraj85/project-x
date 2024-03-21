package com.swaraj.projectx.threads;

import org.junit.jupiter.api.Test;

import java.util.concurrent.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MyAsyncProcessorService {

    public Future<String> someMethodAsync(boolean throwException) {
        CompletableFuture<String> stringCompletableFuture = new CompletableFuture<>();

        Executors.newCachedThreadPool().submit(() -> {
            System.out.println("starting task");
            String result = someLengthyOperation(5000L);
            stringCompletableFuture.complete(result);
        });

        return stringCompletableFuture;
    }

    public CompletableFuture<String> methodWithoutBoilerPlateCodeAsync() {
        return CompletableFuture.supplyAsync(() -> "some result");
    }

    private String someLengthyOperation(long time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return "some result";
    }
}

public class CompletableFutureTests {

    @Test
    void basic_completable_test() throws ExecutionException, InterruptedException {
        MyAsyncProcessorService myAsyncProcessorService = new MyAsyncProcessorService();
        Future<String> stringFuture = myAsyncProcessorService.someMethodAsync(false);
        String output = stringFuture.get();
        System.out.println("output = " + output);
        assertEquals("some result", output);
    }

    @Test
    void basic_call_async_method() throws ExecutionException, InterruptedException {
        MyAsyncProcessorService myAsyncProcessorService = new MyAsyncProcessorService();
        CompletableFuture<String> stringCompletableFuture = myAsyncProcessorService.methodWithoutBoilerPlateCodeAsync()
                .thenApply(s -> s + " stage 2");
        assertEquals("some result stage 2", stringCompletableFuture.get());
    }

    @Test
    void basic_chaining_of_completable_future() throws ExecutionException, InterruptedException {
        // chain futures and pass result to another future
        // combining futures
        CompletableFuture<String> stringCompletableFuture = CompletableFuture.supplyAsync(() -> "1")
                .thenCompose(s -> CompletableFuture.supplyAsync(() -> s + "2"));
        assertEquals("12", stringCompletableFuture.get());
    }
}
