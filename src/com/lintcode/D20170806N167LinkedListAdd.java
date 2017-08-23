package com.lintcode;

import java.util.ArrayList;

import com.List.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;      
 *     }
 * }
 */
public class D20170806N167LinkedListAdd {
	public ListNode addLists(ListNode l1, ListNode l2) {
        // write your code here
		ListNode node = null;
		if (l1 != null && l2 != null) {
			ArrayList<Integer> list = getNodeValue(l1,l2);
			node = setNode(list);
		}
		return node;
    }
	
	public ArrayList<Integer> getNodeValue(ListNode l1, ListNode l2) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		int count = 0;
		int tag = 0;
	
		return null;
	}
	
	public ListNode setNode(ArrayList<Integer> list) {
		return null;
	}

}
