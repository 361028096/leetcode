package com.leetcode;

import org.junit.Test;

/**
 *
 * @description: TODO
 * @date : 2018/4/19
 */
public class No005LongestSubstring {
    /*
    给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为1000。

    示例 1：
    输入: "babad"
    输出: "bab"
    注意: "aba"也是一个有效答案。
    示例 2：
    输入: "cbbd"
    输出: "bb"
     */
    public String longestPalindrome(String s) {
        int maxPalinLength = 0;
        String longestPalidrome = null;
        int length = s.length();
        if (length == 1) {
            return s;
        }
        for (int i = 0; i < length; i++) {
            for (int j = i+1; j < length; j++) {
                int len = j - i;
                String currStr = s.substring(i,j+1);
                if (isPalindrome(currStr)) {
                    if (len > maxPalinLength) {
                        longestPalidrome = currStr;
                        maxPalinLength = len;
                    }
                }
            }
        }
        return longestPalidrome;
    }

    public boolean isPalindrome(String s) {
        for (int i = 0; i < s.length()-1; i++) {
            if (s.charAt(i) != s.charAt(s.length()-1 -i)) {
                return false;
            }
        }
        return true;
    }

    public String longestPalindrome2(String s) {
        if (s.isEmpty() || s == null || s.length() == 1)
            return s;
        String longest = s.substring(0,1);
        for (int i = 0; i < s.length(); i++) {
            String tmp = helper(s,i,i);
            if (tmp.length()>longest.length()) {
                longest = tmp;
            }
            tmp = helper(s, i, i + 1);
            if (tmp.length() > longest.length()){
                longest = tmp;
            }
        }
        return longest;
    }

    public String helper (String s, int begin, int end) {
        while (begin > 0 && end <= s.length()-1 && s.charAt(begin)== s.charAt(end)) {
            begin--;
            end++;
        }
        return s.substring(begin+1,end);
    }
    public String longestPalindrome3(String s) {
        int curLen = 0;
        int start = -1;
        char[] array = s.toCharArray();
        for(int i = 0; i < array.length; i++) {
            if(isPalindrome(array, i - curLen - 1, i)) {
                start = i - curLen - 1;
                curLen += 2;
            } else if (isPalindrome(array, i - curLen, i)) {
                start = i - curLen;
                curLen += 1;
            }
        }
        return new String(array, start, curLen);
    }
    private boolean isPalindrome(char[] array, int start, int end) {
        if(start < 0) {
            return false;
        }
        while(start < end) {
            if(array[start++] != array[end--]) {
                return false;
            }
        }
        return true;
    }



    @Test
    public void testLength() {
        System.out.println(longestPalindrome3("a"));
    }
}
