package com.ankit.competitiveCoding.arrayMatchingElements;

import java.util.*;

public class ArrayMatchingElements {
    public List<Integer> getMatchingElements(List<Integer> arr1, List<Integer> arr2) {
        List<Integer> matchingElements = new ArrayList<>();
        Set<Integer> elements = new HashSet<>(arr1);
        for (Integer element : arr2) {
            if(elements.contains(element)) {
                matchingElements.add(element);
            }
        }

        return matchingElements;
    }
}
