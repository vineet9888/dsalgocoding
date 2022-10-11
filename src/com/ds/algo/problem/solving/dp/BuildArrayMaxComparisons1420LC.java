package com.ds.algo.problem.solving.dp;

import java.util.HashSet;
import java.util.Set;

public class BuildArrayMaxComparisons1420LC {

    public static int mod = 1000000007;
    public static long dp[][][];

    public static long noOfArrays(int n , int elementToCompare , int k , int m) {
        long ans = 0;

        if(k==0 && n==0){
            return 1;
        }
        if(n == 0) {
            return 0;
        }
        if(k == 0 && n >= 1) {
            int mul = 1;
            for(int i = 1 ; i <= n;i++) {
                mul = (mul*elementToCompare)%mod;
            }
            return mul;
        }
        if(n == 1 && k == 1){
            return m - elementToCompare;
        }


        /*if(k==0 && n==0){
            return 1;
        }
        if(n == 0) {
            return 0;
        }*/

        if(dp[n][elementToCompare][k] != -1) {
            return dp[n][elementToCompare][k];
        }

        for(int i = 1 ; i <= m ; i ++) {
            if(i > elementToCompare) {
//                ans +=  (k == 0 ?  noOfArrays(n-1 , i , 0 , m) : noOfArrays(n-1 , i , k-1 , m));
                ans +=  noOfArrays(n-1 , i , k-1 , m);
                ans = ans % mod;
            } else if(k != 0){
                ans +=  noOfArrays(n-1 , elementToCompare , k , m);
                ans = ans % mod;
            }
        }
        dp[n][elementToCompare][k] = ans;
        //System.out.println(temp);
        return ans;
    }


    public static int numOfArrays(int n, int m, int k) {
        dp=new long[n+1][m+1][k+1];
        for(int j=0;j<dp.length;j++){
            for(int i=0;i<dp[0].length;i++){
                for(int l=0;l<dp[0][0].length;l++){
                    dp[j][i][l]=-1;
                }
            }
        }

        return (int)noOfArrays(n,0 , k , m);
    }

    public static void main(String[] args) {
         System.out.println(numOfArrays(37,17,7));
        Set<Integer> set = new HashSet<>();
        //System.out.println(Integer.MAX_VALUE);
    }
}
