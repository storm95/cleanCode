package com.ankit.ankush;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args){
        X x=new X();
        List<Integer> a = new ArrayList<Integer>(Collections.nCopies(3, 0));
        Scanner sc=new Scanner(System.in);
        for(int i=0;i<a.size();i++){
            int value=sc.nextInt();
            a.set(i,value);
        }
        x.func(a);
    }
}
