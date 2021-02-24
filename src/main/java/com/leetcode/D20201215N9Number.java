package com.leetcode;

import org.junit.Test;

/**
 * TODO
 *
 * @date 2020/12/15 7:53
 */
public class D20201215N9Number {
    public boolean isPalindrome(int x) {
        if(x<0) {
            return false;
        }
        if (x == 0) {
            return true;
        }
        int digit = 0;
        int temp = x;
        while (temp != 0) {
            temp = temp/10;
            digit++;
        }
        String str = String.valueOf(x);
        char[] c = str.toCharArray();
//        char[] c = Character.toChars(x);
        int loopNumber = digit/2;
        int stepLength = digit;
        int length = c.length-1;
        for (int i = 0;i< loopNumber ;i++) {
            if (c[i] == c[length]) {
                length--;
            } else {
                return false;
            }
        }
        return true;
    }

    @Test
    public void test() {
        System.out.println(this.isPalindrome(121));
        System.out.println(this.isPalindrome(1001));
    }
}
