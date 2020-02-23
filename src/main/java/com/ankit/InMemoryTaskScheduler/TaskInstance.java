package com.ankit.InMemoryTaskScheduler;

public class TaskInstance implements Runnable, Comparable<TaskInstance> {
    public Task task;
    public long scheduledMs, startTime, endTime;
    public TaskInstanceStatus taskStatus;

    TaskInstance(Task task, long scheduledMs) {
        this.scheduledMs = scheduledMs;
        this.task = task;
        taskStatus = new TaskInstanceStatus();
    }

    public void run() {
        preRun();
        task.run();
        postRun();
    }

    public int compareTo(TaskInstance taskInstance) {
        return Long.compare(this.scheduledMs, taskInstance.scheduledMs);
    }

    void preSubmit() {
        task.preInstanceSubmit();
    }

    private void preRun() {
        startTime = System.currentTimeMillis();
        System.out.println("Task is starting at "+startTime);
        setStatus(TaskInstanceStatus.Status.Running);
    }

    private void postRun() {
        endTime = System.currentTimeMillis();
        System.out.println("Task is completed at "+endTime+"\n----------------------------------\n");
        setStatus(TaskInstanceStatus.Status.Complete);
    }

    void setStatus(TaskInstanceStatus.Status status) {
        taskStatus.status = status;
    }
}
