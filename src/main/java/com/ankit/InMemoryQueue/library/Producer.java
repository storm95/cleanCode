package com.ankit.InMemoryQueue.library;

public class Producer {
    String name;
    Queue queue;

    Producer(String name, String queueName) {
        this.name = name;
        queue = QueueManager.getInstance().getQueue(queueName);
    }

    public void pushMessage(Message message) {
        queue.pushMessage(message);
    }
}
