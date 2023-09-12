package com.leetcode;

import java.util.List;

/**
 * canVisitAllRooms
 *
 * @author wei.he
 * @date 2023/9/8 9:56
 */
public class D20230908N841CanVisitAllRooms {

    boolean[] vis;
    int num;

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        num = 0;
        vis = new boolean[n];
        dfs(rooms, 0);
        return num == n;
    }

    public void dfs(List<List<Integer>> rooms, int x) {
        vis[x] = true;
        num++;
        for (int it:rooms.get(x)) {
            if (!vis[it]) {
                dfs(rooms, it);
            }
        }
    }
}
