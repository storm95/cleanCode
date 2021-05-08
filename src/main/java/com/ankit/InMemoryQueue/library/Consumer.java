package com.ankit.InMemoryQueue.library;

import java.util.concurrent.atomic.AtomicInteger;

public class Consumer implements ConsumerInterface {
    String name;
    Queue queue;
    private AtomicInteger offset;

    Consumer(String name, String queueName) {
        this.name = name;
        offset = new AtomicInteger(0);
        queue = QueueManager.getInstance().getQueue(queueName);
    }

    public void update(Object message) {
//        try {
//            long r = RandomGenerator.getInstance().nextRandom();
//            System.out.printf("message:%s ,name: %s , r: %d\n", message, this.name, r);
//            Thread.sleep(r);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        System.out.printf("message: %s ,name: %s\n", message, this.name);
    }

    public void setOffset(int offset) {
        this.offset.getAndSet(offset);
    }

    public void incrementOffset() {
        this.offset.incrementAndGet();
    }

    public Integer getOffset() {
        return offset.get();
    }
}
