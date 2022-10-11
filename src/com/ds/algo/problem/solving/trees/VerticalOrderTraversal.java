package com.ds.algo.problem.solving.trees;

import java.util.*;

public class VerticalOrderTraversal {


    public static void traverse(TreeMap<Integer,TreeMap<Integer , ArrayList<Integer>>> map , TreeNode node , int level , int hd) {
        if(node == null) {
             return;
        }
        if(map.containsKey(hd)) {
            if(map.get(hd).containsKey(level)) {
                map.get(hd).get(level).add(node.val);
            } else {
                ArrayList<Integer> list = new ArrayList<Integer>(){
                    {
                        add(node.val);
                    }
                };
                map.get(hd).put(level , list);
            }
        } else {
            TreeMap<Integer , ArrayList<Integer>> levelMap = new TreeMap<>();
            ArrayList<Integer> list = new ArrayList<Integer>(){
                {
                    add(node.val);
                }
            };
            levelMap.put(level , list);
            map.put(hd , levelMap);
        }
        traverse(map , node.left , level + 1 , hd - 1);
        traverse(map , node.right , level + 1 ,hd + 1);
    }


    public static List<List<Integer>> traverse(TreeNode node) {
        TreeMap<Integer,TreeMap<Integer , ArrayList<Integer>>> map = new TreeMap<>();
        traverse(map,node,0,0);
        List<List<Integer>> ans = new ArrayList<>();

        for(Map.Entry<Integer , TreeMap<Integer , ArrayList<Integer>>> entry : map.entrySet()) {
            ArrayList<Integer> list = new ArrayList<>();
            for(Map.Entry<Integer , ArrayList<Integer>> levelEntry : entry.getValue().entrySet()){
                Collections.sort(levelEntry.getValue());
                list.addAll(levelEntry.getValue());
            }
            ans.add(list);
        }

        ans.forEach(item-> {
            for (Integer nestedItem : item) {
                System.out.print(nestedItem + " ");
            }
            System.out.println(" ");
        });

        return ans;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(3);
        node.left = new TreeNode(1);
        node.right = new TreeNode(4);
        node.left.left = new TreeNode(0);
        node.left.right = new TreeNode(2);
        node.right.left = new TreeNode(2);
        // node.right.right = new TreeNode(7);
        traverse(node);

    }
}

class Node extends TreeNode {

    public int verticalDistance;
    public Node(int verticalDistance , int val) {
        this.verticalDistance = verticalDistance;
        this.val = val;
    }
}

