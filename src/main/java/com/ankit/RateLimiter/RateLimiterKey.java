package com.ankit.RateLimiter;

import java.util.Objects;

public class RateLimiterKey extends Object {
    String ip;
    Long second;

    RateLimiterKey(String ip, Long second) {
        this.ip = ip;
        this.second = second;
    }

    @Override
    public String toString() {
        Objects.hash(ip, second);
        return ip+"_"+second;
    }

    static RateLimiterKey fromString(String rateLimiterKeyString) {
        return new RateLimiterKey(rateLimiterKeyString.split("_")[0], Long.valueOf(rateLimiterKeyString.split("_")[1]));
    }
}


//Overrite hashCode and equals so that u can use it in map