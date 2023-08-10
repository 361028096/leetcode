package com.leetcode;

import org.apache.commons.lang.StringUtils;

import java.math.BigInteger;

/**
 * // [43]字符串相乘
 * //给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 * //
 * // 示例 1:
 * //
 * // 输入: num1 = "2", num2 = "3"
 * //输出: "6"
 * //
 * // 示例 2:
 * //
 * // 输入: num1 = "123", num2 = "456"
 * //输出: "56088"
 * //
 * // 说明：
 * //
 * //
 * // num1 和 num2 的长度小于110。
 * // num1 和 num2 只包含数字 0-9。
 * // num1 和 num2 均不以零开头，除非是数字 0 本身。
 * // 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
 * //
 * // Related Topics 数学 字符串
 * // 👍 574 👎 0
 *
 * @author wei.he
 * @date 2021/7/15 18:21
 */
public class D20210224N43StringMultiply {

    private static final String zero = "0";

    public String multiply(String num1, String num2) {
        // 前置校验
        if (num1.equals(zero) || num2.equals(zero)) {
            return zero;
        }
        // 获取长的乘数 及 短的被乘数
        String longStr = "";
        String shortStr = "";
        if (num1.length() >= num2.length()) {
            longStr = num1;
            shortStr = num2;
        } else {
            longStr = num2;
            shortStr = num1;
        }

        for (char c : shortStr.toCharArray()) {
            this.multiply(longStr,String.valueOf(c));
        }
        // 遍历被乘数
        return new BigInteger(num1).multiply(new BigInteger(num2)).toString();

    }

}
