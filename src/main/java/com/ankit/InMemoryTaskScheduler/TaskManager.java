package com.ankit.InMemoryTaskScheduler;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.PriorityBlockingQueue;

public class TaskManager {
    private static TaskManager taskManager = new TaskManager();
    private final List<Task> taskList;
    private final TaskScheduler taskScheduler;
    private final TaskPoller taskPoller;
    private final PriorityBlockingQueue<TaskInstance> queue;

    public static TaskManager getInstance() {
        return taskManager;
    }

    private TaskManager() {
        taskList = new ArrayList<>();
        taskScheduler = TaskScheduler.getInstance();
        taskPoller = TaskPoller.getInstance();
        queue = new PriorityBlockingQueue<>();
    }

    public void init(int noOfThreads) {
        taskScheduler.init(queue);
        taskPoller.init(noOfThreads, queue);
    }

    public boolean submitDelayedTask(Runnable runnable, long delayMs) {
        DelayedTask delayedTask = new DelayedTask(runnable, delayMs);
        return delayedTask.schedule();
    }

    public boolean submitScheduledTask(Runnable runnable, long intervalMs) {
        ScheduledTask scheduledTask = new ScheduledTask(runnable, intervalMs);
        return scheduledTask.schedule();
    }

    public void shutdown() {
        taskPoller.shutdown();
    }
}
