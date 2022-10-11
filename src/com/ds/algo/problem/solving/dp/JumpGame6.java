package com.ds.algo.problem.solving.dp;

public class JumpGame6 {

    public static int MIN_VALUE = -100000;

    // 1,-1,-2,4
    public static int jumpGame(int nums[] , int k , int start) {
        int ans = MIN_VALUE;
        // System.out.println(start + " - " + k);
        if(start == nums.length-1) {
            return nums[start];
        }
        if(start > nums.length - 1) {
            return 0;
        }
        int low = start + 1;
        int high = start + k;
        for(int i = low;i <= high;i++) {

            int temp = nums[start] + jumpGame(nums , k, i);
            // System.out.println(temp + " - " + ans);
            ans = Math.max(ans , temp);

        }
        return ans;
    }

    public static int maxResult(int[] nums, int k) {
        return jumpGame(nums , k , 0);
    }

    public static void main(String[] args) {
        int arr[] = new int[]{1,-5,-20,4,-1,3,-6,-3};
        int k = 2;
        System.out.println(maxResult(arr , k));
    }
}
