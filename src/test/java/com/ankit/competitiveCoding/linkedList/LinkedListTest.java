package com.ankit.competitiveCoding.linkedList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class LinkedListTest {

    @Test
    public void linkedListTest() {
        Node a1 = new Node(1, null);
        Node a2 = new Node(2, null);
        Node a3 = new Node(3, null);
        Node a4 = new Node(4, null);
        Node a5 = new Node(5, null);

        a1.setNextNode(a2);
        a2.setNextNode(a3);
        a3.setNextNode(a4);
        a4.setNextNode(a5);

        LinkedList linkedList = new LinkedList();
        linkedList.addNode(a1);
        linkedList.addNode(a2);
        linkedList.addNode(a3);
        linkedList.addNode(a4);
        linkedList.addNode(a5);

        linkedList.printNodes();
    }
}
