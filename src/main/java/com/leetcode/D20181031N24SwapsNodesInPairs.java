package com.leetcode;

import com.leetcode.common.ListNode;

/**
 * Given a linked list, swap every two adjacent nodes and return its head.
 *
 * @author hewei
 * @date 2018/10/31
 */
public class D20181031N24SwapsNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode root = new ListNode(0);
        root.next = head;
        ListNode p = root;
        while (p.next != null && p.next.next != null) {
            ListNode node1 = p;
            p = p.next;

            root = head;

        }




        return null;
    }
}
