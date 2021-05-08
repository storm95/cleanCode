package com.ankit.InMemoryQueue.library;

public interface ConsumerInterface {
    void update(Object message);
    void setOffset(int offset);
    void incrementOffset();
    Integer getOffset();
}
