package com.ankit.ankushPlacements.parkingLot;

public class SpotAssignment {

    long startTime, endTime;
    Vehicle vehicle;

    SpotAssignment(Vehicle vehicle) {
        this.vehicle = vehicle;
        this.startTime = System.currentTimeMillis();
    }

    void release() {
        this.endTime = System.currentTimeMillis();
    }
}
