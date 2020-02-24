package com.ankit.InMemoryTaskScheduler;

import java.util.concurrent.PriorityBlockingQueue;

class TaskScheduler {
    private static TaskScheduler ourInstance = new TaskScheduler();
    private PriorityBlockingQueue<TaskInstance> queue;

    public static TaskScheduler getInstance() {
        return ourInstance;
    }

    private TaskScheduler() {
    }

    void init(PriorityBlockingQueue<TaskInstance> queue) {
        this.queue = queue;
    }

    boolean schedule(TaskInstance taskInstance) {
        return queue.add(taskInstance);
    }
}
