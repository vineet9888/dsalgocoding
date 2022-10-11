package com.ds.algo.problem.solving.dp;

public class CherryPick2 {

    public static int pickCherriesSolver(int grid[][] , int row , int firstRobotCol , int secondRobotCol , int dp[][][]) {
        // make sure the call is valid...
        int rows = grid.length;
        int cols = grid[0].length;
        if(row > rows -1 || firstRobotCol < 0 || firstRobotCol > cols - 1 || secondRobotCol < 0 || secondRobotCol > cols - 1) {
            return 0;
        }

        if(dp[row][firstRobotCol][secondRobotCol] != -1) {
            return dp[row][firstRobotCol][secondRobotCol];
        }

        int ans = -1;
        for(int i = firstRobotCol - 1 ; i <= firstRobotCol + 1;i++) {
            for(int j = secondRobotCol - 1 ;j <= secondRobotCol + 1 ;j++) {
                int subProblemAns = pickCherriesSolver(grid, row + 1 , i , j , dp) + grid[row][firstRobotCol];
                if(firstRobotCol != secondRobotCol) {
                    subProblemAns += grid[row][secondRobotCol];
                }
                ans = Math.max(ans, subProblemAns);
            }
        }
        dp[row][firstRobotCol][secondRobotCol] = ans;
        return ans;
    }

    public static int pickCherries(int grid[][]) {
        int rows = grid.length;
        int cols = grid[0].length;
        int dp[][][] = new int[rows][cols][cols];
        for(int i = 0 ; i < rows;i++) {
            for(int j = 0 ; j < cols;j++) {
                for(int k = 0 ; k < cols;k++) {
                    dp[i][j][k] = -1;
                }
            }
        }
        return pickCherriesSolver(grid , 0 , 0 , cols-1 , dp);
    }

    public static void main(String[] args) {
        int grid[][] = new int[][]{
                {1,0,0,0,0,0,1},
                {2,0,0,0,0,3,0},
                {2,0,9,0,0,0,0},
                {0,3,0,5,4,0,0},
                {1,0,2,3,0,0,6}
        };
        System.out.println(pickCherries(grid));
    }
}
