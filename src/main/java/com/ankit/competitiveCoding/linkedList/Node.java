package com.ankit.competitiveCoding.linkedList;

public class Node {
    int value;
    Node nextNode;

    Node(int value, Node nextNode) {
        this.value = value;
        this.nextNode = nextNode;
    }

    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }
}
