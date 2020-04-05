package com.leetcode;

import java.util.Arrays;

/**
 * // [912]排序数组
 * //给定一个整数数组 nums，将该数组升序排列。
 * //
 * //
 * //
 * //
 * //
 * //
 * // 示例 1：
 * //
 * //
 * //输入：[5,2,3,1]
 * //输出：[1,2,3,5]
 * //
 * //
 * // 示例 2：
 * //
 * //
 * //输入：[5,1,1,2,0,0]
 * //输出：[0,0,1,1,2,5]
 * //
 * //
 * //
 * //
 * // 提示：
 * //
 * //
 * // 1 <= A.length <= 10000
 * // -50000 <= A[i] <= 50000
 * //
 * //
 *
 * @date 2020/3/31 9:30
 */
public class D20200331N912Sort {
    public int[] sortArray(int[] nums) {
        Arrays.sort(nums);
        return nums;
    }
}
