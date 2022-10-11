package com.ds.algo.problem.solving.graphs;

import java.util.*;

public class WordLadder {


    public static int wordLadder(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>();
        for(String word : wordList) {
            set.add(word);
        }

        if(set.contains(beginWord)) {
            set.remove(beginWord);
        }

        Queue<Item> queue = new LinkedList<>();
        queue.add(new Item(beginWord , 1));
        while(!queue.isEmpty()) {
            int size = queue.size();
            Item item = queue.poll();
            char []itemArray = item.value.toCharArray();
            for(int i = 0 ; i < item.value.length();i++) {
                for(char c = 'a';c <= 'z';c++) {
                    if(item.value.charAt(i) != c) {
                        itemArray[i] = c;
                        String curr = String.valueOf(itemArray);
                        if(set.contains(curr)) {
                            if(endWord.equals(curr)) {
                                return item.level + 1;
                            }
                            set.remove(curr);
                            queue.add(new Item(curr ,item.level + 1));
                        }
                    }
                }
                itemArray[i] = item.value.charAt(i);
            }


        }
        return 0;
    }

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>();
        for(String word : wordList) {
            set.add(word);
        }

        if(set.contains(beginWord)) {
            set.remove(beginWord);
        }

        Queue<Item> queue = new LinkedList<>();
        queue.add(new Item(beginWord , 1));
        while(!queue.isEmpty()) {
            int size = queue.size();
            while(size > 0) {
                Item item = queue.poll();
                char []itemArray = item.value.toCharArray();
                for(int i = 0 ; i < item.value.length();i++) {
                    for(char c = 'a';c <= 'z';c++) {
                        if(item.value.charAt(i) != c) {
                            itemArray[i] = c;
                            String curr = String.valueOf(itemArray);
                            if(set.contains(curr)) {
                                if(endWord.equals(curr)) {
                                    return item.level + 1;
                                }
                                set.remove(curr);
                                queue.add(new Item(curr ,item.level + 1));
                            }
                        }
                    }
                    itemArray[i] = item.value.charAt(i);
                }
                size--;
            }
        }
        return 0;
    }


    public static void main(String[] args) {
//        "toon"
//        "plea"

        //String arr[] = new String[]{"hot","dot","dog","lot","log"};
        String arr[] = new String[]{"a","b","c"};
        //String arr[] = new String[]{"POON", "PLEE", "SAME", "POIE", "PLEA", "PLIE", "POIN"};
        List<String> list = Arrays.asList(arr);
        System.out.println(ladderLength("a","c",list));
        System.out.println(wordLadder("a","c",list));
    }
}

class Item {
    String value;
    int level;
    Item(String value , int level) {
        this.level = level;
        this.value = value;
    }
}
