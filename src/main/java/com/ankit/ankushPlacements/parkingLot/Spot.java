package com.ankit.ankushPlacements.parkingLot;

public class Spot {
    int no;
    VehicleType vehicleType;
    boolean free;
    Double perHrPrice;

    Spot(int no, VehicleType vehicleType, Double perHrPrice) {
        this.no = no;
        this.vehicleType = vehicleType;
        this.perHrPrice = perHrPrice;
        this.free = true;
    }

    void assign() {
        this.free = false;
    }

    void release() {
        this.free = true;
    }
}
