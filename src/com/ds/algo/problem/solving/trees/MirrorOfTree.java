package com.ds.algo.problem.solving.trees;

public class MirrorOfTree {

    public static void main(String[] args) {
        TreeNode root = constructTree();
        traverseInOrder(root);
        TreeNode mirrorTree = mirrorTree(root);
        traverseInOrder(mirrorTree);
    }

    private static TreeNode mirrorTree(TreeNode root) {
        if(root == null) {
            return null;
        }
        TreeNode left =mirrorTree(root.left);
        TreeNode right = mirrorTree(root.right);
        // swap left and right node
        root.left = right;
        root.right = left;
        return root;
    }

    public static TreeNode constructTree() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        return root;
    }

    public static void traverseInOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        traverseInOrder(root.left);
        System.out.println(root.val);
        traverseInOrder(root.right);
    }

}
