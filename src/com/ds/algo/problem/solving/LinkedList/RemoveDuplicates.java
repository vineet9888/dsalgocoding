package com.ds.algo.problem.solving.LinkedList;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicates {

    public static void removeDuplicates(){

    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(3);
        // head.next.next.next.next.next = new ListNode(3);
        ListNode curr = head;
        ListNode prev= curr;

        while(curr != null) {
            prev = curr;
            while(curr.next != null && curr.val == curr.next.val) {
                curr=curr.next;
            }
            prev.next = curr.next;
            curr = curr.next;
        }
        curr = head;
        while(curr != null) {
            System.out.println(curr.val);
            curr= curr.next;
        }

    }
}
