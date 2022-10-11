package com.ds.algo.problem.solving.backtracking;

public class PrintPermutations {

    public static void main(String[] args) {
        char arr[] = new char[]{'1','2','3' , '4'};
        permute(0,arr);
    }

    public static void permute(int start , char arr[]) {

        if(start == arr.length) {
            for(int i = 0;i<arr.length;i++) {
                System.out.print(arr[i]);
            }
            System.out.println();
        }

        for(int i = start ;i < arr.length;i++) {
            swap(start , i , arr);
            permute(start + 1 , arr);
            swap(start , i , arr);
        }
    }

    public static void swap(int a , int b , char arr[]) {
        char temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
