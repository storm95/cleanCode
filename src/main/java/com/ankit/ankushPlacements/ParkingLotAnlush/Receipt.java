package com.ankit.ankushPlacements.ParkingLotAnlush;

public class Receipt {
    Vehical vehical;
    Owner owner;
    Spot spot;
    long startTime;
    long endTime;
    long price;

    Receipt(Vehical vehical,Owner owner,Spot spot,long startTime,long endTime,long price){
        this.vehical=vehical;
        this.owner=owner;
        this.spot=spot;
        this.startTime=startTime;
        this.endTime=endTime;
        this.price=price;
    }
}
