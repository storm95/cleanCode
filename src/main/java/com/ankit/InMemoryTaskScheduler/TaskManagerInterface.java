package com.ankit.InMemoryTaskScheduler;

public interface TaskManagerInterface {
    void init(int noOfThreads);
    void shutdown();
    boolean submitDelayedTask(Runnable runnable, long delayMs);
    boolean submitScheduledTask(Runnable runnable, long intervalMs);
}
