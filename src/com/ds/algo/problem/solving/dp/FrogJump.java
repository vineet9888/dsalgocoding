package com.ds.algo.problem.solving.dp;

import java.util.*;
import java.util.stream.Collectors;

public class FrogJump {

    public static boolean canCross(Set<Integer> stoneSet , int[] stones , int curr , int end , int jumps , Map<String , Boolean> cache) {
        if(jumps == 0) {
            return false;
        }
        if(!stoneSet.contains(curr)) {
            return false;
        }
        if(curr == end) {
            return true;
        }
        String key = curr+"-"+jumps;
        if(cache.containsKey(key)) {
            return cache.get(key);
        }

        boolean canCross = canCross(stoneSet , stones , curr + jumps -1 , end , jumps -1 ,cache) ||
                canCross(stoneSet , stones , curr   + jumps  , end , jumps , cache) ||
                canCross(stoneSet , stones , curr  + jumps + 1 , end , jumps + 1 , cache);

         cache.put(key , canCross);
        return canCross;
    }

    public static void main(String[] args) {
        int stone[] = new int[]{0,1,2,3,4,8,9,11};
        int dp[] = new int[20];
        for(int i = 0 ; i < 20;i++) {
            dp[i] = -1;
        }
        Set<Integer> stoneSet = new HashSet<>();
        Map<String , Boolean> cache = new HashMap<>();
        for(int i = 0 ; i < stone.length;i++) {
            stoneSet.add(stone[i]);
        }
        System.out.println(canCross(stoneSet , stone , 1 , stone[stone.length - 1] , 1 , cache));
    }

    public static boolean canCross(Set<Integer> stoneSet , int[] stones , int curr , int end , int jumps , int dp[]) {
        if(jumps == 0) {
            return false;
        }
        if(!stoneSet.contains(curr)) {
            return false;
        }
        if(curr == end) {
            return true;
        }

        if(dp[curr] != -1) {
            return dp[curr] == 1 ? true : false;
        }

        boolean canCross = canCross(stoneSet , stones , curr + jumps -1 , end , jumps -1 ,dp) ||
                canCross(stoneSet , stones , curr   + jumps  , end , jumps , dp) ||
                canCross(stoneSet , stones , curr  + jumps + 1 , end , jumps + 1 , dp);

        dp[curr] = canCross ? 1 : 0;
        return canCross;
    }

}
