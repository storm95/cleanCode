package com.ankit.competitiveCoding.linkedListIntersection;

public class Node {
    int value;
    private Node nextNode;
    Node(Node nextNode, int value) {
        this.value = value;
        this.nextNode = nextNode;
    }

    public Node getNextNode() {
        return nextNode;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                ", nextNode=" + nextNode +
                '}';
    }
}
