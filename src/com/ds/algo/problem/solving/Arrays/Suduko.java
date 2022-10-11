package com.ds.algo.problem.solving.Arrays;

public class Suduko {

    public static void main(String[] args) {
        char board[][] = new char[][] {
                {'.','.','.','.','5','.','.','1','.'},
                {'.','4','.','3','.','.','.','.','.'},
                {'.','.','.','.','.','3','.','.','1'},
                {'8','.','.','.','.','.','.','2','.'},
                {'.','.','2','.','7','.','.','.','.'},
                {'.','1','5','.','.','.','.','.','.'},
                {'.','.','.','.','.','2','.','.','.'},
                {'.','2','.','9','.','.','.','.','.'},
                {'.','.','4','.','.','.','.','.','.'}
            };
        System.out.println(isValidSudoku(board));
    }

    public static boolean isValidSudoku(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        for(int i = 0 ; i < rows;i++) {
            for(int j = 0 ; j < cols;j++) {
                char ch = board[i][j];
                if(ch != '.') {
                    if(validateSameElementInRow(i  , j, ch , board)) {
                        return false;
                    }
                    if(validateSameElementInCol(i, j , ch , board)) {
                        return false;
                    }
                    if(validateSameElementInGrid(i , j , ch , board)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static boolean validateSameElementInGrid(int row , int col , int ch , char board[][]) {

        int startRow = ((row)/3)*3;
        int startCol = (col/3)*3;
        for(int i = startRow;i <(startRow+3);i++){
            for(int j = startCol;j<(startCol+3);j++) {
                if(i != row && j!= col && board[i][j] == ch) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean validateSameElementInRow(int row ,int col, char ch , char board[][]) {
        for(int i = 0;i < 9;i++) {
            if(i != col && board[row][i] == ch) {
                return true;
            }
        }
        return false;
    }

    public static boolean validateSameElementInCol(int row , int col , char ch , char board[][]) {
        for(int i = 0 ; i < 9;i++) {
            if(i != row && board[i][col] == ch) {
                return true;
            }
        }
        return false;
    }
}
