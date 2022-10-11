package com.tech.interviews;

public class AngelOne {

    public static void main(String[] args) {
        int arr[][] = new int[][] {{0, 0, 0, 0, 1, 1},
                                    {0, 0, 0, 0, 0, 1},
                                   {0,0,0,0,0,0},
                                   {1,1,1,1,1,1}
                                };

        int ans = 0;
        int rowIndex = -1;
        for(int i = 0 ; i < arr.length;i++) {
            int res = binarySearch(arr[i]);
            if(res > ans) {
                ans = res;
                rowIndex = i;
            }
        }
        System.out.println(rowIndex + " - " + ans);
    }

    private static int binarySearch(int arr[]) {
        int index = -1;
        int low = 0;
        int high = arr.length-1;
        while(low <= high) {
            int mid = (low + high)/2;
            if(arr[mid] == 1) {
                index = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        if(index == -1) {
            return -1;
        } else {
            System.out.println(arr.length + " " + index);
            return arr.length - index;
        }
    }
}
