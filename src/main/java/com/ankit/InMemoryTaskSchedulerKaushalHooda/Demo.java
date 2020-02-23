package com.ankit.InMemoryTaskSchedulerKaushalHooda;

public class Demo {
    public static void main(String[] args){
        TasksConfig config = new TasksConfig();
        TaskScheduler scheduler = new TaskScheduler(config);

        Runnable runnable = () -> System.out.println("Executing task on thread " + Thread.currentThread().getName());

        scheduler.submit(new DelayedTask(runnable, 1000L, 10000L));

        try {
            Thread.sleep(100000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            scheduler.shutdown();
        }
    }
}
