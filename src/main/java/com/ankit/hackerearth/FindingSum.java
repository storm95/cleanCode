package com.ankit.hackerearth;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FindingSum {
    private final long modulo = 1000000007;

    public void compute() {

        List<Long> inv = precompute();

        int n;
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        List<Integer> arr = new ArrayList<>();
        for(int i=0;i<n;++i) {
            arr.add(scanner.nextInt());
        }

        int iMax = (n+1)/2 + 1 - 1;
        int jCons = n/2 -1;
        long mul = 1L;
        long ans = 0L;
        for(int i=n-1;i>=0;i--) {
            int jMax = i+jCons;
            mul = (mul*arr.get(i))%modulo;
            if(jMax+1<n)
                mul = (mul*inv.get(arr.get(jMax+1)))%modulo;

            if(i<=iMax) {
                ans = (ans + mul) % modulo;
//                System.out.println("i= "+ i+ ", iMax= "+ iMax+ ", jMax= "+ jMax+ ", mul= "+ mul+ ", ans= "+ ans);
            }
        }

        System.out.println(ans);
    }

    private List<Long> precompute() {
        int maxA = 1000000;
        List<Long> inv = new ArrayList<>();
        inv.add(0L);
        for(int i=1;i<=maxA;++i) {
            inv.add(pow(i, modulo-2));
        }

        return inv;
    }

    private long pow(long a, long b) {
        if (b==0L)
            return 1L;
        long p = pow((a*a)%modulo, b/2L);
        if(b%2L==1)
            p = (p*a)%modulo;
        return p;
    }
}
