package com.leetcode.model;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public ListNode buildListNode(int[] nums) {
        ListNode fakeHead = new ListNode(0);
        ListNode head = fakeHead;
        for (int num : nums) {
            head.next = new ListNode(num);
            head = head.next;
        }
        return fakeHead;
    }
}
