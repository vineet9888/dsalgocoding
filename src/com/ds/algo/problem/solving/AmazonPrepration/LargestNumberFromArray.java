package com.ds.algo.problem.solving.AmazonPrepration;

import java.util.Arrays;
import java.util.Collections;

public class LargestNumberFromArray {

    public static void main(String[] args) {
        Integer arr[] = new Integer[]{10, 7, 76, 415};
        /*String first = "776";
        String second = "767";
        System.out.println(second.compareTo(first));*/
        String str[] = new String[arr.length];
        for(int i = 0 ; i < arr.length;i++) {
            str[i] = String.valueOf(arr[i]);
        }
        Arrays.sort(str , (a , b) -> {
            String first = String.valueOf(a) + String.valueOf(b);
            String second = String.valueOf(b) + String.valueOf(a);
            System.out.println(first +" - " +  second + " - " + first.compareTo(second));
            return second.compareTo(first);
        });

        for(int i = 0 ; i < str.length;i++) {
            System.out.println(str[i]);
        }


    }
}
