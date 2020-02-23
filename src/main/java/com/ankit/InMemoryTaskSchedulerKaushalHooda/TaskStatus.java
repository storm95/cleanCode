package com.ankit.InMemoryTaskSchedulerKaushalHooda;

public class TaskStatus {
    public long startTime;
    public Status status = Status.queued;

    public enum Status{
        queued, running, done, failed
    }
}
