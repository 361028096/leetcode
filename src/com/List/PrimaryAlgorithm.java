package com.List;

public class PrimaryAlgorithm {
	ListNode head = null;
	
	public int length() {
		int length = 0;
		ListNode tmp = head;
		while (tmp != null) {
			length++;
			tmp = tmp.next;
		}
		return length;
	}
	
	// 增加操作
	public void addNode(int d) {
		ListNode newNode = new ListNode(d);
		if (head == null) {
			head = newNode;
			return ;
		}
		ListNode tmp = head;
		while (tmp.next != null) {
			tmp = tmp.next;
		}
		// add node to end
		tmp.next = newNode;
	}
	
	// 删除操作
	public Boolean deleteNode(int index) {
		if (index < 1 || index > length()) {
			return false;
		}
		
		if (index == 1) {
			head = head.next;
			return true;
		}
		int i = 1;
		ListNode preNode = head;
		ListNode curNode = preNode.next;
		while (curNode != null) {
			if (i == index) {
				preNode.next = curNode.next;
				return true;
			}
			preNode = curNode;
			curNode = curNode.next;
			i++;
		}
		return true;
	}
	
	
	/**
	 * 单链表排序操作，每次挑出最小元素，最终单链表由小到大排列
	 */
	public ListNode sorderList() {
		ListNode nextNode = null;
		int tmp = 0;
		ListNode curNode = head;
		while (curNode.next != null) {
			nextNode = curNode.next;
			while (nextNode != null) {
				if (curNode.val > nextNode.val) {
					tmp = curNode.val;
					curNode.val = nextNode.val;
					nextNode.val = tmp;
				}
				nextNode = nextNode.next;
			}
			curNode = curNode.next;
		}
		return head;
	}
}
