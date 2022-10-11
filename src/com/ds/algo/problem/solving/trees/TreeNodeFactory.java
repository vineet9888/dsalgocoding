package com.ds.algo.problem.solving.trees;

public class TreeNodeFactory {

    public static TreeNode constructTreeForLevelOrderTraversal() {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node.left.left = new TreeNode(4);
        node.left.left.right = new TreeNode(14);
        node.right.right = new TreeNode(5);
        node.right.right.left = new TreeNode(6);
        return node;
    }

    public static TreeNode constructTreeForBottomView() {
        TreeNode node = new TreeNode(20);
        node.left = new TreeNode(8);
        node.right = new TreeNode(22);
        node.left.left = new TreeNode(5);
        node.left.right = new TreeNode(3);
        node.left.right.left = new TreeNode(10);
        node.left.right.right = new TreeNode(14);
        node.right.right = new TreeNode(25);
        return node;
    }


    public static TreeNode getCompleteBinaryTreeTill7() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        return root;
    }
}
