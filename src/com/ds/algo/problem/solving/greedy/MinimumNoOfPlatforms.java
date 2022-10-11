package com.ds.algo.problem.solving.greedy;

import java.util.Arrays;
import java.util.Collections;

public class MinimumNoOfPlatforms {

    public static void main(String[] args) {
//        double arr[] = new double[]{9 , 9.41 , 9.51 , 11 , 15,18};
//        double dep[] = new double[]{9.11 , 12, 11.21 , 11.31 , 19, 20};


        double arr[] = new double[]{9 , 9.40 };
        double dep[] = new double[]{9.10 , 12};


        minPlatforms(arr , dep);
    }


    public static void minPlatforms(double arr[] , double dep[]) {
        Arrays.sort(arr);
        Arrays.sort(dep);
        for(int i = 0 ; i < arr.length;i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("");
        for(int i = 0 ; i < dep.length;i++) {
            System.out.print(dep[i] + " ");
        }

        int i = 1, j=0;
        int ans = -1;
        int platforms = 1;
        while(inBounds(i , j , arr , dep)) {

            while(inBounds(i , j , arr, dep) && arr[i] < dep[j]) {
                i++;
                platforms++;
            }
            ans = Math.max(ans , platforms);
            while(inBounds(i , j , arr, dep) && arr[i] > dep[j]) {
                j++;
                platforms--;
            }
        }

        System.out.println(ans);
    }

    public static boolean inBounds(int i , int j , double arr[] , double dep[]) {
        return (i < arr.length && j < dep.length) ? true : false;
    }
}
