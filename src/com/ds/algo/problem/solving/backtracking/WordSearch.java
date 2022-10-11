package com.ds.algo.problem.solving.backtracking;

public class WordSearch {

    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;
        boolean visited[][] = new boolean[rows][cols];
        for(int i = 0 ; i < rows;i++) {
            for(int j = 0 ; j < cols;j++) {
                boolean ans = dfs(board , word , visited , i , j , String.valueOf(board[i][j]));
                if(ans) {
                    return ans;
                }
            }
        }
        return false;
    }

    public static boolean dfs(char board[][] , String word , boolean visited[][] , int r, int c , String curr ) {
        int rows = board.length;
        int cols = board[0].length;
        if(curr.length() == word.length() && curr.equals(word)) {
            return true;
        }

        int nrows[] = new int[]{0,-1,0,1};
        int ncols[] = new int[]{-1,0,1,0};
        visited[r][c] = true;
        for(int i = 0 ; i < 4;i++) {
            int nr = r + nrows[i];
            int nc = c + ncols[i];
            if(nr >= 0 && nr < rows && nc >= 0 && nc < cols && !visited[nr][nc]) {
                boolean ans = dfs(board,word,visited,nr,nc,curr + board[nr][nc]);
                if(ans){
                    return ans;
                }
            }
        }
        visited[r][c] = false;
        return false;

    }

    public static void main(String[] args) {

    }

}
