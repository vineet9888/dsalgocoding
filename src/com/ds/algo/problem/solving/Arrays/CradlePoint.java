package com.ds.algo.problem.solving.Arrays;


/*

Given an array of intervals where intervals[i] = [starti, endi],
merge all overlapping intervals and return an array of the non-overlapping
intervals that cover all the intervals in the input.

        Example 1:
        Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
        Output: [[1,6],[8,10],[15,18]]

        Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
        Example 2:

        Input: intervals = [[1,4],[4,5]]
        Output: [[1,5]]
        Explanation: Intervals [1,4] and [4,5] are considered overlapping.


        Constraints:

        1 <= intervals.length <= 104
        intervals[i].length == 2
        0 <= starti <= endi <= 104


*/


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CradlePoint {

    public static void main(String[] args) {
        Integer arr[][] = new Integer[][] {
                {1,3},
                {2,6} ,
                {8,10},
                {15,18}

        };
        /*List<Integer[]> ans = mergeIntervals(arr);
        System.out.println("Merged Intervals : ");
        for(int i = 0 ; i < ans.size();i++) {
            System.out.println(ans.get(i)[0] + " " + ans.get(i)[1]);
        }*/
        mergeIntervalsAgain(arr);
    }

    public static void mergeIntervalsAgain(Integer arr[][]) {
        Arrays.sort(arr , (first ,second) -> {
            return first[0].compareTo(second[0]);
        });

        for(int i = 0; i < arr.length;i++) {
            System.out.println(arr[i][0] + " -> " + arr[i][1]);
        }
        int i = 1;
        List<Integer[]> ans = new ArrayList<>();
        ans.add(arr[0]);
        while(i < arr.length) {
            int size = ans.size()-1;
            if(ans.get(size)[1] >= arr[i][0]) {
                ans.get(size)[1] = Math.max(arr[i][0] , ans.get(size)[1]);
            } else {

            }
        }

    }

    public static List<Integer[]> mergeIntervals(Integer arr[][]) {
        List<Integer[]> ans = new ArrayList<>();
        Arrays.sort(arr , (a , b) -> {
            return a[0] - b [0];
        });
        ans.add(arr[0]);
        int i = 1;
        while( i < arr.length) {
            int size = ans.size() - 1;
            if(arr[i][0] <= ans.get(size)[1]) {
                ans.get(size)[1] = Math.max(ans.get(size)[1] , arr[i][1]);
                i++;
            } else {
                ans.add(arr[i]);
                i++;
            }
        }
        return ans;
    }

}
