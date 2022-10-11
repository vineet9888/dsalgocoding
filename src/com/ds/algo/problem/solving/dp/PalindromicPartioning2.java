package com.ds.algo.problem.solving.dp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PalindromicPartioning2 {

    public static final Integer MAX_VALUE = 10000;

    public static boolean ispalin(String input, int begin, int end) {
        while (begin < end) {
            if (input.charAt(begin) != input.charAt(end))
                return false;
            begin++;
            end--;
        }
        return true;
    }





    // cuts can be made at every position.... of the string.....
    // n i t i n
    // 0 1 2 3 4
    // i = 0 j = n-1
    public static int minCuts(String str,int i ,int j, HashMap<String , Integer> map) {
        if(i >= j || ispalin(str, i , j)) {
            return 0;
        }
        String key = i + " - " + j;
        if(map.containsKey(key)) {
            return map.get(key);
        }
        int ans = 10000;
        for(int k = i;k < j;k++) {
            int temp = 1 + minCuts(str , i , k , map)  + minCuts(str , k +1 , j , map);
            ans = Math.min(temp, ans);
        }
        map.put(key , ans);
        return ans;
    }


    public static int minCut(String s , int index) {
        System.out.println(index);
        int ans = MAX_VALUE;
        int size = s.length();
        if(size == 1) {
            return 0;
        }
        for(int i = 1 ; i <= size;i++) {
            String first = s.substring(0, i);
            if(isPalin(first)) {
                String second = s.substring(i , size);
                if(second.length() != 0) {
                    ans = Math.min((1 + minCut(second, i)) , ans);
                } else {
                    ans = 0;
                }
            }
        }
        return ans;
    }

    public static boolean isPalin(String str) {
        boolean isPalin = true;
        int start = 0;
        int end = str.length() - 1;
        while(start <= end) {
            if(str.charAt(start) == str.charAt(end)) {
                start++;
                end--;
            } else {
                isPalin = false;
                break;
            }
        }
        return isPalin;
    }


    public static void main(String[] args) {
        String s = "nitin";
        HashMap<String , Integer> map = new HashMap<>();
        System.out.println(minCuts(s , 0,s.length()-1 , map));
    }

}
