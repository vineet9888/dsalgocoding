package com.ds.algo.problem.solving.dp;

import java.util.Arrays;

public class PartitionEqualSubsetSum {

    public static boolean canPartition(int arr[]  , int curr , int first , int second) {
        if(first == second && curr == arr.length) {
            return true;
        }
        if(curr > arr.length-1) {
            return false;
        }
        // partition with considering current element in both the arrays...
        return canPartition(arr , curr + 1 , arr[curr] + first , second) ||
        canPartition(arr , curr + 1 , first , arr[curr] + second);
    }

    public static boolean canPartitionEqually(int arr[]  , int curr , int sum , int targetSum) {

        if(curr > arr.length-1) {
            return false;
        }

        if(sum == targetSum) {
            return true;
        }

        return canPartitionEqually(arr , curr + 1 , arr[curr] + sum , targetSum) ||
                canPartitionEqually(arr , curr + 1 , sum , targetSum);
    }

    public static void main(String[] args) {
        int arr[] = new int[]{1,5,11,5};
        Arrays.sort(arr);
        // System.out.println(canPartition(arr , 0 , 0 , 0));
        int sum = 0;
        for(int i : arr) {
            sum += i;
        }
        if(sum % 2 == 1) {
            System.out.println(false);
        } else {
            int target = sum/2;
            System.out.println(canPartitionEqually(arr,0,0,6));
        }
    }
}
