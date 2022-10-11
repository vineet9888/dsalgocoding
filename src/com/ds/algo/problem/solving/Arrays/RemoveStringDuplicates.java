package com.ds.algo.problem.solving.Arrays;

import com.sun.deploy.util.StringUtils;

import java.util.Stack;

public class RemoveStringDuplicates {

    public static void main(String[] args) {
        System.out.println(removeDuplicates("deeedbbcccbdaa" , 3));
        System.out.println(removeDuplicates("abcd" , 2));
        System.out.println(removeDuplicates("pbbcggttciiippooaais" , 2));

    }

    public static String removeDuplicates(String s){

        if(s.isEmpty()) {
            return "";
        }
        int i = 1;
        int size = s.length() - 1;
        Stack<Character> stack = new Stack<>();
        stack.push(s.charAt(0));
        String ans = "";
        boolean matchFound = false;
        while(i <= size) {
            int k = 0;
            while(i<=size && !stack.isEmpty() && s.charAt(i) == stack.peek() && k < 1) {
                matchFound = true;
                i++;
                k++;
            }
            if(matchFound){
                if(!stack.isEmpty()){
                    stack.pop();
                }
                matchFound = false;
            } else {
                stack.push(s.charAt(i));
                i++;
            }
        }

        while(!stack.isEmpty()){
            ans += stack.pop();
        }
        String revAns = "";
        for(i = ans.length()-1 ; i >=0;i--) {
            revAns += ans.charAt(i);
        }

        return revAns;
    }

    public static String removeDuplicates(String s , int k){
        int i = 1;
        int size = s.length() - 1;
        Stack<StackItem> stack = new Stack<>();
        stack.push(new StackItem(s.charAt(0) , 1));
        while(i <= size) {
            if(!stack.isEmpty()){
                if(stack.peek().ch != s.charAt(i)) {
                    stack.push(new StackItem(s.charAt(i) , 1));
                } else {
                    if(stack.peek().count == k-1) {
                        stack.pop();
                    } else {
                       stack.peek().count += 1;
                    }
                }
            } else {
                stack.push(new StackItem(s.charAt(i) , 1));
            }
            i++;
        }
        StringBuilder st = new StringBuilder();
        while(!stack.isEmpty()) {
            StackItem item = stack.pop();
            for(i = 0;i < item.count;i++) {
                st.append(item.ch);
            }
        }
        return st.reverse().toString();
    }
}



class StackItem {
    char ch;
    int count;
    StackItem(char ch , int count) {
        this.ch = ch;
        this.count = count;
    }
}
