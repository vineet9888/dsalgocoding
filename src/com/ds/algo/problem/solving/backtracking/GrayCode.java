package com.ds.algo.problem.solving.backtracking;

import java.util.ArrayList;
import java.util.List;

public class GrayCode {

    public static void main(String[] args) {
        List<String> ans = new ArrayList<>();
        generate(0 , 3 , ans , "");
        ans.forEach(System.out::println);
    }

    public static void generate(int start , int len , List<String> ans , String curr) {
        if(start > len) {
            return;
        }
        if(start == len) {
            ans.add(curr);
            return;
        }
        generate(start + 1 , len , ans , curr + "0");
        generate(start + 1 , len , ans , curr + "1");
    }
}
