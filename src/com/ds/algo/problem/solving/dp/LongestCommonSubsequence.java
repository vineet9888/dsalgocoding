package com.ds.algo.problem.solving.dp;

import java.util.*;

public class LongestCommonSubsequence {


    public static int lcs(String first , String second , int firstStringIndex , int secondStringIndex,HashMap<String , Integer> cache) {
        String key = firstStringIndex+"-"+secondStringIndex;

        if(firstStringIndex > (first.length() - 1)  || secondStringIndex > (second.length() - 1)){
            return 0;
        }
        if(cache.containsKey(key)) {
            return cache.get(key);
        }

        int ans = 0;
        if(first.charAt(firstStringIndex) == second.charAt(secondStringIndex)) {
            ans = 1 + lcs(first,second,firstStringIndex + 1 , secondStringIndex + 1,cache);
        } else {
            ans = Math.max(lcs(first,second,firstStringIndex,secondStringIndex + 1,cache) ,
                    lcs(first,second,firstStringIndex + 1 , secondStringIndex,cache));
        }
        cache.put(key,ans);
        return ans;
    }


    public static int lcs(String first , String second) {
        int rowSize = first.length();
        int colSize = second.length();
        int dp[][] = new int[rowSize][colSize];

        for(int i = 0;i < rowSize;i++) {
            for(int j = 0;j < colSize;j++) {
                if(i == 0) {
                    if(first.charAt(i) == second.charAt(j)) {
                        dp[0][j] = 1;
                    } else {
                        dp[0][j] = (j != 0) ? dp[0][j-1] : 0;
                    }
                } else if(j == 0) {
                    if(first.charAt(i) == second.charAt(j)) {
                        dp[i][0] = 1;
                    } else {
                        dp[i][0] = (i != 0) ? dp[i-1][0] : 0;
                    }
                } else {
                    dp[i][j] =  (first.charAt(i) == second.charAt(j)) ?(1+dp[i-1][j-1]) : (Math.max(dp[i-1][j], dp[i][j-1]));
                }
            }
        }


        for(int i = 0 ; i < rowSize;i++) {
            for(int j = 0 ; j < colSize;j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        int row = rowSize-1;
        int col = colSize-1;
        List<Integer> firstStringIndexes = new ArrayList<>();
        List<Integer> secondStringIndexes = new ArrayList<>();
        String lcs = "";
        while(row >= 0 && col >=0 ) {
            if(first.charAt(row) == second.charAt(col)) {
                lcs += first.charAt(row);
                firstStringIndexes.add(row);
                secondStringIndexes.add(col);
                row = row - 1;
                col = col - 1;
            } else {
                /*if((col-1 >= 0) && (row-1 >= 0 ) &&  (dp[row][col-1] == dp[row-1][col])) {
                    row = row - 1;
                    col = col - 1;
                } else*/
                if(row == 0) {
                    col = col - 1;
                } else if((col-1 >= 0) && (row-1 >= 0 ) &&  (dp[row][col-1] > dp[row-1][col])) {
                    col = col-1;
                } else {
                    row = row-1;
                }
            }
        }



        Collections.reverse(firstStringIndexes);
        Collections.reverse(secondStringIndexes);
        firstStringIndexes.forEach((index) -> System.out.print(index + " "));
        System.out.println("");
        secondStringIndexes.forEach((index) -> System.out.print(index + " "));
        System.out.println("LCS IS " + new StringBuilder(lcs).reverse());
        String ans = "";

        int i = 0;
        int lcsLength = firstStringIndexes.size();
        // System.out.println(lcs("AGGTAB","GXTXAYB"));

        while(i < lcsLength) {
            int j  = (i == 0 ? 0 : firstStringIndexes.get(i-1)+1);
            while(j < firstStringIndexes.get(i)) {
                   ans += first.charAt(j);
                   j++;
            }
            j  = (i == 0 ? 0 : secondStringIndexes.get(i-1)+1);
            while(j < secondStringIndexes.get(i)) {
                ans += second.charAt(j);
                j++;
            }
            ans += first.charAt(firstStringIndexes.get(i));
            i++;
        }

        for(int j = firstStringIndexes.get(lcsLength-1) + 1; j < first.length();j++) {
            ans += first.charAt(j);
        }

        for(int j = secondStringIndexes.get(lcsLength-1) + 1; j < second.length();j++) {
            ans += second.charAt(j);
        }



        System.out.println(ans);
        return dp[rowSize - 1][colSize - 1];
    }


    public static void main(String[] args) {
        HashMap<String , Integer> cache = new HashMap<>();
        // System.out.println(lcs("bbbaaaba","bbababbb",0,0,cache));

        System.out.println(lcs("babad","bxbad"));
        //b c a c a a a b          b b a b a c c c
        //0 1 2 3 4 5 6 7          0 1 2 3 4 5 6 7
        // 6 4
    }

}
