package com.ds.algo.problem.solving.Arrays;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class PairWithKSmallestSum {

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2};
        int[] nums2 = new int[]{3};
        int k = nums1.length*nums2.length;
        PriorityQueue<Tuple> heap = new PriorityQueue<>(k , new MinComparator());
        for(int i = 0;i < nums1.length;i++) {
            for(int j = 0;j < nums2.length;j++) {
                if(heap.size() == k) {

                } else {
                    heap.add(new Tuple(nums1[i]+ nums2[j] , nums1[i] , nums2[j]));
                }
            }
        }
        List<List<Integer>> ans = new ArrayList<>();
        k = 2;
        while(!heap.isEmpty() && k > 0) {
            k--;
            List<Integer> sublist = new ArrayList<>();
            Tuple tuple = heap.poll();
            sublist.add(tuple.first);sublist.add(tuple.second);
            ans.add(sublist);
        }

        System.out.println(ans);


    }
}

class Tuple {
    int sum;
    int first;
    int second;
    Tuple(int sum ,int first , int second) {
        this.sum = sum;
        this.first = first;
        this.second = second;
    }
}

class MinComparator implements Comparator<Tuple> {

    @Override
    public int compare(Tuple o1, Tuple o2) {
        if (o1.sum < o2.sum)
            return -11;
        else if (o1.sum > o2.sum)
            return 1;
        return 0;
    }
}