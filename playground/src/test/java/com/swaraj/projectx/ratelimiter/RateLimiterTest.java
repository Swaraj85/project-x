package com.swaraj.projectx.ratelimiter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RateLimiterTest {

    @Test
    void isThrottlingRequired() throws InterruptedException {
        RateLimiter rateLimiter= new RateLimiter(5,2);

        for (int i = 0; i < 10; i++) {
            if (rateLimiter.isThrottlingRequired()) {
                System.out.println("throttling required for request = " + i);
            }
            else {
                System.out.println("throttling not required  request i = " + i);
            }

            Thread.sleep(5*1000);
        }
    }
}