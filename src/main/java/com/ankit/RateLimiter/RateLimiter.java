package com.ankit.RateLimiter;

import java.time.Instant;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class RateLimiter {
    private static RateLimiter ourInstance = new RateLimiter();
    private Map<RateLimiterKey, AtomicInteger> noOfCalls;
    private int throttleLimit;
    private Thread keyRemoverThread;

    public static RateLimiter getInstance() {
        return ourInstance;
    }

    private RateLimiter() {
        noOfCalls = new ConcurrentHashMap<>();
        keyRemoverThread = new Thread(getKeyRemoverRunnable());
        keyRemoverThread.setDaemon(true);
        keyRemoverThread.start();
    }

    public void init(int throttleLimit) {
        this.throttleLimit = throttleLimit;
        //Add cleaner task
    }

    public void shutdown() {
        keyRemoverThread.interrupt();
    }

    private Runnable getKeyRemoverRunnable() {
        return () -> {
          while(!keyRemoverThread.isInterrupted()) {
              noOfCalls.keySet().removeIf(key -> key.second < Instant.now().getEpochSecond());
          }
        };
    }

    public void rateLimiterCall(String ip, Executable executable) throws RateLimiterException {
        RateLimiterKey rateLimiterKey = new RateLimiterKey(ip, Instant.now().getEpochSecond());;
        Integer calls = incrementAndGetNoOfCalls(rateLimiterKey);
        System.out.println("Calls: "+calls+", ip: "+rateLimiterKey.ip+", second: "+rateLimiterKey.second);
        if (calls > throttleLimit) {
            throw new RateLimiterException();
        }

        try {
            executable.run();
        } catch (Exception e) {
            System.out.println("Exception occured while running your Executable: "+e);
        }
    }

    private int incrementAndGetNoOfCalls(RateLimiterKey rateLimiterKey) {
        noOfCalls.putIfAbsent(rateLimiterKey, new AtomicInteger(0));
        Integer calls = noOfCalls.get(rateLimiterKey).incrementAndGet();

        return calls;
    }
}


//Use AtomicInteger to keep synchronisation