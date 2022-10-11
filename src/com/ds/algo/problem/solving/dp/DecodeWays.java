package com.ds.algo.problem.solving.dp;

public class DecodeWays {

    // 226 , 0
    //
    public static int numDecode(String s , int index) {

        if(index <s.length() && s.charAt(index) == '0') {
            return 0;
        }

        int ans = 0;
        if(index == s.length()-1 || index==s.length()) {
            return 1;
        }
        if(index < s.length()) {
            System.out.println("vineet ---- " + (index+1));
            ans += numDecode(s , index + 1);
        }
        if(index < s.length() - 1) {
            int val = Integer.valueOf(s.substring(index , index + 2));
            if(val <= 26) {
                System.out.println("sharma ---- " + (index+2));
                ans += numDecode(s , index + 2);
            }
        }
        return ans;
    }

    public static int numDecodings(String s) {
        return numDecode(s , 0);
    }


    public static void main(String[] args) {
        System.out.println(numDecodings("60"));
    }
}
