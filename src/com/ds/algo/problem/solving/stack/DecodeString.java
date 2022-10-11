package com.ds.algo.problem.solving.stack;

import java.util.Stack;

public class DecodeString {

    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        String s = "3[a]2[b]";
        // 3[abc]
        System.out.print(decode(s , 0));

    }
    // abc
    public static String decode(String s , int curr) {
        String ans = "";
        if(curr < s.length()-1 && s.charAt(curr + 1) == '[') {
            String ways =  decode(s , curr + 2);
            ans += multiply(ways , Integer.valueOf(String.valueOf(s.charAt(curr))));
        } else if(curr < s.length()){
             if(s.charAt(curr) != ']') {
                 ans += s.charAt(curr) + decode(s , curr+1);
             } else {
                 ans += decode(s , curr + 1);
             }

        }

        return ans;
    }

    public static String multiply(String s , int multiplier){
        String ans = "";
        for(int i = 0 ; i < multiplier;i++) {
            ans += s;
        }
        return ans;
    }
}
