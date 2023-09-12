package com.leetcode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * TODO
 *
 * @author wei.he
 * @date 2023/9/6 10:12
 */
public class D20230906N933RecentCounter {

    Queue<Integer> queue = new ArrayDeque<Integer>();

    public int ping(int t) {
        queue.offer(t);
        while(queue.peek() < t-3000) {
            queue.poll();
        }
        return queue.size();
    }

}
