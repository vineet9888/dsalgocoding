package com.ds.algo.problem.solving.dp;

public class UniquePaths {

    public static int uniquePaths(int m, int n) {
        int dp[][] = new int[m][n];
        for( int i = 0; i < n;i++) {
            dp[0][i] = 1;
        }
        for(int i = 0 ; i < m ; i ++) {
            dp[i][0] = 1;
        }

        for(int i = 1 ; i < m ; i++) {
            for(int j = 1;j < n;j++) {
                dp[i][j] = dp[i][j-1] + dp[i-1][j];
            }
        }

        return dp[m-1][n-1];
    }


    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int dp[][] = new int[m][n];
        boolean foundObstacle = false;
        for(int i = 0; i < n;i++) {
            // after an obstacle in first row all the entries after that will be zero
            if(obstacleGrid[0][i] == 1) {
                foundObstacle = true;
            }
            dp[0][i] = foundObstacle ? 0 : 1;
        }
        foundObstacle = false;
        for(int i = 0 ; i < m ; i ++) {
            // after an obstacle in first column all the entries after that will be zero
            if(obstacleGrid[i][0] == 1) {
                foundObstacle = true;
            }
            dp[i][0] = foundObstacle ? 0 : 1;
        }

        for(int i = 1 ; i < m ; i++) {
            for(int j = 1;j < n;j++) {
                if(obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i][j-1] + dp[i-1][j];
                }
            }
        }
        return dp[m-1][n-1];
    }

    public static void main(String[] args) {
        System.out.println(uniquePaths(7,3));
    }
}
