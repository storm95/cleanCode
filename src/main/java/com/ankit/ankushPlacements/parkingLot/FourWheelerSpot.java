package com.ankit.ankushPlacements.parkingLot;

public class FourWheelerSpot  extends  Spot{
    FourWheelerSpot(int no, Double perHrPrice) {
        super(no, VehicleType.FOUR_WHEELER, perHrPrice, 4,4,4);
    }

    @Override
    double getPrice(long timeDurationInHour) {
        long timeDurationBelow4Hr = Math.min(timeDurationInHour, 4);
        long timeDurationAbove4Hr = Math.max(timeDurationInHour-4, 0);

        return timeDurationBelow4Hr*perHrPrice + timeDurationAbove4Hr*perHrPrice*4;
    }
}
