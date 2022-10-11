package com.ds.algo.problem.solving.AmazonPrepration;

import java.util.Arrays;

public class MoviesOnFlight {

    public static void main(String[] args) {
        int arr[] = new int[]{90, 85, 75, 60, 120, 150 , 100, 125};
        Arrays.sort(arr);
        int d = 250;
        for(int i = 0 ; i < arr.length;i++) {
            System.out.print(arr[i]+ " ");
        }
        System.out.println("");

        int i = 0 , j = arr.length-1;
        int target = d;
        int sum= -1;
        int firstMovie = 0, secondMovie = 0;
        while(i < j) {
            if(arr[i] + arr[j] == target) {
                firstMovie = i;
                secondMovie = j;
                break;
            } else if(arr[i] + arr[j] > target) {
                j--;
            } else if(arr[i] + arr[j] < target) {
                if(sum < arr[i] + arr[j]) {
                    sum = arr[i] + arr[j];
                    firstMovie = i;
                    secondMovie = j;
                }
                i++;
            }
        }

        System.out.println(arr[firstMovie] + " - " +  arr[secondMovie]);


    }
}
