package com.ankit.competitiveCoding.arrayMatchingElements;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Arrays;
import java.util.List;

@RunWith(JUnit4.class)
public class ArrayMatchingElementsTest {
    private static ArrayMatchingElements arrayMatchingElements;

    @BeforeClass
    public static void setUp() {
        arrayMatchingElements = new ArrayMatchingElements();
    }

    @Test
    public void getMatchingElementsTest() {
        List<Integer> expected = Arrays.asList(1, 3);
        List<Integer> actual = arrayMatchingElements.getMatchingElements(Arrays.asList(1, 2, 3), Arrays.asList(3, 1, 4, 5));
        Assert.assertTrue(expected.size() == actual.size() && expected.containsAll(actual) && actual.containsAll(expected));
    }
}
