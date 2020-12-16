package com.leetcode;

import org.junit.Test;

/**
 * // [290]单词规律
 * //给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。
 * //
 * // 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。
 * //
 * // 示例1:
 * //
 * // 输入: pattern = "abba", str = "dog cat cat dog"
 * //输出: true
 * //
 * // 示例 2:
 * //
 * // 输入:pattern = "abba", str = "dog cat cat fish"
 * //输出: false
 * //
 * // 示例 3:
 * //
 * // 输入: pattern = "aaaa", str = "dog cat cat dog"
 * //输出: false
 * //
 * // 示例 4:
 * //
 * // 输入: pattern = "abba", str = "dog dog dog dog"
 * //输出: false
 * //
 * // 说明:
 * //你可以假设 pattern 只包含小写字母， str 包含了由单个空格分隔的小写字母。
 * // Related Topics 哈希表
 * // 👍 229 👎 0
 * @date 2020/12/16 8:55
 */
public class D20201216N290WordRule {
    public boolean wordPattern(String pattern, String s) {
        if (pattern == null || s == null) {
            return false;
        }
        boolean isMatch = false;
        String[] ss = s.split(" ");
        char[] patternChars = pattern.toCharArray();
        if (ss.length != patternChars.length) {
            return false;
        }
        for (int i = 0;i<patternChars.length;i++) {
            for (int j = i+1;j<patternChars.length;j++) {
                if (patternChars[i] == patternChars[j]) {
                    isMatch = ss[i].equals(ss[j]);
                } else {
                    isMatch = !ss[i].equals(ss[j]);
                }
                if (!isMatch) {
                    return false;
                }
            }
        }
        return true;
    }

    @Test
    public void test () {
        System.out.println(this.wordPattern("abba","dog cat cat dog"));
        System.out.println(this.wordPattern("abba","dog cat cat fish"));
    }
}
