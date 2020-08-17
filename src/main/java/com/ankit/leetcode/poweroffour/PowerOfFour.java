package com.ankit.leetcode.poweroffour;

public class PowerOfFour {

    public boolean isPowerOfFour(int num) {
        if(num==1)
            return true;

        while((num%4==0) && (num!=0)) {
            num /= 4;
        }
        return (num==1);
    }
}
