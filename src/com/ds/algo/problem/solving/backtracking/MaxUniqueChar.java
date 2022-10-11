package com.ds.algo.problem.solving.backtracking;

import java.util.*;

public class MaxUniqueChar {

    public static int max = 0;

    public static void main(String[] args) {
        List<String> arr = new ArrayList<>();
        arr.add("abcdefghijklmnopqrstuvwxyz");

        findMaxLength(arr , 0  ,"");
        System.out.println(max);
    }

    public static void findMaxLength(List<String> arr , int index , String curr) {
        System.out.println(curr);
        int ans = uniqueLength(curr);
        if(ans == -1) {
            return;
        }

        if(max < ans) {
            max = ans;
        }


        if(index >= arr.size()) {
            return;
        }
        findMaxLength(arr , index + 1 , curr + arr.get(index));
        findMaxLength(arr , index + 1 , curr);

    }

    public static int uniqueLength(String s) {
        Set<Character> set = new HashSet<>();
        for(int i = 0 ; i < s.length();i++) {
            Character ch = s.charAt(i);
            if(set.contains(ch)) {
                return -1;
            } else {
                set.add(ch);
            }
        }
        System.out.println(set.size() + " - unique characters");
        return set.size();
    }


}
