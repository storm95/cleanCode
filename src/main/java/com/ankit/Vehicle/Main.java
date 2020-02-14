package com.ankit.Vehicle;

public class Main {
    public static void main(String args[]) {
        Bike b1=new Sujuki(23);
        Bike b2=new Mahindra(34);
        Bike b3=new Bajaj(45);
        b1.accelerate();
        b2.accelerate();
        System.out.println(b2.age);
        b3.accelerate();
        try {
            b3.decreaseGear();
        }
        catch (Exception e) {
            System.out.println("gear is less than 0 make it within the range 0-4");
        }
        System.out.println(b3.getGear());

    }

}
