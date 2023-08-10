package com.leetcode;

/**
 * TODO
 *
 * @author wei.he
 * @date 2021/2/25 19:57
 */
public class D20210225N867ConvertMatrix {
    public int[][] transpose(int[][] matrix) {
        if (matrix.length ==1 && matrix[0].length == 1) {
            return matrix;
        }
        int[][] result = new int[matrix[0].length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0;j < matrix[0].length; j++) {
                result[j][i] = matrix[i][j];
            }
        }
        return result;
    }
}
