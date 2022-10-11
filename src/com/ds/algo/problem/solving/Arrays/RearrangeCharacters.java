package com.ds.algo.problem.solving.Arrays;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class RearrangeCharacters {

    public static void main(String[] args) {
        String s="aaab";
        rearrangeCharacters(s);

    }


    public static void rearrangeCharacters(String s) {
        Map<Character , Integer> map = new HashMap<>();
        for(int i = 0 ; i < s.length();i++) {
            Character ch = s.charAt(i);
            if(map.containsKey(ch)) {
                map.put(ch , map.get(ch)+1);
            } else {
                map.put(ch , 1);
            }
        }

        PriorityQueue<Item> queue = new PriorityQueue<>((Item a , Item b) -> {
            return b.count - a.count;
        });
        map.forEach((key , value) -> {
            queue.add(new Item(key , value));
        });

        for (Item item : queue) {
            System.out.println(item.ch + " -> " + item.count);
        }

        String ans = "";
        Item prev = new Item('!',0);
        while(!queue.isEmpty()) {
            Item item = queue.peek();
            ans += item.ch;
            item.count--;
            queue.poll();
            if(prev.count > 0) {

                queue.add(prev);
            }
            prev = item;
            // remove current entry from queue;
        }
        // System.out.println(ans);

    }

}



class Item {
    Character ch;
    int count;
    Item(Character ch , int count) {
        this.ch = ch;
        this.count = count;
    }
}