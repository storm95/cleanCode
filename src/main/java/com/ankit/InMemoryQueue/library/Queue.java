package com.ankit.InMemoryQueue.library;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

public class Queue implements QueueInterface {
    String name;
    List<ConsumerInterface> consumers;
    private final List<Message> messages;
    BlockingQueue<Message> messagesExpiryPriority;

    Queue(String name, Integer maxNoOfMessagesBeforeTtl) {
        this.name = name;
        consumers = new Vector<>();//Used Vector instead of ArrayList as Vector is Thread Safe
        messages = new Vector<>();
        messagesExpiryPriority = new PriorityBlockingQueue<>(maxNoOfMessagesBeforeTtl, Comparator.comparing((Message message) -> message.ttl));
    }

    public void addObserver(ConsumerInterface consumer) {
        consumers.add(consumer);
    }

    public void notifyObservers(Object message) {
        //TODO: Check if parallelStream is thread safe. If it iterates over the consumers and parallely somebody calls add on the consumers or if there is a remove function on consumer
        consumers.parallelStream().forEach(consumer -> {
            if (consumer.getOffset() <= getSize()) {
                consumer.update(message);
                consumer.incrementOffset();
            }
        });
    }

    void pushMessage(Message message) {
        messages.add(message);
        messagesExpiryPriority.add(message);
        notifyObservers(message);
    }

    void removeMessage(Message message) {
        messages.remove(message);
    }

    public Integer getSize() {
        return messages.size();
    }
}
