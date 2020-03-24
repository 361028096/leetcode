package com.leetcode;

import com.leetcode.common.ListNode;

/**
 * Reverse a singly linked list.
 *
 *
 * @date 2018/10/30
 */
public class D20181030N206ReverseLinkedList {
    public ListNode reverseList(ListNode head) {

        ListNode curr = head;
        ListNode prev = null;
        while (curr != null) {
            ListNode nextTmp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTmp;
        }
        return prev;
    }
}
