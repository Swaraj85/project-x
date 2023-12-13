package com.swaraj.projectx.ratelimiter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.LinkedList;
import java.util.Queue;

public class RateLimiter {

    private final int windowSize;
    private final int requestLimit;
    private final Queue<Long> requestLog;

    public RateLimiter(int windowSize, int requestLimit) {
        this.windowSize = windowSize;
        this.requestLimit = requestLimit;
        requestLog = new LinkedList<>();
    }

    public boolean isThrottlingRequired() {
        long currentSeconds = LocalDateTime.now().toEpochSecond(ZoneOffset.UTC);
        clearOldTimeStamps(currentSeconds);
        if (requestLog.size() < requestLimit) {
            requestLog.offer(currentSeconds);
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    private void clearOldTimeStamps(long elapsedEpochTime) {
        while (!requestLog.isEmpty() && elapsedEpochTime - requestLog.peek() >= windowSize) {
            requestLog.poll();
        }
    }

}
