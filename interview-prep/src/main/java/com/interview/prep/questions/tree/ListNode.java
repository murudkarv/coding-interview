package com.interview.prep.questions.tree;

/**
 * Definition for singly-linked list.
 */

public class ListNode {
    int val;
    ListNode next;

    public int getVal() {
        return val;
    }

    public ListNode getNext() {
        return next;
    }

    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    public static ListNode buildList(Integer[] arr) {
        if (arr == null || arr.length == 0) return null;

        ListNode dummy = new ListNode(0);  // dummy head
        ListNode current = dummy;

        for (int val : arr) {
            current.next = new ListNode(val);
            current = current.next;
        }

        return dummy.next; // head of the list
    }
}
