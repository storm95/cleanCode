package com.ankit.Calculator;

public class Main {
    public static void main(String args[]) {
        Calculator calc = new Calculator("casio");
        System.out.println(calc.GetName());
//        System.out.println(calc.add(2, 3));
//        System.out.println(calc.add(1.2,2.3));
//        System.out.println(calc.add(1,2,3));
//        System.out.println(calc.subtract(1, 5));
        int a, b;
        a = 4;
        b = 2;
        try {
            int c=calc.divide(a, b);
            System.out.println(calc.add(a, c));
        } catch (Exception e) {
            System.out.println("Should not devide by 0");
            System.out.println(e);
        }


//        ComplexNumber a = new ComplexNumber(1, 1);
//        ComplexNumber b = new ComplexNumber(2, 2);
//        ComplexNumber sum = calc.add(a, b);
//        sum.Print();
//        QuadraticClass a1=new QuadraticClass(1,2,3);
//        QuadraticClass b1=new QuadraticClass(3,4,5);
//        QuadraticClass c1=calc.add(a1,b1);
//        c1.printi();
    }
}

//c = divide(a, b)
//print(add(a, c))