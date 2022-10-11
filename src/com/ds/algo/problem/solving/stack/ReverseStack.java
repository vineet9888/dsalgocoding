package com.ds.algo.problem.solving.stack;

import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;
import java.util.TreeSet;

public class ReverseStack {

    public static void main(String[] args) {
        int nums[] = new int[]{};

        TreeMap<Integer , TreeSet<Integer>> map = new TreeMap<>((a, b)-> b-a);

        for(int i = 0 ; i < nums.length;i++) {
            String num = String.valueOf(nums[i]);

            String digit = num.substring(0,1);
            if(map.containsKey(digit)) {
                map.get(Integer.valueOf(digit)).add(nums[i]);
            } else {
                TreeSet<Integer> set = new TreeSet<>((a, b)-> b-a);
                set.add(nums[i]);
                map.put(Integer.valueOf(digit) , set);
            }
        }

        for(Map.Entry<Integer , TreeSet<Integer>> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
        Stack<Integer> stack = new Stack<>();
        stack.add(1);
        stack.add(2);
        stack.add(3);



        System.out.println("After  ");
        reverse(stack);
        while(!stack.isEmpty()) {
            System.out.print(stack.pop() + "  ");
        }
    }

    public static void reverse(Stack<Integer> stack) {
        if(!stack.isEmpty()) {
            int val = stack.pop();
            reverse(stack);
            insertAtBottom(val , stack);
        }
    }

    public static void insertAtBottom(int val , Stack<Integer> stack) {
        if(stack.isEmpty()) {
            stack.push(val);
        } else {
            int curr = stack.pop();
            insertAtBottom(val , stack);
            stack.push(curr);
        }
    }
}
