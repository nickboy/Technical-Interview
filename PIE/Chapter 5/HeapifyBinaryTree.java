package com.nickboy.pie.chapter5;
import java.util.Arrays;
import java.util.Comparator;


class HeapifyBinaryTree {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public static TreeNode heapifyBinaryTree( TreeNode root ) {
		int size = traverse(root, 0, null); //Count nodes

		TreeNode[] nodeArray = new TreeNode[size];
		traverse(root, 0, nodeArray); //Load nodes into array

		//Sort array of nodes based on  their values, using Comparator object
		Arrays.sort( nodeArray, new Comparator<TreeNode>() {
			@Override public int compare(TreeNode m, TreeNode n) {
				int mv = m.val, nv = n.val;
				return (mv < nv ? -1 : (mv == nv ? 0: 1));
			}
		});


		// Reassign children for each node
		for (int i = 0; i < size; i++) {
			int left = 2 * i + 1;
			int right = left + 1;
			nodeArray[i].left = (left >= size ? null : nodeArray[left]);
			nodeArray[i].right = (right >= size ? null : nodeArray[right]);
		}
	}

	public static int traverse( TreeNode node, int count , TreeNode[] arr) {
		if ( node == null)
			return count;
		if ( arr != null)
			arr[count] = node;
		count++;
		count = traverse( node.left, count, arr);
		count = traverse( node.right, count, arr);
		return count;
	}



}