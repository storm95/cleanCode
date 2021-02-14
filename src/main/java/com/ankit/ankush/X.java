package com.ankit.ankush;

import java.io.*;
import java.util.*;

class X{
    void func(List<Integer> a){
        List<Integer> z = new ArrayList<Integer>(Collections.nCopies(a.size(), 0));
        List<Thread> x = new ArrayList<Thread>();
        long startTime = System.currentTimeMillis();
        for(int i=0;i<a.size();i++){
            x.add(new Thread(new com.ankit.Calculator.Addthread(z,i,a.get(i))));
            x.get(i).start();
        }
        try {
            for (int i = 0; i < a.size(); i++) {
                x.get(i).join();
            }

            for(int i=0;i<a.size();i++){
                System.out.println(z.get(i));
            }
        } catch (Exception e) {
            System.out.println("Exception in joining");
            e.printStackTrace();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("time taken : "+(endTime-startTime));
    }
}
class Addthread implements Runnable{
    List<Integer> z;int index;int a;
    Addthread (List<Integer> z, int index, int a){
        this.z=z;
        this.index=index;
        this.a=a;
    }
    public void run(){
        z.set(index, a+2);
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            System.out.println("xxxxxx");
            e.printStackTrace();
        }
    }
}
