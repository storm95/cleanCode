package com.ankit.competitiveCoding.tree;

public class Node {
    Integer id, weight;

    Node(Integer id, Integer weight) {
        this.id = id;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Node{" + id + ", " + weight + '}';
    }
}
