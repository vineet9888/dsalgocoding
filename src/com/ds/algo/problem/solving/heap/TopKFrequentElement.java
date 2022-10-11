package com.ds.algo.problem.solving.heap;

import java.util.*;

public class TopKFrequentElement {

    public static void main(String[] args) {
        int arr[] = new int[]{1,1,1,2,2,3};
        int ans[] = topKFrequent(arr , 2);
        for(int i = 0 ; i <ans.length;i++) {
            System.out.print(ans[i] + " ");
        }
    }

    public static int[] topKFrequent(int[] arr, int k) {
        Queue<PQItem> queue = new PriorityQueue<>((a , b) -> {
            return b.frequency.compareTo(a.frequency);
        });
        Map<Integer , Integer> map = new HashMap<>();
        for(int i = 0 ; i < arr.length;i++) {
            if(map.containsKey(arr[i])) {
                map.put(arr[i] , map.get(arr[i]) + 1);
            } else {
                map.put(arr[i] , 1);
            }
        }
        map.forEach((key , value) -> {
            queue.add(new PQItem(key , value));
        });
        int ans[] = new int[k];

        int i = 0;
        while(!queue.isEmpty() && i <k) {
            ans[i] = queue.poll().val;
            i++;
        }



        return ans;
    }
}


class PQItem {
    int val;
    Integer frequency;

    public PQItem(int val , int frequency) {
        this.frequency =frequency;
        this.val = val;
    }
}
