package com.ds.algo.problem.solving.stack;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;
import java.util.stream.Collectors;

public class EvaluateReversePolishNotation {

    public static int evaluateRVN(String[] tokens) {
        Set<String> operators = Arrays.asList("+","-","*","/").stream().collect(Collectors.toSet());
        Stack<String> stack = new Stack<>();
        for(int i = 0;i < tokens.length;i++) {
            if(!operators.contains(tokens[i])) {
                stack.push(tokens[i]);
            } else {
                String operand2 = stack.pop();
                String operand1 = stack.pop();
                String operator = tokens[i];
                int ans = 0;
                if(operator.equals("+")){
                    ans = Integer.valueOf(operand1) + Integer.valueOf(operand2);
                } else if(operator.equals("*")) {
                    ans = Integer.valueOf(operand1) * Integer.valueOf(operand2);
                } else if(operator.equals("/")) {
                    ans = Integer.valueOf(operand1) / Integer.valueOf(operand2);
                } else if(operator.equals("-")){
                    ans = Integer.valueOf(operand1) - Integer.valueOf(operand2);
                }
                stack.push(String.valueOf(ans));
            }
        }
        return Integer.valueOf(stack.pop());
    }

    public static void main(String[] args) {
        // String tokens[] = new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        // System.out.println(evaluateRVN(tokens));

        System.out.println(backspaceCompare("a#c"));
        System.out.println(backspaceCompare("b"));
    }

    public static String backspaceCompare(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0;i < s.length();i++) {
            if(s.charAt(i) == '#') {
                if(!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(s.charAt(i));
            }
        }
        String ans = "";
        while(!stack.isEmpty()) {
            ans += stack.pop();
        }
        StringBuilder builder = new StringBuilder(ans);
        return builder.reverse().toString();
    }

}
