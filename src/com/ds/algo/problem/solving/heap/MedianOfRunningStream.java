package com.ds.algo.problem.solving.heap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class MedianOfRunningStream {

    public static void main(String[] args) {
        int arr[] = new int[]{5, 15, 1, 3, 2, 8, 7, 9, 10, 6, 11, 4};
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((Integer i1 , Integer i2) -> i2-i1);
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        List<Integer> median = new ArrayList<>();
        median.add(arr[0]);
        median.add((arr[0] + arr[1])/2);
        if(arr[0] > arr[1]) {
            maxHeap.add(arr[1]);
            minHeap.add(arr[0]);
        } else {
            maxHeap.add(arr[0]);
            minHeap.add(arr[1]);
        }
        for(int i = 2 ; i < arr.length;i++) {
            int minHeapSize = minHeap.size();
            int maxHeapSize = maxHeap.size();
            if(maxHeapSize == minHeapSize) {
                if(arr[i] < maxHeap.peek()) {
                    maxHeap.add(arr[i]);
                } else {
                    minHeap.add(arr[i]);
                }
            } else {
                if(maxHeapSize > minHeapSize) {
                    if(arr[i] < maxHeap.peek()) {
                        minHeap.add(maxHeap.poll());
                        maxHeap.add(arr[i]);
                    } else {
                        minHeap.add(arr[i]);
                    }
                } else {
                    if(arr[i] < minHeap.peek()) {
                        minHeap.add(arr[i]);
                    } else {
                        maxHeap.add(minHeap.poll());
                        minHeap.add(arr[i]);
                    }
                }
            }

            maxHeapSize = maxHeap.size();
            minHeapSize = minHeap.size();
            if(maxHeapSize == minHeapSize) {
                median.add( (maxHeap.peek() + minHeap.peek()) / 2 );
            } else if(maxHeapSize > minHeapSize) {
                median.add(maxHeap.peek());
            } else {
                median.add(minHeap.peek());
            }
        }

        System.out.println(median);


    }
}
