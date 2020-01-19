package com.ankit.InMemoryQueue.library;

public class Consumer implements Observer {
    String name;
    Queue queue;

    Consumer(String name, String queueName) {
        this.name = name;
        queue = QueueProvider.getInstance().getQueue(queueName);
    }

    public void update(Object message) {
        try {
            long r = RandomGenerator.getInstance().nextRandom();
            System.out.printf("message:%s ,name: %s , r: %d\n", message, this.name, r);
            Thread.sleep(r);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("message: %s ,name: %s\n", message, this.name);
    }
}
