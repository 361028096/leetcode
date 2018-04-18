package com.meituan;

import java.util.Scanner;

public class game {
	public static void main(String[] args) {
//		Map codeMap = new HashMap<K, V>();
//		ConcurrentHashMap<K, V>
		
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int n = sc.nextInt();
			System.out.println(fun(n));
		}
		sc.close();
	}
	
	public static int fun (int n) {
		int count = 0;
		if (n == 1) {
			count = 1;
		} else if (n == 2) {
			count = 2;
		} else {
			for (int i = 1; i < n; i++) {
				count += fun(n-1);
			}
			count = count + 1;
		}
		return count;
	}

}
