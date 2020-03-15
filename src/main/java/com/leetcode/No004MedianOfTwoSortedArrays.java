package com.leetcode;

/*
    给定两个大小为 m 和 n 的有序数组 nums1 和 nums2 。
    请找出这两个有序数组的中位数。要求算法的时间复杂度为 O(log (m+n)) 。
 */

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * @author : hewei
 * @description: TODO
 * @date : 2018/4/19
 */
public class No004MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        List<Integer> numList = new ArrayList<Integer>();
        for (int i : nums1) {
            numList.add(i);
        }
        for (int i : nums2) {
            numList.add(i);
        }
        int num = numList.size();
        Collections.sort(numList);
        int middle = 0;
        int middle2 = 0;
        double result = 0;
        if (num%2 == 0) {
            middle = num/2;
            middle2 = middle + 1;
            result = (double)(numList.get(middle-1) + numList.get(middle2-1))/2;
        } else {
            middle = num/2 + 1;
            result = (double) numList.get(middle-1);
        }
        return result;
    }

    @Test
    public void testList() {
        int[] a = {1,3};
        int[] b = {2};
        System.out.println(findMedianSortedArrays(a,b));
    }
}
