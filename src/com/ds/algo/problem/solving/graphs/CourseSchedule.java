package com.ds.algo.problem.solving.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CourseSchedule {

    public static void main(String[] args) {
        int arr[][] = new int[][]{
                {1,0},
                {0,1}
                };
        System.out.println(courseSchedule(arr , 5));

    }

    public static boolean courseSchedule(int grid[][] , int numCourses) {
        Map<Integer , List<Integer>> adjList = new HashMap<>();
        int rows = grid.length;
        int cols = grid[0].length;
        boolean visited[] = new boolean[numCourses];
        for(int i = 0 ; i < rows;i++) {
            adjList.computeIfAbsent(grid[i][0] , (k) -> new ArrayList<>()).add(grid[i][1]);
        }
        System.out.println(adjList);
        for(Map.Entry<Integer , List<Integer>> entry : adjList.entrySet()) {
            if(!visited[entry.getKey()]  && dfs(adjList , visited , entry.getKey())) {
                return false;
            }
        }
        return true;
    }


    public static boolean dfs(Map<Integer , List<Integer>> map , boolean visited[] , int src) {
        if(visited[src]) {
            return true;
        }
        visited[src] = true;
        if(!map.containsKey(src)){
            return false;
        }

        List<Integer> children = map.get(src);
        for(Integer child : children) {
            if(dfs(map , visited , child)) {
                return true;
            }
        }
        return false;
    }
}
