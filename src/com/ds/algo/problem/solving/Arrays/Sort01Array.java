package com.ds.algo.problem.solving.Arrays;

public class Sort01Array {

    public static void main(String[] args) {
        int arr[] = new int[]{1,0,1,0};
        sortArray(arr);
        for(int i = 0 ; i < arr.length;i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static int[] sortArray(int arr[]) {
        int low = 0;
        int high = arr.length-1;
        while(low < high) {
            // iterate till we found first zero
            while(low < arr.length-1 && arr[low] == 0) {
                low++;
            }
            while(high >=0 && arr[high] == 1) {
                high--;
            }
            if (low < high) {
                arr[low] = 0;
                arr[high] = 1;
            }
        }
        return arr;
    }
}
