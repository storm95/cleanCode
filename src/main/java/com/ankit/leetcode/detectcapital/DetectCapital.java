package com.ankit.leetcode.detectcapital;

import java.util.Scanner;

public class DetectCapital {
    public boolean detectCapitalUse(String word) {
        if(word.length()<=1)
            return true;

        if(((word.charAt(0)>='a') && (word.charAt(0)<='z')) && ((word.charAt(1)>='A') && (word.charAt(1)<='Z')))
            return false;

        boolean up = false;
        if((word.charAt(1)>='A') && (word.charAt(1)<='Z')) {
            up = true;
        }

        boolean ans = true;
        for(int i=2;i<word.length();++i) {
            if(((word.charAt(i)>='A') && (word.charAt(i)<='Z') && (!up)) || ((word.charAt(i)>='a') && (word.charAt(i)<='z') && up)) {
                ans = false;
                break;
            }
        }

        return ans;
    }

    public void compute() {
        DetectCapital detectCapital = new DetectCapital();
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        boolean ans = detectCapital.detectCapitalUse(str);
        System.out.println(ans);
    }
}
