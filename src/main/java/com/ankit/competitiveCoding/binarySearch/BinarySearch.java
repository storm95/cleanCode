package com.ankit.competitiveCoding.binarySearch;

import java.util.List;

public class BinarySearch {
    private final List<Integer> arr;

    public BinarySearch(List<Integer> arr) {
        this.arr = arr;
        this.arr.sort(Integer::compareTo);
    }

    public boolean isPresent(Integer a) {
        int start = 0;
        int stop = arr.size() - 1;
        while(start<stop) {
            int mid = (start+stop+1)/2;
            if (arr.get(mid).compareTo(a) > 0) {
                stop = mid-1;
            } else {
                start = mid;
            }
        }

        return arr.get(start).equals(a);
    }
}
