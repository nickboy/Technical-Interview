package com.nickboy.cc150.chapter4;
import java.util.ArrayList;
import java.util.LinkedList;



/**
 * Given a sorted (increasing order) array, write an algorithm to create a
 * binary search tree with minimal height.
 * 
 */
public class Question4 {

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	//recursive version
	void createLevelLinkedList(TreeNode root, ArrayList<LinkedList<TreeNode>> lists, int level) {
		if (root == null) return;

		LinkedList<TreeNode> list = null;
		if (lists.size() == level) { //this level is not in current array
			//create a new list for current level
			list = new LinkedList<TreeNode>();
			lists.add(list);
		} else {
			list = lists.get(level);
		}

		list.add(root);
		createLevelLinkedList(root.left, lists, level + 1);
		createLevelLinkedList(root.right, lists, level + 1);
	}

	ArrayList<LinkedList<TreeNode>> createLevelLinkedList (TreeNode root) {
		ArrayList<LinkedList<TreeNode>> lists = new ArrayList<LinkedList<TreeNode>>();
		createLevelLinkedList(root, lists, 0);
		return lists;
	}

	//iterative version
	ArrayList<LinkedList<TreeNode>> createLevelLinkedListIterative(TreeNode root) {
		ArrayList<LinkedList<TreeNode>> result = new ArrayList<LinkedList<TreeNode>>();

		//visit root node
		LinkedList<TreeNode> current = new LinkedList<TreeNode>();

		if (root != null) {
			current.add(root);
		}

		while (current.size() >0) {
			result.add(current); //add current level

			LinkedList<TreeNode> parents = current; //go to next level
			current = new LinkedList<TreeNode>();
			for (TreeNode parent :parents) {
				//visit child node
				if (parent.left != null) {
					current.add(parent.left);
				}
				if (parent.right != null) {
					current.add(parent.right);
				}
			}
		}

		return result;
	}

}

