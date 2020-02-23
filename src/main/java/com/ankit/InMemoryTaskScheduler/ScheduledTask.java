package com.ankit.InMemoryTaskScheduler;

public class ScheduledTask extends Task {
    long intervalMs;

    ScheduledTask(Runnable runnable, long intervalMs) {
        super(runnable);
        this.intervalMs = intervalMs;
    }

    void preInstanceSubmit(){
        schedule();
    }

    boolean schedule() {
        if(taskInstances.size() == 0) {
            long scheduleMs = ((System.currentTimeMillis() + intervalMs - 1 ) / intervalMs)* intervalMs;
            return super.schedule(scheduleMs);
        }

        return super.schedule(taskInstances.get(taskInstances.size()-1).scheduledMs+intervalMs);
    }
}
