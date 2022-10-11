package com.ds.algo.problem.solving.backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LongestDirectoryPath {

    public static int lengthLongestPath(String input) {
        String[] tokens = input.split("\n");
        int result = 0;
        int curLen = 0;
        Stack<Integer> stack = new Stack<>();

        for (String s : tokens) {
            int level = countLevel(s);

            // if current directory/file depth is lower that the top directory/file on the stack, pop from stack
            while (stack.size() > level) {
                curLen -= stack.pop();
            }

            // +1 here because a "/" needs to be counted following each diretory
            int len = s.replaceAll("\t", "").length() + 1;
            curLen += len;

            // if s contains ".", we have found a file!
            if (s.contains(".")) {
                result = curLen - 1 > result ? curLen - 1 : result;
            }
            stack.add(len);
        }
        return result;
    }

    private static int countLevel(String s) {
        String cur = s.replaceAll("\t", "");
        return s.length() - cur.length();
    }


    public static void main(String[] args) {

        String input = "dir\\n\\tsubdir1\\n\\tsubdir2\\n\\t\\tfile.ext";
        String input1 = "dir\\n\\tsubdir1\\n\\t\\tfile1.ext\\n\\t\\tsubsubdir1\\n\\tsubdir2\\n\\t\\tsubsubdir2\\n\\t\\t\\tfile2.ext";
        lengthLongestPath(input);
        System.out.println(input1);
        Node node = new Node( "root");
        parseInputData(0 , input ,node , 0);
        System.out.println(node);
    }

    public static void parseInputData(int start , String input  , Node parent , int currNodeLevel) {
        if(start >= input.length()) {
            return;
        }
        int i = start;
        while(i < input.length() && input.charAt(i) != '\\') {
            i++;
        }
        String nodeName = input.substring(start , i);
        System.out.println(nodeName + " - " + i);

        int nextNodeLevel = 0;
        if(i + 1 < input.length() && input.charAt(i+1) == 'n') {
            i = i + 2;
            while(i < input.length() && i +1 < input.length() &&  input.charAt(i) == '\\' && input.charAt(i+1) == 't') {
                i = i + 2;
                nextNodeLevel++;
            }
            /*

                dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext

                dir
                    subdir1
                    subdir2
                        file.ext

                    dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext
                 dir
                    subdir1
                        file1.ext
                        subsubdir1
                    subdir2
                        subsubdir2
                            file2.ext


            */
            Node node = new Node(nodeName);
            parent.children.add(node);
            if(nextNodeLevel == 0){
                return;
            }
            if(nextNodeLevel > currNodeLevel) {
                parseInputData(i,input,node,nextNodeLevel);
            } else {
                parseInputData(i,input,parent,nextNodeLevel);
            }

        } else {
            parent.children.add(new Node(nodeName));
            return;
        }

    }


}


class Node {
    List<Node> children = new ArrayList<>();
    String nodeData;
    Node( String nodeData) {
        this.nodeData = nodeData;
    }
}
