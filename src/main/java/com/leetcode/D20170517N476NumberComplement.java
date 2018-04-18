package com.leetcode;


public class D20170517N476NumberComplement {
	public int findComplement(int num) {
        int mask = (Integer.highestOneBit(num) << 1) - 1;
        num = ~num;
        return num & mask;
    }
	
	public static void main(String[] args) {
		/*D20170517N476NumberComplement a = new D20170517N476NumberComplement();
		int result = a.findComplement(1);
		System.out.println(result);*/
		int num = 5;
		int mask = (Integer.highestOneBit(num) << 1) - 1;
		System.out.println("mask:"+mask);
		System.out.println("mask:"+Integer.toBinaryString(mask));
		System.out.println("~num:"+ ~num);
		System.out.println("~num:"+Integer.toBinaryString(~num));
		System.out.println((~num) & mask);
		
		int count = 0;
		while(num != 0) {
			num &= num - 1;
			count ++;
		}
		System.out.println(count);
	}
	

}
