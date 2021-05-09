package com.ankit.RateLimiter;

import java.util.Objects;

public class RateLimiterKey {
    String ip;
    long second;

    RateLimiterKey(String ip, long second) {
        this.ip = ip;
        this.second = second;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ip, second);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (obj == this) return true;
        if (obj.getClass() != this.getClass()) return false;

        RateLimiterKey rateLimiterKey = (RateLimiterKey) obj;
        return rateLimiterKey.ip.equals(this.ip) && (rateLimiterKey.second == this.second);
    }
}