package com.leetcode;

import java.util.Random;

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
 * @author wei.he
 * @date 2022/3/8 8:15
 */
public class D20220308N912Sort {

    // todo hewei unfinished

    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }

    public int quickSelect(int[] a, int l, int r, int index) {

        int q = randomizedPartition(a, l, r);
        if (q == index) {
            return a[q];
        } else {
            return q < index ? quickSelect(a, q + 1, r, index) : quickSelect(a, l, q - 1, index);
        }

    }

//    public void randomizedQuicksourt(int[] nums, int l, int r) {
//        if (l < r) {
//            int pos = randomizedPartition(nums, l, r);
//            randomizedQuicksourt(nums, 1,pos - 1);
//            randomizedQuicksourt(nums,pos +1, r);
//        }
//    }

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

    public static void main(String[] args) {
        System.out.println(new Random().nextInt(2));
        System.out.println(new Random().nextInt(2));
        System.out.println(new Random().nextInt(2));
        System.out.println(new Random().nextInt(2));
        System.out.println(new Random().nextInt(2));
        System.out.println(new Random().nextInt(2));
        System.out.println(new Random().nextInt(2));
        System.out.println(new Random().nextInt(2));
        System.out.println(new Random().nextInt(2));
        System.out.println(new Random().nextInt(2));
    }
}
