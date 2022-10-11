package com.ds.algo.problem.solving.Arrays;


/*

[11:02 AM] Shenakshi Majhail (Guest)
        Snakes and Ladders is a game played on a 10 x 10 board, the goal of which is get from square 1 to square 100.
        On each turn players will roll a six-sided die and move forward a number of spaces equal to the result.
        If they land on a square that represents a snake or ladder, they will be transported ahead or behind, respectively, to a new square.
        Find the smallest number of turns it takes to play snakes and ladders.
        For convenience, here are the squares representing snakes and ladders, and their outcomes:
        snakes = {​​​16: 6, 48: 26, 49: 11, 56: 53, 62: 19, 64: 60, 87: 24, 93: 73, 95: 75, 98: 78}​​​
        ladders = {​​​1 : 38, 4: 14, 9: 31, 21: 42, 28: 84, 36: 44, 51: 67, 71: 91, 80: 100}​​​

          16 14 15 13
          9  10 11  12
          8  7  6  5
         1  2  3   4

           1
           2 3 4 5 6 7
           3 4 5 6 7 11
           12

        ladder = [2]


        queue.add(1);
        class cell{
            int row;
            int col;
            int moves;
        }

        while(!queue.isEmpty()) {
            //
        }


        You are given a string s. We want to partition the string into as many parts as possible so that each letter appears in at most one part.

          Return a list of integers representing the size of these parts.


    You are given a string s. We want to partition the string into as many parts as possible so that each letter appears in at most one part.

        Return a list of integers representing the size of these parts.

        aa bddceeeb

        Example 1:
        Input: s = "ababcbacadaefebgde hijhklij"
        Output: [9,7,8]
        Explanation:
        The partition is "ababcbaca", "defegde", "hijhklij".
        This is a partition so that each letter appears in at most one part.
        A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits s into less parts.
        Example 2:
        Input: s = "eccbbbbdec"
        Output: [10]

        Constraints:
        1 <= s.length <= 500
        s consists of lowercase English letters.







        */


import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Adobe {

    public static void main(String[] args) {



    }



    public int getMinimumMoves(Map<Integer , Integer> snakes , Map<Integer , Integer> ladder , int board[][]) {
        int ans = Integer.MAX_VALUE;
        Queue<Cell> queue = new LinkedList<>();
        queue.add(new Cell(1 , 0));
        while(!queue.isEmpty()) {
            // 2 3 4 5 6 7
            Cell current = queue.poll();
            if(current.cellNo == 100) {
                // ans = current.val;
                ans = Math.min(ans , current.val);
            }
            for(int i = 1 ; i <= 6;i++) {
                // if there is a laddeer at the current index... then add the point to where ladder is taking....
                // 3 4 5 6 7
                int dicePosition = current.cellNo + i;
                if(ladder.containsKey(current.cellNo)) {
                    queue.add(new Cell(ladder.get(current.cellNo) , current.val + 1));
                } else if(snakes.containsKey(current.cellNo)) {
                    queue.add(new Cell(snakes.get(current.cellNo) , current.val + 1));
                } else {
                    queue.add(new Cell(current.cellNo + i , current.val + 1));
                }
            }

             // 3 4 5 6 7 11 3 4 5 6 7
        }
        return ans;
    }
}


class Cell {
    int cellNo;
    int val;
    Cell(int cellNo , int val) {
        this.cellNo = cellNo;
        this.val = val;
    }
}

