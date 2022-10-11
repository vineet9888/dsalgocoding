package com.ds.algo.problem.solving.graphs;

import java.util.*;

public class FindEventualSafeStates {

    public static List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> ans = new ArrayList<>();
        int visited[] = new int[graph.length];
        Set<Integer> safeNodes = new HashSet<>();
        Set<Integer> cycleNodes = new HashSet<>();
        for(int i = 0 ; i < graph.length;i++) {
            if(dfs(graph , i , visited , safeNodes , cycleNodes)) {
                ans.add(i);
            }
        }
        ans.forEach((item) -> System.out.print(item + " "));
        return ans;
    }

    public static boolean dfs(int graph[][] , int source , int visited[] , Set<Integer> safeNodes , Set<Integer> cycleNodes) {
        if(visited[source] == 2) {
            return true;
        }
        if(visited[source] == 3) {
            return false;
        }
        /*if(safeNodes.contains(source)) {
            return true;
        } else if(cycleNodes.contains(source)) {
            return false;
        }*/

        for(int i = 0;i < graph[source].length;i++) {
            // System.out.println(graph[source][i] + " , " +  visited[graph[source][i]]);
            if(visited[graph[source][i]] == 1) {
                return false;
            }
            visited[graph[source][i]] = 1;
            boolean canProceed = dfs(graph , graph[source][i] , visited , safeNodes , cycleNodes);
            // visited[graph[source][i]] = 0;
            if(!canProceed) {
                visited[graph[source][i]] = 3;
                cycleNodes.add(graph[source][i]);
                return false;
            } else {
                visited[graph[source][i]] = 2;
                safeNodes.add(graph[source][i]);
            }

        }
        return true;
    }

    public static void main(String[] args) {
        int graph[][] = new int[][]{
                {1,2},
                {2,3},
                {5},
                {0},
                {5},{},{}
                };
        eventualSafeNodes(graph);
    }

}
