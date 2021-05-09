package com.ankit.competitiveCoding.petrolPump;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class PetrolPump {
    List<Integer> distances, petrol;
    PriorityQueue<Integer> leftOverPetrol;

    PetrolPump(List<Integer> distances, List<Integer> petrol) {
        this.distances = distances;
        this.petrol = petrol;
        leftOverPetrol = new PriorityQueue<>(petrol.size(), Comparator.comparing((Integer a) -> -a));
    }

    int compute() {
        int noOfPetrolPumpsFill = 0;
        int petrolPresent = 0;
        for(int i=0;i<distances.size();++i) {
            leftOverPetrol.add(petrol.get(i));
            while ((!leftOverPetrol.isEmpty()) && (petrolPresent<distances.get(i))) {
                noOfPetrolPumpsFill++;
                petrolPresent += leftOverPetrol.peek();
                leftOverPetrol.poll();
            }

            if (petrolPresent < distances.get(i)) {
                return -1;
            }

            petrolPresent -= distances.get(i);
        }

        return noOfPetrolPumpsFill;
    }
}
