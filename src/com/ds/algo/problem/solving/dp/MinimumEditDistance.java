package com.ds.algo.problem.solving.dp;

public class MinimumEditDistance {

    public static final Integer MAX_VALUE = 100000;

    public static int minDistance(String word1 , String word2 , int f, int s , int dp[][]) {
        if(f == -1 && s == -1) {
            return 0;
        }
        if(s == -1) {
            return f+1;
        }
        if(f == -1) {
            return s+1;
        }

        if(dp[f][s] != -1) {
            return dp[f][s];
        }


        int ans = MAX_VALUE;
        if(word1.charAt(f) == word2.charAt(s)) {
            ans = minDistance(word1 , word2, f-1,s-1 , dp);
        } else {
            // replace
            ans = Math.min(ans , 1 + minDistance(word1 , word2 , f-1,s-1 , dp));
            // delete
            ans = Math.min(ans , 1 + minDistance(word1,word2,f-1,s , dp));
            // insert
            ans = Math.min(ans , 1 + minDistance(word1,word2,f,s-1 , dp));
        }
        dp[f][s] = ans;
        return ans;
    }

    public static int minDistance(String word1, String word2) {
        int dp[][] = new int[word1.length()][word2.length()];
        for(int i = 0; i < word1.length();i++) {
            for(int j = 0 ; j < word2.length();j++) {
                dp[i][j] = -1;
            }
        }
        return minDistance(word1 , word2, word1.length()-1, word2.length()-1 , dp);
    }

    public static void main(String[] args) {
        System.out.println(minDistance("intention","execution"));
    }
}
