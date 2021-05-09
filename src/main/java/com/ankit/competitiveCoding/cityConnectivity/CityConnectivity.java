package com.ankit.competitiveCoding.cityConnectivity;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CityConnectivity {

    private final int noOfCities;
    private final List<Edge> allEdges;

    CityConnectivity(int noOfCities, List<Edge> allEdges) {
        this.noOfCities = noOfCities;
        this.allEdges = allEdges;
    }

    int compute() {
        List<Integer> group = new ArrayList<>();
        for (int i=0;i<noOfCities;++i) {
            group.add(i);
        }

        List<Edge> both = allEdges.parallelStream().filter((edge) -> edge.edgeType == Edge.EdgeType.BOTH).collect(Collectors.toList());
        int maxNoOfRoadsDestroyable = createDsu(group, both);

        List<Integer> groupMen = new ArrayList<>(group);
        List<Edge> menOnly = allEdges.parallelStream().filter((edge) -> edge.edgeType == Edge.EdgeType.MEN_ONLY).collect(Collectors.toList());
        maxNoOfRoadsDestroyable += createDsu(groupMen, menOnly);

        List<Integer> groupWomen = new ArrayList<>(group);
        List<Edge> womenOnly = allEdges.parallelStream().filter((edge) -> edge.edgeType == Edge.EdgeType.WOMEN_ONLY).collect(Collectors.toList());
        maxNoOfRoadsDestroyable += createDsu(groupWomen, womenOnly);

        return maxNoOfRoadsDestroyable;
    }

    private int createDsu(List<Integer> group, List<Edge> edges) {
        int maxNoOfRoadsDestroyable = 0;
        for (Edge edge:edges) {
            if (getPar(group, edge.cityA) != getPar(group, edge.cityB)) {
                union(group, edge.cityA, edge.cityB);
            } else {
                maxNoOfRoadsDestroyable++;
            }
        }

        return maxNoOfRoadsDestroyable;
    }

    private int getPar(List<Integer> group, int city) {
        if (group.get(city) == city) {
            return city;
        }

        group.set(city, getPar(group, group.get(city)));
        return group.get(city);
    }

    private void union(List<Integer> group, int cityA, int cityB) {
        int parA = getPar(group, cityA);
        int parB = getPar(group, cityB);

        group.set(parA, parB);
    }
}
