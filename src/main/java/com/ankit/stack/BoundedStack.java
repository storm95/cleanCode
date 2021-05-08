package com.ankit.stack;

public class BoundedStack implements Stack {
    int size;
    int currentSize;
    int elements[];

    public BoundedStack(int size) {
        this.size = size;
        this.currentSize = 0;
        this.elements = new int[size];
    }

    public boolean isEmpty() {
        return (currentSize==0);
    }

    public int getSize() {
        return size;
    }

    public void push(int element) {
        if (currentSize==size)
            throw new Overflow();
        elements[currentSize++] = element;
    }

    public Integer top() {
        if (currentSize==0)
            return null;
        return elements[currentSize-1];
    }
}
