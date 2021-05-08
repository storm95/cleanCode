package com.ankit.InMemoryQueue.library;

import java.util.HashMap;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class QueueManager {
    private static final QueueManager QUEUE_MANAGER = new QueueManager();
    public HashMap<String, Queue> queueMap;
    private final List<Queue> queues;
    private ExecutorService executorService;

    public static QueueManager getInstance() {
        return QUEUE_MANAGER;
    }

    private QueueManager() {
        queueMap = new HashMap<>();
        queues = new Vector<>();//Used Vector instead of ArrayList as Vector is Thread Safe
    }

    public void init(int maxNoOfQueues) {
        executorService = Executors.newFixedThreadPool(maxNoOfQueues);
    }

    public void shutdown() {
        executorService.shutdownNow();
        System.out.println("isShutdown: "+executorService.isShutdown()+"     isTerminated: "+executorService.isTerminated());
    }

    private Runnable getProcessRemovingExpiredMessages(Queue queue) {
        return () -> {
            while (!Thread.interrupted()) {
                Message leastTtlMessage = queue.messagesExpiryPriority.peek();
                if (leastTtlMessage == null) continue;
                if (leastTtlMessage.ttl >= System.currentTimeMillis()) continue;
                System.out.println("Thread: "+Thread.currentThread().getName()+", Removing Message: "+leastTtlMessage);
                queue.messagesExpiryPriority.poll();
                queue.removeMessage(leastTtlMessage);
            }
        };
    }

    public void addQueue(String queueName, Queue queue) {
        queueMap.put(queueName, queue);
        queues.add(queue);
        executorService.submit(getProcessRemovingExpiredMessages(queue));
    }

    public Queue getQueue(String queueName) {
        return queueMap.get(queueName);
    }
}
