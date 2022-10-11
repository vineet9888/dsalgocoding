package com.ds.algo.problem.solving.AmazonPrepration;

public class RodCutting {

    public static void main(String[] args) {
        int n = 8;

        int arr[] = new int[] {1, 5, 8, 9, 10, 17, 17, 20};
        int dp[] = new int[arr.length + 1];
        for(int i = 1 ; i <= n;i++) {
            dp[i] = -1;
        }
        int ans = maxPrice(arr , n , dp);
        System.out.println(ans);
    }


    public static int maxPrice(int arr[] , int n , int dp[]) {
        int ans = 0;
        if(n == 0) {
            return 0;
        }
        if(dp[n] != -1) {
            return dp[n];
        }
        for(int i = 1;i <= n ;i++) {
            ans = Math.max(ans , arr[i-1] + maxPrice(arr , n-i , dp));
        }
        dp[n] = ans;
        return ans;
    }

}
