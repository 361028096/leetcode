package com.leetcode;

import org.junit.Test;

import java.util.*;

/**
 * // [16]最接近的三数之和
 * //给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和
 * //。假定每组输入只存在唯一答案。
 * //
 * //
 * //
 * // 示例：
 * //
 * // 输入：nums = [-1,2,1,-4], target = 1
 * //输出：2
 * //解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
 * //
 * //
 * //
 * //
 * // 提示：
 * //
 * //
 * // 3 <= nums.length <= 10^3
 * // -10^3 <= nums[i] <= 10^3
 * // -10^4 <= target <= 10^4
 * //
 * // Related Topics 数组 双指针
 * // 👍 696 👎 0
 *
 * @author wei.he
 * @date 2021/2/23 17:44
 */
public class D20210223N16Sum {
    public int threeSumClosest1(int[] nums, int target) {

        // 获取所有的和
        List<Integer> sumList = new LinkedList<>();
        for (int i = 0; i < nums.length-2; i++) {
            for (int j = i+1; j < nums.length-1; j++) {
                for (int k = j+1; k < nums.length; k++) {
                    Integer result = nums[i] + nums[j] + nums[k];
                    sumList.add(result);
                }
            }
        }
//        Integer index =0;
        // 与target比较，记录差值
        List<Integer> subList = new LinkedList<>();
        for (Integer sum:sumList) {
            subList.add(Math.abs(sum-target));
        }
        Integer index = 0;
        Integer min = subList.get(0);
        // 获取最小的
        for (int i = 0;i < subList.size(); i++) {
            Integer sub = subList.get(i);
            if (min>sub) {
                min = sub;
                index = i;
            }
        }
        return sumList.get(index);
    }

    public int threeSumClosest2(int[] nums, int target) {

        // 获取所有的和
        List<Integer> subList = new LinkedList<>();
        List<Integer> sumList = new LinkedList<>();
        for (int i = 0; i < nums.length-2; i++) {
            for (int j = i+1; j < nums.length-1; j++) {
                for (int k = j+1; k < nums.length; k++) {
                    Integer sum = nums[i] + nums[j] + nums[k];
                    Integer result = Math.abs(sum-target);
                    sumList.add(sum);
                    subList.add(result);
                }
            }
        }

        Integer index = 0;
        Integer min = subList.get(0);
        // 获取最小的
        for (int i = 0;i < subList.size(); i++) {
            Integer sub = subList.get(i);
            if (min>sub) {
                min = sub;
                index = i;
            }
        }
        return sumList.get(index);
    }

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int len = nums.length;
        int ans = Integer.MAX_VALUE;
        int s = 0;
        for (int i = 0; i < len; i++) {
            int L = i+1;
            int R = len-1;
            while (L < R) {
                int sum = nums[i] + nums[L] + nums[R];
                if (sum == target) {
                    return sum ;
                }
                int c = Math.abs(sum-target);
                ans = Math.min(ans,c);
                if (ans == c) {
                    s = sum;
                }
                if (sum > target) {
                    R--;
                }
                if (sum < target) {
                    L++;
                }
            }
        }
        return s;
    }

    @Test
    public void test() {
//        int[] a = {-1,2,1,-4};
        //解答失败: 测试用例:[-1,2,1,-4] 1 测试结果:-1 期望结果:2 stdout:
        Integer target = 1;
//        System.out.println(this.threeSumClosest(a,target));
//        System.out.println(a.length);
        target = -59;
        int[] b = {13,2,0,-14,-20,19,8,-5,-13,-3,20,15,20,5,13,14,-17,-7,12,-6,0,20,-19,-1,-15,-2,8,-2,-9,13,0,-3,-18,-9,-9,-19,17,-14,-19,-4,-16,2,0,9,5,-7,-4,20,18,9,0,12,-1,10,-17,-11,16,-13,-14,-3,0,2,-18,2,8,20,-15,3,-13,-12,-2,-19,11,11,-10,1,1,-10,-2,12,0,17,-19,-7,8,-19,-17,5,-5,-10,8,0,-12,4,19,2,0,12,14,-9,15,7,0,-16,-5,16,-12,0,2,-16,14,18,12,13,5,0,5,6};
        System.out.println(this.threeSumClosest(b,target));

    }
}
