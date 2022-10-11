package com.ds.algo.problem.solving.LinkedList;

public class OddEvenLinkedList {

    public static ListNode oddEvenList(ListNode head) {
        ListNode odd = null;
        ListNode even = null;
        ListNode evenStart = null;
        ListNode oddStart = null;
        int count = 1;
        while(head != null) {
            // even
            if(count % 2 == 0)  {
                if(even == null) {
                    even = head;
                    evenStart = head;
                } else {
                    even.next = head;
                    even = head;
                }
            } else {
                if(odd == null)  {
                    odd = head;
                    oddStart = head;
                } else {
                    odd.next = head;
                    odd = head;
                }
            }
            count++;
            head = head.next;
        }
        odd.next = evenStart;
        if(even != null) {
            even.next= null;
        }

        return oddStart;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        /*head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);*/
        ListNode newHead = oddEvenList(head);
        while(newHead != null) {
            System.out.println(newHead.val);
            newHead = newHead.next;
        }
    }
}
