package com.ankit.leetcode.validpalindrome;

public class ForwardIterator implements StringIterator {
    MyString myString;
    int currentIdx;
    ForwardIterator(MyString myString) {
        this.myString = myString;
        currentIdx = 0;
    }

    public boolean hasNext() {
        if(currentIdx == myString.s.length())
            return false;

        for(char currentChar = myString.s.charAt(currentIdx); (!Utils.isAlphaNumeric(currentChar)); currentChar = myString.s.charAt(currentIdx)) {
            ++currentIdx;
            if(currentIdx == myString.s.length())
                break;
        }

        if(currentIdx == myString.s.length())
            return false;

        return true;
    }

    public Character getNext() {
        if(!hasNext())
            return null;

        Character ret = myString.s.charAt(currentIdx);
        ++currentIdx;
        return ret;
    }
}
