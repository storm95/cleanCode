package com.ankit.competitiveCoding.linkedListIntersection;

public class LinkedListIntersection {
    public Node getIntersection(Node a, Node b) {
        int lenA = getLength(a);
        int lenB = getLength(b);
        Node a1 = a;
        Node b1 = b;
        if (lenA>lenB)
            a1 = getNthNode(a, lenA-lenB+1);
        else
            b1 = getNthNode(b, lenB-lenA+1);

        return getIntersectionEqualLength(a1, b1);
    }

    private Node getIntersectionEqualLength(Node a, Node b) {
        if (a==b)
            return a;
        return getIntersectionEqualLength(a.getNextNode(), b.getNextNode());
    }

    private Node getNthNode(Node a, int n) {
        if (a==null || n==1)
            return a;

        return getNthNode(a.getNextNode(), n-1);
    }

    private int getLength(Node a) {
        if (a==null)
            return 0;
        return 1+getLength(a.getNextNode());
    }
}
