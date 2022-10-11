package com.ds.algo.problem.solving.dp;

import java.util.HashMap;
import java.util.Map;

public class MinCostForTickets {

    public static int findMinCostTickets(int days[], int costs[] , int day , int arr[] , int maxDay,
                                         Map<Integer , Integer> cache) {
        // next available day is 1 day ahead
        if(day > maxDay || day == -1) {
            return 0;
        }

        if(cache.containsKey(day)) {
            return cache.get(day);
        }
        int ans = Integer.MAX_VALUE;
        int nextAvailableDay = findNextAvailableDay(arr , day + 1);
        ans = costs[0] + findMinCostTickets(days , costs, nextAvailableDay ,arr , maxDay , cache);

        // next available day is 7 days ahead
        nextAvailableDay = findNextAvailableDay(arr , day + 7);

        ans = Math.min(ans , costs[1] + findMinCostTickets(days , costs,nextAvailableDay,arr , maxDay , cache));

        // next available day is 30 days ahead
        nextAvailableDay = findNextAvailableDay(arr , day + 30);

        ans = Math.min(ans, costs[2] + findMinCostTickets(days , costs,nextAvailableDay,arr , maxDay , cache));

        cache.put(day , ans);


        return ans;
    }

    public static int findNextAvailableDay(int arr[] , int day) {
        int ans = -1;
        for(int i = day;i < arr.length;i++) {
            if(arr[i] == 1) {
                ans = i;
                break;
            }
        }
        return ans;
    }

    public static int mincostTickets(int[] days, int[] costs) {
        int arr[] = new int[366];
        for(int i = 0;i<days.length;i++) {
            arr[days[i]] = 1;
        }
        int maxDay = days[days.length - 1];
        Map<Integer , Integer> cache = new HashMap<>();
        return findMinCostTickets(days,costs,days[0] , arr ,maxDay , cache);
    }

    public static void main(String[] args) {

        int days[] = new int[]{1,2,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,20,21,24,25,27,28,29,30,31,34,37,38,39,41,43,44,45,47,48,49,54,57,60,62,63,66,69,70,72,74,76,78,80,81,82,83,84,85,88,89,91,93,94,97,99};
        int costs[] = new int[]{9,38,134};
        System.out.println(mincostTickets(days,costs));
    }

}
