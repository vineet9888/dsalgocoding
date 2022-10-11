package com.ds.algo.problem.solving.dp;

public class MininumSidewaysJump {

    public static int MAX_VALUE = 1000000000;

    public static int minSideJumps(int matrix[][] ,int dp[][] ,boolean visited[][], int current , int row , int col) {

        if(matrix.length - 1 == current){
            return 0;
        }
        if(matrix[row][col] == -1) {
            return MAX_VALUE;
        }
        if(visited[row][col]) {
            return dp[row][col] != -1 ? dp[row][col] : MAX_VALUE;
        }
        visited[row][col] = true;

        if(dp[row][col] != -1) {
            return dp[row][col];
        }
        int ans = 0;

        if(col == 0) {
            ans = minSideJumps(matrix , dp,visited,current + 1 , row + 1 , col);
            ans = min(ans , minSideJumps(matrix , dp,visited,current , row , col + 1) , 1);
            ans = min(ans , minSideJumps(matrix ,dp, visited,current , row , col + 2) , 1);
        }
        if(col == 1) {
            ans = minSideJumps(matrix ,dp, visited,current , row , col -1) + 1;
            ans = min(ans , minSideJumps(matrix ,dp,visited,current + 1 , row + 1 , col) , 0);
            ans = min(ans , minSideJumps(matrix ,dp,visited,current , row , col +1) , 1);
        }
        if(col == 2) {
            ans = minSideJumps(matrix ,dp,visited,current + 1 , row + 1 , col);
            ans = min(ans , minSideJumps(matrix ,dp,visited,current , row , col - 1) , 1);
            ans = min(ans , minSideJumps(matrix ,dp ,visited,current , row , col - 2) , 1);
        }
        dp[row][col] = ans;
        return ans;
    }

    // if a==b==integer.MAXVAKUE
    public static int min(int a , int b , int increment) {
        return Math.min(a, b + increment);
        /*if((a ==  Integer.MAX_VALUE && b == Integer.MAX_VALUE)) {
            return Integer.MAX_VALUE;
        }

        if(a < b) {
            return a;
        }
        if(b == Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }


        return Math.min(a, b + increment);*/
    }


    public static void main(String[] args) {
        int obstacles[] = new int[]{0,0,0,3,3,1,3,0,1,1,0,3,0,2,1,2,2,0,0,0,1,2,3,1,2,1,1,2,2,1,1,0,2,3,3,3,0,2,3,2,0,0,0,1,0,2,2,0,0,2,0,2,0,1,1,0,3,1,3,3,0,1,0,3,0,3,1,2,3,1,0,0,2,3,2,0,0,3,1,2,3,2,2,3,1,3,3,2,0,1,3,0,3,2,2,3,2,1,2,2,0};
        int matrix[][] = new int[obstacles.length][3];
        int dp[][] = new int[obstacles.length][3];
        boolean visited[][] = new boolean[obstacles.length][3];
        for(int i =0;i<obstacles.length;i++) {
            dp[i][0] = -1;
            dp[i][1] = -1;
            dp[i][2] = -1;
            if(obstacles[i] == 1) {
                matrix[i][0] = -1;
                matrix[i][1] = 0;
                matrix[i][2] = 0;
            } else if (obstacles[i] == 2) {
                matrix[i][0] = 0;
                matrix[i][1] = -1;
                matrix[i][2] = 0;
            } else if(obstacles[i] == 3) {
                matrix[i][0] = 0;
                matrix[i][1] = 0;
                matrix[i][2] = -1;
            } else {
                matrix[i][0] = 0;
                matrix[i][1] = 0;
                matrix[i][2] = 0;
            }
        }

        /*for(int i = 0 ; i < matrix.length;i++) {
            System.out.println(matrix[i][0] + " " + matrix[i][1] + " " + matrix[i][2]);
        }*/

        System.out.println(minSideJumps(matrix,dp , visited,0,0,1));
        System.out.println(minJump(matrix,dp,0,1));
        // System.out.print(Math.min(Integer.MAX_VALUE , Integer.MAX_VALUE));
    }


    public static int minJump(int matrix[][] ,int dp[][] , int row , int col) {

        if(row == matrix.length -1) {
            return 0;
        }
        if(dp[row][col] != -1) {
            return dp[row][col];
        }
        int ans = 10000000;
        if(matrix[row + 1][col] != -1) {
            ans = Math.min(ans , minJump(matrix , dp ,  row + 1 , col));
        } else {
            if(col == 0) {
                if((row +1)<=(matrix.length-1) && matrix[row+1][1] != -1 && matrix[row][1] != -1) {
                    ans = Math.min(ans , minJump(matrix , dp , row + 1 , 1) + 1);
                }
                if((row +1)<=(matrix.length-1) && matrix[row+1][2] != -1 && matrix[row][2] != -1) {
                    ans = Math.min(ans , minJump(matrix , dp  , row + 1 , 2) + 1);
                }
            } else if (col == 1){
                if((row +1)<=(matrix.length-1) && matrix[row+1][0] != -1 && matrix[row][0] != -1) {
                    ans = Math.min(ans , minJump(matrix , dp  , row + 1 , 0) + 1);
                }
                if((row +1)<=(matrix.length-1) && matrix[row+1][2] != -1 && matrix[row][2] != -1) {
                    ans = Math.min(ans , minJump(matrix , dp , row + 1 , 2) + 1);
                }
            } else if(col == 2) {
                if((row +1)<=(matrix.length-1) && matrix[row+1][0] != -1 && matrix[row][0] != -1) {
                    ans = Math.min(ans , minJump(matrix , dp , row + 1 , 0) + 1);
                }
                if((row +1)<=(matrix.length-1) && matrix[row+1][1] != -1 && matrix[row][1] != -1) {
                    ans = Math.min(ans , minJump(matrix , dp ,  row + 1 , 1) + 1);
                }
            }
        }
        dp[row][col] = ans;
        return ans;
    }
}
