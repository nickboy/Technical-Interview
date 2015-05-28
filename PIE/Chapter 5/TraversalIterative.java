package com.nickboy.pie.chapter5;
import java.util.Stack;


class TraversalIterative {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	void preorderTraversal(TreeNode root) {
		Stack<TreeNode> stack = new Stack<TreeNode>();

		stack.push(root);

		while(stack.size() > 0) {
			TreeNode curr = stack.pop();
			System.out.println(curr.val);

			if(curr.left != null)
				stack.push(n.left);
			if(curr.right != null)
				stack.push(n.right);

		}
	}

}