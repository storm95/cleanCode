package com.ankit.Calculator;

public class Calculator {
    String name;
    Calculator(String name){
        this.name=name;
    }

    String GetName(){
        return name;
    }

    int add(int a,int b)
    {
        return a+b;
    }

    int subtract(int a,int b)
    {
        return a-b;
    }

    int divide(int a,int b)
    {
        return (a/b);
    }
}