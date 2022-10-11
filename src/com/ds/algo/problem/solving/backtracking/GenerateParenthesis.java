package com.ds.algo.problem.solving.backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class GenerateParenthesis {

    public static void generateParenthesis(int n , int i , String curr , List<String> ans) {
        if(i > n) {
//            if(isValid(curr)) {
//
//            }
            ans.add(curr);
            return;
        }
        generateParenthesis(n , i + 1 , curr + "(" , ans);
        generateParenthesis(n , i + 1, curr + ")" , ans);
    }

    public static boolean isValid(String s) {
        // ()()()
        Stack<Character> stack = new Stack<>();
        int c = 0;
        while(c < s.length()){
            if(s.charAt(c) == '(') {
                stack.push('(');
            } else {
                if(!stack.isEmpty()){
                    stack.pop();
                } else {
                    return false;
                }
            }
            c++;
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        int n = 3;
        List<String> ans = new ArrayList<>();
        generateParenthesis(2*n, 1 , "" , ans);
        for (String an : ans) {
            System.out.println(an);

        }
    }
}
