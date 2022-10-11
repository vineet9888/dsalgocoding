package com.ds.algo.problem.solving.trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RootToLeafNodePath {

    public static void main(String[] args) {
        TreeNode root = TreeNodeFactory.getCompleteBinaryTreeTill7();
        List<TreeNode> ans = new ArrayList<>();
        printPath(root , new ArrayList<>() , ans , 7);
        ans.forEach((node) -> {
            System.out.print(node.val + " ");
        });
    }


    public static boolean printPath(TreeNode root , List<TreeNode> list , List<TreeNode> ans , int target) {

        if (root == null) {
            return false;
        }
        if(root.val == target) {
            ans.addAll(list);
            ans.add(root);
            return true;
        }
        List<TreeNode> list1 = new ArrayList<>(list);
        list1.add(root);
        return printPath(root.left , list1 , ans , target) || printPath(root.right , list1 , ans , target);
    }





}
