package com.ankit.competitiveCoding.threeSum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Arrays;

@RunWith(JUnit4.class)
public class ThreeSumTest {

    @Test
    public void getTripletsTest() {
        ThreeSum threeSum = new ThreeSum();
        threeSum.getTriplets(Arrays.asList(2, 1, 2, 1, 2, 1, 2, 1), 5);
    }
}
