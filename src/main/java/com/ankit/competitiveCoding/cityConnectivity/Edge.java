package com.ankit.competitiveCoding.cityConnectivity;

public class Edge {
    int cityA, cityB;
    EdgeType edgeType;

    public static enum EdgeType {
        BOTH,
        MEN_ONLY,
        WOMEN_ONLY
    }

    Edge(int cityA, int cityB, EdgeType edgeType) {
        this.cityA = cityA;
        this.cityB = cityB;
        this.edgeType = edgeType;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "cityA=" + cityA +
                ", cityB=" + cityB +
                ", edgeType=" + edgeType +
                '}';
    }
}
