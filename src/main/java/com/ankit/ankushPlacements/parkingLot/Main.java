package com.ankit.ankushPlacements.parkingLot;

public class Main {
    public static void main(String args[]) {
        ParkingLot parkingLot = new ParkingLot();

        Spot spot1 = new TwoWheelerSpot(1, 10000000000000.0);
        Spot spot2 = new ThreeWheelerSpot(2, 20.0);
        Spot spot3 = new FourWheelerSpot(3,  40.0);
        Spot spot4 = new TwoWheelerSpot(4, 10.0);

        parkingLot.addSpot(spot1);
        parkingLot.addSpot(spot2);
        parkingLot.addSpot(spot3);
        parkingLot.addSpot(spot4);


        Vehicle vehicle1 = new Vehicle(10, VehicleType.TWO_WHEELER);
        Spot assignedSpot1 = parkingLot.getSpot(vehicle1);
        if (assignedSpot1 == null) {
            System.out.println("No Spot");
        } else {
            System.out.println("Spot No: " + assignedSpot1.no);
        }

        Vehicle vehicle2 = new Vehicle(20, VehicleType.TWO_WHEELER);
        Spot assignedSpot2 = parkingLot.getSpot(vehicle2);
        if (assignedSpot2 == null) {
            System.out.println("No Spot");
        } else {
            System.out.println("Spot No: " + assignedSpot2.no);
        }

        Vehicle vehicle3 = new Vehicle(30, VehicleType.FOUR_WHEELER);
        Spot assignedSpot3 = parkingLot.getSpot(vehicle3);
        if (assignedSpot3 == null) {
            System.out.println("No Spot");
        } else {
            System.out.println("Spot No: " + assignedSpot3.no);
        }

        Vehicle vehicle4 = new Vehicle(40, VehicleType.TWO_WHEELER);
        Spot assignedSpot4 = parkingLot.getSpot(vehicle4);
        if (assignedSpot4 == null) {
            System.out.println("No Spot");
        } else {
            System.out.println("Spot No: " + assignedSpot4.no);
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Double price1 = parkingLot.getPrice(assignedSpot1.no);
        System.out.println("Price1: " + price1);


        parkingLot.releaseSpot(assignedSpot1.no);


        Vehicle vehicle5 = new Vehicle(50, VehicleType.TWO_WHEELER);
        Spot assignedSpot5 = parkingLot.getSpot(vehicle5);
        if (assignedSpot5 == null) {
            System.out.println("No Spot");
        } else {
            System.out.println("Spot No: " + assignedSpot5.no);
        }
    }
}
