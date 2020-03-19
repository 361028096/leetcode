package com.leetcode;

import org.junit.Test;

/**
 * // [189]旋转数组
 * //给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 * //
 * // 示例 1:
 * //
 * // 输入: [1,2,3,4,5,6,7] 和 k = 3
 * //输出: [5,6,7,1,2,3,4]
 * //解释:
 * //向右旋转 1 步: [7,1,2,3,4,5,6]
 * //向右旋转 2 步: [6,7,1,2,3,4,5]
 * //向右旋转 3 步: [5,6,7,1,2,3,4]
 * //
 * //
 * // 示例 2:
 * //
 * // 输入: [-1,-100,3,99] 和 k = 2
 * //输出: [3,99,-1,-100]
 * //解释:
 * //向右旋转 1 步: [99,-1,-100,3]
 * //向右旋转 2 步: [3,99,-1,-100]
 * //
 * // 说明:
 * //
 * //
 * // 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
 * // 要求使用空间复杂度为 O(1) 的 原地 算法。
 * //
 * // Related Topics 数组
 *
 * @author wei.he
 * @date 2020/3/19 22:19
 */
public class D20200319N189ConvertArray {
    // Solution1:暴力
//    public void rotate(int[] nums, int k) {
//        int tmp,previsou;
//        for (int i = 0; i < k; i++) {
//            previsou = nums[nums.length-1];
//            for (int j = 0; j < nums.length; j++) {
//                tmp = nums[j];
//                nums[j] = previsou;
//                previsou = tmp;
//            }
//        }
//    }


    // Solution2:反转
    public void rotate(int[] nums, int k) {
        // 如果不%，当k=30的时候，就会做很多次无用的旋转。%之后可以得到最少旋转次数
        k = k % nums.length;
        reverse(nums,0,nums.length-1);
        reverse(nums,0,k-1);
        reverse(nums,k,nums.length-1);
    }

    private void reverse(int[] nums,int start, int end) {
        while (start < end) {
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start++;
            end--;
        }
    }

    @Test
    public void test() {
        System.out.println(3%7);
    }
}
