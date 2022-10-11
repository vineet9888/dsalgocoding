package com.ds.algo.problem.solving.Arrays;

import java.util.PriorityQueue;

public class PeakIndexInMountainArray {

    public static void main(String[] args) {
        PriorityQueue<Node> queue = new PriorityQueue<>((first , second) -> {
            return second.data-first.data;
        });

        int arr[] = new int[]{3,4,5,1};
        for(int i = 0 ; i < arr.length;i++) {
            queue.add(new Node(arr[i] , i));
        }

        System.out.println(queue.peek().index + " " + queue.peek().data);
        Character cc = 'a';
        String s = cc + "sd";
        
        System.out.println(s);
    }
}


class Node {
    int data;
    int index;
    Node(int data , int index) {
        this.data = data;
        this.index = index;
    }
}
