package com.ds.algo.problem.solving.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {

    public static void main(String[] args) {
        int intervals[][] = new int[][] {
                {4,8},
                {2,7},
                {1,3},
                {9,15},
                {21,22},
                {10,19}
        };

//        int intervals[][] = new int[][] {
//                {1,4},
//                {2,3}
//        };

        System.out.println(mergeIntervals(intervals));
    }

    public static int[][] mergeIntervals(int intervals[][]) {
        Arrays.sort(intervals , (int first[] , int second[]) -> {
            return first[0] - second[0];
        });

        for(int i = 0 ; i < intervals.length;i++) {
            System.out.println(intervals[i][0] + " - " + intervals[i][1]);
        }

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> top = new ArrayList<>();;
        top.add(intervals[0][0]);
        top.add(intervals[0][1]);
        ans.add(top);
        int count = 1;
        while(count < intervals.length) {
            top = ans.get(ans.size() - 1);
            if(top.get(1) >= intervals[count][0]) {
                top.set(1 , intervals[count][1] > top.get(1) ? intervals[count][1] : top.get(1));
            } else {
                top = new ArrayList<>();
                top.add(intervals[count][0]);
                top.add(intervals[count][1]);
                ans.add(top);
            }
            count++;
        }
        int arr[][] = new int[ans.size()][2];

        count = 0;
        for (List<Integer> item : ans) {
            int a[] = new int[2];
            a[0] = item.get(0);
            a[1] = item.get(1);
            arr[count] = a;
            count++;
        }

        System.out.println("--------------");
        for(int i = 0 ; i < arr.length;i++) {
            System.out.println(arr[i][0] + " - " + arr[i][1]);
        }

        return arr;
    }

}
