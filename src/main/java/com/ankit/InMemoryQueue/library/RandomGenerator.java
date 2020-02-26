package com.ankit.InMemoryQueue.library;

import java.util.Random;

public class RandomGenerator {
    Random random;
    private static RandomGenerator ourInstance = new RandomGenerator();

    public static RandomGenerator getInstance() {
        return ourInstance;
    }

    private RandomGenerator() {
        random = new Random();
    }

    long nextRandom() {
        return random.nextInt(1000);
    }
}
