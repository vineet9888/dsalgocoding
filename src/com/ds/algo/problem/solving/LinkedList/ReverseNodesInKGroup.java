package com.ds.algo.problem.solving.LinkedList;

import java.util.ArrayList;
import java.util.List;

public class ReverseNodesInKGroup {


    public static boolean isValidGroup(ListNode head , int count , int right) {
        boolean isValidGroup = true;
        while(count <= right) {
            if(head == null) {
                isValidGroup = false;
                break;
            }
            head = head.next;
            count++;
        }
        return isValidGroup;
    }

    public static List<ListNode> reverseLinkedList(ListNode head , ListNode previousGroupLastNode ,  int count , int right) {
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
        // till now i have the reversed linked list....
        newHead = prev;
        if(previousGroupLastNode != null) {
            previousGroupLastNode.next = newHead;
        }
        tuple.add(newHead);
        tuple.add(head);
        tuple.add(curr);


        return tuple;
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode curr = head;
        int count = 1;
        ListNode previousGroupLastNode= null;
        while(curr != null) {
            if(isValidGroup(curr , count , count + k - 1)) {
                List<ListNode> tuple = reverseLinkedList(curr,previousGroupLastNode , count,count + k - 1);
                // in the case of count == 1 save reference to head
                if(count == 1) {
                    head = tuple.get(0);
                }
                curr = tuple.get(2);
                previousGroupLastNode = tuple.get(1);
                count = count + k;
            } else {
                previousGroupLastNode.next = curr;
                break;

            }
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next= new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next.next = new ListNode(8);
        head.next.next.next.next.next.next.next.next = new ListNode(9);

        head = reverseKGroup(head , 4);
        while(head !=null) {
            System.out.print(head.val + " ");;
            head = head.next;
        }

    }
}

