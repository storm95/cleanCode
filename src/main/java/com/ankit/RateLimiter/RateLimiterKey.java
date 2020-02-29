package com.ankit.RateLimiter;

public class RateLimiterKey {
    String ip;
    Long second;

    RateLimiterKey(String ip, Long second) {
        this.ip = ip;
        this.second = second;
    }

    @Override
    public String toString() {
        return ip+"_"+second;
    }

    static RateLimiterKey fromString(String rateLimiterKeyString) {
        return new RateLimiterKey(rateLimiterKeyString.split("_")[0], Long.valueOf(rateLimiterKeyString.split("_")[1]));
    }
}
