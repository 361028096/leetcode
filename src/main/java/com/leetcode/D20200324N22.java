package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * // [22]括号生成
 * //给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 * //
 * // 例如，给出 n = 3，生成结果为：
 * //
 * // [
 * //  "((()))",
 * //  "(()())",
 * //  "(())()",
 * //  "()(())",
 * //  "()()()"
 * //]
 * //
 * // Related Topics 字符串 回溯算法
 *
 * @date 2020/3/24 21:46
 */
public class D20200324N22 {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        backTrack(ans, "", 0, 0, n);
        return ans;
    }

    private void backTrack(List<String> ans, String cur, int open, int close, int max) {
        if (cur.length() == max * 2) {
            ans.add(cur);
            return;
        }
        if (open < max) {
            backTrack(ans, cur+"(", open + 1,  close, max);
        }
        if (close < open) {
            backTrack(ans, cur+")", open, close + 1, max);
        }
    }
}
