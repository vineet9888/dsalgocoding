package com.tech.interviews;

import java.util.Stack;

public class JpMorgan {
    public static void main(String[] args) {
        String input = "[][]][[";
        int countA = 0;
        int countB = 0;
        for(int i = 0 ; i < input.length();i++) {
            if(input.charAt(i) == '[') {
                countA++;
            } else {
                countB++;
            }
        }
        System.out.println(Math.min(countA , countB)*2);
        print(Math.min(countA , countB)*2 , "");
    }

    public static void print(int n , String currString) {
        if(n == 0) {
            if(isValid(currString)) {
                System.out.println(currString);
            }
            return;
        }
        print(n-1 , currString + "[");
        print(n-1 , currString + "]");
    }

    // [[[[
    public static boolean isValidSubtring(String s , int n) {
        if(s.charAt(0) == ']') {

        }
        return true;
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0 ; i < s.length();i++) {
            if(s.charAt(i) == '[') {
                stack.push(s.charAt(i));
            } else {
                if(stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }
        }
        if(!stack.isEmpty()) {
            return false;
        }
        return true;
    }
}
