package com.ankit.ankushPlacements.ParkingLotAnlush;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class VehicalParking {
    Map<String, ArrayList<VehicalTimeSpot >> ownerHistory;
    Map<Integer, ArrayList<OwnerVehical >> spotHistory;
    Map<Integer,Spot> spotIdToSpot;
    ArrayList<Integer>spotIds;

    VehicalParking(){
        ownerHistory= new HashMap<>();
        spotHistory= new HashMap<>();
        spotIdToSpot = new HashMap<>();
        spotIds= new ArrayList<>();
    }

    boolean checkSpotFreeOrNot(Vehical vehical){
        for(int i=0;i<spotIds.size();i++){
            if(spotIdToSpot.get(spotIds.get(i)).vehicalType==vehical.vehicalType && spotIdToSpot.get(spotIds.get(i)).freeOrNot==true){
                return true;
            }
        }
        return false;
    }

    void addSpot(Spot spot){
        spotIds.add(spot.id);
        spotIdToSpot.put(spot.id, spot);
        spotHistory.put(spot.id, new ArrayList<>());
    }

    Receipt returnValidSpotDet(Vehical vehical,Owner owner){
        Spot spot=null;
        for(int i=0;i<spotIds.size();i++){
            if(spotIdToSpot.get(spotIds.get(i)).vehicalType==vehical.vehicalType && spotIdToSpot.get(spotIds.get(i)).freeOrNot==true){
                spot=spotIdToSpot.get(spotIds.get(i));

                break;
            }
        }

        Receipt receipt=new Receipt(vehical,owner,spot,System.currentTimeMillis()/1000,-1,-1);

        spot.freeOrNot=false;
        VehicalTimeSpot vehicalTimeSpot=new VehicalTimeSpot(vehical,receipt.startTime,receipt.endTime,spot);
        OwnerVehical ownerVehical=new OwnerVehical(owner,vehical,receipt.startTime,receipt.endTime);

        if (ownerHistory.get(owner.id) == null) {
            ownerHistory.put(owner.id, new ArrayList<>());
        }
        ownerHistory.get(owner.id).add(vehicalTimeSpot);
        spotHistory.get(spot.id).add(ownerVehical);

        return receipt;
    }

    void releaseSpace(Receipt receipt){
        receipt.endTime=System.currentTimeMillis()/1000;
        receipt.price=(receipt.endTime- receipt.startTime)*receipt.spot.pricePerHr*100;
        receipt.spot.freeOrNot=true;
        ownerHistory.get(receipt.owner.id).get(ownerHistory.get(receipt.owner.id).size()-1).en=receipt.endTime;
        spotHistory.get(receipt.spot.id).get(spotHistory.get(receipt.spot.id).size()-1).en=receipt.endTime;
    }
}
