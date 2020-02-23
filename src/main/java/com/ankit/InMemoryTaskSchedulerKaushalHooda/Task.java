package com.ankit.InMemoryTaskSchedulerKaushalHooda;

import java.util.concurrent.PriorityBlockingQueue;

public abstract class Task implements Comparable<Task> {
    private Runnable runnable;
    private long maxExecutionTimeMs;
    long scheduledExecutionTimeMs = System.currentTimeMillis();

    public Task(Runnable runnable, long maxExecutionTimeMs){
        this.runnable = runnable;
        this.maxExecutionTimeMs = maxExecutionTimeMs;
    }

    public Runnable constructRunable(PriorityBlockingQueue queue, TaskStatus taskStatus){
        return () -> {
            preProcess(queue, taskStatus);
            try {
                runnable.run();
            } catch (Exception e){
                System.out.println("Exception while executing task: " + e);
            } finally {
                postProcess(queue, taskStatus);
            }
        };
    }

    abstract void preProcess(PriorityBlockingQueue queue, TaskStatus status);
    abstract void postProcess(PriorityBlockingQueue queue, TaskStatus status);


    @Override
    public int compareTo(Task o) {
        return Long.compare(this.maxExecutionTimeMs, o.maxExecutionTimeMs);
    }
}
