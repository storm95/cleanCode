package com.ankit.competitiveCoding.threeSum;

import java.util.*;
import java.util.stream.Collectors;

public class ThreeSum {
    public List<List<Integer>> getTriplets(List<Integer> list, int sum) {
        Map<Integer, Integer> mp = new TreeMap<>();
        for (Integer x: list) {
            mp.putIfAbsent(x, 0);
            mp.put(x, mp.get(x)+1);
        }
        List<List<Integer>> triplets = new ArrayList<>();
        Set<Map.Entry<Integer, Integer>> freqSet = mp.entrySet();
        List<Map.Entry<Integer, Integer> > freq= new ArrayList<>(freqSet);

        for(int i=0;i<freq.size();++i) {
            for(int j=i+1, k=freq.size()-1;j<k;) {
                int presentSum = freq.get(i).getKey()+freq.get(j).getKey()+freq.get(k).getKey();
                if(presentSum == sum) {
                    triplets.add(Arrays.asList(
                            freq.get(i).getKey(),
                            freq.get(j).getKey(),
                            freq.get(k).getKey(),
                            freq.get(i).getValue() * freq.get(j).getValue() * freq.get(k).getValue())
                    );
                    ++j;
                    --k;
                } else if(presentSum > sum) {
                    --k;
                } else {
                    ++j;
                }
            }
        }

        return triplets;
    }
}
