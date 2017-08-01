package com.leetcode;


public class D20170512N537ComplexNumberMultiplication {
	public static String complexNumberMultiply(String a, String b) {
		String result = "";
		String[] A = a.split("\\+");
		String[] B = b.split("\\+");
		int a1 = Integer.parseInt(A[0]);
		int b1 = Integer.parseInt(A[1].replace("i", ""));
		
		int a2 = Integer.parseInt(B[0]);
		int b2 = Integer.parseInt(B[1].replace("i", ""));
		
		int a1a2 = a1 * a2;
		int b1b2 = b1 * b2;
		int a1b2a2b1 = (a1 * b2) + (a2 * b1);
		
		String afinal = (a1a2 + (b1b2 * (-1))) + "";
		String bfinal = a1b2a2b1 + "i";
		result = afinal + "+" + bfinal;
		return result;
	}
	
	public static void main(String[] args) {
		System.out.println(complexNumberMultiply("1+1i","1+1i"));
	}

}
