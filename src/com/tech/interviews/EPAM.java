package com.tech.interviews;

public class EPAM {

    public static void main(String[] args) {
        int arr[][] = new int[][] { {1,0,1,0,0},
                                    {0,1,1,1,1},
                                    {0,1,1,1,1},
                                    {1,1,1,1,0}};

        int rows = arr.length;
        int cols = arr[0].length;
        int heights[][] = new int[rows][cols];
        for(int i = 0 ; i < cols;i++) {
            heights[0][i] = arr[0][i];
        }
        for(int i = 1 ; i < rows;i++) {
            for(int j = 0; j < cols;j++) {
                if(arr[i][j] == 0) {
                    heights[i][j] = 0;
                } else {
                    heights[i][j] = heights[i-1][j] + 1;
                }
            }
        }

        for(int i = 0 ; i < rows;i++) {
            for(int j = 0; j < cols;j++) {
                System.out.print(heights[i][j] + " ");
            }
            System.out.println();
        }

        int ans = -1;
        for(int i = 0 ; i < rows;i++) {
            for(int j = 0; j < cols ;j++) {
                if(heights[i][j] !=0) {
                    ans = Math.max(ans , findMaxArea( j , heights[i]));
                }
            }
        }
        System.out.println(ans);
        int index = 2;
        int ar[] = new int[]{0,0,5,6,2};
        for(int i = 0 ; i < ar.length;i++) {
            System.out.println(findMaxArea(i , ar));
        }

    }

    public static int findMaxArea(int index , int heights[]) {
        // go on right side until the bar height is no equal to 0
        int min = heights[index];
        int rightIndex = index;
        int leftIndex = index;
        for(int i = index +1 ; i < heights.length;i++) {
            if(min <= heights[i]) {
                rightIndex = i;
            } else {
                break;
            }
        }
        for(int i = index-1;i >=0;i--) {
            if(min <= heights[i]) {
                leftIndex = i;
            } else {
                break;
            }
        }
        if(leftIndex < 0) {
            leftIndex = 0;
        }
        if(rightIndex >= heights.length) {
            rightIndex = heights.length-1;
        }
        int ans =(rightIndex - leftIndex + 1) * min;
        return ans;
    }
}
