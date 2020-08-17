package com.ankit.leetcode.validpalindrome;

public class MyString implements StringContainer {

    String s;

    MyString(String s) {
        this.s = s;
    }

    public StringIterator getForwardIterator() {
        return new ForwardIterator(this);
    }

    public StringIterator getBackwardIterator() {
        return new BackwardIterator(this);
    }
}
