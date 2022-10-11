package com.ds.algo.problem.solving.trees;

import java.util.*;

public class MaximumLevelSumBinaryTree {

    public static int maxLevelSum(TreeNode node) {
        Queue<HashMap<TreeNode , Integer>> queue = new LinkedList<>();
        HashMap<TreeNode , Integer> map = new HashMap<>();
        map.put(node , 1);
        HashMap<Integer , Integer> levelSumMap = new HashMap<>();
        queue.add(map);
        while(!queue.isEmpty()) {
            // extract the first node from queue....
            HashMap<TreeNode ,Integer>  queueEntry = queue.poll();
            // adding left and right for the extracted node and adding it to the queue
            queueEntry.forEach((key , level) -> {
                System.out.println(level + " - " + key.val);
                if(levelSumMap.computeIfPresent(level , (k,v)-> v + key.val) == null) {
                    levelSumMap.put(level , key.val);
                }
                if(key.left != null) {
                    HashMap<TreeNode, Integer> left = new HashMap<>();
                    left.put(key.left , level + 1);
                    queue.add(left);
                }
                if(key.right != null) {
                    HashMap<TreeNode, Integer> right = new HashMap<>();
                    right.put(key.right, level + 1);
                    queue.add(right);
                }
            });
        }

        int maxSum = Integer.MIN_VALUE;
        int level = -1;
        for(Map.Entry<Integer , Integer> entry : levelSumMap.entrySet()) {
            if(entry.getValue() > maxSum) {
                maxSum = entry.getValue();
                level = entry.getKey();
            }
        }
        return level;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(7);
        root.left.left = new TreeNode(7);;
        root.left.right = new TreeNode(-8);
        root.right = new TreeNode(0);
        /*TreeNode root = new TreeNode(1);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.left.left = new TreeNode(2);
        root.left.left.right = new TreeNode(2);
        root.left.right = new TreeNode(1);
        root.right = new TreeNode(30);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(18);
        root.right.right.left = new TreeNode(2);
        root.right.right.right = new TreeNode(2);*/
        System.out.println(maxLevelSum(root));
    }
}
