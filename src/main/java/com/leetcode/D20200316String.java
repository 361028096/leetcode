package com.leetcode;

import org.apache.commons.lang.StringUtils;
import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;


/**
 * 面试题 01.06.字符串压缩
 * //字符串压缩。利用字符重复出现的次数，编写一种方法，实现基本的字符串压缩功能。比如，字符串aabcccccaaa会变为a2b1c5a3。若“压缩”后的字符串没
 * //有变短，则返回原先的字符串。你可以假设字符串中只包含大小写英文字母（a至z）。
 * //
 * // 示例1:
 * //
 * //
 * // 输入："aabcccccaaa"
 * // 输出："a2b1c5a3"
 * //
 * //
 * // 示例2:
 * //
 * //
 * // 输入："abbccd"
 * // 输出："abbccd"
 * // 解释："abbccd"压缩后为"a1b2c2d1"，比原字符串长度更长。
 * //
 * //
 * // 提示：
 * //
 * //
 * // 字符串长度在[0, 50000]范围内。
 * //
 * // Related Topics 字符串
 *
 * @author hewei
 * @date 2020/3/16 0:09
 */
public class D20200316String {
    public String compressString(String s) {
        if (StringUtils.isBlank(s)) {
            return s;
        }
        String result = "";
        Stack<String> stack = new Stack<>();
        char[] charArr = s.toCharArray();
        for (int i = 0; i < charArr.length; i++) {
            if (stack.empty() || stack.peek().equals(String.valueOf(charArr[i]))) {
                stack.push(String.valueOf(charArr[i]));
                continue;
            }
            if (!stack.peek().equals(String.valueOf(charArr[i]))) {
                result = result + stack.peek() + stack.size();
                stack.clear();
                stack.push(String.valueOf(charArr[i]));
            }
        }
        if (!stack.isEmpty()) {
            result = result + stack.peek()+ stack.size();
        }
        return result.length() < s.length()? result:s;
    }

    public String compressString2(String s) {
        if (s == null || s.length()<=2)
            return s;
        StringBuilder sb = new StringBuilder().append(s.charAt(0));
        int cnt = 1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i-1)) {
                cnt++;
            } else {
                sb.append(cnt).append(s.charAt(i));
                cnt=1;
            }
        }
        return sb.append(cnt).length() < s.length() ? sb.toString():s;
    }

    @Test
    public void testStack() {
        Stack<String> stack = new Stack<>();
        System.out.println(stack.peek());
        System.out.println(stack.size());
    }
    @Test
    public void testString() {
        String str = "aaaabbbbcccc";
        char[] charArr = str.toCharArray();
        System.out.println(this.compressString(str));
        Assert.assertEquals("",this.compressString(""));
        Assert.assertEquals("abbc",this.compressString("abbc"));
        Assert.assertEquals("a4b4c4",this.compressString("aaaabbbbcccc"));
    }



}
