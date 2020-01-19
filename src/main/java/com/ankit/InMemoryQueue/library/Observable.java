package com.ankit.InMemoryQueue.library;

public interface Observable {
    void addObserver(Observer observer);
    void notifyObservers(Object message);
}
