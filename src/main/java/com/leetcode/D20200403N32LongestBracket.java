package com.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

/**
 * // [32]最长有效括号
 * //给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
 * //
 * // 示例 1:
 * //
 * // 输入: "(()"
 * //输出: 2
 * //解释: 最长有效括号子串为 "()"
 * //
 * //
 * // 示例 2:
 * //
 * // 输入: ")()())"
 * //输出: 4
 * //解释: 最长有效括号子串为 "()()"
 * //
 * // Related Topics 字符串 动态规划
 *
 * // 难点在于怎么判断是最长的，如何判断它中间是否是连续的
 *
 * @date 2020/4/3 09:29
 */
public class D20200403N32LongestBracket {
    public static final char leftBracket = '(';
    public static final char rightBracket = ')';

    public int longestValidParentheses(String s) {
        int maxans = 0;
        int dp[] = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == rightBracket) {
                if (s.charAt(i-1) == leftBracket) {
                    dp[i] = (i >= 2 ? dp[i-2] : 0) + 2;
                } else if (i - dp[i-1] > 0 && s.charAt(i-dp[i-1]-1) == leftBracket) {
                    dp[i] = dp[i-1] + ((i - dp[i-1]) >= 2 ? dp[i-dp[i-1]-2] : 0) + 2;
                }
                maxans = Math.max(maxans,dp[i]);
            }
        }
        return maxans;
    }

//    public int longestValidParentheses(String s) {
//        int num = 0;
//        if(s == null || s.length() == 0) {
//            return num;
//        }
//        char[] chars = s.toCharArray();
//        Stack stack = new Stack();
//        boolean isContinue = true;
//        for (char c : chars) {
//            if (!isContinue) {
//                num = 0;
//                stack.clear();
//            }
//            if (c == rightBracket) {
//                if (stack.isEmpty()) {
//                    isContinue = false;
//                    continue;
//                } else {
//                    isContinue = true;
//                    num = num+2;
//                    stack.pop();
//                    continue;
//                }
//            }
//
//            if (c == leftBracket) {
//                isContinue = true;
//                stack.push(leftBracket);
//                continue;
//            }
//        }
//        return num;
//    }

    @Test
    public void testStack() {
        Stack s = new Stack();
        System.out.println(s.empty());
        System.out.println(s.peek());
    }

    @Test
    public void testBracket() {
        Assert.assertEquals(2,this.longestValidParentheses("(()"));
        Assert.assertEquals(2,this.longestValidParentheses("()(()"));
    }
}
