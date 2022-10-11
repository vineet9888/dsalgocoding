package com.tech.interviews;

public class NexthinkInterview {

    public static void main(String[] args) {

        int n = 15958;
        String s = "12345";
//        System.out.println(s.substring(0,1));
//        System.out.println(s.substring(2,5));
//        System.out.println(Integer.valueOf(s));
        System.out.println(solution(n));
        System.out.println(solution(-5859));
        System.out.println(solution(-5000));
        System.out.println(solution(257859));
        System.out.println(solution(-257859));
    }

    public static int solution(int n) {
        if( n == 0) {
            return 0;
        }
        boolean isNegative = (n < 0 ) ? true : false;
        String s = String.valueOf(Math.abs(n));
        int ans = Integer.MIN_VALUE;
        for(int i = 0 ; i < s.length();i++) {
            if(s.charAt(i) == '5') {
                String temp = s.substring(0 , i) + s.substring(i+1 , s.length());
                if(isNegative) {
                    ans = Math.max(-(Integer.valueOf(temp)) , ans);
                } else {
                    ans = Math.max(Integer.valueOf(temp) , ans);
                }
            }
        }
        return ans;
    }


}
