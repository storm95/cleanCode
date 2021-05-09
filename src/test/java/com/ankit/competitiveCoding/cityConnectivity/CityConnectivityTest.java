package com.ankit.competitiveCoding.cityConnectivity;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Arrays;

@RunWith(JUnit4.class)
public class CityConnectivityTest {

    @Test
    public void computeTest() {
        CityConnectivity cityConnectivity = new CityConnectivity(
                3,
                Arrays.asList(
                        new Edge(0, 1, Edge.EdgeType.BOTH),
                        new Edge(0, 1, Edge.EdgeType.MEN_ONLY),
                        new Edge(0, 2, Edge.EdgeType.MEN_ONLY),
                        new Edge(0, 2, Edge.EdgeType.WOMEN_ONLY),
                        new Edge(0, 2, Edge.EdgeType.BOTH)
                )
        );

        System.out.println("Max no. of edges which can be destroyed are: "+cityConnectivity.compute()+"\n\n\n");
    }
}
