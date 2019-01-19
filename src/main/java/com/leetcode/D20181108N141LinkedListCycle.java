package com.leetcode;

import com.leetcode.common.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * TODO description
 *
 * @author hewei
 * @date 2018/11/8
 */
public class D20181108N141LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        Set address = new HashSet();
        while (head!=null && head.next!=null) {
            if (address.contains(head)) {
                return true;
            }
            address.add(head);
            head = head.next;
        }
        return false;
    }
}
