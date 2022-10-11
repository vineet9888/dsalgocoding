package com.ds.algo.problem.solving.graphs;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CloneGraph {


    public static Node cloneGraph(Node node , Map<Integer , Boolean> visited) {
        /*
            1 - 2 4
            2 - 3 1
            3 - 4 2
            4 - 1 3
        */

        if(node == null) {
            return null;
        }

        if(visited.containsKey(node.val) && visited.get(node.val)) {
            return null;
        }

        visited.put(node.val , true);
        ArrayList<Node> neighbors = new ArrayList<>();
        if(node.neighbors != null) {
            for (Node neighbor : node.neighbors) {
                neighbors.add(cloneGraph(neighbor , visited));
            }
        }
        Node clonedNode = new Node(node.val , neighbors);
        visited.put(node.val , false);
        return clonedNode;
    }


    public static Node dfs(Node node , Map<Integer , Node> map){
        if(node == null) {
            return null;
        }

        if(map.containsKey(node.val)) {
            return map.get(node.val);
        }

        Node clone = new Node(node.val , new ArrayList<Node>());
        map.put(node.val , clone);
        for (Node child: node.neighbors) {
            clone.neighbors.add(dfs(child , map));
        }
        return clone;
    }


    public static Node cloneGraph(Node node) {
        Map<Integer , Node> map = new HashMap<>();
        return dfs(node , map);
    }

    public static void main(String[] args) {

    }
}


class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}