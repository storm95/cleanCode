package com.ankit.leetcode.matrix;

import java.util.Scanner;

public class Main {
    public static void main(String args[]) {

        int nofrows, nofcols;
        Scanner scanner = new Scanner(System.in);
        nofrows = scanner.nextInt();
        nofcols = scanner.nextInt();
        int arr[][] = new int[nofrows][nofcols];

        for(int i=0;i<nofrows;++i) {
            for(int j=0;j<nofcols;++j) {
                arr[i][j] = scanner.nextInt();
            }
        }

        Metrix metrix = new Metrix();
        int ans[][] = metrix.updateMatrix(arr);
        for(int i=0;i<nofrows;++i) {
            for(int j=0;j<nofcols;++j) {
                System.out.printf("%d ", ans[i][j]);
            }
            System.out.println();
        }
    }
}
