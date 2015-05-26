package com.nickboy.cc150.chapter4;
import java.util.ArrayList;
import java.util.LinkedList;



/**
 * Write an algorithm to find the 'next' node (i.e., in-order successor) of a
 * given node in a binary search tree. You may assume that each node has a link
 * to its parent.
 * 
 */
// O(1) space, O(n) time
public class Question6 {

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode parent;

		TreeNode(int x) {
			val = x;
		}
	}

	public TreeNode inorderSucc(TreeNode n) {
		if (n == null)
			return null;

		//n is root or n has right subtree, just return left most children in right subtree.
		if (n.parent == null || n.right != null) {
			return leftMostChild(n.right);
		} else {
			//if no right subtree, go back to parent, find his parent.
			TreeNode q = n;
			TreeNode x = q.parent;
			while (x != null && x.left != q) {
				q = x;
				x = x.parent;
			}

			return x;
		}
	}

	public TreeNode leftMostChild(TreeNode n) {
		if (n == null)
			return null;
		while (n.left != null) {
			n= n.left;
		}
		return n;
	}


}

