package com.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * TODO
 *
 * @author hewei
 * @date 2019/4/21 13:45
 */
public class LeetCode_142 {
    public ListNode detectCycle(ListNode head) {
        List<ListNode> listNodes = new ArrayList<>();
        while(head != null && head.next != null) {
            listNodes.add(head);
            if (listNodes.contains(head.next)) {
                return head.next;
            } else {
                head = head.next;
            }
        }
        return null;
    }
//        public ListNode detectCycle(ListNode head) {
//            Set<ListNode> check = new HashSet<ListNode>();
//            while(head != null){
//                if(check.contains(head)){
//                    return head;
//                } else {
//                    check.add(head);
//                    head = head.next;
//                }
//            }
//            return null;
//        }


    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
