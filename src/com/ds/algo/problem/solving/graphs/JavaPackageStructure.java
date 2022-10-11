package com.ds.algo.problem.solving.graphs;

import java.util.*;

public class JavaPackageStructure {

    public static final int PADDING = 5;

    public static void main(String[] args) {
        List<String> packages = new ArrayList<>();
        packages.add("java.util.List");
        packages.add("java.util.vector");
        packages.add("java.util.regex.Pattern");
        packages.add("org.json.JSONObject");
        packages.add("org.writequit.Strings");



        Map<String  , Set<String>> map = new HashMap<>();

        packages.forEach((item) -> {
            int prev = -1;
            String prevKey = "";
            for(int i = 0 ; i  < item.length();i++) {
                if(item.charAt(i) == '.') {
                    if(prev == -1) {
                        String key = item.substring(0 , i);
                        prevKey = key;
                        if(!map.containsKey(key)) {
                            map.put(key , new HashSet<>());
                        }
                        prev = i+1;
                    } else {
                        String key = item.substring(prev , i);
                        map.get(prevKey).add(key);
                        if(!map.containsKey(key)) {
                            map.put(key , new HashSet<>());
                        }
                        prevKey = key;
                        prev = i+1;
                    }
                }
                if(i == item.length() - 1) {
                    String key = item.substring(prev , i+1);
                    map.get(prevKey).add(key);
                    if(!map.containsKey(key)) {
                        map.put(key , new HashSet<>());
                    }
                    prevKey = key;
                    prev = i+1;
                }
            }
        });

        /*map.forEach((key , value) -> {
            System.out.println(key + " -> " + value);
        });*/


        printTraversal(map , "java" ,0);
        printTraversal(map , "org" ,0);

    }


    public static void printTraversal(Map<String  , Set<String>> map , String key , int level) {
        System.out.println(getSpacePadding(level)  + key+":");
        if(map.containsKey(key)) {
            map.get(key).forEach((item) -> {
                printTraversal(map , item , level + PADDING);
            });
        }
    }

    public static String getSpacePadding(int level) {
        String res = "";
        for(int i = 0 ; i < level;i++) {
            res += " ";
        }
        return res;
    }

}





class QueueItem {
    String data;
    int level;
    QueueItem(String data , int level) {
        this.data = data;
        this.level = level;
    }
}