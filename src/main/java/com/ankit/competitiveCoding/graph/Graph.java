package com.ankit.competitiveCoding.graph;

import java.util.*;

public class Graph {

    private Map<Integer, List<Map.Entry<Integer, Integer>>> graph;

    Graph(List<Edge> edges) {
        graph = new HashMap<>();

        for(Edge edge: edges) {
            if(!graph.containsKey(edge.nodeA))
                graph.put(edge.nodeA, new ArrayList<>());
            if(!graph.containsKey(edge.nodeB))
                graph.put(edge.nodeB, new ArrayList<>());

            graph.get(edge.nodeA).add(new AbstractMap.SimpleEntry<>(edge.nodeB, edge.weight));
            graph.get(edge.nodeB).add(new AbstractMap.SimpleEntry<>(edge.nodeA, edge.weight));
        }
    }

    public void printNodes(Integer node) {
        Set<Integer> visited = new HashSet<>();

        dfs(node, visited);
    }

    void dfs(Integer node, Set<Integer> visited) {
        visited.add(node);
        System.out.println("node: "+node);
        for(Map.Entry<Integer, Integer> edges : graph.get(node)) {
            if (visited.contains(edges.getKey()))
                continue;
            dfs(edges.getKey(), visited);
        }
    }

    Map<Integer, Integer> getMinDistance(Integer node) {
        PriorityQueue<Map.Entry<Integer, Integer>> priorityQueue = new PriorityQueue<>(Map.Entry.comparingByValue());
        Map<Integer, Integer> minDis = new HashMap<>();
        Set<Integer> calculatedMinDis = new HashSet<>();

        priorityQueue.add(new AbstractMap.SimpleEntry<>(node, 0));

        while(!priorityQueue.isEmpty()) {
            Map.Entry<Integer, Integer> top = priorityQueue.peek();
            Integer minNode = top.getKey();
            Integer distance = top.getValue();
            priorityQueue.poll();

            if (calculatedMinDis.contains(minNode))
                continue;

            calculatedMinDis.add(minNode);
            minDis.put(minNode, distance);
            for(Map.Entry<Integer, Integer> mapEntry: graph.get(top.getKey())) {

                Integer peerNode = mapEntry.getKey();
                Integer weight = mapEntry.getValue();

                if(distance + weight < minDis.getOrDefault(peerNode, Integer.MAX_VALUE)) {
                    priorityQueue.add(new AbstractMap.SimpleEntry<>(peerNode, distance + weight));
                    minDis.put(peerNode, distance + weight);
                }
            }
        }

        return minDis;
    }
}
