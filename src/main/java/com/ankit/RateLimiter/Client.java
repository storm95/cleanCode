package com.ankit.RateLimiter;

public class Client {
    public static void main(String[] args) {
        RateLimiter rateLimiter = RateLimiter.getInstance();
        rateLimiter.init(2);

        try {
            rateLimiter.rateLimiterCall("ip1", () -> {System.out.println("call1");});
        } catch (RateLimiterException e) {
            System.out.println("RateLimiterException occurred in call1");
        }

        try {
            rateLimiter.rateLimiterCall("ip1", () -> {System.out.println("call2");});
        } catch (RateLimiterException e) {
            System.out.println("RateLimiterException occurred in call2");
        }

        try {
            rateLimiter.rateLimiterCall("ip1", () -> {System.out.println("call3");});
        } catch (RateLimiterException e) {
            System.out.println("RateLimiterException occurred in call3");
        }

        try {
            rateLimiter.rateLimiterCall("ip1", () -> {System.out.println("call4");});
        } catch (RateLimiterException e) {
            System.out.println("RateLimiterException occurred in call4");
        }

        rateLimiter.shutdown();
    }
}
