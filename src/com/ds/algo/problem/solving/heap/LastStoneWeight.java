package com.ds.algo.problem.solving.heap;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Stack;

public class LastStoneWeight {


    public static void main(String[] args) {

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        Stack<Integer> stack =new Stack<>();
        stack.clear();
        int input[] =new int[]{2,7,4,1,8,1};
        for(int item : input) {
            maxHeap.add(item);
        }

        maxHeap.forEach((item) -> {
            System.out.println(item);
        });
        while(maxHeap.size() >= 2) {
            int first = maxHeap.remove();
            int second = maxHeap.remove();
            if(first != second) {
                maxHeap.add(first - second);
            }
        }

        maxHeap.forEach((item) -> {
            System.out.println(item);
        });



    }
}
