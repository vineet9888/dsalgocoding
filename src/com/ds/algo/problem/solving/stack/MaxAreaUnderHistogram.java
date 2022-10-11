package com.ds.algo.problem.solving.stack;

import java.util.Stack;

public class MaxAreaUnderHistogram {

    public static void main(String[] args) {
        int heights[] = new int[]{2,1,4,5,1,3,3};
        Stack<Integer> stack = new Stack<>();
        int size = heights.length;
        int left[] = new int[size];
        left[0] = 0;
        stack.push(0);
        for(int i = 1;i < size;i++) {
            if(heights[i] == 0) {
                stack.clear();
                stack.push(i);
                left[i] = 0;
                continue;
            }
            int top = heights[stack.peek()];
            if(top > heights[i]) {
                while((heights[stack.peek()] > heights[i])) {
                    stack.pop();
                    if(stack.isEmpty()) {
                        break;
                    }
                }
                if(stack.isEmpty()) {
                    left[i] = 0;
                    stack.push(i);
                } else {
                    if(heights[i]==heights[stack.peek()]) {
                        left[i] = left[stack.peek()];
                        stack.push(i);
                    } else {
                        left[i] = stack.peek() + 1;
                        stack.push(i);
                    }

                }
            } else {
                if(heights[i]==heights[stack.peek()]) {
                    left[i] = left[stack.peek()];
                    stack.push(i);
                } else {
                    left[i] = stack.peek() + 1;
                    stack.push(i);
                }

            }
        }
        for(int i =0;i<size;i++) {
            System.out.print(left[i] + " ");
        }
        stack.clear();
        int right[] = new int[size];
        right[size - 1] = size - 1;
        System.out.println();
        stack.push(size-1);
        for(int i = size - 2;i >= 0;i--) {
            if(heights[i] == 0) {
                stack.clear();
                right[i] = 0;
                stack.push(i);
                continue;
            }
            int top = heights[stack.peek()];
            if(top > heights[i]) {
                while((heights[stack.peek()] > heights[i])) {
                    stack.pop();
                    if(stack.isEmpty()) {
                        break;
                    }
                }
                if(stack.isEmpty()) {
                    right[i] = size - 1;
                    stack.push(i);
                } else {
                    if(heights[i]== heights[stack.peek()]) {
                        right[i] = right[stack.peek()];
                        stack.push(i);
                    } else{
                        right[i] = stack.peek() - 1;
                        stack.push(i);
                    }

                }
            } else {
                if(heights[i]== heights[stack.peek()]) {
                    right[i] = right[stack.peek()];
                    stack.push(i);
                } else {
                    right[i] = stack.peek() - 1;
                    stack.push(i);
                }

            }
            //System.out.println(right[i]);
        }

        for(int i =0;i<size;i++) {
            System.out.print(right[i] + " ");
        }

        int ans = -1;
        for(int i = 0 ; i < size;i++) {
            ans = Math.max(ans , ((right[i]-left[i] + 1)*heights[i]));
        }
        System.out.println();
        System.out.println(ans);
    }
}
