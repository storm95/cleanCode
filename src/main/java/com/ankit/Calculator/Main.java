package com.ankit.Calculator;

public class Main {
    public static void main(String args[]) {
        Calculator calc = new Calculator("casio");
        System.out.println(calc.GetName());
        System.out.println(calc.add(2, 3));
        System.out.println(calc.subtract(1, 5));
        System.out.println(calc.divide(4, 2));
    }
}
