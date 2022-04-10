package com.leetcode.general;

import com.leetcode.model.ListNode;

public class LC25 {

    /*
    A hard version of keep on swap. Two parts required
    1. swap in groups
    2. if the last part is not fully swapped, have to keep the original order

    1 is pretty straightforward
    2 has several different ways, one way is to count then decide,
    the other is what I did (to keep the code shorter, I think), swap for whaever, if not fully, then swap again.
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1 || head == null || head.next == null) {
            /* first typo is here, where I returned null */
            return head;
        }
        ListNode fakeHead = new ListNode(0);
        fakeHead.next = head;
        ListNode prev = fakeHead;

        while (head != null) {
            int count = k - 1;
            while (head != null && head.next != null && count-- > 0) {
                /* second error is here, where I put count-- in the first place,
                basically the count here is to count how many actual swaps have been done.
                if head == null || head.next == null, there is no actual swap, so should put count-- to the last
                 */
                ListNode temp = prev.next;
                prev.next = head.next;
                head.next = prev.next.next;
                prev.next.next = temp;
            }

            if (count > 0) {
                head = prev.next;
                while (head != null && head.next != null) {
                    ListNode temp = prev.next;
                    prev.next = head.next;
                    head.next = prev.next.next;
                    prev.next.next = temp;
                }
                break;
            }

            prev = head;
            head = head.next;
        }
        return fakeHead.next;

    }
}
