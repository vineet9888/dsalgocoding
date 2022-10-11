package com.ds.algo.problem.solving.trees;

import java.util.*;

public class TreeTraversals {

    public static void main(String[] args) {
        //preOrderTraversal(constructTree());
        //TreeNode root = constructTreeForLCA();
        //int ans = lowestCommonAncesstorOptionOne(root);
        // TreeNode ans = lowestCommonAncesstor(root , 2 , 8);
        // System.out.println(ans.val);
        zigZagTraversal();
    }

    public static void zigZagTraversal() {
        TreeNode root = TreeNodeFactory.constructTreeForLevelOrderTraversal();
        Queue<WrapperNode> queue = new LinkedList<>();
        WrapperNode node = new WrapperNode(root , 1);
        queue.add(node);
        Map<Integer , List<Integer>> levelOrderTraversal = new TreeMap<>();
        while(!queue.isEmpty()) {
            WrapperNode item = queue.poll();
            levelOrderTraversal.computeIfAbsent(item.level , (k) -> new ArrayList<>()).add(item.node.val);
            if(item.node.left != null) {
                queue.add(new WrapperNode(item.node.left , item.level + 1));
            }
            if(item.node.right != null) {
                queue.add(new WrapperNode(item.node.right , item.level + 1));
            }
        }
        levelOrderTraversal.forEach((key , value) -> {
            System.out.println(key + " -> " + value);
        });

        levelOrderTraversal.forEach((key , value) -> {
            List<Integer> list = value;
            if(key%2 == 0) {
                for(int i = list.size()-1;i>=0;i--) {
                    System.out.print(list.get(i) + " ");
                }
            } else {
                for(int i = 0;i < list.size();i++) {
                    System.out.print(list.get(i) + " ");
                }
            }
            System.out.println();
        });

    }

    public static void serializeDeserializeTree() {
        TreeNode root = constructTree();
        String s = "";
        List<String> list = new ArrayList<>();
        serializeTree(root , list);
        System.out.println(list);
        Stack<String> stack = new Stack<>();
        for(int i = list.size() - 1 ; i >=0;i--) {
            stack.push(list.get(i));
        }
        System.out.println(stack);
        TreeNode node = deserializeTree(stack);
        System.out.println(node);
    }



    public static TreeNode deserializeTree(Stack<String> stack) {
        if(!stack.isEmpty()) {
            String s = stack.pop();
            if(s.equals("*")) {
                return null;
            }
            TreeNode node = new TreeNode(Integer.valueOf(s));
            TreeNode left = deserializeTree(stack);
            TreeNode right = deserializeTree(stack);
            node.left = left;
            node.right = right;
            return node;
        } else {
            return null;
        }
    }

    public static void serializeTree(TreeNode node , List<String> list) {
        if(node == null) {
            list.add("*");
            return;
        }
        list.add(String.valueOf(node.val));
        serializeTree(node.left , list);
        serializeTree(node.right,list);
        return;
    }

    public static int lowestCommonAncesstorOptionOne(TreeNode root) {
        List<Integer> first = findNodePath(root , 4);
        List<Integer> second = findNodePath(root , 7);
        System.out.println(first);
        System.out.println(second);
        int ans = -1;
        if(first.size() > second.size()) {
            for(int i = 0 ; i < second.size();i++) {
                if(first.get(i) != second.get(i)) {
                    break;
                }
                ans = second.get(i);
            }
        } else {
            for(int i = 0 ; i <first.size();i++) {
                if(first.get(i) != second.get(i)) {
                    break;
                }
                ans = first.get(i);
            }
        }
        return ans;
    }

    public static TreeNode constructTree() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        return root;
    }

    public static TreeNode constructTreeForLCA() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(9);
        root.left.right.right = new TreeNode(8);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        return root;
    }

    public static List<Integer> findNodePath(TreeNode root , Integer targetValue){
        if(root == null) {
            return new ArrayList<>();
        }
        if(root.val == targetValue) {
            List<Integer> list = new ArrayList<>();
            list.add(targetValue);
            return list;
        }
        List<Integer> leftPath = findNodePath(root.left , targetValue);
        if(leftPath.size() > 0) {
            List<Integer> list = new ArrayList<>();
            list.add(root.val);
            list.addAll(leftPath);
            return list;
        }
        List<Integer> rightPath = findNodePath(root.right , targetValue);
        if(rightPath.size() > 0) {
            List<Integer> list = new ArrayList<>();
            list.add(root.val);
            list.addAll(rightPath);
            return list;
        }
        return new ArrayList<>();
    }

    public static TreeNode lowestCommonAncesstor(TreeNode root , int first , int second) {
        if(root == null) {
            return null;
        }

        if(root.val == first || root.val == second) {
            return root;
        }

        TreeNode left = lowestCommonAncesstor(root.left , first, second);
        TreeNode right = lowestCommonAncesstor(root.right , first , second);

        if(left != null && right != null) {
            return root;
        }

        return (left != null) ? left : right;
    }

    public static void preOrderTraversal(TreeNode root) {
        if(root == null) {
            return;
        }
        preOrderTraversal(root.left);
        System.out.println(root.val);
        preOrderTraversal(root.right);
    }
}
