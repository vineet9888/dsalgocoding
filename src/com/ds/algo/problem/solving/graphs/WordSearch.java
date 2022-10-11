package com.ds.algo.problem.solving.graphs;

import java.util.Scanner;

public class WordSearch {

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
            String keyword = scan.next();
            for(int i = 0 ; i < r ; i++) {
                for(int j = 0;j< c ; j ++) {
                    System.out.print(arr[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println(exist(arr , keyword));
        }
    }

    public static int exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;
        int ans = 0;
        boolean visited[][] = new boolean[rows][cols];
        for(int i = 0 ; i < rows;i++) {
            for(int j = 0 ; j < cols;j++) {
                ans += dfs(board , word , visited , i , j , String.valueOf(board[i][j]));
                visited = new boolean[rows][cols];
            }
        }
        return ans;
    }

    public static int dfs(char board[][] , String word , boolean visited[][] , int r, int c , String curr ) {
        int rows = board.length;
        int cols = board[0].length;
        int curLen = curr.length();
        if(curr.charAt(curLen-1) != word.charAt(curLen-1)) {
            return 0;
        }
        if(curr.length() == word.length()) {
            return 1;
        }

        int nrows[] = new int[]{0,-1,0,1};
        int ncols[] = new int[]{-1,0,1,0};
        visited[r][c] = true;
        int ans = 0;
        for(int i = 0 ; i < 4;i++) {
            int nr = r + nrows[i];
            int nc = c + ncols[i];
            if(nr >= 0 && nr < rows && nc >= 0 && nc < cols && !visited[nr][nc]) {
                ans += dfs(board,word,visited,nr,nc,curr + board[nr][nc]);
            }
        }
        visited[r][c] = false;
        return ans;

    }
}
