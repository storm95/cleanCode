package com.ankit.InMemoryQueue.library;

public class App {
    static QueueProvider queueManager;

    public static void init() {
        queueManager = QueueProvider.getInstance();
    }

    public static Queue registerQueue(String name) {
        Queue queue = new Queue(name);
        queueManager.addQueue(name, queue);

        return queue;
    }

    public static Producer registerProducer(String name, String queueName) {
        return new Producer(name, queueName);
    }

    public static Consumer registerConsumer(String name, String queueName) {
        Consumer consumer = new Consumer(name, queueName);
        Queue queue = queueManager.getQueue(queueName);
        queue.addObserver(consumer);

        return consumer;
    }
}
