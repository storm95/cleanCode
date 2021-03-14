package com.ankit.ankushPlacements.parkingLot;

public class ThreeWheelerSpot  extends  Spot{
    ThreeWheelerSpot(int no, Double perHrPrice) {
        super(no, VehicleType.THREE_WHEELER, perHrPrice, 3,3,3);
    }

    @Override
    double getPrice(long timeDurationInHour) {
        long timeDurationBelow3Hr = Math.min(timeDurationInHour, 3);
        long timeDurationAbove3Hr = Math.max(timeDurationInHour-3, 0);

        return timeDurationBelow3Hr*perHrPrice + timeDurationAbove3Hr*perHrPrice*3;
    }
}
