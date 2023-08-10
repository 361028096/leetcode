package com.leetcode;

/**
 * // [283]移动零
 * //给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * //
 * // 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 * //
 * //
 * //
 * // 示例 1:
 * //
 * //
 * //输入: nums = [0,1,0,3,12]
 * //输出: [1,3,12,0,0]
 * //
 * //
 * // 示例 2:
 * //
 * //
 * //输入: nums = [0]
 * //输出: [0]
 * //
 * //
 * //
 * // 提示:
 * //
 * //
 * //
 * // 1 <= nums.length <= 104
 * // -231 <= nums[i] <= 231 - 1
 * //
 * //
 * //
 * //
 * // 进阶：你能尽量减少完成的操作次数吗？
 * // Related Topics 数组 双指针
 * // 👍 1572 👎 0
 *
 * @author wei.he
 * @date 2022/5/5 12:42
 */
public class D20220505N283Remove {
    public void moveZeroes(int[] nums) {
        if (null == nums || nums.length == 0) {
            return;
        }
        int n = nums.length, left = 0, right = 0;
        while (right < n) {
            if (nums[right] != 0) {
                swap(nums, left, right);
                left++;
            }
            right++;
        }
    }

    public void swap(int[] nums,int left, int right) {
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }
}
