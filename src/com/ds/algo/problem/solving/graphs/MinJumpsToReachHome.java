package com.ds.algo.problem.solving.graphs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class MinJumpsToReachHome {

    public static void main(String[] args) {
        int arr[] = new int[]{8,3,16,6,12,20};
        int a = 15;
        int b = 13;
        int x = 11;
        System.out.println(minJumpsRequired(arr,  a,  b,  x));
    }



    public static int minJumpsRequired(int[] forbidden, int a, int b, int x) {
        Queue<QueueItem1> queue = new LinkedList<>();
        QueueItem1 item = new QueueItem1(0 , true , 0);
        queue.add(item);
        boolean visited[] = new boolean[2001];
        Set<Integer> set = new HashSet<>();
        for(int i = 0 ; i < forbidden.length;i++) {
            set.add(forbidden[i]);
        }

        while(!queue.isEmpty()) {
            item = queue.poll();
            visited[item.source] = true;
            if(item.source == x) {
                return item.count;
            }
            int forward = item.source + a;
            int backward = item.source - b;
            if(!set.contains(forward) && forward <=2000 && !visited[forward] && item.isForwardJump) {
                queue.add(new QueueItem1(forward , true  , item.count + 1));
            }

            if(!set.contains(backward) && backward > 0 && !visited[backward] && item.isForwardJump) {
                queue.add(new QueueItem1(backward , false  , item.count + 1));
            }

        }

        return -1;
    }
}


class QueueItem1 {
    int source;
    boolean isForwardJump;
    int count;
    QueueItem1(int source  , boolean isForwardJump , int count) {
        this.source = source;
        this.isForwardJump = isForwardJump;
        this.count = count;
    }
}