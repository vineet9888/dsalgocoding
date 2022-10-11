package com.ds.algo.problem.solving.dp;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ShortestPathInBinaryMatrix {

    public static final int MAX_VALUE = 100000;


    public static int shortestPathBinaryMatrix(int[][] grid) {
        List<Integer> list = new ArrayList<>();
        List<Integer> copy = new ArrayList<>(list);

        int rows = grid.length;
        int cols = grid[0].length;
        boolean visited[][] = new boolean[rows][cols];
        int dp[][] = new int[rows][cols];
        for(int i = 0 ; i < rows;i++) {
            for(int j = 0 ; j < cols;j++) {
                dp[i][j] = -1;
            }
        }
        // base case when start is not zero...
        if(grid[0][0] == 1) {
            return -1;
        }

        int ans = shortestPath(grid , visited , 0 , 0 , dp);

        for(int i = 0 ; i < rows;i++) {
            for(int j = 0 ; j < cols;j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        return ans == MAX_VALUE ? -1 : ans;

    }

    public static int shortestPath(int grid[][] , boolean visited[][]  , int row , int col , int dp[][]) {
        // at any point ans is the max of all the 8 directions....
        int ans = MAX_VALUE;
        int rows = grid.length;
        int cols = grid[0].length;
        int nrows[] = new int[]{0 , -1 , -1,-1 , 0 , 1 , 1 , 1};
        int ncols[] = new int[]{-1 , -1 , 0 , 1 , 1 , 1 , 0 , -1};

        if(dp[row][col] != -1) {
            return dp[row][col];
        }

        if(row == rows -1 && col == cols - 1) {
            dp[row][col] = 1;
            return 1;
        }

        visited[row][col] = true;
        for(int i = 0 ; i < nrows.length;i++) {
            int nr = row + nrows[i];
            int nc = col + ncols[i];


            if(nr >= 0 && nr < rows && nc >= 0 && nc < cols && grid[nr][nc] != 1 ) {
                if(row == 1 && col == 1) {
                    System.out.println(nr + " - " + nc + visited[nr][nc] + " - " + dp[nr][nc]);
                }
                if(!visited[nr][nc]) {
                    ans = Math.min(ans , 1 + shortestPath(grid , visited , nr , nc , dp));
                } else if(visited[nr][nc] && dp[nr][nc] != -1) {
                    ans = Math.min(ans , 1 + dp[nr][nc]);
                }

            }
        }
        //System.out.println(row + " - " + col + " - " + ans);
        dp[row][col] = ans;
        return ans;
    }


    /*
         0, 0, 0, 1
         0, 0, 1, 0
         0, 1, 0, 0
         1, 0, 0, 0
    */

    public static void main(String[] args) {
        int grid[][] = new int[][]{{0,0,0},{1,1,0},{1,1,0}};
        int ans =  lot(grid);
        System.out.println(ans);
    }

    public static int lot(int[][] grid) {
        int ans = MAX_VALUE;
        Queue<Cell> queue = new LinkedList<>();
        int rows = grid.length;
        int cols = grid[0].length;
        boolean visited[][] = new boolean[rows][cols];
        if(grid[0][0] == 1) {
            return -1;
        }
        visited[0][0] = true;
        queue.add(new Cell(0 , 0,1));
        while(!queue.isEmpty()) {
            Cell cell = queue.poll();
            int row = cell.r;
            int col = cell.c;
            if(row == rows-1 && col == cols-1) {
                ans = Math.min(ans , cell.l);
            }
            int nrows[] = new int[]{0 , -1 , -1,-1 , 0 , 1 , 1 , 1};
            int ncols[] = new int[]{-1 , -1 , 0 , 1 , 1 , 1 , 0 , -1};
            for(int i = 0 ; i < nrows.length;i++) {
                int nr = row + nrows[i];
                int nc = col + ncols[i];
                if(nr >= 0 && nr < rows && nc >= 0 && nc < cols && grid[nr][nc] != 1 &&!visited[nr][nc])                 {
                    visited[nr][nc]=true;
                    queue.add(new Cell(nr,nc,cell.l+1));
                }
            }
        }
        return ans;

    }


}


class Cell {
    int r;
    int c;
    int l;
    Cell(int r , int c , int l) {
        this.r = r;
        this.c = c;
        this.l = l;
    }
}