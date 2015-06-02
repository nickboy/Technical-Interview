package com.nickboy.cc150.chapter4;
import java.util.ArrayList;
import java.util.LinkedList;



/**
 * Design an algorithm and write code to find the first common ancestor of two
 * nodes in a binary tree. Avoid storing additional nodes in a data structure.
 * NOTE: This is not necessarily a binary search tree.
 * 
 */
public class Question7 {

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode parent;

		TreeNode(int x) {
			val = x;
		}
	}
	//Add another isAncestor attribute based on original TreeNode class.
	public static class Result {
		public TreeNode node;
		public boolean isAncestor;
		public Result(TreeNode n, boolean isAnc) {
			node = n;
			isAncestor = isAnc;
		}
	}

	Result commonAncestorHelper(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null) {
			return new Result(null, false);
		}

		if (root == p && root == q) {
			return new Result(root, true);
		}

		Result rx = commonAncestorHelper(root.left, p, q);
		if (rx.isAncestor) {
			return rx;
		}

		Result ry = commonAncestorHelper(root.right, p, q);
		if (ry.isAncestor) {
			return ry;
		}

		if (rx.node != null && ry.node != null) {
			return new Result(root, true);
		} else if ( root == p || root == q) {
			boolean isAncestor = rx.node != null || ry.node != null ? true : false;
			return new Result(root, isAncestor);
		} else {
			return new Result(rx.node != null ? rx.node : ry.node, false);
		}
	}

	TreeNode commonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		Result r = commonAncestorHelper(root, p, q);
		if (r.isAncestor) {
			return r.node;
		}
		return null;
	}

}

