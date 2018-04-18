package com.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;


public class D20170518N486NextGreaterElementI {
	public int[] nextGreaterElement (int[] findNums, int[] nums) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		Stack<Integer> stack = new Stack<Integer>();
		for (int num : nums) {
			while (!stack.isEmpty() && stack.peek() < num) {
				map.put(stack.pop(), num);
			}
			stack.push(num);
		}
		for (int i = 0; i < findNums.length; i++) {
			//findNums[i] = map.g
		}
		
		
		return null;
	}

}
