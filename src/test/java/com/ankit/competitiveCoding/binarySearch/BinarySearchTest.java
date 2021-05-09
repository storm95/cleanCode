package com.ankit.competitiveCoding.binarySearch;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.ArrayList;
import java.util.List;

@RunWith(JUnit4.class)
public class BinarySearchTest {

    @Test
    public void isPresentTest1() {
        List<Integer> arr = new ArrayList<>();
        arr.add(10);
        arr.add(20);
        arr.add(100);
        arr.add(5);
        arr.add(15);
        BinarySearch binarySearch = new BinarySearch(arr);
        Assert.assertTrue(binarySearch.isPresent(15));
        Assert.assertFalse(binarySearch.isPresent(155));
    }
}
