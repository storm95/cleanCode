package com.ankit.InMemoryTaskScheduler;

public class ScheduledTask extends Task {
    long intervalMs;

    ScheduledTask(Runnable runnable, long intervalMs) {
        super(runnable);
        this.intervalMs = intervalMs;
    }

    void postInstanceSubmit(){
        schedule();
    }

    boolean schedule() {
        return super.schedule(System.currentTimeMillis()+intervalMs);
    }
}
