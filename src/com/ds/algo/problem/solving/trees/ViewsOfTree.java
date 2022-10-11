package com.ds.algo.problem.solving.trees;

import java.util.*;

public class ViewsOfTree {

    public static void main(String[] args) {
        /*TreeNode root = TreeNodeFactory.constructTreeForLevelOrderTraversal();
        System.out.println("left view");
        leftRightViewOfTree(root,true);
        System.out.println("right view");
        leftRightViewOfTree(root,false);*/

        /*System.out.println("bottom view of tree");
        bottomAndTopViewOfTree(false);
        System.out.println("top view of tree");
        bottomAndTopViewOfTree(true);*/
        boundaryTraversalOfTree();
    }


    public static void boundaryTraversalOfTree() {
        TreeNode root = TreeNodeFactory.constructTreeForLevelOrderTraversal();
        printLeft(root);
        printLeafNodes(root);
        printRight(root);
    }

    public static void printLeafNodes(TreeNode root) {
        if(root == null) {
            return;
        }
        if(root.left == null && root.right == null) {
            System.out.print(root.val +" ");
        }
        printLeafNodes(root.left);
        printLeafNodes(root.right);
    }

    public static void printRight(TreeNode root) {
        if(root == null) {
            return;
        }
        if(root.right != null && root.right.left == null && root.right.right == null) {
            return;
        }
        printRight(root.right);
        System.out.print(root.val + " ");
    }

    public static void printLeft(TreeNode root) {
        if(root == null) {
            return;
        }
        System.out.print(root.val + " ");
        if(root.left != null && root.left.left == null && root.left.right == null) {
            return;
        }
        printLeft(root.left);
    }



    // save all the data and put it in a map
    public static void bottomAndTopViewOfTree(boolean isTopView) {
        TreeNode root = TreeNodeFactory.constructTreeForBottomView();
        Queue<WrapperNode> queue = new LinkedList<>();
        Map<Integer , TreeNode> map = new TreeMap<>();
        queue.add(new WrapperNode(root , 0));
        while(!queue.isEmpty()) {
            WrapperNode item = queue.poll();

            if(isTopView) {
                map.putIfAbsent(item.level , item.node);
            } else {
                map.put(item.level , item.node);
            }
            if(item.node.left != null) {
                queue.add(new WrapperNode(item.node.left , item.level -1));
            }
            if(item.node.right != null) {
                queue.add(new WrapperNode(item.node.right , item.level + 1));
            }
        }

        map.forEach((key , value) -> {
            System.out.print(value.val + " ");
        });
    }
    

    public static void leftRightViewOfTree(TreeNode root , boolean isLeft) {
        Queue<WrapperNode> queue = new LinkedList<>();
        WrapperNode node = new WrapperNode(root , 1);
        Map<Integer , TreeNode> map = new LinkedHashMap<>();
        queue.add(node);
        while(!queue.isEmpty()) {
            WrapperNode item = queue.poll();
            map.putIfAbsent(item.level , item.node);
            if(isLeft) {
                if(item.node.left != null) {
                    queue.add(new WrapperNode(item.node.left, item.level + 1));
                }
                if(item.node.right != null) {
                    queue.add(new WrapperNode(item.node.right , item.level + 1));
                }
            } else {
                if(item.node.right != null) {
                    queue.add(new WrapperNode(item.node.right , item.level + 1));
                }
                if(item.node.left != null) {
                    queue.add(new WrapperNode(item.node.left, item.level + 1));
                }
            }

        }

        map.forEach((key , treeNode) -> {
            System.out.println(treeNode.val);
        });

    }


}

class WrapperNode {
    TreeNode node;
    int level;
    WrapperNode(TreeNode node, int level) {
        this.node = node;
        this.level = level;
    }
}

