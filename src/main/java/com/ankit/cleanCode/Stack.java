package com.ankit.cleanCode;

public interface Stack {

    boolean isEmpty();

    int getSize();

    void push(int element);

    Integer top();

    class Overflow extends RuntimeException {
    }

    class InvalidSize extends RuntimeException {
    }
}
