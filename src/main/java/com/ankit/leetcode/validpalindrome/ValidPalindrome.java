package com.ankit.leetcode.validpalindrome;

import java.util.Scanner;

public class ValidPalindrome {

    public boolean isPalindrome(String s) {
        MyString myString = new MyString(s);
        StringIterator forwardIterator = myString.getForwardIterator();
        StringIterator backwardIterator = myString.getBackwardIterator();

        while(forwardIterator.hasNext() && backwardIterator.hasNext()) {
            Character forwardCharacter = Character.toLowerCase(forwardIterator.getNext());
            Character backardCharacter = Character.toLowerCase(backwardIterator.getNext());
            if(!forwardCharacter.equals(backardCharacter))
                return false;
        }

        return true;
    }

    public void compute() {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        System.out.println(isPalindrome(s));
    }
}
