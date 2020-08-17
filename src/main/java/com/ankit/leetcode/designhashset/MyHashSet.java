package com.ankit.leetcode.designhashset;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MyHashSet {

    private final int maxElementVal = 1000000;
    private List<Integer> hashSet;

    /** Initialize your data structure here. */
    public MyHashSet() {
        hashSet = new ArrayList<>(Collections.nCopies(maxElementVal+1, 0));
    }

    public void add(int key) {
        hashSet.set(key, 1);
    }

    public void remove(int key) {
        hashSet.set(key, 0);
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        return (hashSet.get(key) == 1);
    }
}
