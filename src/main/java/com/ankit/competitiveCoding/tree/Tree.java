package com.ankit.competitiveCoding.tree;

import java.util.*;

public class Tree {

    Node root;
    Map<Node, List<Node>> tree;

    Tree(List<Edge> edges) {

        Set<Node> nonRootNodes = new HashSet<>();
        tree = new HashMap<>();
        for(Edge edge : edges) {
            if (!tree.containsKey(edge.parent)) {
                tree.put(edge.parent, new ArrayList<>());
            }

            tree.get(edge.parent).add(edge.child);
            nonRootNodes.add(edge.child);
        }

        for(Edge edge : edges) {
            if (!nonRootNodes.contains(edge.parent)) {
                root = edge.parent;
                break;
            }
        }
    }

    public Integer getTotalWeight(Node node) {
        Integer totalWeight = node.weight;
        if (tree.containsKey(node)) {
            for (Node child : tree.get(node)) {
                totalWeight += getTotalWeight(child);
            }
        }

        return totalWeight;
    }

    public Node getNearestLeaf(Node node) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        Node nearestLeaf = node;
        while(!queue.isEmpty()) {
            nearestLeaf = queue.peek();
            queue.poll();
            if(!tree.containsKey(nearestLeaf))
                break;
            queue.addAll(tree.get(nearestLeaf));
        }

        return nearestLeaf;
    }

    @Override
    public String toString() {
        return "Tree{" +
                "root=" + root +
                ", tree=" + tree +
                '}';
    }
}
