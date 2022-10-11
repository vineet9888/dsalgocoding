package com.ds.algo.problem.solving.AmazonPrepration;

import com.ds.algo.problem.solving.trees.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Trie {

    public static void main(String[] args) {
        String words[] = new String[]{"mobile","mouse","moneypot","monitor","mousepad"};
        TrieNode root = constructTrie(words);
        // System.out.println(searchInTrie(root , "monitors",0));
        List<String> ans = new ArrayList<>();
        getAllTrieWords(root , ans, "");
        System.out.println(ans);
    }

    public static void getAllTrieWords(TrieNode root , List<String> ans , String curr) {
        if(root != null) {
            if(root.children[26] != null && root.children[26].ch == '$') {
                ans.add(curr);
            }
            for(int i = 0;i < root.children.length;i++) {
                if(root.children[i] != null) {
                    getAllTrieWords(root.children[i] , ans , curr + root.children[i].ch);
                }
            }
        }
    }

    public static boolean searchInTrie(TrieNode root , String prefix , int curr) {
        if(curr == prefix.length()) {
            return true;
        }
        Character ch = prefix.charAt(curr);
        int index = ch - 'a';
        if(root.children[index] != null) {
            return searchInTrie(root.children[index] , prefix , curr + 1);
        }
        return false;
    }

    public static TrieNode constructTrie(String words[]) {
        TrieNode root = new TrieNode('#');
        for(String word : words) {
            addWordToTrie(root , word , 0);
        }
        return root;
    }

    // mobile
    public static void addWordToTrie(TrieNode root , String word , int curr) {
        if(curr > word.length() - 1) {
            root.children[26] = new TrieNode('$');
            return;
        }
        Character ch = word.charAt(curr);
        int index = ch - 'a';
        if(root.children[index] == null){
            root.children[index] = new TrieNode(ch);
            addWordToTrie(root.children[index] , word , curr + 1);
        } else {
            addWordToTrie(root.children[index] , word , curr + 1);
        }
    }


}

class TrieNode {
    Character ch;
    TrieNode[] children = new TrieNode[27];
    TrieNode(Character ch) {
        this.ch = ch;
    }
}
