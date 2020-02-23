package com.ankit.InMemoryTaskSchedulerKaushalHooda;

import java.util.concurrent.PriorityBlockingQueue;

public class DelayedTask extends Task{
    public DelayedTask(Runnable runnable, long maxTaskExecutionTimeMs, long delayMs){
        super(runnable, maxTaskExecutionTimeMs);
        this.scheduledExecutionTimeMs = System.currentTimeMillis() + delayMs;
    }

    @Override
    void preProcess(PriorityBlockingQueue queue, TaskStatus status) {
        status.status = TaskStatus.Status.running;
        status.startTime = System.currentTimeMillis();
    }

    @Override
    void postProcess(PriorityBlockingQueue queue, TaskStatus status) {
        status.status = TaskStatus.Status.done;
    }
}
