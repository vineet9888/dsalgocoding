package com.ds.algo.problem.solving.Arrays;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Adobe1 {

    public static void main(String[] args) {
        Map<Integer , Integer> cache = new HashMap<>();
//        System.out.println(findMinWays(4 , cache));
//        System.out.println(findMinWays(12, cache));
       // System.out.println(findMinWays(132 , cache));
        System.out.println(findMinWays(104 , cache));

        // select * from employee order by salary desc limit 5,1
        //  ;
    }

    public static int findMinWays(int n , Map<Integer , Integer> cache) {
        if(n == 0) {
            return 0;
        }
        if(cache.containsKey(n)) {
            return cache.get(n);
        }
        int ans = Integer.MAX_VALUE;
        for(int i = 1;i <= n;i++) {
            if(isPerfectSquare(i)) {
                ans = Math.min(ans , 1 + findMinWays(n-i , cache));
            }
        }
        cache.put(n , ans);
        return ans;
    }

    public static boolean isPerfectSquare(int n) {
        Set<Integer> perfectSquares = new HashSet<>();
        perfectSquares.add(1);
        perfectSquares.add(4);
        perfectSquares.add(9);
        perfectSquares.add(16);
        perfectSquares.add(25);
        perfectSquares.add(36);
        perfectSquares.add(49);
        perfectSquares.add(64);
        perfectSquares.add(81);
        perfectSquares.add(100);
        return perfectSquares.contains(n);
    }

}



