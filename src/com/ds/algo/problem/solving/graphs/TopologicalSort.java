package com.ds.algo.problem.solving.graphs;

import java.util.*;

public class TopologicalSort {

    public static int[] findOrder(int numCourses, int[][] pr) {

        if(numCourses == 1) {
            int res[] = new int[]{0};
            return res;
        }

        Map<Integer , List<Integer>> map = new HashMap<>();
        for(int i = 0;i < pr.length;i++) {
            int source = pr[i][1];
            int dest = pr[i][0];
            if(map.containsKey(source)) {
                map.get(source).add(dest);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(dest);
                map.put(source , list);
            }
        }

         map.forEach((key ,value) -> {
             System.out.print(key + " -> ");
             value.forEach((item) -> {
                 System.out.print(item + " ");
             });
             System.out.println("");
         });


        boolean visited[] = new boolean[numCourses];
        boolean cycleVisited[] = new boolean[numCourses];
        Stack<Integer> stack = new Stack<Integer>();
        boolean hasCycle= false;
        for(Map.Entry<Integer , List<Integer>> entry : map.entrySet()) {
            int key = entry.getKey();
            if(cycleVisited[key]) {
                hasCycle = true;
                break;
            }

            if(!visited[key]) {
                hasCycle = dfs(map , entry.getKey(),visited , cycleVisited , stack);
                if(hasCycle) {
                    System.out.println("this has a cycle");
                    break;
                }
            }

        }
        if(hasCycle) {
            int res[] = new int[0];
            return res;
        } else {
            int res[] = new int[stack.size()];
            int i = 0;
            while(!stack.isEmpty()) {
                res[i] = stack.pop();
                i++;
            }
            return res;
        }
    }


    public static boolean dfs(Map<Integer , List<Integer>> map , int src, boolean visited[] , boolean cycleVisited[] , Stack<Integer> stack) {

        System.out.println("this is my src" + src);
        visited[src] = true;
        boolean hasCycle = false;
        if(map.containsKey(src)) {
            if(cycleVisited[src]) {
                System.out.println(" Idar aaya hai cycle " + src);
                return true;
            }
            cycleVisited[src] = true;

            List<Integer> child = map.get(src);
            for(Integer item : child) {
                if(!visited[item]) {
                    hasCycle = dfs(map , item , visited , cycleVisited , stack);
                    if(hasCycle) {
                        return true;
                    }
                }
            }
            stack.push(src);
            cycleVisited[src] = false;
        } else {
            stack.push(src);
        }

        return hasCycle;
    }


    public static void main(String[] args) {
        System.out.println(test());
        Practice pr = new Practice();
        pr.ambiguity(null);
    }

    public static int test()  {
        try {
            System.out.println("Hi vineet i am throwing an exception");
            throw new Exception("");
        } catch (Exception e) {
            System.out.println(" Catch is handled here... ");
            return 13;
        } finally {
            System.out.println(" finally is called here ");
            return 14;
        }
    }

}


class Practice {

    public void ambiguity(Object obj) {
        System.out.println(obj + " Inside the first object ");
    }

    public void ambiguity(int obj) {
        System.out.println(obj + " Inside the second integer");
    }

    public void ambiguity(String obj) {
        System.out.println(obj + " Inside the second integer");
    }

}