package com.ds.algo.problem.solving.trees;

import java.util.LinkedList;
import java.util.Queue;

public class SerializeDeserializeBinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(-7);
        root.right = new TreeNode(-3);
        /*root.right.left = new TreeNode(-9);
        root.right.right = new TreeNode(-3);
        root.right.left.left = new TreeNode(9);
        root.right.left.right = new TreeNode(-1);*/
        String data = serialize(root);
        System.out.println(data);
//        String pat[] = data.split(",");
//        for(int i = 0 ; i < pat.length;i++) {
//            System.out.print(pat[i]+"<->");
//        }
//        System.out.println("");

        /*String data = serialize(root);

        System.out.println(data);
        System.out.println("vineet");
        String pat[] = data.split(",");
        Queue<String> queue= new LinkedList<>();
        for(int i = 0;i<pat.length;i++) {
            System.out.print(pat[i] + " ");
            if(!pat[i].equals("")){
                queue.add(pat[i]);
            }

        }
        root = deserialize(queue);
        inOrder(root);*/
//        root = deserialize(pat,0);
//        inOrder(root);
    }

    public static void inOrder(TreeNode root) {
        if(root == null) {
            return;
        }
        System.out.println(root.val);
        inOrder(root.left);
        inOrder(root.right);

    }



    public static String serializeLevelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        String serializedData = "";
        if(root == null) {
            return serializedData;
        }
        queue.add(root);
        while(!queue.isEmpty()) {
            TreeNode item = queue.poll();
            if(item != null) {
                queue.add(item.left);
                queue.add(item.right);
            }
            serializedData += item != null ? item.val + "," : "*,";
        }

        return serializedData;
    }


    public static String serialize(TreeNode root) {
        if(root == null) {
            return "*";
        }
        String serialized = "";
        // System.out.println(root.val);
        String left = serialize(root.left);
        String right = serialize(root.right);
        /*System.out.println("root " + root.val);
        System.out.println("left " + left);
        System.out.println("right " + right);*/
        serialized = String.valueOf(root.val)  +","+ left + "," + right ;
        //System.out.println("serialized " + serialized);

        return serialized;
    }

    // 12**34**5**
    public static TreeNode deserialize(Queue<String> queue)  {
        if(queue == null) {
            return null;
        }
        String item = queue.poll();
        if(item .equals("*")) {
            return null;
        }
        int val = Integer.valueOf(item);
        TreeNode root = new TreeNode(val);
        root.left = deserialize(queue);
        root.right = deserialize(queue);
        return root;
    }

    // -11,2,3,*,*,4,5,*,*,*,*,
    public static TreeNode deserialize(String data[] , int index) {
        TreeNode root = null;
        if(index >= data.length) {
            return null;
        }
        if(!data[index].equals("*")) {
            root = new TreeNode(Integer.valueOf(data[index]));
            root.left = deserialize(data , 2*index + 1);
            root.right = deserialize(data , 2*index + 2);
        } else {
            return null;
        }

        return root;
    }


}
