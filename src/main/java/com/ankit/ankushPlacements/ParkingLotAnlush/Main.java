package com.ankit.ankushPlacements.ParkingLotAnlush;


public class Main {
    public static void main(String args[]) {
        VehicalParking vehicalParking = new VehicalParking();

        Spot spot=new Spot(1,"spotNO",VehicalType.TWO,50);
        Spot spot1 =new Spot(2,"spotNO1",VehicalType.FOUR,50);
        Spot spot2=new Spot(3,"spotNO2",VehicalType.TWO,50);
        Spot spot3=new Spot(4,"spotNO3",VehicalType.FOUR,50);
        Spot spot4=new Spot(5,"spotNO4",VehicalType.TWO,50);


        vehicalParking.addSpot(spot);
        vehicalParking.addSpot(spot1);
        vehicalParking.addSpot(spot2);
        vehicalParking.addSpot(spot3);
        vehicalParking.addSpot(spot4);

        Vehical vehical=new Vehical("v1",VehicalType.TWO);
        Owner owner=new Owner("e1");

        Receipt receipt;
        if(vehicalParking.checkSpotFreeOrNot(vehical)==true){
            System.out.println(vehicalParking.checkSpotFreeOrNot(vehical));

            receipt=vehicalParking.returnValidSpotDet(vehical,owner);
            System.out.println(receipt.spot.id);
        } else{
            System.out.println(vehicalParking.checkSpotFreeOrNot(vehical));
        }


        Vehical vehical1=new Vehical("v2",VehicalType.FOUR);
        Owner owner1=new Owner("e2");

        Receipt receipt1;
        if(vehicalParking.checkSpotFreeOrNot(vehical1)==true){
            System.out.println(vehicalParking.checkSpotFreeOrNot(vehical1));

            receipt1=vehicalParking.returnValidSpotDet(vehical1,owner1);
            System.out.println(receipt1.spot.id);
        } else{
            System.out.println(vehicalParking.checkSpotFreeOrNot(vehical1));
        }


        Vehical vehical2=new Vehical("v3",VehicalType.TWO);
        Owner owner2=new Owner("e3");

        Receipt receipt3;
        if(vehicalParking.checkSpotFreeOrNot(vehical2)==true){
            System.out.println(vehicalParking.checkSpotFreeOrNot(vehical2));

            receipt3=vehicalParking.returnValidSpotDet(vehical2,owner2);
            System.out.println(receipt3.spot.id);
        } else{
            System.out.println(vehicalParking.checkSpotFreeOrNot(vehical2));
        }

        Vehical vehical3=new Vehical("v4",VehicalType.TWO);
        Owner owner3=new Owner("e4");

        Receipt receipt4=null;
        if(vehicalParking.checkSpotFreeOrNot(vehical3)==true){
            System.out.println(vehicalParking.checkSpotFreeOrNot(vehical3));

            receipt4=vehicalParking.returnValidSpotDet(vehical3,owner3);
            System.out.println(receipt4.spot.id);
        } else{
            System.out.println(vehicalParking.checkSpotFreeOrNot(vehical3));
        }

        Vehical vehical4=new Vehical("v5",VehicalType.TWO);
        Owner owner4=new Owner("e5");

        Receipt receipt5;
        if(vehicalParking.checkSpotFreeOrNot(vehical4)==true){
            System.out.println(vehicalParking.checkSpotFreeOrNot(vehical4));

            receipt5=vehicalParking.returnValidSpotDet(vehical4,owner4);
            System.out.println(receipt5.spot.id);
        } else{
            System.out.println(vehicalParking.checkSpotFreeOrNot(vehical4));
        }

        vehicalParking.releaseSpace(receipt4);


        if(vehicalParking.checkSpotFreeOrNot(vehical4)==true){
            System.out.println(vehicalParking.checkSpotFreeOrNot(vehical4));

            receipt5=vehicalParking.returnValidSpotDet(vehical4,owner4);
            System.out.println(receipt5.spot.id);
        } else{
            System.out.println(vehicalParking.checkSpotFreeOrNot(vehical4));
        }
    }
}
