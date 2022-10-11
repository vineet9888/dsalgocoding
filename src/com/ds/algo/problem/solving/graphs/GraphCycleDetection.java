package com.ds.algo.problem.solving.graphs;

import java.util.HashMap;
import java.util.Map;

public class GraphCycleDetection {

    public static void main(String[] args) {
        Map<Integer , Integer[]> graph = new HashMap<>();
        graph.put(1 , new Integer[]{2});
        graph.put(2 , new Integer[]{1,4,3});
        graph.put(3 , new Integer[]{2, 5});
        graph.put(4 , new Integer[]{2});
        graph.put(5 , new Integer[]{3,6});
        graph.put(6 , new Integer[]{5 , 7});
        graph.put(7 , new Integer[]{6,8});
        graph.put(8 , new Integer[]{7});

        System.out.println(checkForCycle(graph));
    }

    public static Map<Integer , Integer[]> getUndirectedGraph() {
        Map<Integer , Integer[]> map = new HashMap<>();
        map.put(1 , new Integer[]{3});
        map.put(2, new Integer[]{5});
        map.put(3, new Integer[]{1,4});
        map.put(4, new Integer[]{3});
        map.put(5, new Integer[]{2,6,8});
        map.put(6, new Integer[]{5,7});
        map.put(7, new Integer[]{6,8});
        map.put(8, new Integer[]{7,5});
        return map;
    }

    public static void detectCycleInUndirectedGraph(Map<Integer , Integer[]> map) {

    }

    public static boolean checkForCycle(Map<Integer , Integer[]> graph) {
        boolean visited[] = new boolean[9];
        for(int i = 1 ; i < 8;i++) {
            if(!visited[i]) {
                if(checkCycle(i , -1 , graph , visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean checkCycle(Integer source , Integer parent , Map<Integer , Integer[]> graph , boolean visited[]) {
        visited[source] = true;
        for(Integer item : graph.get(source)) {
            if(!visited[item]) {
                if(checkCycle(item , source , graph , visited)) {
                    return true;
                }
            } else {
                if(parent != item) {
                    return true;
                }
            }
        }
        return false;
    }


}


