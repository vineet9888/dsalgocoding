package com.ds.algo.problem.solving.dp;

import java.util.HashMap;
import java.util.Map;

public class LongestHappyString {

    public static String longestDiverseString(int a, int b, int c , String str , Map<String , String> cache) {
        String ans = "";



        if(a == 0 && b == 0 && c ==0) {
            return str;
        }

        int size = str.length();
        String key = "";
        if(size > 2) {
            key = a + "-" + b + "-" + c + "-" +str.charAt(size-1)+str.charAt(size-2);
        }

        System.out.println(key);
        if(!key.isEmpty() && cache.containsKey(key)) {
            return cache.get(key);
        }

        boolean valid = checkLastTwoChars(str , 'a');
        if(!valid && b == 0 && c == 0) {
            return str;
        } else if(valid){
            if(a-1 >= 0) {
                ans =  longestDiverseString(a-1, b ,c,str+"a" , cache);
            }
        }

        valid = checkLastTwoChars(str , 'b');
        if(!valid && a == 0 && c == 0) {
            return str;
        } else if(valid) {
            if(b - 1 >= 0) {
                ans = max(ans, longestDiverseString(a,b-1,c,str+"b" , cache));
            }

        }

        valid = checkLastTwoChars(str , 'c');
        if(!valid && a == 0 && b == 0) {
            return str;
        } else if(valid) {
            if(c-1 >= 0) {
                ans = max(ans , longestDiverseString(a,b,c-1,str+"c" , cache));
            }
        }
        if(!key.isEmpty()) {
            cache.put(key , ans);
        }
        return ans;
    }


    public static boolean checkLastTwoChars(String a , Character c) {
        boolean ans = true;
        int size = a.length() - 1;
        if(a.length() >= 2) {
            ans = !(a.charAt(size) == c && a.charAt(size-1) == c);
        }
        return ans;
    }

    public static String max(String a , String b) {
        return a.length() > b.length() ? a : b;
    }

    public static String longestDiverseString(int a, int b, int c) {
        Map<String , String> cache = new HashMap<>();
        return longestDiverseString(a,b,c , "" , cache);
    }

    public static void main(String[] args) {
        String s = "vineet";
        // System.out.println(s.charAt(s.length()-1));
        int a = 0, b=2 , c=3;
        String str = "";

//        String key = a + "-" + b + "-" + c + "-" + str;
//        System.out.println(key);
        System.out.println(longestDiverseString(1,1,7));
    }

}
