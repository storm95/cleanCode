package com.ankit.InMemoryTaskScheduler;

public class TaskInstanceStatus {
    public Status status;

    TaskInstanceStatus() {
        status = Status.Created;
    }

    public enum Status {
        Created,
        Queued,
        Running,
        Complete
    }
}
