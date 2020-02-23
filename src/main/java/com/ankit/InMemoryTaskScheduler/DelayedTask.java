package com.ankit.InMemoryTaskScheduler;

class DelayedTask extends Task {
    long delayMs;

    DelayedTask(Runnable runnable, long delayMs) {
        super(runnable);
        this.delayMs = delayMs;
    }

    void preInstanceSubmit(){}

    boolean schedule() {
        return super.schedule(System.currentTimeMillis() + delayMs);
    }
}
