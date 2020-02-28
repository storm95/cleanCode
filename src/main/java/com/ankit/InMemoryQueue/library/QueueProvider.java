package com.ankit.InMemoryQueue.library;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class QueueProvider {
    private static QueueProvider queueProvider = new QueueProvider();
    public HashMap<String, Queue> queueMap;
    private List<Queue> queues;
    private final Thread expiredMessageRemover;

    public static QueueProvider getInstance() {
        return queueProvider;
    }

    private QueueProvider() {
        queueMap = new HashMap<>();
        queues = new ArrayList<>();
        expiredMessageRemover = new Thread(getProcessRemovingExpiredMessages());
        expiredMessageRemover.setDaemon(true);
    }

    public void init() {
        expiredMessageRemover.start();
    }

    private Runnable getProcessRemovingExpiredMessages() {
        return () -> {
          while(true) {
            queues.parallelStream().forEach((queue) -> {
                while (true) {
                    Message leastTtlMessage = queue.messagesExpiryPriority.peek();
                    if (leastTtlMessage == null) break;
                    if (leastTtlMessage.ttl >= System.currentTimeMillis()) break;
                    System.out.println("Removing Message: "+leastTtlMessage);
                    queue.messagesExpiryPriority.poll();
                    queue.removeMessage(leastTtlMessage);
                }
            });
          }
        };
    }

    public void addQueue(String queueName, Queue queue) {
        queueMap.put(queueName, queue);
        queues.add(queue);
    }

    public Queue getQueue(String queueName) {
        return queueMap.get(queueName);
    }
}
