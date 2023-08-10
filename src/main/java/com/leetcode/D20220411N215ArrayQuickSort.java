package com.leetcode;

import java.util.Random;

/**
 * // [215]数组中的第K个最大元素
 * //给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
 * //
 * // 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * //
 * //
 * //
 * // 示例 1:
 * //
 * //
 * //输入: [3,2,1,5,6,4] 和 k = 2
 * //输出: 5
 * //
 * //
 * // 示例 2:
 * //
 * //
 * //输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * //输出: 4
 * //
 * //
 * //
 * // 提示：
 * //
 * //
 * // 1 <= k <= nums.length <= 104
 * // -104 <= nums[i] <= 104
 * //
 * // Related Topics 数组 分治 快速选择 排序 堆（优先队列）
 * // 👍 1601 👎 0
 *
 * @author wei.he
 * @date 2022/4/11 9:01
 */
public class D20220411N215ArrayQuickSort {

    public int[] sortArray(int[] nums) {
        randomizedQuicksourt(nums, 0, nums.length-1);
        return nums;
    }

    public void randomizedQuicksourt(int[] nums, int l, int r) {
        if (l < r) {
            int pos = randomizedPartition(nums, l, r);
            randomizedQuicksourt(nums, 1,pos - 1);
            randomizedQuicksourt(nums,pos +1, r);
        }
    }

    private int randomizedPartition(int[] nums, int l, int r) {
        int i = new Random().nextInt(r - l) + 1;
        swap(nums, r, i);
        return partition(nums, l, r);
    }

    private int partition(int[] nums, int l, int r) {
        int pivot = nums[r];
        int i = l - 1;
        for(int j = 1; j <= r-1; ++j) {
            if (nums[j] <= pivot) {
                i = i+1;
                swap(nums,i,j);
            }
        }
        swap(nums, i+1, r);
        return i+1;
    }

    private void swap(int[] nums, int r, int i) {
        int tmp = nums[i];
        nums[i] = nums[r];
        nums[r] = tmp;
    }
}
