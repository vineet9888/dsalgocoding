package com.ds.algo.problem.solving.heap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class MergeKSortedArrays {

    public static void main(String[] args) {
        int arrs[][] = new int[][] {
                {1 ,2 ,3 ,4, 5},
                {7,8,9,10,11},
                {23,24,25,26,27}
        };

        PriorityQueue<Item> heap = new PriorityQueue<>((Item first , Item second) -> {
            return first.val-second.val;
        });

        for(int i = 0 ; i < arrs.length;i++) {
            heap.add(new Item(arrs[i][0] , i , 1));
        }
        List<Integer> ans = new ArrayList<>();
        int k = 5;
        while(!heap.isEmpty()) {
            Item item  = heap.poll();
            ans.add(item.val);
            if(item.childListIndex < k) {
                heap.add(new Item(arrs[item.parentListIndex][item.childListIndex] , item.parentListIndex , item.childListIndex + 1));
            }
        }
        System.out.print(ans);

    }
}

class Item {
    int val;
    int parentListIndex;
    int childListIndex;
    Item(int val , int parentListIndex , int childListIndex) {
        this.val = val;
        this.parentListIndex = parentListIndex;
        this.childListIndex = childListIndex;
    }
}