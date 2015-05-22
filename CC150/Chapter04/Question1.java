package com.nickboy.cc150.chapter4;
import java.util.Stack;


/**
 * Implement a function to check if a binary tree is balanced. For the purposes
 * of this question, a balanced tree is defined to be a tree such that the
 * heights of the two subtrees of any node never differ by more than one.
 * 
 */
// O(1) space, O(n) time

public class Question1 {

	public class TreeNode {
		int val;
		Treenode left;
		Treenode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public boolean isBalanced(TreeNode root) {
		return check(root) >= 0;
	}

	public int checker(TreeNode node) {
		if (node == null)
			return 0;

		int left = checker(node.left);
		int right = checker(node.right);
		if (left < 0 || right < 0 || Math.abs(left - right) > 1) {
			return -1;
		} else {
			return Math.max(left, right) + 1;
		}

	}
}

