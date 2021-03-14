package com.ankit.ankushPlacements.parkingLot;

public abstract class Spot {
    int no;
    VehicleType vehicleType;
    int length, width, noOfSensor;
    boolean free;
    Double perHrPrice;

    Spot(int no, VehicleType vehicleType, Double perHrPrice, int length, int width, int noOfSensor) {
        this.no = no;
        this.vehicleType = vehicleType;
        this.perHrPrice = perHrPrice;
        this.free = true;
        this.length = length;
        this.width = width;
        this.noOfSensor = noOfSensor;
    }

    void assign() {
        this.free = false;
    }

    void release() {
        this.free = true;
    }

    abstract double getPrice(long timeDuration);
}
