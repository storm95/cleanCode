package com.ankit.competitiveCoding.circularLinkedListIntersection;

public class CircularLinkedListIntersection {
    public Node getIntersection(Node node) {
        Node presentNode = node;
        Node grandChildNode = node.getNextNode().getNextNode();
        while (!(presentNode == grandChildNode)) {
            presentNode = presentNode.getNextNode();
            grandChildNode = grandChildNode.getNextNode().getNextNode();
        }

        return presentNode;
    }
}
