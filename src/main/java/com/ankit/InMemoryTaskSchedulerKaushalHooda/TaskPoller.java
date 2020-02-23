package com.ankit.InMemoryTaskSchedulerKaushalHooda;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.*;

public class TaskPoller implements Runnable {
    private final ExecutorService executor;
    private final TasksConfig config;
    private Map<UUID, TaskStatus> ongoingTasks = new ConcurrentHashMap<>();
    private PriorityBlockingQueue<Task> queue;


    public TaskPoller(TasksConfig tasksConfig, PriorityBlockingQueue<Task> taskQueue){
        this.config = tasksConfig;
        this.queue = taskQueue;
        executor = Executors.newFixedThreadPool(tasksConfig.getNumThreads());
    }

    @Override
    public void run() {
        while(!Thread.interrupted()){
            if(ongoingTasks.size() < config.getNumThreads()){
                Task task = queue.peek();
                if (task != null){
                    System.out.println("Task is scheduled at, now is: " + task.scheduledExecutionTimeMs + " " + System.currentTimeMillis());
                }
                if (task != null && task.scheduledExecutionTimeMs <= System.currentTimeMillis()) {
                    queue.poll();
                    UUID taskId = UUID.randomUUID();
                    TaskStatus status = new TaskStatus();
                    ongoingTasks.put(taskId, status);
                    executor.submit(task.constructRunable(queue, status));
                }
            }
        }
    }

    public void shutdown() {
        executor.shutdown();
    }
}
