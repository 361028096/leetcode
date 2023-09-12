package com.leetcode;

import java.util.ArrayList;

/**
 * TODO
 *
 * @author wei.he
 * @date 2023/9/8 11:26
 */
public class D20230908N1466MinReorder {

    public int minReorder(int n, int[][] connections) {
        ArrayList<Integer>[] adj = new ArrayList[n];
        ArrayList<Integer>[] array = new ArrayList[n];

        for(int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
            array[i] = new ArrayList<>();
        }
        for (int[] connection : connections) {
            int from = connection[0];
            int to = connection[1];
            adj[from].add(to);
            array[from].add(to);
            array[to].add(from);
        }
        int[] num = {0};
        boolean[] visited = new boolean[n];
        dfs(0, array, adj, num, visited);
        return num[0];
    }

    private void dfs(int i, ArrayList<Integer>[] array, ArrayList<Integer>[] adj, int[] num, boolean[] visited) {
        visited[i] = true;
        ArrayList<Integer> list = array[i];
        for (int j = 0; j < list.size(); j++) {
            Integer k = list.get(j);
            if (visited[k]) {
                continue;
            }
            if (!adj[k].contains(i)) {
                num[0]++;
            }
            dfs(k, array, adj, num, visited);
        }
    }
}
