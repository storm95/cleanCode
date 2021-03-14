package com.ankit.ankushPlacements.parkingLot;

public class TwoWheelerSpot extends Spot {

    TwoWheelerSpot(int no, Double perHrPrice) {
        super(no, VehicleType.TWO_WHEELER, perHrPrice, 2, 2, 2);
    }

    @Override
    double getPrice(long timeDurationInHour) {
        long timeDurationBelow2Hr = Math.min(timeDurationInHour, 2);
        long timeDurationAbove2Hr = Math.max(timeDurationInHour-2, 0);

        return timeDurationBelow2Hr*perHrPrice + timeDurationAbove2Hr*perHrPrice*2;
    }
}
