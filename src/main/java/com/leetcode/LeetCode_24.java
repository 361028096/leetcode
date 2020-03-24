package com.leetcode;

import java.util.List;

/**
 * TODO
 *
 *
 * @date 2019/4/21 12:03
 */
public class LeetCode_24 {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dump = new ListNode(0);
        dump.next = head;
        ListNode current = dump;
        while(current.next != null && current.next.next != null) {
            ListNode first = current.next;
            ListNode second = current.next.next;
            first.next = second.next;
            current.next = second;
            current.next.next = first;
            current = current.next.next;
        }
        return dump.next;
    }

    private class ListNode {
        int val;
        ListNode next;
        public ListNode(int val) {
            this.val = val;
        }
    }
}
