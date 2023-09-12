package com.leetcode;

import com.leetcode.common.ListNode;

/**
 * TODO
 *
 * @author wei.he
 * @date 2023/9/6 13:23
 */
public class D20230906N328OddEvenList {

    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode evenHead = head.next;
        ListNode odd = head, even = evenHead;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }


}
