package com.ds.algo.problem.solving.stack;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class SimplifyPath {

    public static String simplifyPath(String path) {
        Deque<String> deque = new LinkedList<>();
        int i = 0;
        int size = path.length();
        while(i < size) {
            if(path.charAt(i) == '/') {
                boolean keepRunning = true;
                while(keepRunning && i < size) {
                    i++;
                    if(i < size && path.charAt(i) !='/') {
                        keepRunning = false;
                    }
                }
            }

            if(i < size &&  path.charAt(i) == '.') {
                boolean keepRunning = true;
                int continuousPeriods = 1;
                while(keepRunning && i < size) {
                    i++;
                    if(i < size && path.charAt(i) == '.') {
                        continuousPeriods++;
                    } else {
                        keepRunning = false;
                        break;
                    }
                    if(continuousPeriods > 2) {
                        break;
                    }
                }
                if(continuousPeriods == 2) {
                    if(i == size) {
                        if(!deque.isEmpty()) {
                            deque.removeLast();
                        }
                    } else if(i < size && path.charAt(i) == '/') {
                        if(!deque.isEmpty()) {
                            deque.removeLast();
                        }
                    } else {
                        i = i-2;
                    }
                } else if(continuousPeriods > 2) {
                    i = i-2;
                } else if(continuousPeriods == 1 && i < size && path.charAt(i) != '/') {
                    i = i-1;
                }
            }

            if(i < size && /*path.charAt(i) != '.' && */ path.charAt(i) !='/') {
                boolean keepRunning = true;
                int continuousChars = 0;
                while(keepRunning && i < size) {
                    if(path.charAt(i) == '/') {
                        keepRunning = false;
                        break;
                    } else {
                        continuousChars++;
                    }
                    i++;
                }
                String str = path.substring(i-continuousChars ,i-continuousChars +  continuousChars);
                deque.add(str);
            }
        }

        StringBuilder ans = new StringBuilder();
        ans.append("/");
        size = deque.size();
        i = 0;
        while(!deque.isEmpty()) {
            i++;
            ans.append(deque.removeFirst());
            if(i != size) {
                ans.append("/");
            }
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        System.out.println(simplifyPath("/.hidden./."));
        //System.out.println("ans is " + simplifyPath("/home//foo"));
    }
}
