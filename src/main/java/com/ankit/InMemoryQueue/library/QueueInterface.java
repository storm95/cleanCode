package com.ankit.InMemoryQueue.library;

public interface QueueInterface {
    void addObserver(ConsumerInterface observer);
    void notifyObservers(Object message);
}
