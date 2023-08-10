package com.leetcode;

import org.apache.commons.lang.ArrayUtils;
import org.junit.Test;

/**
 * // 水平翻转图片就是将图片的每一行都进行翻转，即逆序。例如，水平翻转 [1, 1, 0] 的结果是 [0, 1, 1]。
 * //
 * // 反转图片的意思是图片中的 0 全部被 1 替换， 1 全部被 0 替换。例如，反转 [0, 1, 1] 的结果是 [1, 0, 0]。
 *
 * //输入：[[1,1,0,0],[1,0,0,1],[0,1,1,1],[1,0,1,0]]
 * //输出：[[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
 * //解释：首先翻转每一行: [[0,0,1,1],[1,0,0,1],[1,1,1,0],[0,1,0,1]]；
 * //     然后反转图片: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
 * @author wei.he
 * @date 2021/2/24 17:35
 */
public class D20210224N832ReverseImage {

    public int[][] flipAndInvertImage(int[][] A) {
        // 逆序
        for (int i = 0; i < A.length; i++) {
            // 逆序
            this.reverse(A[i]);
        }

        // 反转
        for (int i = 0; i < A.length; i++) {
            // 反转
            for(int j = 0; j<A[i].length; j++) {
                if (A[i][j] == 0) {
                    A[i][j] = 1;
                } else {
                    A[i][j] = 0;
                }
            }
        }
        return A;
    }

    public void reverse(int[] array) {
        if (array != null) {
            int i = 0;

            for (int j = array.length - 1; j > i; ++i) {
                int tmp = array[j];
                array[j] = array[i];
                array[i] = tmp;
                --j;
            }

        }
    }

    @Test
    public void test() {
        int A[][] = {{1,1,0},{1,0,1},{0,0,0}};
        System.out.println(this.flipAndInvertImage(A).toString());
    }
}
