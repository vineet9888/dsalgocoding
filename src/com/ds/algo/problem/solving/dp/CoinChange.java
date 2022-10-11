package com.ds.algo.problem.solving.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CoinChange {

    public static void main(String[] args) {
        int arr[] = new int[]{2};
        Arrays.sort(arr);
        Map<Integer , Integer> cache = new HashMap<>();
        int ans = minCoins(arr , 3 , cache);


        System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);

    }

    public static int minCoins(int coins[] , int sum , Map<Integer , Integer> cache) {
        if(sum ==0) {
            return 0;
        }

        if(cache.containsKey(sum)) {
            return cache.get(sum);
        }

        int ans = Integer.MAX_VALUE;
        for(int i = 0 ; i < coins.length;i++) {
            if(coins[i] <= sum) {
                int subans = minCoins(coins , sum -coins[i] , cache);
                int temp = 1;
                if(subans == Integer.MAX_VALUE) {
                    temp = Integer.MAX_VALUE;
                } else {
                    temp += subans;
                }

               ans = Math.min(ans , temp);
            }
        }
        cache.put(sum , ans);
        return ans;
    }

}
