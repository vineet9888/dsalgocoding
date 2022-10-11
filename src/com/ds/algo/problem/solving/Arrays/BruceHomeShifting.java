package com.ds.algo.problem.solving.Arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class BruceHomeShifting {
    public static void main(String[] args) {
       int arr[] = new int[]{1,5,3,3,1};
       int k = 3;
       int moves = 0;
        Arrays.sort(arr);
        int i = 0;
        // 1 2 2 3

        Map<Character , Integer> map = new HashMap<>();
        String s = "";
        Character c = s.charAt(0);
        for(int j = 0 ; j < arr.length;j++) {
            for(int l = 0 ; l < arr.length;l++) {
                if(l != j) {
                    if(arr[j] + arr[l] <= k) {

                    }
                }
            }
            //
        }



        while(i < arr.length) {
            if(i == arr.length - 1) {
                moves += 1;
                break;
            }
            if(arr[i] + arr[i+1] <= k) {
                i = i + 2;
                moves += 1;
            } else {
                moves += 1;
                i++;
            }
        }
        System.out.println(moves);

    }
}
