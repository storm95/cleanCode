package com.ankit.InMemoryTaskScheduler;

class TaskInstance implements Runnable, Comparable<TaskInstance> {
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
        try {
            task.run();
            setStatus(TaskInstanceStatus.Status.Complete);
        } catch (Exception e) {
            System.out.println("Exception occured during Task Execution: " + e);
            setStatus(TaskInstanceStatus.Status.Failed);
        }
        postRun();
    }

    public int compareTo(TaskInstance taskInstance) {
        return Long.compare(this.scheduledMs, taskInstance.scheduledMs);
    }

    private void preRun() {
        startTime = System.currentTimeMillis();
        System.out.println("Task is starting at "+startTime);
        setStatus(TaskInstanceStatus.Status.Running);
    }

    private void postRun() {
        endTime = System.currentTimeMillis();
        System.out.println("Task is completed at "+endTime+"\n----------------------------------\n");
        task.postInstanceSubmit();
    }

    void setStatus(TaskInstanceStatus.Status status) {
        taskStatus.status = status;
    }
}
