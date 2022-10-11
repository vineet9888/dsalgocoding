package com.ds.algo.problem.solving.Arrays;

import java.util.*;
import java.util.stream.Collectors;

public class OYO {



    /*
    Count Sum of Distinct Elements in every Window of size K

            arr = 1, 2, 1, 3, 4, 4, 3
            k = 3

            1 - 2
            2 - 1

            3

            1 - 1
            2 - 1
            3 - 1




            w1 = 3
            w2 = 6
            w3 = 8
            w4 = 7
            w5 = 7

    */


    public static void main(String[] args) {
        int arr[] = new int[]{1, 2, 1, 3, 4, 4, 3};
        List<Integer> ans = new ArrayList<>();
        int k = 3;

        Map<Integer , Integer> map = new HashMap<>();
        List<Map.Entry<Integer , Integer>> entry= map.entrySet().stream().collect(Collectors.toList());
        Collections.sort(entry, (first, second) ->{
            return first.getValue().compareTo(second.getValue());
        });
        Map<Integer, Integer> sortedByValue = new HashMap<>();
        for (Map.Entry<Integer, Integer> item : entry) {
            sortedByValue.put(item.getKey() , item.getValue());
        }
        for(int i = 0 ; i < k;i++) {
            if(map.containsKey(arr[i])) {
                map.put(arr[i] , map.get(arr[i]) + 1);
            } else {
                map.put(arr[i] , 1);
            }
        }
        ans.add(getMapKeySum(map));

        // int arr[] = new int[]{1, 2, 1, 3, 4, 4, 3};
        int i = 0;
        int j = 3;

        while(j < arr.length) {
            // remove from window start.
            if(map.containsKey(arr[i])) {
                if(map.get(arr[i]) > 1) {
                    map.put(arr[i] , map.get(arr[i]) - 1);
                } else if(map.get(arr[i]) == 0 || map.get(arr[i]) == 1)  {
                    map.remove(arr[i]);
                }
                i++;
            }
            // add new end of window..
            if(map.containsKey(arr[j])) {
                map.put(arr[j] , map.get(arr[j]) + 1);
            } else {
                map.put(arr[j] , 1);
            }
            j++;
            ans.add(getMapKeySum(map));
        }
        System.out.println(ans);
    }


    public static int getMapKeySum(Map<Integer , Integer> map) {
        int sum = 0;
        for(Map.Entry<Integer , Integer> entry : map.entrySet()) {
            sum += entry.getKey();
        }
        return sum;
    }
}
