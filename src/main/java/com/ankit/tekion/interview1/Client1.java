package com.ankit.tekion.interview1;

//Given an unsorted arrray of size n, find the minimum lenght of subarray that when sorted makes the whole array sorted.
//0, 1, 15, 25, 6, 7, 30, 40, 50

// 2, 5

import java.util.ArrayList;
import java.util.List;
//prefix = 3
//suffix = 4
//        (i, j) -> min, max
//
//i, j
//min => arr[i-1]
//max <= arr[j+1]
////i-1 <= prefix
////j+1 >= suffix
//
//
//len = 2
//
//
//left = 2
//right = 4
//
//
//ch = left -1  -> 15



public class Client1 {
    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>();
        //Initialise
        arr.add(0);
        arr.add(1);
        arr.add(15);
        arr.add(25);
        arr.add(6);
        arr.add(7);
        arr.add(30);
        arr.add(40);
        arr.add(50);

        int prefix, suffix;
        prefix = 0;
        suffix = arr.size()-1;
        for(int i=1;i<arr.size();++i) {
            if(arr.get(i) < arr.get(i-1)) {
                break;
            }
            prefix++;
        }

        for(int i=arr.size()-2;i>=0;--i) {
            if(arr.get(i) > arr.get(i+1)) {
                break;
            }
            suffix--;
        }

        int min, max;
        min = 10000;
        max = 0;
        for(int i=prefix;i<=suffix;++i) {
            min = Math.min(min, arr.get(i));
            max = Math.max(max, arr.get(i));
        }

        int left;
        for(left=0;left<=prefix;++left) {
            if(arr.get(left) > min) {
                break;
            }
        }

        int right;
        for(right=arr.size()-1;right>=suffix;--right) {
            if(arr.get(right) < max) {
                break;
            }
        }

        System.out.println("left: "+left+"  right: "+right);

    }


}
