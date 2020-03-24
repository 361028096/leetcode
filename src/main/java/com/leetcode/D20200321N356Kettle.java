package com.leetcode;

import java.util.*;

/**
 * // [365]水壶问题
 * //有两个容量分别为 x升 和 y升 的水壶以及无限多的水。请判断能否通过使用这两个水壶，从而可以得到恰好 z升 的水？
 * //
 * // 如果可以，最后请用以上水壶中的一或两个来盛放取得的 z升 水。
 * //
 * // 你允许：
 * //
 * //
 * // 装满任意一个水壶
 * // 清空任意一个水壶
 * // 从一个水壶向另外一个水壶倒水，直到装满或者倒空
 * //
 * //
 * // 示例 1: (From the famous "Die Hard" example)
 * //
 * // 输入: x = 3, y = 5, z = 4
 * //输出: True
 * //
 * //
 * // 示例 2:
 * //
 * // 输入: x = 2, y = 6, z = 5
 * //输出: False
 * //
 * // Related Topics 数学
 *
 *
 * @date 2020/3/21 12:46
 */
public class D20200321N356Kettle {

    public boolean canMeasureWater(int x, int y, int z) {
        if (z == 0) {
            return true;
        }
        if (x + y < z) {
            return false;
        }
        Queue<Map.Entry<Integer,Integer>> queue = new ArrayDeque<>();
        AbstractMap.SimpleEntry<Integer, Integer> start = new AbstractMap.SimpleEntry<>(0, 0);
        queue.add(start);
        Set<Map.Entry<Integer, Integer>> visited = new HashSet<>();
        visited.add(start);
        while (!queue.isEmpty()) {
            Map.Entry<Integer, Integer> entry = queue.poll();
            int curX = entry.getKey();
            int curY = entry.getValue();
            if (curX == z || curY == z || curX + curY == z) {
                return true;
            }
            if (curX == 0) {
                addIntoQueue(queue, visited, new AbstractMap.SimpleEntry<>(x, curY));
            }
            if (curY == 0) {
                addIntoQueue(queue,visited,new AbstractMap.SimpleEntry<>(curX,y));
            }
            if (curY < y) {
                addIntoQueue(queue, visited,new AbstractMap.SimpleEntry<>(0,curY));
            }
            if (curX <x) {
                addIntoQueue(queue,visited,new AbstractMap.SimpleEntry<>(curX,0));
            }
            int moveSize = Math.min(curX, y-curY);
            addIntoQueue(queue,visited,new AbstractMap.SimpleEntry<>(curX - moveSize, curY + moveSize));
            moveSize = Math.min(curY, x-curX);
            addIntoQueue(queue,visited,new AbstractMap.SimpleEntry<>(curX+moveSize, curY - moveSize));
        }
        return false;
    }

    private void addIntoQueue(Queue<Map.Entry<Integer, Integer>> queue,
                              Set<Map.Entry<Integer, Integer>> visited,
                              Map.Entry<Integer, Integer> newEntry) {
        if (!visited.contains(newEntry)) {
            visited.add(newEntry);
            queue.add(newEntry);
        }
    }
}
