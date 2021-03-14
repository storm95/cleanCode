package com.ankit.ankushPlacements.ParkingLotAnlush;

public class VehicalTimeSpot{
    Vehical vehical;
    long st;
    long en;
    Spot spot;

    VehicalTimeSpot(Vehical vehical, long st, long en, Spot spot){
        this.vehical=vehical;
        this.st=st;
        this.en=en;
        this.spot=spot;
    }
}
