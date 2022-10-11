package com.ds.algo.problem.solving.dp;

import java.util.*;

public class CountWaysToSumN {

    static Set<String> set = new HashSet<>();

    public static void main(String[] args) {

       int arr[] = new int[]{1,2};
       System.out.println(countWays(8 , arr , ""));
       System.out.println(set);
    }

    public static int countWays(int n , int arr[] , String curr) {
        if(n < 0) {
            return 0;
        }
        if(n == 0) {
            List<Integer> list = new ArrayList<>();
            Map<Integer , Integer> map = new TreeMap<>();
            for(int i = 0 ; i < curr.length();i++) {
                Integer item = Integer.valueOf(String.valueOf(curr.charAt(i)));
                map.putIfAbsent(item , 0);
                map.put(item , map.get(item) + 1);
            }
            final StringBuilder item = new StringBuilder();
            map.forEach((k,v) -> {
                item.append(k +"_"+v);
            });
            set.add(item.toString());
            System.out.println(curr + " -> " + item.toString());
            return 1;
        }
        int ans = 0;
        for(int i = 0;i < arr.length;i++) {
            ans += countWays(n-arr[i] , arr , curr+arr[i]);
        }
        return ans;
    }
}
