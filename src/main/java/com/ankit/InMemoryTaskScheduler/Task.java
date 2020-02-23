package com.ankit.InMemoryTaskScheduler;

import java.util.ArrayList;
import java.util.List;

public abstract class Task {
    List<TaskInstance> taskInstances;
    Runnable runnable;
    private final TaskScheduler taskScheduler;

    Task(Runnable runnable) {
        taskInstances = new ArrayList<>();
        taskScheduler = TaskScheduler.getInstance();
        this.runnable = runnable;
    }

    abstract void preInstanceSubmit();

    void run() {
        runnable.run();
    }

    private void addInstance(TaskInstance taskInstance) {
        taskInstances.add(taskInstance);
    }

    boolean schedule(long scheduleTime) {
        TaskInstance taskInstance = new TaskInstance(this, scheduleTime);
        addInstance(taskInstance);
        taskInstance.setStatus(TaskInstanceStatus.Status.Queued);
        return taskScheduler.schedule(taskInstance);
    }
}
