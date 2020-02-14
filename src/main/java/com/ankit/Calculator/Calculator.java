package com.ankit.Calculator;

public class Calculator {
    private String name;
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

    double add(double a,double b) { return a+b; }

    int add(int a,int b,int c) {return a+b+c  ;}

    ComplexNumber add(ComplexNumber a, ComplexNumber b) {
        ComplexNumber sum = new ComplexNumber(a.realPart+b.realPart, a.imaginaryPart+b.imaginaryPart);
        return sum;
    }

    QuadraticClass add(QuadraticClass a1,QuadraticClass b1)
    {
        QuadraticClass finali=new QuadraticClass((a1.xSQR+b1.xSQR),(a1.x+b1.x),(a1.Const+b1.Const));
        return finali;
    }

    int subtract(int a,int b)
    {
        return a-b;
    }

    int divide(int a,int b) throws Exception
    {
        if(b==0)
        {
            throw new Exception("DIVIDED BY 0");
        }

        return a/b;
    }
}