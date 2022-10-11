package com.ds.algo.problem.solving.dp;

import java.util.HashSet;
import java.util.Set;

public class MatrixBlockSum {

    public static final int MAX  = 1000011;
    public static long tot[] = new long[1000005];

    static long solve(int l, int r){
        int size = r - l + 1;
        int dp[] = new int[MAX];

        long ans  = 0;
         for(int i = l ; i <= r ; i ++ ) {
             Set<Integer> set = new HashSet<>();
             if(solve(i , dp , set) == 1) {
                 ans += i;
             }
         }
        System.out.println(ans);
        return ans;
    }


    // 49
    public static int solve(int num , int dp[] , Set<Integer> set) {

        if(set.contains(num)) {
            return -1;
        }

        if(num > MAX) {
            return -1;
        }

        if(dp[num] == 1) {
            return 1;
        }
        set.add(num);


        int temp = num;
        int sum = 0;
        // 32
        //System.out.println(temp);
        while(temp > 0) {
            long digit = temp%10;
            sum += digit*digit;
            temp = temp/10;
        }

        if(sum == 1) {
            dp[num] = 1;
            return 1;
        }
        int ans =  solve(sum , dp , set);
        dp[num] =  ans;
        return ans;
    }

    public static void main(String[] args) {
        solve(1 ,2);
//        int num = 2;
//        int temp = num;
//        int sum = 0;
//        while(temp > 0) {
//            long digit = temp%10;
//            sum += digit*digit;
//            System.out.println();
//            temp = temp/10;
//        }

        /*int mat[][] = { {1,2,3},
                        {4,5,6},
                        {7,8,9}};

        int k = 1;
        int rowSize = mat.length;
        int colSize = mat[0].length;
        int prefixMatSum[][] = new int[rowSize][colSize];
        for(int i = 0;i < rowSize; i++) {
            for(int j = 0 ; j < colSize ; j++) {
                if(i == 0) {
                    prefixMatSum[0][j] = j > 0 ?  (prefixMatSum[0][j-1] + mat[i][j]) : mat[i][j];
                } else if(j == 0) {
                    prefixMatSum[i][0] = i > 0  ? (prefixMatSum[i-1][0] + mat[i][j]) : mat[i][j];
                } else {
                    prefixMatSum[i][j] = prefixMatSum[i-1][j] + prefixMatSum[i][j-1] - prefixMatSum[i-1][j-1] + mat[i][j];
                }
            }
        }

        int ans[][] = new int[rowSize][colSize];
        for(int i = 0 ; i < rowSize ; i ++) {
            for(int j = 0 ; j < colSize ; j++) {
                int lowR = (i-k) >= 0?(i - k) : 0;
                int highR = (i+k) < rowSize ? (i+k) : rowSize - 1;
                int lowC = (j-k) >= 0?(j-k) : 0;
                int highC = (j+k) < colSize ? (j+k) : colSize - 1;
                ans[i][j] = prefixMatSum[highR][highC] - ((lowC-1) < 0 ? 0 : prefixMatSum[highR][lowC-1])
                        - ((lowR-1) < 0 ? 0 :  prefixMatSum[lowR -1][highC]) + ((lowR-1) <0 || (lowC -1) < 0 ? 0 : prefixMatSum[lowR-1][lowC-1 ]);
            }
        }*/

    }
}
