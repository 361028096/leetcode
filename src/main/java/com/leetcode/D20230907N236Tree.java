package com.leetcode;

import com.leetcode.common.TreeNode;

/**
 * lowestCommonAncestor
 *
 * @author wei.he
 * @date 2023/9/7 16:41
 */
public class D20230907N236Tree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        return root;
    }
}
