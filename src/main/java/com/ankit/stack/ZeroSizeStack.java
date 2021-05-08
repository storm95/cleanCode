package com.ankit.stack;

public class ZeroSizeStack implements Stack {
    public ZeroSizeStack(int size) {
    }

    public boolean isEmpty() {
        return true;
    }

    public int getSize() {
        return 0;
    }

    public void push(int element) {
        throw new Overflow();
    }

    public Integer top() {
        return null;
    }
}
