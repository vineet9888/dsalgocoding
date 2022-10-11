package com.ds.algo.problem.solving.Arrays;

public class MatrixSpiralOrder {

    static int count;

    public static void main(String[] args) {
        int matrix[][] = new int[][]{
                {1,2,3,4},
                {6,7,8,9},
                {1,2,3,4},
                {6,7,8,9},
                {1,2,3,4}
        };
        int rows = matrix.length;
        int cols = matrix[0].length;
        count = rows*cols;
        int arr[][] = new int[][]{
                {0,cols-1,0 , 1},
                {1,rows-1,cols-1 , 1},
                {cols-2 , 0 , rows - 1 , 0},
                {rows-2 , 1 , 0, 0}
            };
        while(count > 0) {
            // move right -> row is fixed
            // move down ! -> row is varied.
            // move left
            // move up |
            // in horizontal movement row is fixed...
            // in vertical movement row is variable...
            loop(arr[0][0] , arr[0][1] , arr[0][2] , arr[0][3] , matrix , true);
            arr[0][0]++;
            arr[0][1]--;
            arr[0][2]++;

            loop(arr[1][0] , arr[1][1] , arr[1][2] , arr[1][3] , matrix , false);
            arr[1][0]++;
            arr[1][1]--;
            arr[1][2]--;

            loop(arr[2][0] , arr[2][1] , arr[2][2] , arr[2][3] , matrix , true);
            arr[2][0]--;
            arr[2][1]++;
            arr[2][2]--;

            loop(arr[3][0] , arr[3][1] , arr[3][2] , arr[3][3] , matrix , false);
            arr[3][0]--;
            arr[3][1]++;
            arr[3][2]++;
        }
    }

    public static void loop(int start , int end , int constt , int direction , int matrix[][] , boolean row) {

        if(count <= 0) {
            return;
        }
        // either moving right or down
        // row is true means row is fixed....
        if(direction == 1) {
            if(row) {
                for(int i = start;i<=end;i++) {
                    System.out.print(matrix[constt][i] + " , ");
                    count--;
                }
            } else {
                for(int i = start;i<=end;i++) {
                    System.out.print(matrix[i][constt] + " , ");
                    count--;
                }
            }
        } else {
            if(row) {
                for(int i = start;i >= end;i--) {
                    System.out.print(matrix[constt][i] + " , ");
                    count--;
                }
            } else {
                for(int i = start;i >= end;i--) {
                    System.out.print(matrix[i][constt] + " , ");
                    count--;
                }
            }

        }
    }
}

