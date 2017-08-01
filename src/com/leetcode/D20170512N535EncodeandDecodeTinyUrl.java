package com.leetcode;

import java.util.HashMap;
import java.util.Map;


public class D20170512N535EncodeandDecodeTinyUrl {
	Map<Integer, String> map = new HashMap<Integer, String>();
	public String encode(String longUrl) {
		map.put(longUrl.hashCode(), longUrl);
		return "http://tinyurl.com/" + longUrl.hashCode();
	}
	
	public String decode(String shortUrl) {
		return map.get(Integer.parseInt(shortUrl.replace("http://tinyurl.com/", "")));
	}
	
	public static void main(String[] args) {
		D20170512N535EncodeandDecodeTinyUrl code = new D20170512N535EncodeandDecodeTinyUrl();
		System.out.println(code.encode("https://leetcode.com/problems/design-tinyurl"));
		System.out.println(code.decode(code.encode("https://leetcode.com/problems/design-tinyurl")));
	}

}
