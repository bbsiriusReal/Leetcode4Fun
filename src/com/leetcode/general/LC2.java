package com.leetcode.general;

import com.leetcode.model.ListNode;

public class LC2 {

    /**
     * basically do a add in order, until either l1 or l2 is reaching the end
     * remember to add a carry over number
     **/
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;

        ListNode fakeHead = new ListNode(0);
        ListNode node = fakeHead;
        int carry = 0;
        while (l1 != null && l2 != null) {
            carry += l1.val + l2.val;
            node.next = new ListNode(carry % 10);
            carry /= 10;
            l1 = l1.next;
            l2 = l2.next;
            node = node.next;
        }

        while (l1 != null) {
            carry += l1.val;
            node.next = new ListNode(carry % 10);
            carry /= 10;
            l1 = l1.next;
            node = node.next;
        }

        while (l2 != null) {
            carry += l2.val;
            node.next = new ListNode(carry % 10);
            carry /= 10;
            l2 = l2.next;
            node = node.next;
        }

        if (carry != 0)
            node.next = new ListNode(carry);

        return fakeHead.next;
    }
}
