package com.ds.algo.problem.solving.graphs;

import java.util.Scanner;

public class SearchWordInGrid {

/*
           a x m y
           b g d f
           x e e t
           r a k s
      */
// geeks
// 01234

    public static boolean dfs(char grid[][] , String pat , int row , int col , int level) {
        if(level == pat.length()) {
            System.out.println(level);
            return true;
        }
        int rows= grid.length;
        int cols = grid[0].length;
        int nRows[] = new int[]{0,-1,0,1};
        int nCols[] = new int[]{-1,0,1,0};

        char temp = grid[row][col];
        grid[row][col] = '#';
        System.out.println(temp);
        boolean ans = false;
        for(int i = 0 ; i < 4;i++) {
            int nextRow = row + nRows[i];
            int nextCol = col + nCols[i];
            if(nextCol >= 0 && nextCol < cols && nextRow >=0 && nextRow < rows && grid[nextRow][nextCol] == pat.charAt(level)) {

                ans = dfs(grid , pat , nextRow , nextCol , level + 1);
                if(ans) {
                    return ans;
                }
            }
        }
        grid[row][col] = temp;
        return ans;
    }


    public static boolean exists(char grid[][] , String pat) {

        int rows= grid.length;
        int cols = grid[0].length;
        for(int i = 0 ; i < rows;i++) {
            for(int j = 0 ; j < cols;j++) {
                if(grid[i][j] == pat.charAt(0)) {
                    if(dfs(grid,pat,i,j , 1)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }




    public static void main(String[] args) {
        char grid[][] = { "axmy".toCharArray(),
                "bgdf".toCharArray(),
                "xeet".toCharArray(),
                "raks".toCharArray() };
        String pat = "geet";
        // System.out.println(exists(grid , pat));
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        for(int k = 0;k<t;k++) {
            int r = scan.nextInt();
            int c = scan.nextInt();
            char arr[][] = new char[r][c];
            for(int i = 0 ; i < r ; i++) {
                for(int j = 0;j< c ; j ++) {
                    Character ch =  scan.next().charAt(0);
                    arr[i][j] = ch;
                }
            }
            for(int i = 0 ; i < r ; i++) {
                for(int j = 0;j< c ; j ++) {
                    System.out.print(arr[i][j] + " ");
                }
                System.out.println();
            }
        }






    }
}
