package com.ds.algo.problem.solving.trees;

import java.util.*;

public class SpiralLevelOrderTraversal {

    public static void main(String[] args) {
        TreeNode root  = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        spiralLevelOrderTraversal(root);
    }


    // 1 2 3 7 6 5 4
    public static void spiralLevelOrderTraversal(TreeNode node) {

        Deque<QueueItem> queue = new LinkedList<>();
        queue.add(new QueueItem(node , false));
        boolean flip=true;
        while(!queue.isEmpty()) {
            List<QueueItem> items = new ArrayList<>();
            while (!queue.isEmpty()) {
                if(flip) {
                    QueueItem item = queue.poll();
                    if(item != null) {
                        System.out.print(item.node.val);
                        if(item.node != null ) {
                            if(item.node.left != null) {
                                items.add(new QueueItem(item.node.left , false));
                            }
                            if(item.node.right != null) {
                                items.add(new QueueItem(item.node.right , false));
                            }
                        }
                    }
                } else {
                    QueueItem item = queue.pop();
                    if(item != null) {
                        System.out.print(item.node.val);
                        if(item.node != null ) {
                            if(item.node.right != null) {
                                items.add(new QueueItem(item.node.right , false));
                            }
                            if(item.node.left != null) {
                                items.add(new QueueItem(item.node.left , false));
                            }
                        }
                    }
                }
            }
            flip = !flip;
            queue.addAll(items);
            System.out.println();
        }
    }
}

class QueueItem {
    TreeNode node;
    boolean direction;
    QueueItem(TreeNode node, boolean direction) {
        this.node = node;
        this.direction = direction;
    }
}