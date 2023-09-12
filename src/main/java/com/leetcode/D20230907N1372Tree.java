package com.leetcode;

import com.leetcode.common.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * TODO
 *
 * @author wei.he
 * @date 2023/9/7 16:07
 */
public class D20230907N1372Tree {
    Map<TreeNode, Integer> f = new HashMap<>();
    Map<TreeNode, Integer> g = new HashMap<>();
    Queue<TreeNode[]> q = new LinkedList<TreeNode[]>();

    public int longestZigZag(TreeNode root) {
        db(root);
        int maxAns = 0;
        for(TreeNode u:f.keySet()) {
            maxAns = Math.max(maxAns, Math.max(f.get(u),g.get(u)));
        }
        return maxAns;
    }

    public void db(TreeNode o) {
        f.put(o, 0);
        g.put(o, 0);
        q.offer(new TreeNode[]{o, null});
        while(!q.isEmpty()) {
            TreeNode[] y = q.poll();
            TreeNode u = y[0], x = y[1];
            f.put(u, 0);
            g.put(u, 0);
            if (x != null) {
                if (x.left == u) {
                    f.put(u, g.get(x) + 1);
                }
                if (x.right == u) {
                    g.put(u, f.get(x) + 1);
                }
            }
            if (u.left != null) {
                q.offer(new TreeNode[]{u.left, u});
            }
            if (u.right != null) {
                q.offer(new TreeNode[]{u.right, u});
            }
        }
    }
}
