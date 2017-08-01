package com.leetcode;

import java.util.HashSet;
import java.util.Set;


public class D20170512N575DistributeCandies {
	public int distributeCandies(int[] candies) {
		Set<Integer> kinds = new HashSet<Integer>();
		for(int candy : candies) {
			kinds.add(candy);
		}
		return kinds.size() >= candies.length / 2 ? candies.length / 2 : kinds.size();
	}

}
