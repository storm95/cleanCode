package com.ankit.leetcode.matrix;


import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

public class Metrix {

    public int[][] updateMatrix1(int[][] matrix) {
        int nofrows = matrix.length;
        int nofcols = matrix[0].length;

        int[][] ans = new int[nofrows][nofcols];

        for(int i=0;i<nofrows;++i) {
            for (int j=0;j<nofcols;++j) {
                ans[i][j] = nofrows+nofcols;
                if(matrix[i][j]==0)
                    ans[i][j] = 0;
            }
        }

        for(int k=0;k<=(nofrows+nofcols);++k) {
            for(int i=0;i<nofrows;++i) {
                for (int j=0;j<nofcols;++j) {
                    if(i>0)
                        ans[i][j] = Math.min(ans[i][j], 1+ans[i-1][j]);
                    if(i<(nofrows-1))
                        ans[i][j] = Math.min(ans[i][j], 1+ans[i+1][j]);
                    if(j>0)
                        ans[i][j] = Math.min(ans[i][j], 1+ans[i][j-1]);
                    if(j<(nofcols-1))
                        ans[i][j] = Math.min(ans[i][j], 1+ans[i][j+1]);

                }
            }
        }

        return ans;
    }

    public int[][] updateMatrix(int[][] matrix) {
        int nofrows = matrix.length;
        int nofcols = matrix[0].length;

        int[][] ans = new int[nofrows][nofcols];

        Queue<Pair<Integer, Integer>> q = new LinkedList<>();


        for(int i=0;i<nofrows;++i) {
            for (int j=0;j<nofcols;++j) {
                ans[i][j] = nofrows+nofcols;
                if(matrix[i][j]==0) {
                    ans[i][j] = 0;
                    q.add(new Pair<>(i, j));
                }
            }
        }

        while(!q.isEmpty()) {
            Pair<Integer, Integer> top = q.poll();

            int i = top.getKey();
            int j = top.getValue();

            if((i>0) && (ans[i - 1][j]>(ans[i][j] + 1))) {
                ans[i - 1][j] = ans[i][j] + 1;
                q.add(new Pair<>(i - 1, j));
            }

            if((i<(nofrows - 1)) && (ans[i + 1][j]>(ans[i][j] + 1))) {
                ans[i + 1][j] = ans[i][j] + 1;
                q.add(new Pair<>(i + 1, j));
            }

            if((j>0) && (ans[i][j - 1]>(ans[i][j] + 1))) {
                ans[i][j - 1] = ans[i][j] + 1;
                q.add(new Pair<>(i, j - 1));
            }

            if((j<(nofcols - 1)) && (ans[i][j + 1]>(ans[i][j] + 1))) {
                ans[i][j + 1] = ans[i][j] + 1;
                q.add(new Pair<>(i, j + 1));
            }
        }

        return ans;
    }
}
