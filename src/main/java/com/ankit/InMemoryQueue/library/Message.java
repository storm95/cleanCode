package com.ankit.InMemoryQueue.library;

public class Message {
    public String message;

    public Message(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
