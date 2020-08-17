package com.ankit.leetcode.validpalindrome;

public class Utils {

    public static boolean isAlphaNumeric(char a) {
        return (((a>='A') && (a<='Z')) || ((a>='a') && (a<='z')) || ((a>='0') && (a<='9')));
    }
}
