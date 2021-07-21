package com.ankit.competitiveCoding.palindromeChecker;

import java.util.Scanner;

public class PalindromeChecker {
    public static void main(String[] args) {
        StringBuilder a, b;
        Scanner scanner = new Scanner(System.in);
        a = new StringBuilder(scanner.nextLine());
        b = new StringBuilder(a);
        a.reverse();
        System.out.println("if equals: "+a.toString().equals(b.toString()));

        scanner.close();
    }
}
