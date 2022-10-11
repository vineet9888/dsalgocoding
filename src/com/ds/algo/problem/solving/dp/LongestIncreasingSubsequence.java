package com.ds.algo.problem.solving.dp;

public class LongestIncreasingSubsequence {

    public static final int MIN_VALUE = 0;

    public static void main(String[] args) {
        int arr[] = new int[]{10, 22, 9, 33, 21, 50, 41, 60};
        int ans = MIN_VALUE;
        for(int i = 0;i<arr.length;i++) {
            ans = Math.max(ans , LIS(arr , i));
        }
        System.out.println(ans);
    }

    public static int LIS(int arr[] , int n) {
        int ans = 1;
        if(n == 0) {
            return 1;
        }
        for(int i = n-1;i >=0;i--) {
            if(arr[n] > arr[i]) {
                ans = Math.max(ans , 1 + LIS(arr , i));
            }
        }
        return ans;
    }
}
