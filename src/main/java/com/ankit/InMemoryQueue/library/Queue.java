package com.ankit.InMemoryQueue.library;

import java.util.ArrayList;
import java.util.List;

public class Queue implements Observable {
    String name;
    List<Observer> consumers;
    List<Message> messages;

    Queue(String name) {
        this.name = name;
        consumers = new ArrayList<>();
        messages = new ArrayList<>();
    }

    public void addObserver(Observer observer) {
        consumers.add(observer);
    }

    public void notifyObservers(Object message) {
        consumers.parallelStream().forEach(consumer -> consumer.update(message));
    }

    void pushMessage(Message message) {
        messages.add(message);
        notifyObservers(message);
    }
}
