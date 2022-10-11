package com.ds.algo.problem.solving.Arrays;

public class MinSubArraySum {

    public static int minSubArrayLen(int target, int[] nums) {
        int l = 0;
        int h = 0;
        int sum = nums[0];
        int ans = Integer.MAX_VALUE;
        while(l <= h && h <= nums.length) {
            if(h ==l && l == 0) {
                sum = nums[l];
                h++;
            }
            if(sum < target && h == nums.length) {
                break;
            }
            while(sum < target && h < nums.length) {
                sum += nums[h];
                h++;
            }

            if(sum >= target) {
                ans = Math.min(ans , h - l);
                sum = sum - nums[l];
                l++;
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

    public static void main(String[] args) {
        int arr[] = new int[]{1,1,1,1,1,1,1,1};
        int target = 11;

        String s = "123";




        s = s+ 9;
        System.out.println(s);
        //Integer.parseInt(String.valueOf(s.charAt(2)));
        //System.out.println(minSubArrayLen(target , arr));
    }
}
