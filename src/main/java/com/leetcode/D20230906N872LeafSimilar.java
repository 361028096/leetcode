package com.leetcode;

import com.leetcode.common.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * TODO
 *
 * @author wei.he
 * @date 2023/9/6 14:00
 */
public class D20230906N872LeafSimilar {

    public boolean leafSimilar(TreeNode t1, TreeNode t2) {
        List<Integer> l1 = new LinkedList<>(), l2 = new LinkedList<>();
        dfs(t1, l1);
        dfs(t2, l2);
        if (l1.size() == l2.size()) {
            for (int i = 0; i < l1.size(); i++) {
                if (!l1.get(i).equals(l2.get(i))) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    private void dfs(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            list.add(root.val);
            return;
        }
        dfs(root.left, list);
        dfs(root.right, list);
    }


}
