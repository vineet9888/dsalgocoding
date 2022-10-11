package com.ds.algo.problem.solving.LinkedList;

public class TwinSumLinkedList {

    public static void main(String[] args) {
        ListNode node = createList();
        System.out.print(pairSum(node));
    }

    public static int pairSum(ListNode head) {
        Ans ans = new Ans();
        Ref ref = new Ref(head);
        traverse(head , head , ans , ref);
        return ans.max;
    }

    public static void traverse(ListNode curr , ListNode head , Ans ans , Ref ref) {
        if(curr == null) {
            return;
        }
        ans.end++;
        traverse(curr.next , head , ans , ref);
        ans.start++;
        ans.end--;
        if((ans.end - ans.start) != 1) {
            ans.max = Math.max(ans.max , curr.val + ref.curr.val);
            System.out.println(ans.max);
            ref.curr = ref.curr.next;
        }
    }

    public static ListNode createList() {
        ListNode node = new ListNode(4);
        node.next = new ListNode(2);
        node.next.next = new ListNode(2);
        node.next.next.next = new ListNode(3);
        return node;
    }
}

class Ans {
    public int max = -1;
    public int end = 0;
    public int start = 0;


}

class Ref {
    public ListNode curr;
    Ref(ListNode curr) {
        this.curr = curr;
    }
}