package com.ankit.leetcode.validpalindrome;

public class BackwardIterator implements StringIterator {
    MyString myString;
    int currentIdx;
    BackwardIterator(MyString myString) {
        this.myString = myString;
        currentIdx = myString.s.length()-1;
    }

    public boolean hasNext() {
        if(currentIdx == -1)
            return false;

        for(char currentChar = myString.s.charAt(currentIdx); (!Utils.isAlphaNumeric(currentChar)); currentChar = myString.s.charAt(currentIdx)) {
            --currentIdx;
            if(currentIdx == -1)
                break;
        }

        if(currentIdx == -1)
            return false;

        return true;
    }

    public Character getNext() {
        if(!hasNext())
            return null;

        Character ret = myString.s.charAt(currentIdx);
        --currentIdx;
        return ret;
    }
}
