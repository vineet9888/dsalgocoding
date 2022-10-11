package com.ds.algo.problem.solving.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElement {

    public static void main(String[] args) {
        int nums1[] = new int[]{4,1,2};
        int nums2[] = new int[]{1,3,4,2};
        System.out.print(nextGreaterElement(nums1,nums2));
    }

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer , Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        int len = nums2.length;
        int arr[] = new int[len];
        arr[len-1] = -1;
        stack.push(nums2[len-1]);
        for(int i = len - 2 ; i >= 0;i--) {
            if(!stack.isEmpty() && nums2[i] < stack.peek()) {
                arr[i] = stack.peek();
                stack.push(nums2[i]);
            } else if(!stack.isEmpty() && stack.peek() < nums2[i]) {
                while(!stack.isEmpty() && nums2[i] > stack.peek()) {
                    stack.pop();
                }
                if(stack.isEmpty()) {
                    arr[i] = -1;
                } else {
                    arr[i] = stack.peek();
                }
                stack.push(nums2[i]);
            }
        }

        for(int i = 0 ; i < len;i++) {
            map.put(nums2[i] , arr[i]);
        }
        int ans[] = new int[nums1.length];
        System.out.println(map);
        for(int i = 0 ; i < ans.length;i++) {
            ans[i] = map.get(nums1[i]);
        }
        return ans;

        // 15 8 9 2 7 8
    }
}
