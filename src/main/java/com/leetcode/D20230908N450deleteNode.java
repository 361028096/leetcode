package com.leetcode;

import com.leetcode.common.TreeNode;

/**
 * TODO
 *
 * @author wei.he
 * @date 2023/9/8 9:49
 */
public class D20230908N450deleteNode {

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                TreeNode node = root.right;
                while(node.left != null) {
                    node = node.left;
                }
                node.left = root.left;
                return root.right;
            }
        }
        return root;
    }


}
