package com.ds.algo.problem.solving.dp;

public class PartitionArrayMaximuumSum {

    public static int maxSumAfterPartitioning(int[] arr, int k) {
        int dp[] = new int[arr.length];
        dp[0] = arr[0];
        int max = arr[0];
        for(int i = 1;i < arr.length;i++) {
            int partitionValue = -1;
            max = arr[i];
            for(int j = i , l = 1 ; j >= (i+1-k) && j >= 0 ;j-- , l++) {
                max = arr[j] > max ? arr[j] : max;
                int lastDpEntry = (i-l) >= 0 ? dp[i-l] :0;
                partitionValue = partitionValue > (lastDpEntry + (max * l)) ? partitionValue : (lastDpEntry + (max * l));
            }
            dp[i] = partitionValue;
        }
        return dp[arr.length - 1];
    }

    public static void main(String[] args) {
        int arr[] = new int[]{1};
        System.out.println(maxSumAfterPartitioning(arr , 1));
    }
}
