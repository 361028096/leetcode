package com.leetcode;

import com.leetcode.common.ListNode;

/**
 * // [19]删除链表的倒数第N个节点
 * //给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * //
 * // 示例：
 * //
 * // 给定一个链表: 1->2->3->4->5, 和 n = 2.
 * //
 * //当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * //
 * //
 * // 说明：
 * //
 * // 给定的 n 保证是有效的。
 * //
 * // 进阶：
 * //
 * // 你能尝试使用一趟扫描实现吗？
 * // Related Topics 链表 双指针
 *
 * 解答成功: 执行耗时:0 ms,击败了100.00% 的Java用户 内存消耗:38 MB,击败了5.05% 的Java用户
 *
 * //leetcode submit region begin(Prohibit modification and deletion)
 *
 * @date 2020/3/24 17:50
 */
public class D20200324N19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode fast = pre, slow = pre;
        while (n != 0) {
            fast = fast.next;
            n--;
        }
        while(fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return pre.next;
    }

}
