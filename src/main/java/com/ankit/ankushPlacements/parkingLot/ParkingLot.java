package com.ankit.ankushPlacements.parkingLot;

import java.util.*;

public class ParkingLot {
    Map<Integer, SpotAssignment> assignedSpotMapping;
    Map<Integer, Spot> spotNoToSpotMapping;
    Map<Integer, List<SpotAssignment>> historicalAssignedSpotMapping;

    ParkingLot() {
        assignedSpotMapping = new HashMap<>();
        spotNoToSpotMapping = new HashMap<>();
        historicalAssignedSpotMapping = new HashMap<>();
    }

    void addSpot(Spot spot) {

        spotNoToSpotMapping.put(spot.no, spot);
        historicalAssignedSpotMapping.put(spot.no, new ArrayList<>());
    }

    Spot getSpot(Vehicle vehicle) {
        for (Map.Entry<Integer, Spot> stopNoToSpot : spotNoToSpotMapping.entrySet()) {
            Spot spot = stopNoToSpot.getValue();
            if(spot.free && (vehicle.vehicleType == spot.vehicleType)) {
                spot.free = false;
                SpotAssignment spotAssignment = new SpotAssignment(vehicle);
                assignedSpotMapping.put(spot.no, spotAssignment);
                return spot;
            }
        }

        return null;
    }

    Double getPrice(int spotNo) {


        long endTime = System.currentTimeMillis();
        SpotAssignment spotAssignment = assignedSpotMapping.get(spotNo);
        long startTime = spotAssignment.startTime;
        long durationInHr = (endTime - startTime)/(1000*60*60);
        double  price=spotNoToSpotMapping.get(spotNo).getPrice(durationInHr);

        return price;
    }

    void releaseSpot(int spotNo) {
        SpotAssignment spotAssignment = assignedSpotMapping.get(spotNo);
        spotAssignment.endTime = System.currentTimeMillis();

        historicalAssignedSpotMapping.get(spotNo).add(spotAssignment);

        assignedSpotMapping.put(spotNo, null);

        Spot spot = spotNoToSpotMapping.get(spotNo);
        spot.free = true;
    }
}
