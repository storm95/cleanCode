package com.ankit.RateLimiter;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class RateLimiter {
    private static RateLimiter ourInstance = new RateLimiter();
    private Map<RateLimiterKey, Integer> noOfCalls;
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

    private Runnable getKeyRemoverRunnable() {
        return () -> {
          while(true) {
              noOfCalls.keySet().removeIf(key -> key.second < System.currentTimeMillis()/1000);
          }
        };
    }

    public void rateLimiterCall(String ip, Executable executable) throws Exception {
        RateLimiterKey rateLimiterKey = new RateLimiterKey(ip, System.currentTimeMillis()/1000);
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
        Integer calls = 0;
        synchronized (noOfCalls) {//TODO: Ask Vinit how to make this better so that we dont have performance implecations due to holding lock on whole of noOfCalls
            if (noOfCalls.containsKey(rateLimiterKey)) {
                calls = noOfCalls.get(rateLimiterKey);
            }

            noOfCalls.put(rateLimiterKey, calls + 1);
            return calls + 1;
        }
    }
}


//Use AtomicInteger to keep synchronisation