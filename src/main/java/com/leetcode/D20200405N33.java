package com.leetcode;

import com.alibaba.fastjson.JSON;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * // [33]搜索旋转排序数组
 * //假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * //
 * // ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * //
 * // 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 * //
 * // 你可以假设数组中不存在重复的元素。
 * //
 * // 你的算法时间复杂度必须是 O(log n) 级别。
 * //
 * // 示例 1:
 * //
 * // 输入: nums = [4,5,6,7,0,1,2], target = 0
 * //输出: 4
 * //
 * //
 * // 示例 2:
 * //
 * // 输入: nums = [4,5,6,7,0,1,2], target = 3
 * //输出: -1
 * // Related Topics 数组 二分查找
 *
 * @date 2020/4/5 23:27
 */
public class D20200405N33 {
    public int search(int[] nums, int target) {
        if (null == nums) {
            return -1;
        }
        List<Integer> list = new ArrayList<>();
        for (int i : nums) {
            list.add(i);
        }
//        List<Integer> list = Arrays.asList(nums);
        System.out.println(JSON.toJSONString(list));
        if (list.contains(target)) {
            return list.lastIndexOf(target);
        } else {
            return -1;
        }
    }

    @Test
    public void test() {
        Assert.assertEquals(4,this.search(new int[] {4,5,6,7,0,1,2},0));
    }
}
