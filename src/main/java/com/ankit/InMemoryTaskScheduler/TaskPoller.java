package com.ankit.InMemoryTaskScheduler;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.PriorityBlockingQueue;

public class TaskPoller {
    private static TaskPoller ourInstance = new TaskPoller();
    private final Thread pollingThread;
    private PriorityBlockingQueue<TaskInstance> queue;
    private ExecutorService executorService;

    public static TaskPoller getInstance() {
        return ourInstance;
    }

    private TaskPoller() {
        this.pollingThread = new Thread(getStartPollingRunnable());
    }

    void init(int noOfThreads, PriorityBlockingQueue<TaskInstance> queue) {
        executorService = Executors.newFixedThreadPool(noOfThreads);//TODO: Implement if number of threads are not specified
        this.queue = queue;
        pollingThread.start();
    }

    void shutdown() {
        pollingThread.interrupt();
        executorService.shutdown();
    }

    private Runnable getStartPollingRunnable() {
        return () -> {
            while(!pollingThread.isInterrupted()) {
                TaskInstance taskInstance = queue.peek();
                if (taskInstance != null) {
                    if (taskInstance.scheduledMs <= System.currentTimeMillis()) {
                        taskInstance.preSubmit();
                        executorService.submit(taskInstance);
                        queue.poll();
                    }
                }
            }
        };
    }
}
