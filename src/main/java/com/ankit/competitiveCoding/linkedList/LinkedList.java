package com.ankit.competitiveCoding.linkedList;

public class LinkedList {
    Node headNode;
    Node tailNode;

    LinkedList() {
        headNode = tailNode = null;
    }

    public void addNode(Node a) {
        if (headNode == null) {
            headNode = tailNode = a;
            return;
        }

        tailNode.nextNode = a;
        tailNode = a;
    }

    public void printNodes() {
        Node node = headNode;
        while (node != null) {
            System.out.println(node.value);
            node = node.nextNode;
        }
    }

    public void reverse() {
        reverse(null, headNode);
        Node tempNode = headNode;
        headNode = tailNode;
        tailNode = tempNode;
    }

    private void reverse(Node prevNode, Node thisNode) {
        if (thisNode == null)
            return;

        reverse(thisNode, thisNode.nextNode);

        thisNode.nextNode = prevNode;
    }
}
