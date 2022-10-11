package com.ds.algo.problem.solving.Arrays;

import java.util.Map;

public class LargestSumSubarray {

    public static void main(String[] args) {
        int arr[] = new int[]{-2 , -3 , 4 ,-1,-2 ,1 ,5,-1};
        int input[] = new int[]{-1,-2,-3};
        System.out.println(kadaneAlgo(arr));
        System.out.println(kadaneAlgo(input));
    }

    public static int kadaneAlgo(int arr[]) {
        int ans = Integer.MIN_VALUE;
        int sumTillNow = 0;
        int negativeCount = 0;
        int negativeMin = Integer.MIN_VALUE;
        for(int i = 0 ; i < arr.length;i++) {
            if(arr[i] < 0) {
                negativeMin = Math.max(arr[i] , negativeMin);
                negativeCount++;
            }

            sumTillNow = sumTillNow + arr[i];
            if(ans < sumTillNow) {
                ans = sumTillNow;
            }

            if(sumTillNow < 0) {
                sumTillNow = 0;
            }
        }
        if(negativeCount == arr.length) {
            return negativeMin;
        } else {
            return ans;
        }
    }
}
