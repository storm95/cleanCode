package com.ankit.competitiveCoding.tree;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Arrays;
import java.util.List;

@RunWith(JUnit4.class)
public class TreeTest {

    @Test
    public void getTotalWeightTest() {
        Node node1 = new Node(1, 1);
        Node node2 = new Node(2, 2);
        Node node3 = new Node(3, 3);
        Node node4 = new Node(4, 4);
        Node node5 = new Node(5, 5);

        List<Edge> edges = Arrays.asList(
                new Edge(node1, node4),
                new Edge(node2, node3),
                new Edge(node2, node1),
                new Edge(node1, node5)
        );
        Tree tree = new Tree(edges);

        Assert.assertEquals(new Integer(10), tree.getTotalWeight(node1));
        Assert.assertEquals(node3, tree.getNearestLeaf(node2));
    }
}
