package com.ds.algo.problem.solving.Arrays;

public class MoveZerosToLast {

    public static void main(String[] args) {
        int arr[] = new int[]{1,2,0,0,0,3,6};
        int curr = 0;
        int z = -1;
        while(curr <= arr.length - 1) {
            if(arr[curr] != 0 && z != -1) {
                arr[z] = arr[curr];
                arr[curr] = 0;
                z++;
            } else if(arr[curr] == 0 && z == -1) {
                z = curr;
            }
            curr++;
        }


        for(Integer i : arr) {
            System.out.print(i + " - ");
        }


    }
}
