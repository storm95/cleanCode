package com.ankit.InMemoryTaskSchedulerKaushalHooda;

public class TasksConfig {
    private int numThreads = 100;
    private int taskQueueSize = 1000;

    public int getNumThreads() {
        return numThreads;
    }

    public void setNumThreads(int numThreads) {
        this.numThreads = numThreads;
    }

    public int getTaskQueueSize() {
        return taskQueueSize;
    }

    public void setTaskQueueSize(int taskQueueSize) {
        this.taskQueueSize = taskQueueSize;
    }
}
