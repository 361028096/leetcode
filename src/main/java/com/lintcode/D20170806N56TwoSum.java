package com.lintcode;

import java.util.Arrays;

public class D20170806N56TwoSum {
	 /*
     * @param numbers : An array of Integer
     * @param target : target = numbers[index1] + numbers[index2]
     * @return : [index1 + 1, index2 + 1] (index1 < index2)
     */
    public static int[] twoSum(int[] numbers, int target) {
        // write your code here
    	int[] result = new int[2];
    	for (int i = 0; i < numbers.length; i++) {
    		for (int j = i+1; j < numbers.length; j++) {
    			if (numbers[i] + numbers[j] == target) {
    				result[0] = i + 1;
    				result[1] = j + 1;
    				return result;
    			}
    		}
    	}
    	return null;
    }
    
    public static void main(String[] args) {
		int[] numbers = {1,0,-1};
		int target = -1;
		System.out.println(Arrays.toString(twoSum(numbers, target)));
	}

}
