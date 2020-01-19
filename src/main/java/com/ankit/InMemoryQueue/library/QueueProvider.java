package com.ankit.InMemoryQueue.library;

import java.util.HashMap;

public class QueueProvider {
    private static QueueProvider queueProvider = new QueueProvider();
    public HashMap<String, Queue> queueMap;

    public static QueueProvider getInstance() {
        return queueProvider;
    }

    private QueueProvider() {
        queueMap = new HashMap<>();
    }

    public void addQueue(String queueName, Queue queue) {
        queueMap.put(queueName, queue);
    }

    public Queue getQueue(String queueName) {
        return queueMap.get(queueName);
    }
}
