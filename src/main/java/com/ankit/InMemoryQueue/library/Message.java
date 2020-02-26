package com.ankit.InMemoryQueue.library;

public class Message {
    public String message;
    public Long ttl;

    public Message(String message, Long ttl) {
        this.message = message;
        this.ttl = System.currentTimeMillis()+ttl;
    }

    @Override
    public String toString() {
        return message;
    }
}
