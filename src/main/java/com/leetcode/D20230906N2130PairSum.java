package com.leetcode;

import com.leetcode.common.ListNode;

import java.util.LinkedList;
import java.util.List;

/**
 * TODO
 *
 * @author wei.he
 * @date 2023/9/6 13:40
 */
public class D20230906N2130PairSum {

    public int pairSum1(ListNode head) {
        List<Integer> list = new LinkedList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        int ans = 0;
        for (int i = 0; i< list.size() / 2; i++) {
            ans = Math.max(ans, list.get(i) + list.get(list.size() - i - 1));
        }
        return ans;
    }

    public int pairSum(ListNode head) {
        ListNode fast = head, slow = head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode pre = null;
        ListNode p = slow;
        while (p != null) {
            ListNode tmp = p.next;
            p.next = pre;
            pre = p;
            p = tmp;
        }

        int ans = 0;
        ListNode q;
        for (p = head, q = pre; q != null; p = p.next, q = q.next) {
            ans = Math.max(ans, p.val + q.val);
        }
        return ans;
    }


}
