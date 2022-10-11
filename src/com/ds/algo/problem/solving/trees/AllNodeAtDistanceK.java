package com.ds.algo.problem.solving.trees;


import java.util.ArrayList;
import java.util.List;

public class AllNodeAtDistanceK {

    public static int findNodeDistance(TreeNode root, TreeNode target, int level, List<Integer> nodesAtDistanceK , int k) {
        if(root == null) {
            return -1;
        }

        if(root.val == target.val) {
            return level;
        }
        // find in left
        int distanceOfNodeInLeftSubtree = findNodeDistance(root.left , target , level+1, nodesAtDistanceK , k);
        // if found in left  , then find all the nodes at (K - distanceOfNodeInLeftSubtree - level) distance in right subtree of the root.
        if(distanceOfNodeInLeftSubtree != -1) {
            System.out.println(level  + " - " + distanceOfNodeInLeftSubtree);
            int newK = k - (distanceOfNodeInLeftSubtree - level);
            if( newK == 0) {
                nodesAtDistanceK.add(root.val);
            } else {
                findDownwardNodeAtDistanceK(root.right , newK - 1, nodesAtDistanceK);
            }

            return distanceOfNodeInLeftSubtree;

        }

        // find in right
        int distanceOfNodeInRightSubtree = findNodeDistance(root.right , target , level + 1, nodesAtDistanceK , k);
        if(distanceOfNodeInRightSubtree != -1) {
            int newK = k - (distanceOfNodeInRightSubtree - level);
            if(newK == 0) {
                nodesAtDistanceK.add(root.val);
            } else {
                findDownwardNodeAtDistanceK(root.left , newK - 1, nodesAtDistanceK);
            }
            return distanceOfNodeInRightSubtree;
        }
        return -1;
    }

    public static void findDownwardNodeAtDistanceK(TreeNode root , int k , List<Integer> nodesAtDistanceK) {
        if(root == null) {
            return;
        }

        if(k < 0) {
            return;
        }

        if(k == 0) {
            nodesAtDistanceK.add(root.val);
        }
        findDownwardNodeAtDistanceK(root.left , k-1 , nodesAtDistanceK);
        findDownwardNodeAtDistanceK(root.right , k-1 , nodesAtDistanceK);
    }

    public static void printAllNodesAtDistanceK(TreeNode root , TreeNode target, int k , List<Integer> nodesAtDistanceK) {
        // first print k nodes down....
        findDownwardNodeAtDistanceK(target , k , nodesAtDistanceK);
        findNodeDistance(root , target , 0 , nodesAtDistanceK , k);
    }




    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        root.right = new TreeNode(1);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        List<Integer> nodes = new ArrayList<>();
        printAllNodesAtDistanceK(root , root.left,2,nodes);
        // findNodeDistance(root , new TreeNode(59) , 0, nodes , 2);


        // printDownwardNodeAtDistanceK(root, 2 , nodes);

        nodes.forEach((node) -> {
            System.out.println(node);
        });




    }


}
