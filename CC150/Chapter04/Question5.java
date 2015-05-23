package com.nickboy.cc150.chapter4;
import java.util.ArrayList;
import java.util.LinkedList;



/**
 * Implement a function to check if a binary tree is a binary search tree.
 * 
 */
// O(1) space, O(n) time
public class Question5 {

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	//recursive approach
	boolean checkBST(TreeNode n) {
		return checkBST(n, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	boolean checkBST(TreeNode n, int min, int max) {
		if (n == null) return true;
		if (n.val > max || n.val < min) return false;

		if (!checkBST(n.left, min, n.val) || !checkBST(n.right, n.val, max)) {
			return false;
		}
		return true;
	}

	//another style
	private boolean validate(TreeNode node, int min, int max) {
		if (node == null) {
			return true;
		}
		if (min < node.val && node.val < max) {
			return validate(node.left, min, node.val) && validate(node.right, node.val, max);
		} else {
			return false;
		}
	} 
}
