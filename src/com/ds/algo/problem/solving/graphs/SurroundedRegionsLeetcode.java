package com.ds.algo.problem.solving.graphs;

public class SurroundedRegionsLeetcode {

    public static void dfs(String[][] grid , int row , int col) {
        int rowSize = grid.length;
        int colSize = grid[0].length;
        int rows[] = { 0 , -1 , 0 , 1};
        int cols[] = { -1 , 0  , 1 , 0};
        grid[row][col] = "V";
        for(int i = 0;i < 4;i++) {
            int newRow = row + rows[i];
            int newCol = col + cols[i];
            if(newRow >= 0 && newRow < rowSize && newCol>=0 && newCol < colSize && grid[newRow][newCol] == "O" && grid[newRow][newCol] != "V"){
                dfs(grid ,newRow , newCol);
            }
        }
    }

    public static void surroundedRegions(String board[][]) {
        int rowLength = board.length;
        int colLength = board[0].length;
        for(int i = 0;i < board.length;i++) {
            for(int j = 0;j < board[0].length;j++) {
                  if((i == 0 || j == 0 || i ==rowLength - 1 || j == colLength - 1)) {
                      if(board[i][j] == "O") {
                          // call dfs only for borders..... and mark all the connected O
                          dfs(board , i , j);
                      }
                  }
            }
        }
    }


    public static void main(String[] args) {

        String board[][] = {
                {"X"}
        };
        surroundedRegions(board);
        for(int i = 0;i < board.length;i++) {
            for(int j = 0;j < board[0].length;j++) {
                if(board[i][j] == "V") {
                    board[i][j] = "O";
                } else {
                    board[i][j] = "X";
                }
            }
        }

        for(int i = 0;i < board.length;i++) {
            for(int j = 0;j < board[0].length;j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        // iterate over the array.... from corner nodes and mark all the connected nodes as visited...
    }
}
