package com.leetcode;

import org.junit.Test;

/**
 * TODO
 *
 * @author wei.he
 * @date 2021/2/23 16:56
 */
public class D20210223N14LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        // 获取最短字符串长度
        int shortestLength = strs[0].length();
        for (String str : strs) {
            if (str.length() < shortestLength) {
                shortestLength = str.length();
            }
        }
        int i = getInt(strs, shortestLength);
        return strs[0].substring(0,i);
    }

    private int getInt(String[] strs, int shortestLength) {
        // 逐个比较
        for (int i = 0; i< shortestLength; i++) {
            for (int j= 1;j < strs.length;j++) {
                if(strs[j-1].charAt(i) != strs[j].charAt(i)) {
                    return i;
                }
            }
        }
        return shortestLength;
    }

    @Test
    public void test() {
        String[] strs = {"a","ab","abc"};
        System.out.println(this.longestCommonPrefix(strs));
    }
}
