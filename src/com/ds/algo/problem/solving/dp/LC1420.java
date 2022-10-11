package com.ds.algo.problem.solving.dp;

import java.util.Arrays;

public class LC1420 {
    public static int mod = 1000000007;
    public static long dp[][][];

    public static long noOfArrays(int n , int m , int k , int elementToCompare) {
        long ans = 0;
        if(k==0 && n==0){
            return 1;
        }
        if(n == 0) {
            return 0;
        }
         // System.out.println(n+ " " + m + " " + k + " " + elementToCompare);
        if(dp[n][k][elementToCompare] != -1) {
            return dp[n][k][elementToCompare];
        }

        if(k == 0){
            for(int i = 1 ; i <= elementToCompare ; i ++) {
                ans = ans +  (noOfArrays(n-1 , m , k , elementToCompare)%mod);
            }
            dp[n][k][elementToCompare]=ans;
        } else {
            for(int i = 1 ; i <= m ; i ++) {
                if(i > elementToCompare) {
                    ans = ans +  (noOfArrays(n-1 , m , k-1 , i )%mod);
                } else {
                    ans = ans +  (noOfArrays(n-1 , m , k , elementToCompare )%mod);
                }
            }
        }

        return dp[n][k][elementToCompare] = ans % mod;
    }


    public static int numOfArrays(int n, int m, int k) {
        dp=new long[n+1][k+1][m+1];
        for(int j=0;j<dp.length;j++){
            for(int i=0;i<dp[0].length;i++){
                for(int l=0;l<dp[0][0].length;l++){
                    dp[j][i][l]=-1;
                }
            }
        }

        return (int)noOfArrays(n,m,k,0);
    }

    public static void main(String[] args) {
        System.out.println(numOfArrays(37,17,7));
    }
}
