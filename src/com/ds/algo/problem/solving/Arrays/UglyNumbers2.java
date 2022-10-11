package com.ds.algo.problem.solving.Arrays;

import java.util.*;

public class UglyNumbers2 {

    public static void main(String[] args) {
        Long ans = nthUglyNumber(1407);

        System.out.println(ans.intValue());
    }


    public static Long nthUglyNumber(int n) {

        int count = 1;
        List<Long> ans = new ArrayList<>();
        ans.add(1L);
        List<PriorityQueue<Long>> list = new ArrayList<>();
        Set<Long> set = new HashSet<>();

        PriorityQueue<Long> first = new PriorityQueue<>();
        first.add(2L);
        PriorityQueue<Long> second = new PriorityQueue<>();
        second.add(3L);
        PriorityQueue<Long> third = new PriorityQueue<>();
        third.add(5L);
        list.add(first);
        list.add(second);
        list.add(third);
        PriorityQueue<QueueItem> queue = new PriorityQueue<>((a , b) -> {
            return (int)a.val - (int)b.val;
        });
        queue.add(new QueueItem(2 , 0));
        queue.add(new QueueItem(3 , 1));
        queue.add(new QueueItem(5 , 2));

        while(!queue.isEmpty() && count <= n-1) {
            QueueItem item =  queue.poll();
            int size = ans.size();

            long top = ans.get(size - 1);
            if(set.contains(item.val)) {
                PriorityQueue<Long> temp = list.get(item.index);
                if(!temp.isEmpty()) {
                    temp.poll();
                }
                if(!temp.isEmpty()) {
                    queue.add(new QueueItem(temp.peek() , item.index));
                }
            } else {
                set.add(item.val);
                if(top != item.val) {
                    ans.add(item.val);
                    count++;
                }

                PriorityQueue<Long> temp = list.get(item.index);
                temp.poll();
                temp.add(item.val * 2);
                temp.add(item.val * 3);
                temp.add(item.val * 5);
                queue.add(new QueueItem(temp.peek() , item.index));
            }

        }
        return ans.get(count-1);
    }

}


class QueueItem {
    long val;
    int index;
    QueueItem(long val , int index) {
        this.val = val;
        this.index = index;
    }
}
