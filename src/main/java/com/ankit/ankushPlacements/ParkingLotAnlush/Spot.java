package com.ankit.ankushPlacements.ParkingLotAnlush;

import java.util.ArrayList;

public class Spot {
    Integer id;
    String spotName;
    VehicalType vehicalType;
    int pricePerHr;
    boolean freeOrNot;

    Spot(Integer id,String spotName,VehicalType vehicalType, int pricePerHr){
        this.id=id;
        this.spotName=spotName;
        this.vehicalType=vehicalType;
        this.pricePerHr=pricePerHr;
        this.freeOrNot=true;
    }
}
