package com.leetcode;

import com.leetcode.common.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
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

    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        // 调用递推公式反转当前结点之后的所有节点
        // 返回的结果是反转后的链表的头结点
        ListNode newHead = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

}
