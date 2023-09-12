package com.leetcode;

import com.leetcode.common.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * TODO
 *
 * @author wei.he
 * @date 2023/9/6 17:10
 */
public class D20230906N437PathSum {

    public int pathSum(TreeNode root, int sum) {
        Map<Long, Integer> prefixSumCount = new HashMap<>();
        prefixSumCount.put(0L, 1);
        return recursionPathSum(root, prefixSumCount, sum, 0L);
    }

    private int recursionPathSum(TreeNode node, Map<Long, Integer> prefixSumCount, int target, long currSum) {
        if (node == null) {
            return 0;
        }

        int res = 0;
        currSum += node.val;

        res += prefixSumCount.getOrDefault(currSum - target, 0);
        prefixSumCount.put(currSum, prefixSumCount.getOrDefault(currSum,0) + 1);

        res += recursionPathSum(node.left, prefixSumCount, target, currSum);
        res += recursionPathSum(node.right, prefixSumCount, target, currSum);

        prefixSumCount.put(currSum, prefixSumCount.get(currSum) -1);
        return res;
    }


}
