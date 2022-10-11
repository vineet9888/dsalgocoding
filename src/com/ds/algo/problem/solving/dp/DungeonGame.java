package com.ds.algo.problem.solving.dp;

public class DungeonGame {

    public static int calculateMinimumHP(int[][] dungeon) {
        int rowSize = dungeon.length;
        int colSize = dungeon[0].length;
        int minHP[][] = new int[rowSize][colSize];
        int hpTillNow[][] = new int[rowSize][colSize];


        for(int i = 0;i < rowSize;i++) {
            for(int j = 0; j < colSize;j++) {
                int minHPEntry = 0;
                int hpTillNowEntry = 0;
                if(i == 0 && j == 0) {
                    if(dungeon[i][j] <= 0) {
                        minHPEntry = Math.abs(dungeon[i][j]) + 1;
                        hpTillNowEntry = 1;
                    } else {
                        minHPEntry = 1;
                        hpTillNowEntry = dungeon[i][j] + 1;
                    }
                } else if(i == 0) {
                    if(dungeon[i][j] <=0) {
                        int ans = Math.abs(dungeon[i][j]) + 1;
                        minHPEntry = ans < hpTillNow[i][j-1] ? minHP[i][j-1] : ans  - hpTillNow[i][j-1] + minHP[i][j-1];
                        // minHPEntry = Math.abs(dungeon[i][j]) + 1 - hpTillNow[i][j-1] + minHP[i][j-1];
                        //hpTillNowEntry = 1;
                        hpTillNowEntry = (Math.abs(dungeon[i][j]) < hpTillNow[i][j-1]) ? hpTillNow[i][j-1] - Math.abs(dungeon[i][j]) : Math.abs(dungeon[i][j]) - hpTillNow[i][j-1] + 1;
                    } else {
                        minHPEntry = minHP[i][j-1];
                        hpTillNowEntry = dungeon[i][j] + hpTillNow[i][j-1];
                    }
                } else if( j == 0) {
                    if(dungeon[i][j] <= 0) {
                        int ans = Math.abs(dungeon[i][j]) + 1;
                        minHPEntry = ans < hpTillNow[i-1][j] ? minHP[i-1][j] : ans  - hpTillNow[i-1][j] + minHP[i-1][j];
                        //minHPEntry = Math.abs(dungeon[i][j]) + 1 - hpTillNow[i-1][j] + minHP[i-1][j];
                        //hpTillNowEntry = 1;
                        hpTillNowEntry = (Math.abs(dungeon[i][j]) < hpTillNow[i-1][j]) ? hpTillNow[i-1][j] - Math.abs(dungeon[i][j]) : Math.abs(dungeon[i][j]) - hpTillNow[i-1][j] + 1;
                    } else {
                        minHPEntry = minHP[i-1][j];
                        hpTillNowEntry = dungeon[i][j] + hpTillNow[i-1][j];
                    }
                } else {
                    if(dungeon[i][j] <= 0) {
                        int ans = Math.abs(dungeon[i][j]) + 1;
                        if(minHP[i-1][j] < minHP[i][j-1]) {
                            minHPEntry = ans < hpTillNow[i-1][j] ? minHP[i-1][j] : ans  - hpTillNow[i-1][j] + minHP[i-1][j];
                            hpTillNowEntry = (Math.abs(dungeon[i][j]) < hpTillNow[i-1][j]) ? hpTillNow[i-1][j] - Math.abs(dungeon[i][j]) : Math.abs(dungeon[i][j]) - hpTillNow[i-1][j] + 1;
                            // minHPEntry = Math.abs(dungeon[i][j]) + 1 - hpTillNow[i-1][j] + minHP[i-1][j];
                        } else {
                            minHPEntry = ans < hpTillNow[i][j-1] ? minHP[i][j-1] : ans  - hpTillNow[i][j-1] + minHP[i][j-1];
                            hpTillNowEntry = (Math.abs(dungeon[i][j]) < hpTillNow[i][j-1]) ? hpTillNow[i][j-1] - Math.abs(dungeon[i][j]) : Math.abs(dungeon[i][j]) - hpTillNow[i][j-1]+ 1;
                            // minHPEntry = Math.abs(dungeon[i][j]) + 1 - hpTillNow[i][j-1] + minHP[i][j-1];
                        }
                        // hpTillNowEntry = 1;
                    } else {
                        if(minHP[i-1][j] < minHP[i][j-1]) {
                            minHPEntry = minHP[i-1][j];
                            hpTillNowEntry = hpTillNow[i-1][j] + dungeon[i][j];
                        } else {
                            minHPEntry = minHP[i][j-1];
                            hpTillNowEntry = hpTillNow[i][j-1] + dungeon[i][j];
                        }
                    }
                }
                minHP[i][j] = minHPEntry;
                hpTillNow[i][j] = hpTillNowEntry;
            }
        }

        for(int i = 0 ; i < rowSize ; i ++) {
            for(int j = 0 ; j < colSize ; j ++) {
                System.out.print(hpTillNow[i][j] + " ");
            }
            System.out.println("");
        }

        for(int i = 0 ; i < rowSize ; i ++) {
            for(int j = 0 ; j < colSize ; j ++) {
                System.out.print(minHP[i][j] + " ");
            }
            System.out.println("");
        }

        return minHP[rowSize-1][colSize-1];
    }



    public static void main(String[] args) {
        //int input[][] = {{-2,-3,3},{-5,-10,1},{10,30,-5}};
         //int input[][] = {{2,1},{1,-1}}; // 1
        // int input[][] = {{3,-20,30},{-3,4,0}}; // 1
        //int input[][] = {{100}}; // 1
        //int input[][] = {{1,-2,3},{2,-2,-2}}; // 1
        int input[][] = {{1,-3,3},{0,-2,0},{-3,-3,-3}};
        System.out.println(calculateMinimumHP(input));
    }

    public static int calculateDungeonGameResult(int[][] dungeon) {
        int rows = dungeon.length;
        int cols = dungeon[0].length;
        int dp[][] = new int[rows][cols];
        for(int i = rows-1;i>=0;--i) {
            for(int j = cols-1 ; j>=0;--j) {
                if(i==rows-1 && j == cols-1) {
                    dp[i][j] = Math.min(0 , dungeon[i][j]);
                } else if (i == rows-1){
                    dp[i][j] = Math.min(0 , dungeon[i][j] + dp[i][j+1]);
                } else if(j == cols-1) {
                    dp[i][j] = Math.min(0, dungeon[i][j] + dp[i+1][j]);
                } else {
                    dp[i][j] = Math.min(0 , dungeon[i][j] + Math.max(dp[i][j+1] , dp[i+1][j]));
                }
            }
        }

        return Math.abs(dp[0][0] + 1);
    }


}
