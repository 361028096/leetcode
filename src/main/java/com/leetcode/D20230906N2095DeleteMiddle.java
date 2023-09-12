package com.leetcode;

import com.leetcode.common.ListNode;

/**
 * TODO
 *
 * @author wei.he
 * @date 2023/9/6 13:15
 */
public class D20230906N2095DeleteMiddle {

    public ListNode deleteMiddle(ListNode head) {
        if (head.next == null) {
            return null;
        }

        ListNode slow = new ListNode();
        ListNode fast = head;
        slow.next = head;
        while(fast.next != null) {
            if (fast.next.next != null) {
                fast = fast.next.next;
            } else {
                fast = fast.next;
            }
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }


}
