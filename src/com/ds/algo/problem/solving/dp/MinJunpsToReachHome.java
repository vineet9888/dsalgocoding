package com.ds.algo.problem.solving.dp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class MinJunpsToReachHome {


    // pass a parameter for positive jump count....
    // if the count for negative jump reaches zero..
    public static final int MAX_VALUE = 20000;

    public static int findMinJumps(Set<Integer> set , int a , int b , int x , int curr , int backwardJumps , int maxJumpPosition , int visited[]) {

        if(curr < 0 || backwardJumps == -2 || set.contains(curr) || curr > maxJumpPosition) {
            return MAX_VALUE;
        }

        if(curr == x) {
            return 0;
        }


        if(visited[curr] == 1) {
            return MAX_VALUE;

        }

        visited[curr] = 1;
        int ans = Math.min(1 + findMinJumps(set , a , b , x,curr + a , 0 , maxJumpPosition , visited) ,
                1 + findMinJumps(set, a, b, x,curr - b , backwardJumps - 1, maxJumpPosition , visited));

        return ans;
    }

    public static int minimumJumps(int[] forbidden, int a, int b, int x) {
        Set<Integer> set = new HashSet<>();
        int max = -1;
        for (int i : forbidden) {
            if(i > max) {
                max = i;
            }
            set.add(i);
        }
        int maxJumpPosition =  2000;
        int visited[] = new int[2001];
        int ans = findMinJumps(set,a,b,x,0,0 , maxJumpPosition,visited);

        return ans >= MAX_VALUE ? -1 : ans;
    }

    public static void main(String[] args) {
        int forbidden[] = new int[]{162,118,178,152,167,100,40,74,199,186,26,73,200,127,30,124,193,84,184,36,103,149,153,9,54,154,133,95,45,198,79,157,64,122,59,71,48,177,82,35,14,176,16,108,111,6,168,31,134,164,136,72,98};
//        Arrays.sort(forbidden);
//        for (int i : forbidden) {
//            System.out.print(i+",");
//        }
        int a = 29 , b = 98 ,x = 80;
        //int a = 29, b = 98,x = 80;
        String s = "vineet";

        System.out.println(minimumJumps(forbidden,a,b,x));

    }
}
