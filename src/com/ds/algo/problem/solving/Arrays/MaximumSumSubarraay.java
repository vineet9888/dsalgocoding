package com.ds.algo.problem.solving.Arrays;

public class MaximumSumSubarraay {

    public static void main(String[] args) {
        int arr[] = new int[]{-2,-3,4,-1,-2,1,5,-3};
        int max = arr[0];
        int maxTillNow = arr[0];
        for(int i = 1;i < arr.length;i++) {
            maxTillNow = maxTillNow + arr[i];
            if(maxTillNow > max) {
                max = maxTillNow;
            }
            if(maxTillNow  < 0 ){
                maxTillNow = 0;
            }
        }
        System.out.println(max);

    }
}
