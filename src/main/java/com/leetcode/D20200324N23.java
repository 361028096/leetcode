package com.leetcode;

import com.leetcode.common.ListNode;

/**
 * // [23]合并K个排序链表
 * //合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 * //
 * // 示例:
 * //
 * // 输入:
 * //[
 * //  1->4->5,
 * //  1->3->4,
 * //  2->6
 * //]
 * //输出: 1->1->2->3->4->4->5->6
 * // Related Topics 堆 链表 分治算法
 *
 *
 * //leetcode submit region begin(Prohibit modification and deletion)
 *
 *
 *
 * @date 2020/3/25 0:17
 */
public class D20200324N23 {
    public ListNode mergeKLists(ListNode[] lists) {
        int len = lists.length;
        if (len == 0) {
            return null;
        }
        while (len > 1){
            int i;
            for (i = 0; i < len/2; i++) {
                lists[i] = mergeTwoLists(lists[2 * i], lists[2 * i + 1]);
            }
            if ((len % 2) != 0) {
                lists[i] = lists[len - 1];
                len++;
            }
            len /= 2;
        }
        return lists[0];
    }


    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode prehead = new ListNode(-1);

        ListNode prev = prehead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }
        prev.next = l1 == null ? l2 : l1;

        return prehead.next;
    }
}
