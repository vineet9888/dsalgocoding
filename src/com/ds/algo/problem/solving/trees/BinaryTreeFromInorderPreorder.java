package com.ds.algo.problem.solving.trees;

import java.util.*;
import java.util.stream.Collectors;

public class BinaryTreeFromInorderPreorder {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        List<Object> objList = new ArrayList<>();
        String first = "vineet";
        String second = "vineet";
        System.out.println(first == second);
        // list = objList;
        Map<Integer , Integer> map = new HashMap<>();
        map.put(1,2);
        map.put(14,7);
        map.put(18,1);

        List<Map.Entry<Integer , Integer>> maplist =  map.entrySet().stream().collect(Collectors.toList());
        Collections.sort(maplist , (item1 , item2) -> {
            return item1.getValue() -item2.getValue();
        });
        map = new HashMap<>();
        for(Map.Entry<Integer , Integer> entry : maplist) {
            map.put(entry.getKey() , entry.getValue());
        }



    }

    public static void createTree(int []preorder , int []inorder) {

    }

}
