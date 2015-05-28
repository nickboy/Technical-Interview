package com.nickboy.pie.chapter5;
import java.util.Stack;


class FindAncestor {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	TreeNode findLowestCommonAncestor (TreeNode root, int value1, int value2) {
		while( root != null) {
			int value = root.val;

			if( value > value1 && value > value2) {
				root = root.left;
			} else if ( value < value1 && value < value2) {
				root = root.right;
			} else {
				return root;
			}
		}
		return null;
	}

	TreeNode findLowestCommonAncestor (TreeNode root, TreeNode child1, TreeNode child2 ) {
		if (root == null || child1 == null || child2 == null) {
			return null;
		}

		return findLowestCommonAncestor(root, child1.val, child2.val);
	}

}