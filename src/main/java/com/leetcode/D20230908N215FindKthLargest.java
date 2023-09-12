package com.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * D20230908N215FindKthLargest
 *
 * @author wei.he
 * @date 2023/9/8 15:01
 */
public class D20230908N215FindKthLargest {
    public int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k, Comparator.comparingInt(a -> a));
        for (int i = 0; i < k; i++) {
            minHeap.offer(nums[i]);
        }

        for (int i = k; i < len; i++) {
            Integer topElement = minHeap.peek();
            if (nums[i] > topElement) {
                minHeap.poll();
                minHeap.offer(nums[i]);

            }
        }
        return minHeap.peek();
    }

}
