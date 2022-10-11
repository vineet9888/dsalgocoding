package com.ds.algo.problem.solving.LinkedList;

public class LinkedListMiddle {

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);
        node.next.next.next.next.next = new ListNode(6);
        node.next.next.next.next.next.next = new ListNode(7);
        printList(node);
        System.out.println();
        rearrangeList(node);
        /*node = reverseList(node);
        System.out.println();
        printList(node);*/
    }

    public static void rearrangeList(ListNode node) {
        ListNode middle = findMiddle(node);
        ListNode temp = reverseList(middle.next);
        middle.next = temp;
        printList(node);

    }

    public static ListNode findMiddle(ListNode node) {
        ListNode fast = node;
        ListNode slow = node;
        while(fast != null) {
            fast = fast.next != null ? fast.next.next : null;
            if(fast != null) {
                slow = slow.next;
            }
        }

        System.out.println("Middle Node is : " + slow.val);
        return slow;
    }

    public static ListNode reverseList(ListNode node) {
        ListNode prev = null;
        ListNode curr = node;
        while(curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;

    }

    public static void printList(ListNode node) {
        while(node != null) {
            System.out.print(node.val + " -> ");
            node = node.next;
        }
    }


}