package com.leetcode;

import com.leetcode.common.TreeNode;

/**
 * TODO
 *
 * @author wei.he
 * @date 2023/9/6 16:54
 */
public class D20230906N1448GoodNodes {

    public int goodNodes(TreeNode root) {
        return dfs(root, Integer.MIN_VALUE);
    }

    private int dfs(TreeNode root, int mx) {
        if (root == null) {
            return 0;
        }
        int left = dfs(root.left, Math.max(mx, root.val));
        int right = dfs(root.right, Math.max(mx, root.val));
        return left + right + (mx <= root.val ? 1 : 0);
    }

}
