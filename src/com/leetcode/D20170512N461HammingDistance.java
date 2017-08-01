package com.leetcode;


public class D20170512N461HammingDistance {
	public int hummingDistance(int x, int y) {
		int count = 0;
		int xor = x ^ y;
		// 计算1的个数
		while (xor != 0) {
			xor &= xor-1;
			count++;
		}
		return count;
	}
}
