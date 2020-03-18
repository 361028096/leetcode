package com.leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * // [7]整数反转
 * //给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * //
 * // 示例 1:
 * //
 * // 输入: 123
 * //输出: 321
 * //
 * //
 * // 示例 2:
 * //
 * // 输入: -123
 * //输出: -321
 * //
 * //
 * // 示例 3:
 * //
 * // 输入: 120
 * //输出: 21
 * //
 * //
 * // 注意:
 * //
 * // 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231, 231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 * // Related Topics 数学
 *
 * @author wei.he
 * @date 2020/3/18 11:32
 */
public class D20200318N7IntegerInversion {

    private static final String minus = "-";

    public int reverse(int x) {
        if (x == 0) {
            return x;
        }
        String str = String.valueOf(x);
        String result = "";
        if (str.contains(minus)) {
            for (int i = str.length()-1; i > 0 ; i--) {
                result = result + str.charAt(i);
            }
            result = minus+result;
        } else {
            for (int i = str.length()-1; i >= 0 ; i--) {
                result = result + str.charAt(i);
            }
        }

        System.out.println("result:" + result);
        int resultInt = 0;
        try {
            resultInt = Integer.valueOf(result);
        } catch (NumberFormatException e) {

        }
        return resultInt;
    }

    @Test
    public void testInt() {
        int i = -1;
//        System.out.println(String.valueOf(i));

//        System.out.println(Integer.valueOf("-2147483649"));
        Assert.assertEquals(321,this.reverse(123));
        Assert.assertEquals(-321,this.reverse(-123));
    }

}
