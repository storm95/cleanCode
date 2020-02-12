package com.ankit.Calculator;

public class Main {
    public static void main() {
        Calculator calc = new Calculator("casio");
        calc.GetName();
        calc.add(2, 3);
        calc.subtract(1, 5);
        calc.divide(4, 2);
    }
}
