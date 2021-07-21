package com.ankit.competitiveCoding.linkedListIntersection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class LinkedListIntersectionTest {

    @Test
    public void getIntersectionTest() {
        Node a1 = new Node(null, 1);
        Node a2 = new Node(a1, 2);

        Node b3 = new Node(a2, 32);
        Node b4 = new Node(b3, 42);

        Node c3 = new Node(a2, 33);
        Node c4 = new Node(c3, 43);
        Node c5 = new Node(c4, 53);
        Node c6 = new Node(c5, 63);

        Node intersection = new LinkedListIntersection().getIntersection(b4, c6);
        System.out.println(intersection);
    }
}
