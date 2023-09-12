package com.leetcode;

//import java.util.HashSet;
//import java.util.PriorityQueue;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

//import java.util.Set;

/**
 * TODO
 *
 * @author wei.he
 * @date 2023/9/11 9:52
 */
public class D20230911N2336SamllestInfiniteSet {
    Set<Integer> set = new HashSet<>();
    PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
    int n = 1;

    public D20230911N2336SamllestInfiniteSet() {
    }

    public int popSmallest() {
        if (set.isEmpty()) {
            return n++;
        }
        int res = pq.poll();
        set.remove(res);
        return res;
    }

    public void addBack(int num) {
        if (num < n && set.add(num)) {
            pq.add(num);
        }

    }

}
