package com.ds.algo.problem.solving.AmazonPrepration;

import java.util.HashMap;
import java.util.Map;

public class PairSumDivisibleByK {

    public static void main(String[] args) {
        //int arr[] = new int[]{30,20,150,100,40};
        int arr[] = new int[]{60,60,60};
        System.out.println(numPairsDivisibleBy(arr));

    }


    public static int numPairsDivisibleBy(int[] time) {

        //  this array represents how many numbers will produce the same remainder.
        // remainders[0] means how many numbers are divisible by 60;
        int[] remainders = new int[60];
        int count = 0;
        for(int t : time ) {

            if(t%60 ==0) {   // if the number is divisble by 60, then any other number which is divisble by 60 can be paired with this song
                count+=remainders[0];
            }else {

                // Don't do (60-t)%60. It is wrong.
                // If sum of  the remainders of two number is equal to 60, then those two numbers when added will also be divisble by 60.
                // 60-t%60 tells us by how much a given number is off by to be completely divisble by 60.
                count += remainders[60-t%60];
            }

            remainders[t%60]++;
        }

        return count;
    }

    public static int numPairsDivisibleBy60(int[] time) {
        Map<Integer , Integer> map = new HashMap<>();
        int ans = 0;
        for(int i = 0 ; i < time.length;i++) {
            int remainder = time[i]%60;
            int key = 60 - remainder;
            if(remainder == 0) {
                key = 0;
            }
            if(map.containsKey(key)) {
                ans++;
            }


            if(map.containsKey(remainder)) {
                map.put(remainder , map.get(remainder) + 1);
            } else {
                map.put(remainder , 1);
            }
        }
        return ans;
    }
}
