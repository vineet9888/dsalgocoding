package com.ds.algo.problem.solving.Arrays;

public class ReverseStringUsingRecursion {

    public static void main(String[] args) {
        char arr[] = new char[]{'v','i','n','e','e','t','s'};
        reverse(arr);
        for(int i = 0 ; i < arr.length;i++) {
            System.out.print(arr[i]);
        }
    }

    public static void reverse(char arr[]) {
        int low = 0;
        int high = arr.length-1;
        char temp = '*';
        while(low <= high) {
            temp = arr[low];
            arr[low] = arr[high];
            arr[high] = temp;
            high--;
            low++;
        }
    }


}
