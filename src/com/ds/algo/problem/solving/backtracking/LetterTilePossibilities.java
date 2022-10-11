package com.ds.algo.problem.solving.backtracking;

import java.util.*;
import java.util.stream.Collectors;

public class LetterTilePossibilities {

    public static int numTilePossibilities(String tiles) {
        Set<String> set = new HashSet<>();
        Set<Integer> inc = new HashSet<>();
        permute(tiles, 0 , "" , set , inc);
        System.out.println(set.size());
        return 0;
    }

    public static void permute(String tiles , int curr , String str , Set<String> set, Set<Integer> inc) {
        if(curr >= tiles.length()) {
            return;
        }
        for(int i = 0 ; i < tiles.length();i++) {
            if(!inc.contains(i)) {
                inc.add(i);
                String temp = str + String.valueOf(tiles.charAt(i));
                if(!set.contains(temp)) {
                    System.out.println(temp);
                    set.add(temp);
                    permute(tiles , curr + 1 , temp , set , inc);
                }
                inc.remove(i);
            }

        }
    }


    public static void main(String[] args) {
        // numTilePossibilities("AACD");
        Map<Integer , String> map = new HashMap<>();
        map.put(10 , "Z");
        map.put(12,"C");
        map.put(11 , "B");
        map.put(3 , "W");
        map.put(4 , "A");

        List<Map.Entry<Integer , String>> list = map.entrySet().stream().collect(Collectors.toList());
        Collections.sort(list , (o1, o2) ->  {
            return o1.getValue().compareTo(o2.getValue());
        });

        list.forEach((entry) -> {
            System.out.println(entry.getKey() + " " + entry.getValue());
        });


    }
}
