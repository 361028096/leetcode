package com.leetcode;

import com.leetcode.common.TreeNode;

/**
 * D20230907N700SearchTree
 *
 * @author wei.he
 * @date 2023/9/7 17:09
 */
public class D20230907N700SearchTree {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null || root.val == val) {
            return root;
        }
        return root.val < val ? searchBST(root.right, val) : searchBST(root.left, val);
    }


}
