package com.ankit.InMemoryTaskSchedulerKaushalHooda;

import java.util.concurrent.PriorityBlockingQueue;

public class TaskScheduler {
    private PriorityBlockingQueue<Task> queue;
    private TasksConfig config;
    private TaskPoller poller;
    private Thread pollerThread;
    public TaskScheduler(TasksConfig config){
        this.config = config;
        queue = new PriorityBlockingQueue<>(config.getTaskQueueSize());
        this.poller = new TaskPoller(config, queue);
        pollerThread = new Thread(poller);
        pollerThread.start();
    }

    public boolean submit(Task task){
        System.out.println("Scheduling task");
        return queue.add(task);
    }

    public void shutdown() {
        pollerThread.interrupt();
        poller.shutdown();
    }
}
