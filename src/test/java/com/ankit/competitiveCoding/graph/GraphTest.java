package com.ankit.competitiveCoding.graph;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Arrays;
import java.util.Map;

@RunWith(JUnit4.class)
public class GraphTest {

    @Test
    public void printNodeTest() {
        Graph graph = new Graph(Arrays.asList(
                new Edge(1, 2, 10),
                new Edge(1, 4, 20),
                new Edge(4, 3, 20)
        ));

        graph.printNodes(1);
    }

    @Test
    public void minDistanceTest() {

        Graph graph = new Graph(Arrays.asList(
                new Edge(1, 2, 10),
                new Edge(2, 3, 40),
                new Edge(1, 4, 20),
                new Edge(4, 3, 20)
        ));

        Map<Integer, Integer> minDis = graph.getMinDistance(1);
        System.out.println(minDis);
    }
}
