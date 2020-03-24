package com.leetcode;

import com.alibaba.fastjson.JSON;
import org.junit.Assert;
import org.junit.Test;

import java.nio.charset.IllegalCharsetNameException;
import java.util.*;

/**
 * // [409]最长回文串
 * //给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。
 * //
 * // 在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。
 * //
 * // 注意:
 * //假设字符串的长度不会超过 1010。
 * //
 * // 示例 1:
 * //
 * //
 * //输入:
 * //"abccccdd"
 * //
 * //输出:
 * //7
 * //
 * //解释:
 * //我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
 * //
 * // Related Topics 哈希表
 *
 * ----
 * 做过前天那题的同学，很容易想到做一个int[26+26]数组来保存各字母的个数，但A～Z和a～z在ASCII表上是分开的喔，所以存数组的时候也要分开存哦
 * 如果某字母有偶数个，因为偶数有对称性，可以把它全部用来构造回文串；但如果是奇数个的话，并不是完全不可以用来构建，也不是只能选最长的那个，而是只要砍掉1个，剩下的变成偶数就可以全部计入了
 * 但奇数字母里，可以保留1个不砍，把它作为回文串的中心，所以最后还要再加回一个1
 * 但是！如果压根没有奇数的情况，这个1也不能随便加，所以还要分情况讨论
 * 大概就是这些坑容易掉进去。。都躲过了AC应该没啥问题
 *
 * ---
 * 解答成功: 执行耗时:2 ms,击败了76.48% 的Java用户 内存消耗:37.9 MB,击败了5.25% 的Java用户
 *
 *
 * @date 2020/3/19 08:22
 */
public class D20200319N409String {

    public int longestPalindrome(String s) {
        if (s == null || s.length()<=0) {
            return 0;
        }
        int[] tmp = new int[26+26];
        for(char c:s.toCharArray()) {
            if (c >= 'a') {
                tmp[c-'a']++;
            } else {
                tmp[c-'A'+26]++;
            }
        }
        int ans = 0;
        for (int v : tmp) {
            ans += v/2*2;
            if (v%2==1 && ans%2==0) {
                ans++;
            }
        }
        return ans;
    }

    @Test
    public void testString() {
        int[] count = new int[1];
        count[0]++;
        System.out.println(JSON.toJSONString(count[0]));
    }

    @Test
    public void test() {
        Assert.assertEquals(7,this.longestPalindrome("abccccdd"));
    }
}
