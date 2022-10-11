package com.ds.algo.problem.solving.trees;

import java.util.ArrayList;
import java.util.List;

public class RangeSumBST {

    // range low and high.....
    public static int rangeSumBST(TreeNode root , int low , int high) {
        int sum = 0;
        if(root == null) {
            return 0;
        }

        // node value is in range....
        // search in both trees....
        if(root.val >= low && root.val <= high) {
            int leftSum = rangeSumBST(root.left , low , high);
            int rightSum = rangeSumBST(root.right , low , high);
            sum += root.val +  leftSum + rightSum;
        }
        // search in right sub tree
        else if(root.val <= low) {
            sum += rangeSumBST(root.right , low , high);
        }
        // search in left sub tree
        else if(root.val >= high) {
            sum += rangeSumBST(root.left ,low , high);
        }

        return sum;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.left.left = new TreeNode(1);
        root.left.right = new TreeNode(7);
        root.left.right.left = new TreeNode(6);
        root.right = new TreeNode(15);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(18);
        // System.out.print(rangeSumBST(root , 6 , 10));


        System.out.println();

    }
}
