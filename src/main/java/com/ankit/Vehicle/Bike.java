package com.ankit.Vehicle;

public abstract class Bike {
    int no;
    int age;
    int petrol;
    private int gear;

    Bike(int no) {
        this.no=no;
        this.petrol=0;
        this.gear=0;
        this.age=0;
    }

    abstract void accelerate();

    void increaseGear() throws Exception{
        if(gear==4) {
            throw new Exception("gear should not be > 4");
        }
        gear++;
    }

    void decreaseGear() throws Exception{
        if(gear==0) {
            throw new Exception("gear should not be < o");
        }
        gear--;
    }

    int getGear(){
       return gear;
    }
}

