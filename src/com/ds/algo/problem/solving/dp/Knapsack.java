package com.ds.algo.problem.solving.dp;

import java.util.ArrayList;
import java.util.List;

public class Knapsack {

    public static void main(String[] args) {
        int value[] = new int[]{60 , 120 , 100};
        int weight[] = new int[]{10,20,30};
        int w = 50;
        //System.out.println(knapsack(value , weight , value.length-1 , w));
        List<Integer> iv = new ArrayList<>();
        List<Integer> articles = new ArrayList<>();
        iv.add(3);iv.add(2);iv.add(2);
        articles.add(3);articles.add(2);articles.add(2);
        System.out.println(maximumLearning(iv , articles , 9));
    }

    public static int maximumLearning(List<Integer> iv, List<Integer> articles, int p) {
        int size = articles.size();
        int art[] = new int[size];
        int ivs[] = new int[size];
        for(int i = 0 ; i < size;i++) {
            art[i] = articles.get(i)*2;
            ivs[i] = iv.get(i);
        }
        //return knapsack(ivs , art , p , size);
        int dp[][] = new int[size][p+1];
        for(int i = 0 ; i < size;i++) {
            for(int j = 0;j<=p;j++) {
                dp[i][j] = -1;
            }
        }
        return knap(ivs , art , p , size-1 , dp);
    }

    public static int knap(int val[] , int wt[] , int W , int n , int dp[][]) {

        if(n < 0) {
            return 0;
        }
        if(dp[n][W] != -1) {
            return dp[n][W];
        }
        int notTake = knap(val , wt , W , n-1 , dp);
        int take = 0;
        if(W >= wt[n]) {
            take = val[n] + knap(val , wt , W-wt[n] , n-1 , dp);
        }
        dp[n][W] = Math.max(take , notTake);
        return dp[n][W];
    }

    public static int knapsack(int val[] , int weight[] , int n , int w){

        if(n < 0) {
            return 0;
        }
        int ans = 0;
        int notPick = knapsack(val , weight , n-1 , w);
        int pick = 0;
        if(w >= weight[n]) {
            pick = val[n] + knapsack(val , weight , n-1 , w-weight[n]);
        }
        return Math.max(pick , notPick);
    }
}
