package com.ds.algo.problem.solving.Arrays;

import java.util.*;
import java.util.stream.Collectors;

public class SortCharactersByFrequency {

    public static void main(String[] args) {
        String s = "tree";
        System.out.println(frequencySort(s));

    }


    public static String frequencySort(String s) {
        Map<Character , Integer> map = new HashMap<>();
        for(int i = 0;i < s.length();i++) {
            Character c = s.charAt(i);
            if(map.containsKey(c)) {
                map.put(c , map.get(c)+1);
            } else {
                map.put(c,1);
            }
        }

        Set<Map.Entry<Character , Integer>> set = map.entrySet();
        List<Map.Entry<Character , Integer>> list = set.stream().sorted((first , second) -> {
            return second.getValue() - first.getValue();
        }).collect(Collectors.toList());

        String ans = "";
        for(Map.Entry<Character,Integer> entry : list) {
            for(int i = 0 ; i < entry.getValue();i++) {
                ans += entry.getKey();
            }
        }
        return ans;
    }
}
