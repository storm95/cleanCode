package com.ankit.RateLimiter;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class RateLimiterTest {

    private static RateLimiter rateLimiter = RateLimiter.getInstance();

    @BeforeClass
    public static void init() {
        rateLimiter.init(10);
    }

    @Test
    public void testRateLimiterCall() {

        for(int i=0;i<20;++i) {

            Thread thread = new Thread(
                    getRunnable(i)
            );
            thread.start();
        }
    }

    private Runnable getRunnable(int i) {
        return () -> {
            String msg = "Executable Running, i = "+Integer.toString(i);
            Executable executable = () -> System.out.println(msg);

            try {
                rateLimiter.rateLimiterCall("ip1", executable);
            } catch (Exception e) {
                System.out.println(e);
            }
        };
    }
}
