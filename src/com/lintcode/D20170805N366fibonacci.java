package com.lintcode;

public class D20170805N366fibonacci {
	public static int fibonacci(int n) {
		if (n < 2) {
			if (n == 1) {
				return 0;
			}
			return 1;
		} 
		return fibonacci(n-1) + fibonacci(n-2);
	} 
	public static void main(String[] args) {
		System.out.println(fibonacci(41));
	}
}
