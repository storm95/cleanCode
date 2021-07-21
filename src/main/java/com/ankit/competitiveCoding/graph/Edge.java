package com.ankit.competitiveCoding.graph;

import java.util.*;

public class Edge {
    Integer nodeA, nodeB, weight;

    Edge(Integer nodeA, Integer nodeB, Integer weight) {
        this.nodeA = nodeA;
        this.nodeB = nodeB;
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Edge edge = (Edge) o;
        return Objects.equals(nodeA, edge.nodeA) && Objects.equals(nodeB, edge.nodeB) && Objects.equals(weight, edge.weight);
    }

    public void x(List<Edge> a) {
        List<Edge> b = new ArrayList<>(a);
        for (Edge edge : a) {
            b.add((Edge) edge.clone());
        }
        b.get(1).nodeA = 10;
    }

    @Override
    protected Object clone() {
        return new Edge(nodeA, nodeB, weight);
    }
}
