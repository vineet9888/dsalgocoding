package com.ds.algo.problem.solving.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JuspayReactNetwork {

    public static void main(String[] args) {
        Map<Integer , List<GNode>> map = new HashMap<>();
       int st[] = new int[] {1,2};
       int edges[][] = new int[][]{
               {2 , 9 , 2},
               {7, 2 , 3},
               {7 ,9 , 7} ,
               {9 , 5 , 1}
       };

       for(int i = 0 ; i < edges.length;i++) {
           int arr[] = edges[0];
           if(map.containsKey(arr[0])) {
               map.get(arr[0]).add(new GNode(arr[1] , arr[2]));
           } else {
               List<GNode> lit = new ArrayList<>();
               GNode node = new GNode(arr[1] , arr[2]);
               lit.add(node);
               map.put(arr[0] , lit);
           }
       }
       int source = 7;
       int dest = 9;
        int ans = Integer.MAX_VALUE;
        List<GNode> list = map.get(source);
        boolean visited[] = new boolean[4];
        visited[source]  = true;
        for(GNode node : list) {
            int temp = dfs(node , dest , map , visited);
            if(temp == Integer.MAX_VALUE) {
                ans = Math.min(ans , Integer.MAX_VALUE);
            } else {
                ans = Math.min(ans , node.time + temp);
            }
        }
        System.out.print(ans);
    }

    public static int dfs(GNode source , int target , Map<Integer , List<GNode>> map , boolean visited[]) {
        if(source.node == target) {
            return 0;
        }
        if(visited[source.node]) {
            return Integer.MAX_VALUE;
        }
        visited[source.node] = true;
        List<GNode> list = map.get(source.node);
        int ans = Integer.MAX_VALUE;
        for(GNode node : list) {
            int temp = dfs(node , target , map , visited);
            if(temp == Integer.MAX_VALUE) {
                ans = Math.min(ans , Integer.MAX_VALUE);
            } else {
                ans = Math.min(ans , node.time + temp);
            }
        }
        visited[source.node] = false;

        return ans;
    }



}

class GNode {
    int node;
    int time;
    GNode(int node , int time) {
        this.node = node;
        this.time = time;
    }
}
