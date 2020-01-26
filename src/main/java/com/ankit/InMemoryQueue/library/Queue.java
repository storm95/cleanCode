package com.ankit.InMemoryQueue.library;

import java.util.List;
import java.util.Vector;

public class Queue implements Observable {
    String name;
    List<Observer> consumers;
    List<Message> messages;

    Queue(String name) {
        this.name = name;
        consumers = new Vector<>();//Used Vector instead of ArrayList as Vector is Thread Safe
        messages = new Vector<>();//Used Vector instead of ArrayList as Vector is Thread Safe
    }

    public void addObserver(Observer observer) {
        consumers.add(observer);
    }

    public void notifyObservers(Object message) {
        //TODO: Check if parallelStream is thread safe. If it iterates over the consumers and parallely somebody calls add on the consumers or if there is a remove function on consumer
        consumers.parallelStream().forEach(consumer -> consumer.update(message));
    }

    void pushMessage(Message message) {
        messages.add(message);
        notifyObservers(message);
    }
}
