package com.ds.algo.problem.solving.backtracking;

import java.util.ArrayList;
import java.util.List;

public class AllSubsetSum {

    public static void main(String[] args) {
        int arr[] = new int[]{5 , 3 , 8};
        List<Integer> ans = new ArrayList<>();
        generate(ans , arr , 0 , 0);
        System.out.println(ans);
    }

    public static void generate(List<Integer> ans , int arr[] , int index , int sum) {
        if(index == arr.length) {
            ans.add(sum);
            return;
        }
        if(index > arr.length) {
            return;
        }
        generate(ans , arr , index + 1 , sum + arr[index]);
        generate(ans , arr , index + 1 , sum);
    }

}
