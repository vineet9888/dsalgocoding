package com.ds.algo.problem.solving.Arrays;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    public static void main(String[] args) {
        int matrix[][] = new int[][]{{1,2,3,4},
                                     {5,6,7,8},
                                     {9,10,11,12},
                                     {13,14,15,16}};

        List<Integer> ans = new ArrayList<>();
        Counter counter = new Counter();
        String s = "vineet";

        print(matrix , 0, ans , 0 , 0 , counter);
        System.out.println(ans);
    }


    public static void print(int matrix[][] , int direction , List<Integer> ans , int row , int col , Counter counter) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        if(counter.count >= rows*cols) {
            return;
        }

        if(row < 0 || row >= rows || col < 0 ||  col >= cols) {
            return;
        }

        System.out.println(direction + " ->" + row + "," + col);

        if(direction == 0) {
            // left to right
            int c = col;
            int r = row;
            while(c < cols && matrix[r][c] != -200) {
                if(matrix[r][c] == -200) {
                    break;
                }
                counter.count++;
                ans.add(matrix[r][c]);
                matrix[r][c] = -200;
                c++;
            }
            print(matrix , 1 , ans , row + 1 , c-1 , counter);
        } else if(direction == 1) {
            // top to bottom
            int c = col;
            int r = row;
            while(r < rows && matrix[r][c] != -200) {
                if(matrix[r][c] == -200) {
                    break;
                }
                counter.count++;
                ans.add(matrix[r][c]);
                matrix[r][c] = -200;
                r++;
            }
            print(matrix , 2 , ans , r-1 , col-1 , counter);

        } else if(direction == 2) {
            // right to left
            int c = col;
            int r = row;
            while(c >= 0 && matrix[r][c] != -200) {
                if(matrix[r][c] == -200) {
                    break;
                }
                counter.count++;
                ans.add(matrix[r][c]);
                matrix[r][c] = -200;
                c--;
            }
            print(matrix , 3 , ans , row-1 , c + 1 , counter);

        } else if(direction == 3){
            // bottom to top
            int c = col;
            int r = row;
            while(r >= 0 && matrix[r][c] != -200) {
                if(matrix[r][c] == -200) {
                    break;
                }
                counter.count++;
                ans.add(matrix[r][c]);
                matrix[r][c] = -200;
                r--;
            }
            print(matrix , 0 , ans , r + 1 , c+1 , counter);
        }
    }
}


class Counter {
    int count = 0;
}