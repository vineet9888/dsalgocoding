package com.ds.algo.problem.solving.graphs;

import java.util.LinkedList;
import java.util.Queue;

class Cell {
    public int row;
    public int col;
    public int time;
    public Cell(int row ,int col , int time){
        this.row = row;
        this.col = col;
        this.time = time;
    }
}

public class RottingOranges {

    public static int orangesRotting(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int visited[][] = new int[row][col];
        int ans = 0;
        int freshOranges[]= new int[]{0};

        Queue<Cell> queue = new LinkedList<>();
        for(int i = 0 ; i < row;i++){
            for(int j =0 ; j < col;j++) {
                if(grid[i][j] == 1) {
                    freshOranges[0] += grid[i][j];
                }
                if(grid[i][j] == 2) {
                    queue.add(new Cell(i,j,0));
                }
            }
        }

        Cell cell = null;
        while(!queue.isEmpty()) {
             cell = queue.poll();
             processNearbyOranges(queue,cell,grid,freshOranges);
        }

        if(freshOranges[0] == 0) {
            // this is the min time cell.time;
            ans = cell != null ?  cell.time :0;
        } else {
            ans = -1;
        }

        return ans;
    }

    public static void processNearbyOranges(Queue<Cell> queue , Cell cell , int[][] grid , int freshOranges[]) {
        int totalRows = grid.length;
        int totalCols = grid[0].length;
        int rows[] = new int[]{-1,0,1,0};
        int cols[] = new int[]{0,1,0,-1};
        for(int i = 0;i < 4;i++){
            int newRow = cell.row + rows[i];
            int newCol = cell.col + cols[i];
            if(newRow >= 0 && newRow < totalRows && newCol >=0 && newCol < totalCols && grid[newRow][newCol] == 1) {
                queue.add(new Cell(newRow,newCol,cell.time+1));
                grid[newRow][newCol] = 2;
                if(freshOranges[0] > 0){
                    freshOranges[0]--;
                }
            }
        }

    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{{0}};
        int[][] grid1 = new int[][]{{0}};
        System.out.println(orangesRotting(grid));
        System.out.println(rotOranges(grid1));
    }

    public static int rotOranges(int grid[][]) {
        int rows = grid.length;
        int cols = grid[0].length;
        int goodOranges = 0;
        Queue<Cell> queue = new LinkedList<>();
        for(int i = 0;i<rows;i++){
            for(int j = 0;j<cols;j++) {
                if(grid[i][j] == 2) {
                    queue.add(new Cell(i , j , 0));
                } else if(grid[i][j] ==1) {
                    goodOranges++;
                }
            }
        }
        int rIndex[] = new int[]{0 , -1 , 0 , 1};
        int cIndex[] = new int[]{-1, 0 , 1 , 0};
        int count = 0;
        int time = 0;
        while(!queue.isEmpty()) {
            Cell cell = queue.poll();
            time = cell.time;
            for(int i = 0 ; i < rIndex.length;i++){
                int nRow = cell.row + rIndex[i];
                int nCol = cell.col + cIndex[i];
                if(nRow >= 0 && nRow < rows && nCol >= 0 && nCol < cols && grid[nRow][nCol] == 1) {
                    grid[nRow][nCol] = 2;
                    queue.add(new Cell(nRow,nCol , cell.time+1));
                    count++;
                }
            }
        }

        if(count == goodOranges){
            return time;
        } else {
            return -1;
        }
    }

    public static void processNeighbours(int row , int col , int grid[][]) {

    }

}

