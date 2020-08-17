package com.ankit.codeforces.boboniu_and_bit_operations;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Boboniu {

    int n, m;
    List<Integer> a, b;

    Boboniu() {
        a = new ArrayList<>();
        b = new ArrayList<>();
    }

    private boolean possible(int c) {
        for(int i=0;i<n;++i) {
            boolean flag = false;
            for(int j=0;j<m;++j) {
                int and = a.get(i) & b.get(j);
                if((and | c) == c) {
                    flag = true;
                    break;
                }
            }

            if(!flag)
                return false;
        }

        return true;
    }

    private int getMinC() {
        int maxC = 1<<9;
        int c;
        for(c=0;((c<maxC) && (!possible(c)));++c) {}
        return c;
    }

    public void compute() {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();

        for(int i=0;i<n;++i) {
            a.add(scanner.nextInt());
        }

        for(int i=0;i<m;++i) {
            b.add(scanner.nextInt());
        }

        System.out.println(getMinC());
    }
}
