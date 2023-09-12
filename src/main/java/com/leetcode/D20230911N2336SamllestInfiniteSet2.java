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
public class D20230911N2336SamllestInfiniteSet2 {

    boolean[] flag = new boolean[1001];
    PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
    int n = 1, remain = 0;


    public D20230911N2336SamllestInfiniteSet2() {
    }

    public int popSmallest() {
        if (remain == 0) {
            return n++;
        }
        int res = pq.poll();
        flag[res] = false;
        remain --;
        return res;
    }

    public void addBack(int num) {
        if (num < n && !flag[num]) {
            flag[num] = true;
            pq.add(num);
            remain++;
        }

    }

}
