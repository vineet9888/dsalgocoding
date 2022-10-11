package com.ds.algo.problem.solving.graphs;

public class FindNoOfIslands {

    private static boolean visited[][];

    public static void dfs(char[][] grid , int row , int col) {
        int rowSize = grid.length;
        int colSize = grid[0].length;
        visited[row][col] = true;
        int rows[] = { 0 , -1 , 0 , 1};
        int cols[] = { -1 , 0  , 1 , 0};
        for(int i = 0;i < 4;i++) {
            int newRow = row + rows[i];
            int newCol = col + cols[i];
            if(newRow >= 0 && newRow < rowSize && newCol>=0 && newCol < colSize && grid[newRow][newCol] == '1' && !visited[newRow][newCol]){
                dfs(grid ,newRow , newCol);
            }
        }
    }

    public static int numOfIslands(char[][] grid) {
        int noOfIslands = 0;
        for(int i = 0;i < grid.length;i++) {
            for(int j = 0;j < grid[i].length;j++) {
                if(grid[i][j] == '1' && !visited[i][j]) {
                    dfs(grid,i,j);
                    noOfIslands++;
                }
            }
        }
        return noOfIslands;
    }


    public static void main(String[] args) {

        char grid[][] = {{'1','1','0','0','0'},
                         {'0','1','0','0','0'},
                        {'1','0','1','0','0'},
                        {'1','0','0','1','1'}};
        visited = new boolean[grid.length][grid[0].length];
        System.out.println(numOfIslands(grid));
        System.out.println(noOfIslands(grid));
    }


    public static void dfs1(char grid[][] , boolean visited[][] , int row , int col) {
        visited[row][col] = true;
        int rows[] = new int[]{0 , -1 , 0 , 1};
        int cols[] = new int[]{-1 , 0 , 1 , 0};
        int totalRows = grid.length;
        int totalCols = grid[0].length;
        for(int i = 0 ; i < rows.length;i++) {
            int newRow = row + rows[i];
            int newCol = col + cols[i];
            if(newRow >= 0 && newRow < totalRows && newCol>=0 && newCol < totalCols && !visited[newRow][newCol] && grid[newRow][newCol] == '1') {
                dfs1(grid,visited,newRow,newCol);
            }
        }
    }


    public static int noOfIslands(char grid[][]) {
        int rows = grid.length;
        int cols = grid[0].length;
        boolean visited[][] = new boolean[rows][cols];
        int count = 0;
        for(int i = 0 ; i < rows;i++) {
            for(int j = 0 ; j < cols;j++) {
                if(grid[i][j] == '1' && !visited[i][j]) {
                    dfs1(grid,visited,i,j);
                    count++;
                }
            }
        }
        return count;
    }


}
