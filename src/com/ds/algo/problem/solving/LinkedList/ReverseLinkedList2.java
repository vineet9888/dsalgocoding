package com.ds.algo.problem.solving.LinkedList;

import java.util.ArrayList;
import java.util.List;

public class ReverseLinkedList2 {


    public static List<ListNode> reverseLinkedList(ListNode head , int count , int right) {

        List<ListNode> tuple = new ArrayList<>();
        ListNode newHead = null;
        ListNode curr = head;
        ListNode prev = null;
        ListNode next = null;
        while(count <= right) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count++;
        }
        newHead = prev;
        tuple.add(newHead);
        tuple.add(head);
        tuple.add(curr);
        return tuple;
    }

    public static ListNode reverseBetween(ListNode head, int left, int right) {
        if(left == right) {
            return head;
        }
        int count = 1;
        ListNode curr = head;
        ListNode nodeBeforeLeft = null;
        while(count <= right) {
            if(count == left) {
                List<ListNode> tuple = reverseLinkedList(curr , count , right);
                count = right + 1;
                tuple.get(1).next = tuple.get(2);
                if(nodeBeforeLeft != null) {
                    nodeBeforeLeft.next = tuple.get(0);
                } else {
                    head = tuple.get(0);
                }
            }
            nodeBeforeLeft = curr;
            curr = curr.next;
            count++;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        head.next = new ListNode(5);
//        head.next.next = new ListNode(3);
//        head.next.next.next= new ListNode(4);
//        head.next.next.next.next = new ListNode(5);


        ListNode curr = reverseBetween(head , 1 ,2);
        System.out.println("Reversed Order");
        while(curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.next;
        }


    }
}
