package com.leetcode;



public class D20170512N557ReverseWordsinaStringIII {
	public static String reverseWords(String s) {
		String[] sArrays = s.split(" ");
		String result = "";
		int i = 0;
		for(String sArray:sArrays) {
			StringBuilder b = new StringBuilder(sArray);
			sArrays[i] = b.reverse().toString();
			if(i == 0){
				result += sArrays[i]; 
			} else {
				result += " " + sArrays[i]; 
			}
			i++;
		}
		return result;
	}
	
	public static void main(String[] args) {
		System.out.println(reverseWords("Let's take LeetCode contest"));
	}

}
