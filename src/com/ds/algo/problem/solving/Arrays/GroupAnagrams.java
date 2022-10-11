package com.ds.algo.problem.solving.Arrays;

import java.util.*;

public class GroupAnagrams {
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String , Integer> map1 = new HashMap<>();
        List<List<String>> ans = new ArrayList<>();
        for(int i = 0;i < strs.length;i++) {
            String str = strs[i];
            int arr[] = new int[26];
            for(int j = 0; j < str.length();j++) {
                Character c = str.charAt(j);
                int pos = c - 'a';
                arr[pos] = arr[pos] + 1;
            }
            String key ="";
            for(int j= 0;j < arr.length;j++) {
                if(arr[j] > 0) {
                    char c = (char)(j+97);
                    key += String.valueOf(c)+arr[j];
                }
            }

            if(map1.containsKey(key)) {
                ans.get(map1.get(key)).add(str);
            } else {
                List<String> list = new ArrayList<>();
                list.add(str);
                ans.add(list);
                map1.put(key , ans.size()-1);
            }
        }
        return ans;

    }

    public static void main(String[] args) {
        String str[] = new String[]{"eat","tea","tan","ate","nat","bat"};
        Set<Integer> set = new HashSet<>();
        String s = "AABC";
        String.valueOf(s.charAt(1));
        Set<String> inc = new HashSet<>();


        System.out.println(groupAnagrams(str));
        System.out.println(hashFunc("eat"));
    }

    public static String hashFunc(String s){

        char[] count = new char[26];
        for(int i=0;i<s.length();i++){
            count[s.charAt(i)-'a']++;
        }
        return String.valueOf(count);

    }
}
