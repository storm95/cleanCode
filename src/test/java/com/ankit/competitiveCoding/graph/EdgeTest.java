package com.ankit.competitiveCoding.graph;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Arrays;

@RunWith(JUnit4.class)
public class EdgeTest {

    @Test
    public void equalsTest() {
        Edge e1 = new Edge(1, 2, 3);
        Edge e2 = new Edge(1, 2, 3);
        Assert.assertTrue(e1.equals(e2));
    }

    @Test
    public void xTest() throws CloneNotSupportedException {
        Edge edge = new Edge(1, 2, 3);
        edge.x(Arrays.asList(
                new Edge(1,1, 1),
                new Edge(2,2, 2),
                new Edge(3,3, 3)
        ));
    }
}
