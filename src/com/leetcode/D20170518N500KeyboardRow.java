package com.leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


public class D20170518N500KeyboardRow {
	public static String[] findWords(String[] words) {
		String[] strs = {"QWERTYUIOP","ASDFGHJKL","ZXCVBNM"};
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < strs.length; i++) {
			for (char c: strs[i].toCharArray()) {
				map.put(c, i);
			}
		}
		List<String> res = new LinkedList<String>();
		for (String w : words) {
			if (w.equals("")) {
				continue;
			}
			int index = map.get(w.toUpperCase().charAt(0));
			for (char c : w.toUpperCase().toCharArray()) {
				if (map.get(c) != index) {
					index = -1;
					break;
				}
			}
			if (index != -1) {
				res.add(w);
			}
		}
		return res.toArray(new String[0]);
	}
	
	public static void main(String[] args) {
		String[] words = {"hello","default"};
		findWords(words);
	}
}
