package com.leetcode;

/**
 * // [面试题 17.16]按摩师
 * //一个有名的按摩师会收到源源不断的预约请求，每个预约都可以选择接或不接。在每次预约服务之间要有休息时间，因此她不能接受相邻的预约。给定一个预约请求序列，替按摩
 * //师找到最优的预约集合（总预约时间最长），返回总的分钟数。
 * //
 * // 注意：本题相对原题稍作改动
 * //
 * //
 * //
 * // 示例 1：
 * //
 * // 输入： [1,2,3,1]
 * //输出： 4
 * //解释： 选择 1 号预约和 3 号预约，总时长 = 1 + 3 = 4。
 * //
 * //
 * // 示例 2：
 * //
 * // 输入： [2,7,9,3,1]
 * //输出： 12
 * //解释： 选择 1 号预约、 3 号预约和 5 号预约，总时长 = 2 + 9 + 1 = 12。
 * //
 * //
 * // 示例 3：
 * //
 * // 输入： [2,1,4,5,3,1,1,3]
 * //输出： 12
 * //解释： 选择 1 号预约、 3 号预约、 5 号预约和 8 号预约，总时长 = 2 + 4 + 3 + 3 = 12。
 * //
 * // Related Topics 动态规划
 *
 * ---
 * 思路：
 * 思路很清晰，就是动态规划
 * dp[i]数组表示前i个预约可以接到的最长预约时间
 * 对于每一个i，都可以选择接或不接
 *
 * 接的话，就是dp[i-2]加自己nums[i]
 * 不接的话，就dp[i-1]不加自己
 * 看哪个时间长选哪个，遍历数组nums，dp最后一项就是总的最优时间
 *
 * 作者：pendygg
 * 链接：https://leetcode-cn.com/problems/the-masseuse-lcci/solution/dpdpdpda-bao-jian-de-dp-by-pendygg/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 *
 * ---
 * 解答成功: 执行耗时:0 ms,击败了100.00% 的Java用户 内存消耗:37.1 MB,击败了100.00% 的Java用户
 *
 *
 * @date 2020/3/24 09:39
 */
public class D20200324MN1716Massage {
    public int massage(int[] nums) {
        if (nums == null) {
            return 0;
        }
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        if(len == 1) {
            return nums[0];
        }

        int[] dp = new int[len];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < len; i++) {
            dp[i] = Math.max(nums[i] + dp[i-2], dp[i-1]);
        }
        return dp[len-1];
    }
}
