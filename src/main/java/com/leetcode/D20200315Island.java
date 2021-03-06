package com.leetcode;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

/**
 * //给定一个包含了一些 0 和 1的非空二维数组 grid , 一个 岛屿 是由四个方向 (水平或垂直) 的 1 (代表土地) 构成的组合。你可以假设二维矩阵的
 * //四个边缘都被水包围着。
 * //
 * // 找到给定的二维数组中最大的岛屿面积。(如果没有岛屿，则返回面积为0。)
 * //
 * // 示例 1:
 * //
 * //
 * //[[0,0,1,0,0,0,0,1,0,0,0,0,0],
 * // [0,0,0,0,0,0,0,1,1,1,0,0,0],
 * // [0,1,1,0,1,0,0,0,0,0,0,0,0],
 * // [0,1,0,0,1,1,0,0,1,0,1,0,0],
 * // [0,1,0,0,1,1,0,0,1,1,1,0,0],
 * // [0,0,0,0,0,0,0,0,0,0,1,0,0],
 * // [0,0,0,0,0,0,0,1,1,1,0,0,0],
 * // [0,0,0,0,0,0,0,1,1,0,0,0,0]]
 * //
 * //
 * // 对于上面这个给定矩阵应返回 6。注意答案不应该是11，因为岛屿只能包含水平或垂直的四个方向的‘1’。
 * //
 * // 示例 2:
 * //
 * //
 * //[[0,0,0,0,0,0,0,0]]
 * //
 * // 对于上面这个给定的矩阵, 返回 0。
 * //
 * // 注意: 给定的矩阵grid 的长度和宽度都不超过 50。
 * // Related Topics 深度优先搜索 数组
 *
 *
 * @date 2020/3/15 21:14
 */
public class D20200315Island {
    public int maxAreaOfIsland(int[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    res = Math.max(res, dfs(i, j, grid));
                }
            }
        }
        return res;
    }

    private int dfs(int i, int j, int[][] grid) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid.length || grid[i][j] == 0) {
            return 0;
        }
        grid[i][j] = 0;
        int num = 1;
        num += dfs(i+1, j, grid);
        num += dfs(i-1, j, grid);
        num += dfs(i, j+1, grid);
        num += dfs(i, j-1, grid);
        return num;
    }
    @Test
    public void test1() {
        int[][] island ={{0,0,1,0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,1,1,0,1,0,0,0,0,0,0,0,0},
                {0,1,0,0,1,1,0,0,1,0,1,0,0},
                {0,1,0,0,1,1,0,0,1,1,1,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,1,1,0,0,0,0}};
        System.out.println(JSON.toJSONString(island));
        System.out.println(maxAreaOfIsland(island));
    }

}
