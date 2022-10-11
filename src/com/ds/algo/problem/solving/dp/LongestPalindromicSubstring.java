package com.ds.algo.problem.solving.dp;

public class LongestPalindromicSubstring {

    public static int longestCommonSubstring(int first[] , int second[]) {
        int rowSize = first.length;
        int colSize = second.length;
        int dp[][] = new int[rowSize][colSize];
        int ans = Integer.MIN_VALUE;
        for(int i = 0;i < rowSize;i++) {
            for(int j = 0;j < colSize;j++) {
                if(i == 0) {
                    if(first[i] == second[j]) {
                        dp[0][j] = 1;
                    } else {
                        dp[0][j] = (j != 0) ? dp[0][j-1] : 0;
                    }
                } else if(j == 0) {
                    if(first[i] == second[j]) {
                        dp[i][0] = 1;
                    } else {
                        dp[i][0] = (i != 0) ? dp[i-1][0] : 0;
                    }
                } else {
                    if(first[i] == second[j]) {
                        if(first[i-1] == second[j-1]) {
                            dp[i][j] = 1+dp[i-1][j-1];
                        } else {
                            dp[i][j] = 1;
                        }
                    } else{
                        dp[i][j] = (Math.max(dp[i-1][j], dp[i][j-1]));
                    }
                }

                ans = dp[i][j] > ans ? dp[i][j] : ans;
            }
        }

        for(int i = 0 ; i < rowSize;i++) {
            for(int j = 0 ; j < colSize;j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }

        return ans;
    }

    public static void main(String[] args) {
        String s = "ABDCBCDBDCBBC";
        StringBuilder s1 = new StringBuilder(s);
        int first[] = new int[]{70,39,25,40,7};
        int second[] = new int[]{52,20,67,5,31};
        System.out.println(findLength(first , second));
        //System.out.println(longestCommonSubstring(s , s1.reverse().toString()));
    }


    public static int findLength(int[] nums1, int[] nums2) {
        return longestCommonSubstring(nums1 , nums2);
    }
}
