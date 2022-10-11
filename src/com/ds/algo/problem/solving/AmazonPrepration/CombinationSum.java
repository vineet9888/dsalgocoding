package com.ds.algo.problem.solving.AmazonPrepration;

import java.util.*;

public class CombinationSum {

    public static void main(String[] args) {

        // this is the main calculation....
        //int arr[] = new int[]{10,1,2,7,6,1,5};
        int arr[] = new int[]{1,2,1,5};
        int target = 8;
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> sublist = new ArrayList<>();
        Map<String , List<Integer>> map = new HashMap<>();
        combinationSum(arr , target , map , sublist);
        map.forEach((key , value) -> {
            ans.add(value);
        });
        System.out.println(ans);
    }


    public static void combinationSum(int[] arr, int target , Map<String , List<Integer>> map , List<Integer> curr) {
        if(target < 0) {
            for(int j = 0; j < arr.length;j++) {
                if(arr[j] < 0) {
                    arr[j] = arr[j]*(-1);
                }
            }
            return;
        }
        for(int i = 0 ; i < arr.length;i++) {
            // found a combination....
            if(target == 0) {
                Map<Integer , Integer> freqMap = new TreeMap<>();
                for (Integer integer : curr) {
                    if(freqMap.containsKey(integer)) {
                        freqMap.put(integer , freqMap.get(integer) + 1);
                    } else {
                        freqMap.put(integer , 1);
                    }
                }
                String key = "";
                for(Map.Entry<Integer , Integer> entry : freqMap.entrySet()) {
                    key += entry.getKey() +"-"+entry.getValue()+",";
                }
                if(!map.containsKey(key)) {
                    map.put(key, curr);
                }
                for(int j = 0; j < arr.length;j++) {
                    if(arr[j] < 0) {
                        arr[j] = arr[j]*(-1);
                    }
                }
            }
            if(target >= arr[i]) {
                if(arr[i] > 0) {
                    List<Integer> sublist = new ArrayList<>();
                    sublist.addAll(curr);
                    int temp = arr[i];
                    sublist.add(temp);
                    arr[i] = arr[i]*(-1);
                    combinationSum(arr , target-temp , map , sublist);
                }
            }
        }
    }
}
