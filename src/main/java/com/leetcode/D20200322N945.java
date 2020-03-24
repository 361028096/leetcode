package com.leetcode;

/**
 * // [945]使数组唯一的最小增量
 * //给定整数数组 A，每次 move 操作将会选择任意 A[i]，并将其递增 1。
 * //
 * // 返回使 A 中的每个值都是唯一的最少操作次数。
 * //
 * // 示例 1:
 * //
 * // 输入：[1,2,2]
 * //输出：1
 * //解释：经过一次 move 操作，数组将变为 [1, 2, 3]。
 * //
 * // 示例 2:
 * //
 * // 输入：[3,2,1,2,1,7]
 * //输出：6
 * //解释：经过 6 次 move 操作，数组将变为 [3, 4, 1, 2, 5, 7]。
 * //可以看出 5 次或 5 次以下的 move 操作是不能让数组的每个值唯一的。
 * //
 * //
 * // 提示：
 * //
 * //
 * // 0 <= A.length <= 40000
 * // 0 <= A[i] < 40000
 * //
 * // Related Topics 数组
 *
 *
 * @date 2020/3/22 13:03
 */
public class D20200322N945 {
    public int minIncrementForUnique(int[] A) {
        int[] count = new int[80000];
        for (int x: A) count[x]++;

        int ans = 0, taken = 0;

        for (int x = 0; x < 80000; ++x) {
            if (count[x] >= 2) {
                taken += count[x] - 1;
                ans -= x * (count[x] - 1);
            }
            else if (taken > 0 && count[x] == 0) {
                taken--;
                ans += x;
            }
        }

        return ans;
    }
}
