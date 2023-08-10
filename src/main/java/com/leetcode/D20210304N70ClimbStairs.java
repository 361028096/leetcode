package com.leetcode;

/**
 * f(x) = f(x-1) + f(x-2)
 * @author wei.he
 * @date 2021/3/4 12:20
 */
public class D20210304N70ClimbStairs {

    //
    public int climbStairs(int n) {
        int p = 0, q = 0, r = 1;
        for (int i = 0; i <= n; i++) {
            p = q;
            q = r;
            r = p + q;
        }
        return r;
    }
}
