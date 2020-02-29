package com.ankit.RateLimiter;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class RateLimiter {
    private static RateLimiter ourInstance = new RateLimiter();
    private Map<String, Integer> noOfCalls;
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
              noOfCalls.keySet().removeIf(key -> RateLimiterKey.fromString(key).second < System.currentTimeMillis()/1000);
          }
        };
    }

    public void rateLimiterCall(String ip, Runnable runnable) throws Exception {
        RateLimiterKey rateLimiterKey = new RateLimiterKey(ip, System.currentTimeMillis()/1000);
        Integer calls = getNoOfCalls(rateLimiterKey.toString());
        System.out.println("Calls: "+calls+", ip: "+rateLimiterKey.ip+", second: "+rateLimiterKey.second);
        if (calls > throttleLimit) {
            throw new RateLimiterException();
        }

        noOfCalls.put(rateLimiterKey.toString(), calls+1);
        System.out.println("Current Time: "+System.currentTimeMillis());
        runnable.run();
    }

    private int getNoOfCalls(String rateLimiterKey) {
        if (!noOfCalls.containsKey(rateLimiterKey)) {
             return 0;
        }

        return noOfCalls.get(rateLimiterKey);
    }
}
