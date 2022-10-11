package com.ds.algo.problem.solving.Arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinimumWindowSubstring {


    public static void main(String[] args) {
        String s = "geeksforgeeks";
        String t = "ork";
        List<Integer> list = new ArrayList<>();

        /*s
        a 0
        b -1
          acbbaca

        da*/

        Map<Character , Integer> map = new HashMap<>();
        for(int i = 0;i < t.length();i++) {
            if(map.containsKey(t.charAt(i))) {
                map.put(t.charAt(i) , map.get(t.charAt(i)) + 1);
            } else {
                map.put(t.charAt(i) , 1);
            }
        }
        int i = 0, j = 0 ,k=0 ,ans = 100000 , count = t.length();
        String res = "";
        while(i <= j && j < s.length()) {
            while(k == map.size()) {
                // we have met the condition ,now try to shrink the window
                if(ans > (j-i+1)) {
                    res = s.substring(i,j+1);
                    ans = Math.min(ans , j-i+1);
                }
                Character curr = s.charAt(i);
                if(map.containsKey(curr)) {
                    map.put(curr , map.get(curr) + 1);
                    if(map.get(curr) > 0) {
                        k--;
                        j++;
                    }
                }
                i++;
            }
            if(j < s.length()) {
                Character curr = s.charAt(j);
                if(map.containsKey(curr)) {
                    map.put(curr , map.get(curr) - 1);
                    if(map.get(curr) == 0) {
                        k++;
                        if(map.size() > k) {
                            j++;
                        }
                    } else {
                        j++;
                    }
                } else {
                    j++;
                }
            }
        }

        System.out.println(ans + " - " + res);
    }
}
