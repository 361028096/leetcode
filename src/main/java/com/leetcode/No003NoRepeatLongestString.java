package com.leetcode;


import org.junit.Test;

import java.util.*;

/**
 * 题目：3.无重复字符的最长子串
 * 给定一个字符串，找出不含有重复字符的最长子串的长度。
 * 示例：
 * 给定 "abcabcbb" ，没有重复字符的最长子串是 "abc" ，那么长度就是3。
 * 给定 "bbbbb" ，最长的子串就是 "b" ，长度是1。
 * 给定 "pwwkew" ，最长子串是 "wke" ，长度是3。请注意答案必须是一个子串，"pwke" 是 子序列  而不是子串。
 *
 *
 * @description: TODO
 * @date : 2018/4/17
 */
public class No003NoRepeatLongestString {

    /*
        "滑动窗口" 
        比方说 abcabccc 当你右边扫描到abca的时候你得把第一个a删掉得到bca，
        然后"窗口"继续向右滑动，每当加到一个新char的时候，左边检查有无重复的char，
        然后如果没有重复的就正常添加，
        有重复的话就左边扔掉一部分（从最左到重复char这段扔掉），在这个过程中记录最大窗口长度
    */
    public int lengthOfLongestSubstring(String s) {
        if ( s == null || s.length() == 0) {
            return 0;
        }
        HashMap<Character,Integer> map = new HashMap<Character, Integer>();
        int leftBound = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            leftBound = Math.max(leftBound,(map.containsKey(c))?map.get(c)+1:0);
            // 0,1,2
            max = Math.max(max, i-leftBound+1);
            map.put(c,i);
        }
        return max;
    }

    @Test
    public void testFor() {
        for (int i = 0; i < 4; i++) {
            System.out.println(i);
        }
    }

}
