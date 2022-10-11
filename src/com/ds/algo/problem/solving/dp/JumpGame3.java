package com.ds.algo.problem.solving.dp;

public class JumpGame3 {

    public static boolean canReachZero(int arr[], int start, boolean isVisited[]){


        if(start < 0 || start >= arr.length) {
            return false;
        }
        if(isVisited[start]) {
            return false;
        }
        if(arr[start] == 0) {
            return true;
        }
        isVisited[start] = true;
        return canReachZero(arr, start + arr[start] , isVisited) ||
                canReachZero(arr , start - arr[start] , isVisited);
    }



    public static void main(String[] args) {
        int arr[] = new int[]{0,1};
        boolean isVisited[] = new boolean[arr.length];
        System.out.println(canReachZero(arr, 1 , isVisited));
    }

}
