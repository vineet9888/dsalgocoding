package com.ds.algo.problem.solving.dp;

import java.util.*;
import java.util.stream.Collectors;

public class WordBreak {

    public static boolean wordBreak(Set<String> dictionary , int index , String word , int dp[]) {
        if(index == word.length()) {
            return true;
        }
        if(dp[index] != -1) {
            return dp[index] == 1;
        }
        boolean ans = false;
        for(int i = index;i < word.length();i++) {
            String substr = word.substring(index , i+1);
            ans = dictionary.contains(substr) && wordBreak(dictionary, i+1 , word , dp);
            if(ans) {
                break;
            }
        }
        dp[index] = ans ?  1 : 0;
       return ans;
    }

    public static void wordBreak2(Set<String> dictionary , int index , String word , List<String> allResults , String result) {
        if(index == word.length()) {
            allResults.add(result.substring(0,result.length()-1));
        }
        for(int i = index;i < word.length();i++) {
            String substr = word.substring(index , i+1);
            if(dictionary.contains(substr)) {
                wordBreak2(dictionary, i+1 , word , allResults , result + substr + " ");
            }
        }
    }

    public static void main(String[] args) {
        List<String> list = Arrays.asList("apple","pen","applepen","pine","pineapple");
        Set<String> dictionary = list.stream().collect(Collectors.toSet());
        int dp[] = new int[301];
        for(int i = 0 ;i< 301;i++) {
            dp[i] = -1;
        }

        // System.out.println(wordBreak(dictionary , 0 , "catsanddog" , dp));
        List<String> allResults = new ArrayList<>();
        wordBreak2(dictionary , 0 , "pineapplepenapple" , allResults , "");
        System.out.println(allResults);

    }

}
