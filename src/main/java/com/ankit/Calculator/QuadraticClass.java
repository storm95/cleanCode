package com.ankit.Calculator;

public class QuadraticClass {
    int xSQR;int x;int Const;
    QuadraticClass(int a,int b,int c){
        this.xSQR=a;
        this.x=b;
        this.Const=c;
    }

    void printi(){
        System.out.println(this.xSQR+"x^2+"+this.x+"x+"+this.Const);
    }
}
