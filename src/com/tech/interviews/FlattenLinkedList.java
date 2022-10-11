package com.tech.interviews;

public class FlattenLinkedList {

   /* You are given a doubly linked list, which contains nodes that have a next pointer, a previous pointer, and an additional child pointer.
    This child pointer may or may not point to a separate doubly linked list, also containing these special nodes.
    These child lists may have one or more children of their own, and so on, to produce a multilevel data structure as shown in the example below.

    Given the head of the first level of the list, flatten the list so that all the nodes appear in a single-level, doubly linked list.
    Let curr be a node with a child list.
    The nodes in the child list should appear after curr and before curr.next in the flattened list.








1 2 3 4 6
      7 8

1 2 3 4 7 8 6
    Return the head of the flattened list. The nodes in the list must have all of their child pointers set to null.*/

    public static void main(String[] args) {

    }

    private Node flattenLinkedList(Node head) {
        if(head == null) {
            return head;
        }
        Node ref = head;
        while(ref != null) {
            if(ref.child == null) {
                ref = ref.next;

            }
            Node child = ref.child;
            while(child.next != null)
                child = child.next;
            child.next = ref.next;
            ref.child.prev = ref;
            ref.child = null;

        }
        return head;
    }
}


class Node {
    int val;
    Node next;
    Node prev;
    Node child;
    Node(int val , Node next , Node prev , Node child) {
        this.val =val;
        this.next = next;
        this.prev = prev;
        this.child = child;
    }
    Node(int val) {
        this.val = val;
    }
}