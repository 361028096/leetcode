package com.test.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Solution {
	public ArrayList<Integer> preorderTraversal(TreeNode root) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		
		if (root == null) {
			return res;
		}
		
		Stack<TreeNode> stack = new Stack<TreeNode>();
		while (!stack.isEmpty() || root != null) {
			if (root == null) {
				TreeNode p = stack.pop();
				root = p.right;
			} else {
				res.add(root.val);
				stack.push(root);
				root = root.left;
			}
		}
		return res;
	}
	
	int target;
	List<List<Integer>> ret = new ArrayList<List<Integer>>();
	public List<List<Integer>> binaryTreePathSum(TreeNode root, int target) {
		// Write your code here
		if (root == null) {
			return ret;
		}
		this.target = target;
		List<Integer> path = new ArrayList<Integer>();
		helper(path, root, 0);
		return null;
	}
	
	public void helper(List<Integer> path, TreeNode root, int sum) {
		sum += root.val;
		path.add(root.val);
		if (root.left == null && root.right == null && sum == target) {
//			List<Integer> newList = new ArrayList<Integer>();
//			newList.addAll(path);
			System.out.println(path);
			ret.add(path);
		}
		if (root.left != null) {
			helper(path, root.left, sum);
		}
		if (root.right != null) {
			helper(path, root.right, sum);
		}
		path.remove(path.size() - 1);
	} 

}
