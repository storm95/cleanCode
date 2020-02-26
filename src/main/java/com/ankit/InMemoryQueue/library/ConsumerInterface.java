package com.ankit.InMemoryQueue.library;

public interface ConsumerInterface {
    void update(Object message);
    void setOffset(Integer offset);
    void incrementOffset();
    Integer getOffset();
}
