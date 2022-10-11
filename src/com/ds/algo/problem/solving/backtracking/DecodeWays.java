package com.ds.algo.problem.solving.backtracking;

import java.util.HashMap;
import java.util.Map;

public class DecodeWays {

    public static void main(String[] args) {
        Map<Integer , Integer> map = new HashMap<>();
        System.out.println(decodeWays("607" , 0 , map));


    }

    public static int decodeWays(String s , int pos , Map<Integer , Integer> map) {

        int len = s.length();
        if(s.isEmpty() || pos >= len) {
            return 0;
        }

        if(map.containsKey(pos)) {
            return map.get(pos);
        }

        if(pos == len-1) {
            char ch = s.charAt(pos);
            if(ch == '0') {
                return 0;
            } else {
                return 1;
            }
        }
        int count = 0;
        if(pos < len -1) {
            char firstChar = s.charAt(pos);
            char secondChar = s.charAt(pos + 1);
            Integer single = Integer.valueOf(String.valueOf(firstChar));
            Integer doubl = (single != 0) ? (Integer.valueOf(String.valueOf(firstChar) + String.valueOf(secondChar))) : (100);

            if(single != 0) {
                count += decodeWays(s , pos+1 , map);
            }
            if(doubl > 0 && doubl <= 26) {
                if(pos == len -2) {
                    count = count + 1;
                } else {
                    count += decodeWays(s , pos + 2 , map);
                }
            }
        }
        map.put(pos , count);
        return count;
    }
}
