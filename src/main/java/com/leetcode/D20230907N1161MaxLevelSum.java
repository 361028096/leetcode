package com.leetcode;

import com.leetcode.common.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * TODO
 *
 * @author wei.he
 * @date 2023/9/7 16:57
 */
public class D20230907N1161MaxLevelSum {
    public int maxLevelSum(TreeNode root) {
        Deque<TreeNode> d = new ArrayDeque<>();
        int max = -0x3f3f3f3f, depth = 1,ans = 0;
        d.addLast(root);
        while(!d.isEmpty()) {
            int sz = d.size(), cur = 0;
            while(sz -- > 0) {
                TreeNode t = d.pollFirst();
                if (t.left != null) d.addLast(t.left);
                if (t.right != null) d.addLast(t.right);
                cur += t.val;
            }
            if (cur > max) {
                max = cur;
                ans = depth;
            }
            depth++;
        }
        return ans;
    }
}
