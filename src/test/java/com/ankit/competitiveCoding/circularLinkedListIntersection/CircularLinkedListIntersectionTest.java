package com.ankit.competitiveCoding.circularLinkedListIntersection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class CircularLinkedListIntersectionTest {

    @Test
    public void getIntersectionTest() {

        Node a1 = new Node(1, null);
        Node a2 = new Node(2, a1);
        Node a3 = new Node(3, a2);
        Node a4 = new Node(4, a3);
        Node a5 = new Node(5, a4);
        Node a6 = new Node(6, a5);

        a1.setNextNode(a4);

        CircularLinkedListIntersection circularLinkedListIntersection = new CircularLinkedListIntersection();
        System.out.println(circularLinkedListIntersection.getIntersection(a6));
    }
}
