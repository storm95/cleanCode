package com.ankit.Calculator;

public class ComplexNumber {
    int realPart, imaginaryPart;

    ComplexNumber(int realPart, int imaginaryPart) {
        this.realPart = realPart;
        this.imaginaryPart = imaginaryPart;
    }

    void Print() {
        System.out.println(realPart+"+"+imaginaryPart+"i");
    }
}
