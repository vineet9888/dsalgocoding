package com.ds.algo.problem.solving.dp;

public class BuyAndSellStock {

    public static void main(String[] args) {
        int arr[] = new int[]{1,2,3,4,5,6};
        int ans = 0;
        int dp[] = new int[arr.length];
        for(int i = 0 ; i < dp.length;i++) {
            dp[i] = -1;
        }

        for(int i = 0 ; i < 1;i++) {
            ans = Math.max(ans , maxProfit(arr , i , dp));
        }
        System.out.println(ans);
    }
    public static int maxProfit(int arr[] , int buy , int dp[]) {
        int max = 0;
        if(buy >= arr.length-1) {
            return 0;
        }
        if(dp[buy] != -1) {
            return dp[buy];
        }

        for(int i = buy + 1 ; i < arr.length;i++) {
            // in this case only we can sell
            if(arr[buy] < arr[i]) {
                int diff = arr[i]-arr[buy];
                int subans = 0;
                for(int j = i + 1 ; j < arr.length;j++) {
                    subans = Math.max(subans ,  maxProfit(arr , j , dp));
                }
                max = Math.max(subans+diff , max);

            }
        }
        dp[buy] = max;
        return max;
    }
}
