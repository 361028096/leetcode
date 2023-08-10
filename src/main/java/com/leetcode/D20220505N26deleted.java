package com.leetcode;

/**
 * TODO
 *
 * @author wei.he
 * @date 2022/5/5 12:19
 */
public class D20220505N26deleted {
        public int removeDuplicates(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            int length = nums.length;
            int fast = 1,slow = 1;
            for(int i = 0; i < length-1; i++) {
                if (nums[fast] != nums[fast - 1]) {
                    nums[slow] = nums[fast];
                    ++ slow;
                }
                ++fast;
            }
            return slow;
        }
}
