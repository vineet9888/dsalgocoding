package com.ds.algo.problem.solving.LinkedList;

import java.util.ArrayList;
import java.util.List;

public class ReversePairsList {

    private static void test(ListNode node ) {
        ListNode ref = node;
        while(ref != null) {
            System.out.print(ref.val + " ");
            ref = ref.next;
        }
        System.out.println();
        ListNode prev = null;
        ListNode curr = null;
        ListNode next = node;
        List<ListNode> list = new ArrayList<>();
        ListNode reff = null;
        while(next != null) {
            int count = 0;
            reff = next;

            while(next != null && count <=2) {
                count++;
                curr = next;
                next = curr.next;
                curr.next = prev;
                prev = curr;
            }
            System.out.println("end " + prev.val);
            list.add(prev);
        }

        prev = null;
        node = list.get(0);
        for(int i = 0 ; i < list.size();i++) {
            ListNode ls = list.get(i);
            int count = 0;
            ListNode a = ls;
            if(prev != null) {
                prev.next = ls;
            }
            while(count < 3) {
                System.out.print(a.val + " ");
                prev = a;
                if(i == list.size()-1 && count == 2) {
                    a.next = null;
                }
                a = a.next;
                count++;
            }
        }

        System.out.println();
        while(node != null) {
            System.out.print(node.val + " -> ");
            node = node.next;
        }
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);
        node.next.next.next.next.next = new ListNode(6);
        node.next.next.next.next.next.next = new ListNode(7);
        node.next.next.next.next.next.next.next = new ListNode(8);
        //node.next.next.next.next.next.next.next.next = new ListNode(9);
        // 1 2 3 4 5 6 7 8 9
        ListNode ans = reverseKGroup(node , 2);
        System.out.println(ans);
        while(ans != null) {
            System.out.print(ans.val + " ");
            ans = ans.next;
        }

    }

    private static ListNode reverseKGroup(ListNode head , int k) {
        ListNode next = head;
        ListNode prev = null;
        ListNode curr = head;
        ListNode ref = head;
        // if the next nodes can form a group of k nodes then reverse them else return the head.
        if(countNodes(ref , k)) {
            // check if this is a valid pair then only reverse
            int i =0;
            while(next != null && i < k) {
                curr = next;
                next = curr.next;
                curr.next = prev;
                prev = curr;
                i++;
            }
            if(next != null) {
                head.next = reverseKGroup(next , k);
            }
            return  prev;
        } else {
            return head;
        }
    }

    private static boolean countNodes(ListNode head , int k) {
        int count = 0;
        // 1 2 3 4
        while(head != null) {
            head = head.next;
            count++;
            if(count == k) {
                return true;
            }
        }
        return false;
    }

    private static List<Pair> generatePairs(ListNode node , int k) {
        int count = 1;
        List<Pair> pairs = new ArrayList<>();
        while(node != null) {
            if(count %k==1) {
                Pair pair = new Pair();
                pair.first = node;
                pairs.add(pair);
                System.out.print(node.val + " ");
            }
            if(count % k == 0) {
                pairs.get(pairs.size()-1).second = node;
                System.out.print(node.val + " ");
            }
            node = node.next;
            count++;
        }
        return pairs;
    }

    private static List<Pair> traverseInPairs(ListNode node, int k) {
        List<Pair> pairs = new ArrayList<>();
        ListNode prev = null;
        ListNode next = node;
        ListNode curr = node;
        int count = 1;
        while(next != null) {
            if(count %k==1) {
                Pair pair = new Pair();
                pair.first = next;
                pairs.add(pair);
                System.out.print(next.val + " ");
            }
            curr = next;
            if(count % k == 0) {
                pairs.get(pairs.size()-1).second = curr;
                System.out.print(curr.val + " ");
            }
            next = curr.next;
            curr.next = prev;
            prev = curr;
            count++;
        }
        System.out.println();
        while(prev != null) {
            System.out.print(prev.val + " ");
            prev = prev.next;
        }
        return pairs;
    }
}

class Pair {
    ListNode first;
    ListNode second;
}