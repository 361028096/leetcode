package com.leetcode.design;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * TODO
 *
 * @author wei.he
 * @date 2021/8/10 10:14
 */
public class D20210810N146LRUCache extends LinkedHashMap<Integer, Integer> {
        private int capacity;

    public D20210810N146LRUCache(int capacity) {
        super(capacity, 0.75F, true);
        this.capacity = capacity;
    }

    public int get(int key) {
        return super.getOrDefault(key,-1);
    }

    public int put(int key, int value) {
        return super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }
}
