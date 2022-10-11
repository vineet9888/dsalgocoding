package com.ds.algo.problem.solving.Arrays;

import java.util.*;

public class SlidingWindowMaximum {

    // 3,8,4,2,1,7
    public static void slidingWindowMax(int arr[]) {
        List<Integer> ans = new ArrayList<>();
        Deque<Integer> deque = new LinkedList<>();
        int windowStart = 0;
        int k = 3;
        for(int i = 0;i < arr.length;i++) {
            // this means first window is hit...
            if(deque.isEmpty()) {
                deque.add(arr[i]);
            } else {
                while(!deque.isEmpty() && arr[i] > deque.getLast()) {
                    deque.removeLast();
                }
                deque.addLast(arr[i]);
            }
            // found the first
            if(i == k-1) {
                ans.add(deque.getFirst());
                if(arr[windowStart] == deque.getFirst()) {
                   deque.removeFirst();
                }
                windowStart++;
            } else if(i >= k){
                ans.add(deque.getFirst());
                if(arr[windowStart] == deque.getFirst()) {
                    deque.removeFirst();
                }
                windowStart++;
            }
        }
        System.out.println(ans);
    }


    public static void main(String[] args) {
        int arr[] = new int[]{3 , 8, 4 , 2 , 1 ,7};
        slidingWindowMax(arr);

    }

    public static void slidingMAX() {
        int[] nums = new int[]{4,-2};
        int k = 2;
        int j = 0;
        int ans[] = new int[nums.length - k + 1];
        Deque<Integer> deque = new LinkedList<>();
        //5 3 8
        for(int i = 0 ; i < k;i++) {
            if(deque.isEmpty()) {
                deque.offer(i);
            } else {
                while(!deque.isEmpty() && nums[i] > nums[deque.peekLast()]) {
                    deque.removeLast();
                }
                deque.offer(i);
            }
        }
        ans[j++] = nums[deque.peek()];
        if(0 == deque.peek()) {
            deque.poll();
        }// till this point i have made a window.
        for(int i = k;i < nums.length;i++) {
            if(deque.isEmpty()) {
                deque.offer(i);
            } else {
                while(!deque.isEmpty() && nums[i] > nums[deque.peekLast()]) {
                    deque.removeLast();
                }
                deque.offer(i);
            }
            ans[j++] = nums[deque.peek()];
            if(i-k+1 == deque.peek()) {
                deque.poll();
            }
        }
        for(int i = 0 ; i<ans.length;i++) {
            System.out.print(ans[i] + " ");
        }
    }



}
