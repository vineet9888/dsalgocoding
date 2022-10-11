package com.ds.algo.problem.solving.dp;

import java.io.File;
import java.io.IOException;

public class JumpGame5 {

    public static int calculateMaxJumps(int arr[] , int d , int start) {
        int ans = 0;
        // for all the possible options where i can jump from the current position... return the max of that ans...
        int jumpLow = (start - d) < 0 ? 0 : (start - d);
        int jumpHigh = (start + d) > (arr.length-1) ? (arr.length-1) : (start+d);
        for(int i = jumpLow;i <= jumpHigh;i++) {
            if(i != start) {
                boolean canJump = false;
                if(start > i) {
                    for(int j = start - 1;j >= i;j--) {
                        canJump = (arr[start] > arr[j]);
                        if(!canJump) {
                            break;
                        }
                    }
                } else {
                    for(int j = start + 1;j<=i;j++) {
                        canJump = (arr[start] > arr[j]);
                        if(!canJump) {
                            break;
                        }
                    }
                }
                if(canJump) {
                    ans = Math.max(ans , 1 + calculateMaxJumps(arr , d , i));
                }
            }
        }
        return ans;
    }

    public static int maxJumps(int[] arr, int d) {
        int ans = 0;
        // create a 2d array to hold the mid computations....
        for(int i = 0;i<arr.length;i++) {
            ans = Math.max(ans , calculateMaxJumps(arr , d , i));
        }
        return ans+1;
    }

    public static void main(String[] args) {
        int arr[] = new int[]{7,6,5,4,3,2,1};
        // System.out.println(maxJumps(arr , 1));
        try {
            File file = File.createTempFile("vineet","sharma.bpmn");

            System.out.println(file.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
