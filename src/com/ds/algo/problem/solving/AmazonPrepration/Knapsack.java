package com.ds.algo.problem.solving.AmazonPrepration;

import java.util.Arrays;

public class Knapsack {

    public static void main(String[] args) {
        int values[] = new int[]{60 , 100 , 120};
        int weights[] = new int[]{10 , 20 , 30};
        Arrays.binarySearch(values , 1);
        int weight = 50;
        int ans = knapsack(values , weights,weight,0);
        System.out.println(ans);
    }


    public static int knapsack(int val[] , int wt[] , int w , int index) {
        int ans = 0;
        if(w <= 0) {
            return 0;
        }
        if(index >= wt.length) {
            return 0;
        }
        int currentIndexValue = w-wt[index] < 0 ? 0 :   val[index];
        int first = currentIndexValue + knapsack(val , wt , w-wt[index] , index + 1);
        int second = knapsack(val , wt , w , index + 1);
        ans = Math.max(first , second);
        return ans;
    }
}
