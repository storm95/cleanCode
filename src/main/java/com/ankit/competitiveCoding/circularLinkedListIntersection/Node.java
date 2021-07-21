package com.ankit.competitiveCoding.circularLinkedListIntersection;

public class Node {
    private int value;
    private Node nextNode;

    Node(int value, Node nextNode) {
        this.value = value;
        this.nextNode = nextNode;
    }

    public int getValue() {
        return value;
    }

    public Node getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }
}
