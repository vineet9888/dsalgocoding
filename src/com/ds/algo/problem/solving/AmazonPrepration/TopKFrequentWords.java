package com.ds.algo.problem.solving.AmazonPrepration;

import java.util.*;

public class TopKFrequentWords {

    public static void main(String[] args) {
        String words[] = new String[]{"the","day","is","sunny","the","the","the","sunny","is","is"};
        Map<String , Integer> map = new HashMap<>();
        for(int i = 0 ; i < words.length;i++) {
            String word = words[i];
            if(map.containsKey(word)) {
                map.put(word , map.get(word) +1);
            } else {
                map.put(word ,1);
            }
        }

        TreeMap<Integer , TreeSet<String>> map1 = new TreeMap<>((Integer a , Integer b) -> b-a );


        for(Map.Entry<String ,Integer> entry : map.entrySet()) {
            Integer newMapKey = entry.getValue();
            if(map1.containsKey(newMapKey)) {
                map1.get(newMapKey).add(entry.getKey());
            } else {
                TreeSet<String> set = new TreeSet<>();
                set.add(entry.getKey());
                map1.put(newMapKey , set);
            }
        }

        List<String> ans = new ArrayList<>();
        int k = 4;
        for(Map.Entry<Integer , TreeSet<String>> entry : map1.entrySet()) {
            TreeSet<String> set = entry.getValue();
            for (String s : set) {
                if(k == 0) {
                    break;
                }
                ans.add(s);
                k--;
            }
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }



    }
}
