package com.ds.algo.problem.solving.Arrays;

public class UglyNumbers {

    public static void main(String[] args) {
        int arr[] = new int[]{2,3,5};
        int num = 40;
        System.out.println(isUgly(num , arr));
    }

    public static boolean isUgly(int num , int arr[]) {
        while(num != 0) {
            if(num == 1) {
                return true;
            }
            // System.out.println(num);
            if(num % arr[0] == 0) {
                num = num / arr[0];
            } else if(num % arr[1] == 0) {
                num = num / arr[1];
            } else if(num % arr[2] == 0) {
                num = num / arr[2];
            } else{
                return false;
            }
        }
        return true;
    }
}
