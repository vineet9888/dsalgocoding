package com.ds.algo.problem.solving.dp;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PalindromicPartioning {
	
    public static boolean ispalin(String input, int begin, int end) {
        while (begin < end) {
            if (input.charAt(begin) != input.charAt(end))
                return false;
            begin++;
            end--;
        }
        return true;
    }

    public static void printpart(String input, String output, int begin, int end) {
        if (begin == end) {
            System.out.println(output);
            return;
        }
        int n = input.length();
        String delimiter = "-" ;
        for (int i = begin; i < end; i++) {
            if (ispalin(input, begin, i)) {
                if (i+1 == n) {
                    delimiter = "" ;
                }
                printpart(input, output + input.substring(begin, i+1) + delimiter, i + 1, end);
            }
        }
    }

    public static void main(String[] args) {
        String input = "vine" ;
        String output = "" ;
        int begin = 0;
        int end = input.length();
        // printpart(input, output, begin, end);
        System.out.println(input.substring(1,input.length()));
        System.out.println(input.substring(0 , 1));
        System.out.println(palindromicPartioning1("abba"));
    }


    public static List<List<String>> palindromicPartioning1(String str) {
        List<List<String>> ans= new ArrayList<>();
        palindromicPartioning1(str , new ArrayList<>() , ans);
        return ans;
    }


    public static void palindromicPartioning1(String s , List<String> sublist , List<List<String>> ans) {
        if(s.length() == 1) {
            sublist.add(s);
            ans.add(sublist);
            return;
        }
        for(int i = 1 ; i <= s.length();i++) {
            String first = s.substring(0, i);
            if(isPalin(first)) {
                String second = s.substring(i , s.length());
                List<String> list = new ArrayList<>(sublist);
                list.add(first);
                if(second.length() != 0) {
                    palindromicPartioning1(second ,list , ans);
                } else {
                    ans.add(list);
                }

            }
        }
    }

    public static boolean isPalin(String str) {
        boolean isPalin = true;
        int start = 0;
        int end = str.length() - 1;
        while(start <= end) {
            if(str.charAt(start) == str.charAt(end)) {
                start++;
                end--;
            } else {
                isPalin = false;
                break;
            }
        }
        return isPalin;
    }


}