package com.ankit.InMemoryTaskScheduler;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertTrue;

@RunWith(JUnit4.class)
public class TaskManagerTest {

    private static TaskManager taskManager = TaskManager.getInstance();

    @BeforeClass
    public static void init() {
        taskManager.init(3);
    }

    @AfterClass
    public static void shutdown() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            System.out.println("Thread Interupted");
        } finally {
            taskManager.shutdown();
        }
    }

    @Test
    public void testSubmitDelayedTask() {

        System.out.println("Creating Delayed Task at "+System.currentTimeMillis());

        Runnable runnable1 = () -> {
            System.out.println("Delayed Task1 is Running");
        };
        assertTrue(taskManager.submitDelayedTask(runnable1, 2000));


        Runnable runnable2 = () -> {
            System.out.println("Delayed Task2 is Running");
        };
        assertTrue(taskManager.submitDelayedTask(runnable2, 1000));
    }

    @Test
    public void testSubmitScheduledTask() {

        Runnable runnable1 = () -> {
            System.out.println("Scheduled Task1 is Running");
        };
        assertTrue(taskManager.submitScheduledTask(runnable1, 1000));

        Runnable runnable2 = () -> {
            System.out.println("Scheduled Task2 is Running");
        };
        assertTrue(taskManager.submitScheduledTask(runnable2, 2000));

        Runnable runnable3 = () -> {
            System.out.println("Scheduled Task3 is Running");
        };
        assertTrue(taskManager.submitScheduledTask(runnable3, 3000));
    }
}
