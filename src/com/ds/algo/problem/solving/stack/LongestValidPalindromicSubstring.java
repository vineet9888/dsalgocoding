package com.ds.algo.problem.solving.stack;

import java.util.Stack;

public class LongestValidPalindromicSubstring {

    public static void main(String[] args) {
        String str = ")((()))";
        Stack<Integer> stack = new Stack<>();
        stack.add(-1);
        int ans = 0;
        for(int i = 0 ; i < str.length();i++) {
            Character ch = str.charAt(i);
            if(ch == '(') {
                stack.add(i);
            } else {
                stack.pop();
                if(stack.isEmpty()) {
                    stack.add(i);
                } else {
                    ans = Math.max(ans, i - stack.peek());
                }
            }
        }
        System.out.println(ans);

    }
}
