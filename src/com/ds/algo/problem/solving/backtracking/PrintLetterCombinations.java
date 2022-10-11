package com.ds.algo.problem.solving.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PrintLetterCombinations {

    public static void main(String[] args) {
        // letterCombinations("2");
        emiratesCombinations("112");
    }


    public static List<String> letterCombinations(String digits) {
        Map<Integer  , List<String>> map = new HashMap<>();
        List<String> list = new ArrayList<String>(){ {  add("a"); add("b"); add("c"); } };
        map.put(2 , list);
        map.put(3 , new ArrayList<String>(){ {  add("d"); add("e"); add("f"); } });
        map.put(4 , new ArrayList<String>(){ {  add("g"); add("h"); add("i"); } });
        map.put(5 , new ArrayList<String>(){ {  add("j"); add("k"); add("l"); } });
        map.put(6 , new ArrayList<String>(){ {  add("m"); add("n"); add("o"); } });
        map.put(7 , new ArrayList<String>(){ {  add("p"); add("q"); add("r");add("s"); } });
        map.put(8 , new ArrayList<String>(){ {  add("t"); add("u"); add("v"); } });
        map.put(9 , new ArrayList<String>(){ {  add("w"); add("x"); add("y");add("z"); } });
        List<String> ans = new ArrayList<>();
        recurse("23",ans,0,"",map);
        for (String an : ans) {
            System.out.println(an + " ");
        }
        return ans;
    }

    public static void recurse(String digits , List<String> ans , int curr , String res , Map<Integer  , List<String>> map) {

        if(curr == digits.length()) {
            ans.add(res);
            return;
        }
        int key = Integer.valueOf(digits.substring(curr , curr + 1));

        List<String> currDigitChars = map.get(key);

        for(String s : currDigitChars) {
            recurse(digits , ans, curr+ 1 , res + s , map);
        }

    }


    public static List<String> emiratesCombinations(String digits) {
        Map<Integer  , List<String>> map = new HashMap<>();
        List<String> list = new ArrayList<String>(){ {  add("a"); add("b"); add("c"); } };
        map.put(2 , list);
        map.put(3 , new ArrayList<String>(){ {  add("d"); add("e"); add("f"); } });
        map.put(4 , new ArrayList<String>(){ {  add("g"); add("h"); add("i"); } });
        map.put(5 , new ArrayList<String>(){ {  add("j"); add("k"); add("l"); } });
        map.put(6 , new ArrayList<String>(){ {  add("m"); add("n"); add("o"); } });
        map.put(7 , new ArrayList<String>(){ {  add("p"); add("q"); add("r");add("s"); } });
        map.put(8 , new ArrayList<String>(){ {  add("t"); add("u"); add("v"); } });
        map.put(9 , new ArrayList<String>(){ {  add("w"); add("x"); add("y");add("z"); } });
        List<String> ans = new ArrayList<>();
        emiratesRecurse(digits,ans,0,"",map);
        for (String an : ans) {
            System.out.println(an + " ");
        }
        return ans;
    }


    public static void emiratesRecurse(String digits , List<String> ans , int curr , String res , Map<Integer  , List<String>> map) {
        if(curr == digits.length()) {
            ans.add(res);
            return;
        }
        String currChar = digits.substring(curr , curr + 1);
        int key = Integer.valueOf(currChar);
        if(map.containsKey(key)) {
            List<String> currDigitChars = map.get(key);
            for(String s : currDigitChars) {
                emiratesRecurse(digits , ans, curr+ 1 , res + s , map);
            }
        } else {
            emiratesRecurse(digits , ans, curr+ 1 , res + currChar , map);
        }

    }
}
